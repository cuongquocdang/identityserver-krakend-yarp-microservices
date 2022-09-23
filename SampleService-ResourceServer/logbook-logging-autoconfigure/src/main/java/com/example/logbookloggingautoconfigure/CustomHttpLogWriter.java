package com.example.logbookloggingautoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zalando.logbook.Correlation;
import org.zalando.logbook.HttpLogWriter;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.Precorrelation;

@SuppressWarnings("all")
public class CustomHttpLogWriter implements HttpLogWriter {

    private final Logger log = LoggerFactory.getLogger(Logbook.class);

    @Override
    public boolean isActive() {
        return log.isInfoEnabled();
    }

    @Override
    public void write(final Precorrelation precorrelation, final String request) {
        log.info(request);
    }

    @Override
    public void write(final Correlation correlation, final String response) {
        log.info(response);
    }

}
