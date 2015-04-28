package com.aptoidemini.remote;

import com.aptoidemini.remote.callback.GetAppListCallback;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.aptoidemini.domain.EventBus;
import com.aptoidemini.remote.object.AppListRest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class AptoideRestClient {

  private static final int CONNECTION_TIMEOUT_SECONDS = 6;
  private static final int CACHE_SIZE_MB = 10;
  private final RestAdapter restAdapter;
  private final AptoideRestClient.RestInterface restInterface;
  private final EventBus mBus;

  // Uses the default okhttp client is given
  public AptoideRestClient(final EventBus bus, String apiUrl) {
    this(bus, new OkClient(new OkHttpClient()), apiUrl, true);
  }

  public AptoideRestClient(final EventBus bus, String apiUrl, boolean logActive) {
    this(bus, new OkClient(new OkHttpClient()), apiUrl, logActive);
  }

  public AptoideRestClient(final EventBus bus, final Client client, String apiUrl) {
    this(bus, client, null, apiUrl, true);
  }

  public AptoideRestClient(final EventBus bus, final Client client,
                          String apiUrl, boolean logActive) {
    this(bus, client, null, apiUrl, logActive);
  }

  public AptoideRestClient(final EventBus bus, final Client client,
                          final RequestInterceptor interceptor, String apiUrl) {
    this(bus, client, interceptor, apiUrl, true);
  }

  public AptoideRestClient(final EventBus bus, final Client client,
                          final RequestInterceptor interceptor, String apiUrl, boolean logActive) {
    mBus = bus;
    bus.register(this);

    // Create an instance of our AsynchronousApi interface.
    RestAdapter.Builder builder = new RestAdapter.Builder();

    if (logActive) {
      builder.setEndpoint(apiUrl).setClient(client).setLogLevel(RestAdapter.LogLevel.FULL);
    } else {
      builder.setEndpoint(apiUrl).setClient(client).setLogLevel(RestAdapter.LogLevel.NONE);
    }

    if (interceptor != null) {
      builder.setRequestInterceptor(interceptor);
    }

    restAdapter = builder.build();

    // Create an instance of our API interface.
    restInterface = restAdapter.create(AptoideRestClient.RestInterface.class);
  }

  public static AptoideRestClient getRestWithCache(final EventBus bus, String cacheAbsolutePath,
      final RequestInterceptor interceptor, String apiUrl, boolean logActive) {
    int cacheSize = CACHE_SIZE_MB * 1024 * 1024; // 10 MiB
    final File cacheDirectory = new File(cacheAbsolutePath, "HttpCache");

    final Cache cache = new Cache(cacheDirectory, cacheSize);
    final OkHttpClient client = new OkHttpClient();
    client.setConnectTimeout(CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS);
    client.setCache(cache);
    final Client okClient = new OkClient(client);
    return new AptoideRestClient(bus, okClient, interceptor, apiUrl, logActive);
  }

  public void listApps() {
    final GetAppListCallback callback = new GetAppListCallback(mBus);

    restInterface.getListApps(callback);
  }


  public interface RestInterface {
    @GET("/listApps/store/apps/")
    public void getListApps(
      Callback<AppListRest> callback);
  }
}
