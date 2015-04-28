package com.aptoidemini.domain;

/**
 * Interface that communication bus using the events should abide to.
 * */
public interface EventBus {

  public void register(Object object);
  public void unregister(Object object);
  public void post(final AbstractEvent event);
  public void postOnMainThread(final AbstractEvent event);
  public void postOnMainThread(final AbstractEvent event, final long delay);

}
