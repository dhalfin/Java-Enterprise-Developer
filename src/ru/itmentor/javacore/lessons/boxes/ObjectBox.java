package ru.itmentor.javacore.lessons.boxes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ObjectBox {

    protected Collection<Object> storage;

    public ObjectBox(Collection<Object> storage) {
        this.storage = storage;
    }

    public ObjectBox(Object[] arr) {
        storage = new ArrayList<>(Arrays.asList(arr));
    }

    public void addObject(Object obj) {
        storage.add(obj);
    }

    public void removeObject(Object obj) {
        storage.remove(obj);
    }

    public void dump() {
        System.out.println(storage.toString());
    }
}
