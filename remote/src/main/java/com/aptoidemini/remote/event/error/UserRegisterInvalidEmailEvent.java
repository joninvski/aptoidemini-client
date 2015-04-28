package com.aptoidemini.remote.event.error;

import com.aptoidemini.remote.event.RemoteEvent;

public class UserRegisterInvalidEmailEvent extends RemoteEvent {

  public UserRegisterInvalidEmailEvent() {

  }

  public static UserRegisterInvalidEmailEvent getEvent() {
    return new UserRegisterInvalidEmailEvent();
  }
}
