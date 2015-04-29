package com.aptoide.app;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.aptoidemini.domain.EventBus;
import com.aptoidemini.remote.AptoideRestClient;
import com.aptoide.app.event.OttoBus;

import retrofit.RequestInterceptor;

import timber.log.Timber;

public class AptoideApp extends Application {
  private static EventBus mBus = new OttoBus();
  private AptoideRestClient mRest;

  @Override
  public void onCreate() {
    super.onCreate();

    configureBus();
    createRestClient();

    configureTimberLog(); // Has to come after crashlytics and Logger
  }

  private void createRestClient() {
    final boolean shouldLog = true;
    mRest = AptoideRestClient.getRestWithCache(getBus(), getCacheDir().getAbsolutePath(),
            createInterceptor(), BuildConfig.API_URL, shouldLog);
  }

  private void configureBus() {
    mBus = new OttoBus();
  }

  private void configureTimberLog() {
    Timber.plant(new Timber.DebugTree());
  }

  public AptoideRestClient getRestClient() {
    return mRest;
  }

  public static EventBus getBus() {
    return mBus;
  }

  public RequestInterceptor createInterceptor() {
    return new RequestInterceptor() {
      @Override
      public void intercept(RequestFacade request) {
        request.addHeader("Accept", "application/json;versions=1");
        if (isOnline()) {
          int maxAge = 60 * 1; // read from cache for 10 minutes
          request.addHeader("Cache-Control", "max-age=" + maxAge + ", max-stale=" + maxAge);
          Timber.d("Using online 1 minute cache");
        } else {
          int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
          request.addHeader("Cache-Control", "public, only-if-cached, max-stale=" + maxStale);
          Timber.d("Using offline 4 weeks cache");
        }
      }
    };
  }

  public boolean isOnline() {
    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    if (netInfo != null && netInfo.isConnected()) {
      return true;
    }
    return false;
  }
}
