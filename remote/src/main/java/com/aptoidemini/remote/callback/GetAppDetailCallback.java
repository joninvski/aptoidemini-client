package com.aptoidemini.remote.callback;

import com.aptoidemini.domain.EventBus;
import com.aptoidemini.remote.event.ReceivedAppDetailEvent;
import com.aptoidemini.remote.object.AppDetailRest;

import retrofit.client.Response;
import retrofit.RetrofitError;

public class GetAppDetailCallback extends AbstractCallback<AppDetailRest> {
  private final EventBus mBus;

  public GetAppDetailCallback(final EventBus bus) {
    this.mBus = bus;
  }

  @Override
  public void success(final AppDetailRest appDetailRest, final Response response) {
    final ReceivedAppDetailEvent event = ReceivedAppDetailEvent.getEvent(appDetailRest);
    mBus.post(event);
  }

  @Override
  public void failure(RetrofitError e) {
    super.failure(e);

    if (isNetworkError(e)) {
      return; // Already treated
    }

    else {
      postUnexpectedRestError();
    }
  }

  @Override
  public EventBus getBus() {
    return mBus;
  }
}
