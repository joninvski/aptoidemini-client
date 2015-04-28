package com.aptoidemini.remote.event.error;

import com.aptoidemini.remote.event.RemoteEvent;

public final class ListWithMessagesDuplicatedAtServer extends RemoteEvent {

  private ListWithMessagesDuplicatedAtServer() { }

  public static ListWithMessagesDuplicatedAtServer getEvent() {
    return new ListWithMessagesDuplicatedAtServer();
  }
}
