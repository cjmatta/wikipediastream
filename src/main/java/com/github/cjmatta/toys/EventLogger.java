package com.github.cjmatta.toys;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventLogger implements EventHandler {
  private final Logger logger = LoggerFactory.getLogger(EventLogger.class);

  public EventLogger() {
  }

  public void onOpen() throws Exception {
    logger.info("opened!");
  }

  public void onClosed() throws Exception {
    logger.info("closed!");

  }

  public void onMessage(String s, MessageEvent messageEvent) throws Exception {
    logger.info("got message type: " + s);
    logger.info(messageEvent.getData().toString());
  }

  public void onComment(String s) throws Exception {
    logger.info("onComment: " + s.toString());

  }

  public void onError(Throwable throwable) {
    logger.error(throwable.getMessage());

  }
}

