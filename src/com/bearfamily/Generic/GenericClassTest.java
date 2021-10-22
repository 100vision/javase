package com.bearfamily.Generic;

public class GenericClassTest {
    public static void main(String[] args) {

        Caculation<String> caculator1 = new Caculation<>();
        Caculation<Integer> caculator2 = new Caculation<>();

        System.out.println(caculator1.getFirst());
        

    }
}

class Caculation<T> {
    T first;
    T last;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }
}
