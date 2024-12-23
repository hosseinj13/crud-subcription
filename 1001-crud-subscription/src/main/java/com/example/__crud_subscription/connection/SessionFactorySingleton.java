package com.example.__crud_subscription.connection;

import com.example.__crud_subscription.Application;
import com.example.__crud_subscription.model.Subscription;
import com.example.__crud_subscription.model.SubscriptionUser;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {
    private SessionFactorySingleton() {
    }

    private static class LazyHolder {
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure ()
                    .build ();
            INSTANCE = new MetadataSources( registry )
                    .addAnnotatedClass(Application.class)
                    .addAnnotatedClass(Subscription.class)
                    .addAnnotatedClass(SubscriptionUser.class)
                    .buildMetadata ()
                    .buildSessionFactory ();
        }
    }

    public static SessionFactory getInstance() {
        return LazyHolder.INSTANCE;
    }
}