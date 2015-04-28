package com.aptoidemini.remote.callback;

import com.aptoidemini.domain.EventBus;
import com.aptoidemini.remote.event.ReceivedAppListEvent;
import com.aptoidemini.remote.object.AppListRest;

import retrofit.client.Response;
import retrofit.RetrofitError;

public class GetAppListCallback extends AbstractCallback<AppListRest> {
  private final EventBus mBus;

  public GetAppListCallback(final EventBus bus) {
    this.mBus = bus;
  }

  @Override
  public void success(final AppListRest appList, final Response response) {
    final ReceivedAppListEvent event = ReceivedAppListEvent.getEvent(appList);
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
