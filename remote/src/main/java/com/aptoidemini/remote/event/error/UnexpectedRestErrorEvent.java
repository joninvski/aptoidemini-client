package com.aptoidemini.remote.event.error;

import com.aptoidemini.remote.event.RemoteEvent;

public class UnexpectedRestErrorEvent extends RemoteEvent {

  public UnexpectedRestErrorEvent() {
  }

  public static UnexpectedRestErrorEvent getEvent() {
    return new UnexpectedRestErrorEvent();
  }
}
