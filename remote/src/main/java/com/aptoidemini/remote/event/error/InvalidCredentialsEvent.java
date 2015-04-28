package com.aptoidemini.remote.event.error;

import com.aptoidemini.remote.event.RemoteEvent;

public class InvalidCredentialsEvent extends RemoteEvent {

  public InvalidCredentialsEvent() {
  }

  public static InvalidCredentialsEvent getEvent() {
    return new InvalidCredentialsEvent();
  }
}
