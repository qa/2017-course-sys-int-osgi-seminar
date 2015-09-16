package com.redhat.brq.integration.osgi.hello.impl.en;

import com.redhat.brq.integration.osgi.hello.api.AbstractGreeting;
import com.redhat.brq.integration.osgi.hello.api.Greeting;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.log.LogService;

import java.util.Dictionary;
import java.util.Properties;

public class Activator implements BundleActivator {

    private ServiceRegistration registration;
    private ServiceReference loggingServiceRef;

    public void start(BundleContext ctx) {
        Dictionary props = new Properties();
        props.put("lang", "EN");
        props.put("service.ranking", 3);
        AbstractGreeting greetImpl = new EnGreetingImpl();

        loggingServiceRef = ctx.getServiceReference(LogService.class.getName());
        if (loggingServiceRef != null) {
            LogService service = (LogService) ctx.getService(loggingServiceRef);
            if (service != null) {
                greetImpl.setLoggingService(service);
            }
        }
        registration = ctx.registerService(Greeting.class.getName(), greetImpl, props);
    }

    public void stop(BundleContext ctx) {
        ctx.ungetService(loggingServiceRef);
        registration.unregister();
    }
}
