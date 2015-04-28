package com.aptoidemini.remote.event.error;

import com.aptoidemini.remote.event.RemoteEvent;

public class UserRegisterPhoneNumberAlreadyExistsEvent extends RemoteEvent {

  public UserRegisterPhoneNumberAlreadyExistsEvent() {

  }

  public static UserRegisterPhoneNumberAlreadyExistsEvent getEvent() {
    return new UserRegisterPhoneNumberAlreadyExistsEvent();
  }
}
