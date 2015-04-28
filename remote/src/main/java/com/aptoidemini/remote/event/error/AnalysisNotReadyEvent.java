package com.aptoidemini.remote.event.error;

import com.aptoidemini.remote.event.RemoteEvent;

public class AnalysisNotReadyEvent extends RemoteEvent {

  public AnalysisNotReadyEvent() {
  }

  public static AnalysisNotReadyEvent getEvent() {
    return new AnalysisNotReadyEvent();
  }
}
