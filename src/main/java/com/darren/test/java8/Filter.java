package com.darren.test.java8;

public interface Filter<T> {

    public boolean filter(T t);
    
   default boolean getResult(){
        return true;
    }
}
