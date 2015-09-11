package com.redhat.brq.integration.osgi.hello.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.redhat.brq.integration.osgi.hello.api.Greeting;

public class Activator implements BundleActivator {

    private static final String NAME = System.getProperty("user.name", "John Doe");

    public void start(BundleContext ctx) {
        ServiceReference sr = ctx.getServiceReference(Greeting.class.getName());
        if (sr != null) {
            try {
                Greeting service = (Greeting) ctx.getService(sr);
                if (service != null) {
                    service.sayHello(NAME);
                }
            } finally {
                ctx.ungetService(sr);
            }
        } else {
            System.err.println("No greeting service available.");
        }
    }

    public void stop(BundleContext ctx) {
        ServiceReference sr = ctx.getServiceReference(Greeting.class.getName());
        if (sr != null) {
            try {
                Greeting service = (Greeting) ctx.getService(sr);
                if (service != null) {
                    service.sayBye(NAME);
                }
            } finally {
                ctx.ungetService(sr);
            }
        }
    }
}
