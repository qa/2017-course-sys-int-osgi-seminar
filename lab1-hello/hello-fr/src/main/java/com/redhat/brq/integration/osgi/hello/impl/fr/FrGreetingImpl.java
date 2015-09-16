package com.redhat.brq.integration.osgi.hello.impl.fr;

import com.redhat.brq.integration.osgi.hello.api.AbstractGreeting;

public class FrGreetingImpl extends AbstractGreeting {

    public void sayHello(String name) {
        print(String.format("Bonjour, %s!", name));
    }

    public void sayBye(String name) {
        print(String.format("Au revoir, %s!", name));
    }
}
