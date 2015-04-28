package com.aptoidemini.remote.event;

import com.aptoidemini.domain.AppList;
import com.aptoidemini.remote.object.AppListRest;

public class ReceivedAppListEvent extends RemoteEvent {

  public final AppList appList;

  public ReceivedAppListEvent(final AppList appList) {
    this.appList = appList;
  }

  public static ReceivedAppListEvent getEvent(final AppListRest appListRest) {
    final AppList appList = appListRest.toDomain();
    return new ReceivedAppListEvent(appList);
  }
}
