package com.redhat.brq.integration.osgi.hello.tracker;

import com.redhat.brq.integration.osgi.hello.api.Greeting;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class HelloServiceTracker extends ServiceTracker {

    public HelloServiceTracker(BundleContext context) {
        super(context, Greeting.class.getName(), null);
    }

    @Override
    public Object addingService(ServiceReference reference) {
        System.out.println(String.format("Greeting service - language %s - ADDED",
                reference.getProperty("lang")));
        return super.addingService(reference);
    }

    @Override
    public void removedService(ServiceReference reference, Object service) {
        System.out.println(String.format("Greeting service - language %s - REMOVED",
                reference.getProperty("lang")));
        super.removedService(reference, service);
    }
}
