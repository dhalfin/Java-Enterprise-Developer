package ru.itmentor.javacore.lessons.boxes;

import java.util.ArrayList;
import java.util.Arrays;


public class MathBox extends ObjectBox {

    public MathBox(Number[] arr) {
        super(arr);
    }

    public ArrayList<Object> getContainer() {
        return (ArrayList<Object>) storage;
    }

    public void remove(Number n) {
        storage.remove(n);
    }

    public Number summator() {
        return (Number) storage.stream().reduce((a, b) ->
                ((Number) a).doubleValue() + ((Number) b).doubleValue()).orElse(null);
    }

    public void splitter(double divisor) {
        ((ArrayList<Object>) storage).replaceAll(a -> ((Number) a).doubleValue() / divisor);
    }

    @Override
    public void addObject(Object obj) {
        if (obj instanceof Number) {
            storage.add(obj);
        } else {
            throw new ClassCastException("Required Number!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        MathBox box = (MathBox) obj;
        return storage.equals(box.getContainer());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(storage.toArray());
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
