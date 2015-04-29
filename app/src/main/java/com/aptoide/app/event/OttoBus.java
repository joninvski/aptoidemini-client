package com.aptoide.app.event;

import android.os.Handler;
import android.os.Looper;

import com.aptoidemini.domain.AbstractEvent;
import com.aptoidemini.domain.EventBus;
import com.squareup.otto.Bus;

public class OttoBus implements EventBus {

  private final Bus ottoBus;

  public OttoBus() {
    ottoBus = new Bus();
  }

  @Override
  public void register(Object object) {
    ottoBus.register(object);
  }

  @Override
  public void unregister(Object object) {
    ottoBus.unregister(object);
  }

  @Override
  public void post(final AbstractEvent event) {
    ottoBus.post(event);
  }

  @Override
  public void postOnMainThread(final AbstractEvent event) {
    final Handler mHandlerCollectEnded = new Handler(Looper.getMainLooper());
    mHandlerCollectEnded.post(new Runnable() {
      @Override
      public void run() {
        ottoBus.post(event);
      }
    });
  }

  @Override
  public void postOnMainThread(final AbstractEvent event, final long delay) {
    final Handler mHandlerCollectEnded = new Handler(Looper.getMainLooper());
    mHandlerCollectEnded.postDelayed(new Runnable() {
      @Override
      public void run() {
        ottoBus.post(event);
      }
    }, delay);
  }
}
