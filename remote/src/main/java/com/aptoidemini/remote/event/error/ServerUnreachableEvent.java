package com.aptoidemini.remote.event.error;

import com.aptoidemini.remote.event.RemoteEvent;

public class ServerUnreachableEvent extends RemoteEvent {
  private final boolean userInteraction;

  public ServerUnreachableEvent(boolean userInteraction) {
    this.userInteraction = userInteraction;
  }

  public static ServerUnreachableEvent getEvent(boolean userInteraction) {
    return new ServerUnreachableEvent(userInteraction);
  }

  public boolean getUserInteraction() {
    return userInteraction;
  }
}
