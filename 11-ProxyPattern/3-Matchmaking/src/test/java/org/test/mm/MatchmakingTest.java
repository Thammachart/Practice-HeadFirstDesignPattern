package org.test.mm;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.junit.Before;

import org.mm.person.PersonBean;
import org.mm.person.PersonBeanImpl;
import org.mm.proxy.OwnerInvocationHandler;
import org.mm.proxy.NonOwnerInvocationHandler;

public class MatchmakingTest {

    private Map<String,PersonBean> db;

    @Before
    public void init() {
        initializeDB();
    }

    @Test
    public void ownerProxyTest() {
        PersonBean test1 = db.get("Test 1");
        PersonBean ownerProxyTest1 = getOwnerProxy(test1);
        System.out.println("Name is " + ownerProxyTest1.getName());
        ownerProxyTest1.setInterests("New Interests 1!");
        System.out.println("New Interests has been set!");

        try {
            ownerProxyTest1.setHotOrNotRating(10);
        } catch(Exception e) {
            System.out.println("No self rating!!!");
        }
    }

    @Test
    public void nonOwnerProxyTest() {
        PersonBean test1 = db.get("Test 1");
        PersonBean nonOwnerProxyTest1 = getNonOwnerProxy(test1);
        System.out.println("Name is " + nonOwnerProxyTest1.getName());

        try {
            nonOwnerProxyTest1.setInterests("New Interests 1!");
        } catch(Exception e) {
            System.out.println("Self Manipulation only!!!");
        }

        nonOwnerProxyTest1.setHotOrNotRating(5);
        System.out.println("Rating has been set!");
        System.out.println("Rating is " + nonOwnerProxyTest1.getHotOrNotRating());
    }

    private void initializeDB() {
        db = new TreeMap<>();
        PersonBean person;

        for(int i=0; i < 5; i++) {
            person = new PersonBeanImpl();
            person.setName("Test " + i);
            person.setGender("Male");
            person.setInterests("Interests " + i);
            person.setHotOrNotRating(i + 1);
            db.put(person.getName(), person);
        }
    }

    private PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance (
                                person.getClass().getClassLoader(),
                                person.getClass().getInterfaces(),
                                new OwnerInvocationHandler(person)
                            );
    }

    private PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance (
                                person.getClass().getClassLoader(),
                                person.getClass().getInterfaces(),
                                new NonOwnerInvocationHandler(person)
                            );
    }

    private PersonBean getProxy(PersonBean person, InvocationHandler handler) {
        return (PersonBean) Proxy.newProxyInstance (
                                person.getClass().getClassLoader(),
                                person.getClass().getInterfaces(),
                                handler
                            );
    }
}
