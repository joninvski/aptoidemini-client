package com.aptoidemini.remote.event.error;

import com.aptoidemini.remote.event.RemoteEvent;

public final class ListWithCallsDuplicatedAtServer extends RemoteEvent {

  private ListWithCallsDuplicatedAtServer() { }

  public static ListWithCallsDuplicatedAtServer getEvent() {
    return new ListWithCallsDuplicatedAtServer();
  }
}
