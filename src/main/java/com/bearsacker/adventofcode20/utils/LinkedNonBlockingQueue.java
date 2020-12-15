package com.bearsacker.adventofcode20.utils;

import java.util.Collection;
import java.util.LinkedList;

public class LinkedNonBlockingQueue<E> extends LinkedList<E> {

    private static final long serialVersionUID = 2352128506263657615L;

    private int maxSize;

    public LinkedNonBlockingQueue(Collection<E> collection, int maxSize) {
        super(collection);

        if (maxSize <= 0) {
            throw new IllegalStateException("Size must be greater than 0");
        }

        this.maxSize = maxSize;
    }

    public LinkedNonBlockingQueue(int maxSize) {
        super();

        if (maxSize <= 0) {
            throw new IllegalStateException("Size must be greater than 0");
        }

        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public boolean add(E e) {
        if (size() >= maxSize) {
            super.removeFirst();
        }

        return super.add(e);
    }

    @Override
    public void push(E e) {
        if (size() >= maxSize) {
            super.removeLast();
        }

        super.push(e);
    }
}
