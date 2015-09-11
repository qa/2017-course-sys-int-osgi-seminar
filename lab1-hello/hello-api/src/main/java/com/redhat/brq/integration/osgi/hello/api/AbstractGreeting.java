package com.redhat.brq.integration.osgi.hello.api;

import org.osgi.service.log.LogService;


public abstract class AbstractGreeting implements Greeting {

    protected LogService loggingService;

    public LogService getLoggingService() {
        return loggingService;
    }

    public void setLoggingService(LogService loggingService) {
        this.loggingService = loggingService;
    }

    protected void print(String msg) {
        loggingService.log(LogService.LOG_INFO, msg);
        System.out.println(msg);
    }
}
