package com.company;

public class Data<T> implements NodeData{

    public Data(T value) {
        this.value = value;
    }

    public T value;

    @Override
    public boolean equal(NodeData data) {
        return false;
    }
}
