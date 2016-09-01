Title: Dagger2
Tags: Dagger,android
Notebook: Android

[TOC]

# Annotation 总结

Annotation | Usage
------|---
@Module|Used on classes which contains methods annotated with @Provides.
@Provides|Can be used on methods in classes annotated with @Module and is used for methods which provides objects for dependencies injection.
@Singleton|Single instance of this provided object is created and shared.
@Component|Used on an interface. This interface is used by Dagger 2 to generate code which uses the modules to fulfill the requested dependencies.

### @Inject

Define classes which have a dependency

```java
package com.vogella.java.dagger2;

import javax.inject.Inject;

public class User {

        private String firstName;
        private String lastName;

        @Inject
        public User(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
        }

        @Override
        public String toString() {
                return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
        }
}
```

```java
package com.vogella.java.dagger2;

import javax.inject.Inject;

public class BackendService {

        @Inject
        public User user;

        private String serverUrl;

        @Inject
        public BackendService(String serverUrl) {
                this.serverUrl = serverUrl;
        }

        public boolean callServer() {
                if (user !=null && serverUrl!=null && serverUrl.length()>0) {
                        System.out.println("User: " + user + " ServerUrl: "  + serverUrl);
                        return true;
                }
                return false;
        }
}
```

### @Module

Define modules which provides dependencies

```java
package com.vogella.java.dagger2.modules;

import javax.inject.Named;
import javax.inject.Singleton;

import com.vogella.java.dagger2.BackendService;

import dagger.Module;
import dagger.Provides;

@Module
public class BackEndServiceModule {

    @Provides
    @Singleton
    BackendService provideBackendService(@Named("serverUrl") String serverUrl) {
       return new BackendService(serverUrl);
    }

    @Provides
    @Named("serverUrl")
    String provideServerUrl() {
       return "http://www.vogella.com";
    }

    @Provides
    @Named("anotherUrl")
    String provideAnotherUrl() {
       return "http://www.google.com";
    }

}
```

```java
package com.vogella.java.dagger2.modules;

import javax.inject.Singleton;

import com.vogella.java.dagger2.User;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Provides
    @Singleton
    User providesUser() {
            return new User("Lars", "Vogel");
    }
}
```

### @Component

Components define from which modules (or other components) dependencies are provided. Dagger 2 uses this interface to generate the accessor class which provides the methods defined in the interface.

```java
package com.vogella.java.dagger2.component;

import javax.inject.Singleton;

import com.vogella.java.dagger2.BackendService;
import com.vogella.java.dagger2.modules.BackEndServiceModule;
import com.vogella.java.dagger2.modules.UserModule;

import dagger.Component;

@Singleton
@Component(modules = { UserModule.class, BackEndServiceModule.class })
public interface MyComponent {
        BackendService createBackendService();

        // allow to inject into BackendService
        // method name not important
        void injectIntoBackendService (BackendService service);
}
```

### @使用

```java
package com.vogella.java.dagger2.main;

import com.vogella.java.dagger2.BackendService;
import com.vogella.java.dagger2.component.DaggerMyComponent;
import com.vogella.java.dagger2.component.MyComponent;

public class Main {

        public static void main(String[] args) {
                MyComponent component = DaggerMyComponent.builder().build();
                BackendService createBackendService = component.createBackendService();
                component.injectIntoBackendService(createBackendService);
                boolean callServer = createBackendService.callServer();
                if (callServer) {
                        System.out.println("Server call was successful. ");
                } else {
                        System.out.println("Server call failed. ");
                }
        }

}
```
