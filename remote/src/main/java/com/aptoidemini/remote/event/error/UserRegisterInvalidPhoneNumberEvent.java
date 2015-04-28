package com.aptoidemini.remote.event.error;

import com.aptoidemini.remote.event.RemoteEvent;

public class UserRegisterInvalidPhoneNumberEvent extends RemoteEvent {

  public UserRegisterInvalidPhoneNumberEvent() {

  }

  public static UserRegisterInvalidPhoneNumberEvent getEvent() {
    return new UserRegisterInvalidPhoneNumberEvent();
  }
}
