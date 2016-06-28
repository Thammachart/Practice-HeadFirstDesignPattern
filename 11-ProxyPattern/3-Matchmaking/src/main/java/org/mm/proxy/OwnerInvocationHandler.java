package org.mm.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;

import org.mm.person.PersonBean;

public class OwnerInvocationHandler implements InvocationHandler {
    private PersonBean person;

    public OwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            String methodName = method.getName();
            if(methodName.startsWith("get")) {
                return method.invoke(person, args);
            } else if(methodName.equals("setHotOrNotRating")) {
                throw new IllegalAccessException("Access denied on this method's own invocation");
            } else if(methodName.startsWith("set")) {
                return method.invoke(person, args);
            }
        } catch(InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
