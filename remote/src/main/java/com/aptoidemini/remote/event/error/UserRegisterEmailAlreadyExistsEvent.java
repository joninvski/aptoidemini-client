package com.aptoidemini.remote.event.error;

import com.aptoidemini.remote.event.RemoteEvent;

public class UserRegisterEmailAlreadyExistsEvent extends RemoteEvent {

  public UserRegisterEmailAlreadyExistsEvent() {

  }

  public static UserRegisterEmailAlreadyExistsEvent getEvent() {
    return new UserRegisterEmailAlreadyExistsEvent();
  }
}
