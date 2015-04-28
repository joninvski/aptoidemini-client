package com.aptoidemini.remote.event;

import com.aptoidemini.domain.AppDetail;
import com.aptoidemini.remote.object.AppDetailRest;

public final class ReceivedAppDetailEvent extends RemoteEvent {

  private final AppDetail appDetail;

  private ReceivedAppDetailEvent(AppDetail appDetail) {
    this.appDetail = appDetail;
  }

  public static ReceivedAppDetailEvent getEvent(AppDetailRest appDetailRest) {
    return new ReceivedAppDetailEvent(appDetailRest.toDomain());
  }
}
