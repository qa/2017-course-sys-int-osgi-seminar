package com.redhat.brq.integration.osgi.hello.impl.de;

import com.redhat.brq.integration.osgi.hello.api.AbstractGreeting;

public class DeGreetingImpl extends AbstractGreeting {

    public void sayHello(String name) {
        print(String.format("Guten Tag, %s!", name));
    }

    public void sayBye(String name) {
        print(String.format("Auf Wiedersehen, %s!", name));
    }
}
