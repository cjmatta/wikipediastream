package com.github.cjmatta.toys;


import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

public class StreamLogger {
  private static final Logger logger = LoggerFactory.getLogger(StreamLogger.class);
  private static final URI STREAMSOURCE = URI.create("https://stream.wikimedia.org/v2/stream/recentchange");

  private static void run() throws Exception {
    logger.info("Starting StreamLogger");
    EventLogger eventLogger = new EventLogger();
    EventSource source = new EventSource.Builder(eventLogger, STREAMSOURCE).build();
    source.start();
    logger.warn("Sleeping...");
    Thread.sleep(10000L);
    logger.debug("Stopping source");
    source.close();
    logger.debug("Stopped");
  }

  public static void main(String[] args) {
    try {
      try {
        run();
        return;
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }
    } catch (Throwable t) {
      t.printStackTrace();
    }
    System.exit(1);
  }
}
