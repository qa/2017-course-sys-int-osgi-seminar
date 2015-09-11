package com.redhat.brq.integration.osgi.hello.impl.en;

import com.redhat.brq.integration.osgi.hello.api.AbstractGreeting;

public class EnGreetingImpl extends AbstractGreeting {

    public void sayHello(String name) {
        print(String.format("Hello, %s!", name));
    }

    public void sayBye(String name) {
        print(String.format("Good bye, %s!", name));
    }
}
