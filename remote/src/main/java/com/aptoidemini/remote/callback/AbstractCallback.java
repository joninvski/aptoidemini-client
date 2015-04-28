package com.aptoidemini.remote.callback;

import com.aptoidemini.domain.EventBus;
import com.aptoidemini.remote.event.error.UnexpectedRestErrorEvent;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.mime.TypedInput;
import retrofit.RetrofitError;

public abstract class AbstractCallback<T> implements Callback<T> {

  public abstract EventBus getBus();

  @Override
  public void failure(final RetrofitError e) {
    return;
  }


  public boolean isNetworkError(final RetrofitError e) {
    final Response response = e.getResponse();

    if (response == null) {
      return true;
    }

    if (e.isNetworkError()) {
      return true;
    }

    final TypedInput body = response.getBody();
    if (body == null) {
      return true;
    }

    return false;
  }

  public boolean validCredentials(final RetrofitError e) {
    if (e.getResponse().getStatus() == 401) {
      System.out.println("INVALID TOKEN");
      return false;
    }
    return true;
  }

  public void postUnexpectedRestError() {
    getBus().post(UnexpectedRestErrorEvent.getEvent());
  }
}
