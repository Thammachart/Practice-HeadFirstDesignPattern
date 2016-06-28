package org.mm.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;

import org.mm.person.PersonBean;

public class NonOwnerInvocationHandler implements InvocationHandler {
    private PersonBean person;

    public NonOwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            String methodName = method.getName();
            if(methodName.startsWith("get") || methodName.equals("setHotOrNotRating")) {
                return method.invoke(person, args);
            } else if(methodName.startsWith("set")) {
                throw new IllegalAccessException("No setter allowed on non-owner invocation");
            }
        } catch(InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
