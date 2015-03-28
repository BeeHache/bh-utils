/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.blackhacker.utils.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import net.blackhacker.utils.Incrementable;

/**
 *
 * @author ben
 * @param <T>
 */
abstract public class RangeIterator<T extends Number> implements Iterator<T> {
    final private Incrementable<T> index;
    final private T step;

    public RangeIterator(Incrementable<T> index, T step){
        this.index = index;
        this.step = step;
    }

    @Override
    final public T next() {
        if (hasNext()) {
            T value = index.getValue();
            index.incr(step);
            return value;
        }
        throw new NoSuchElementException();
        
    }

    @Override
    final public void remove() {
        throw new UnsupportedOperationException("Not supported");
    }

    final public Incrementable<T> getIndex() {
        return index;
    }

    final public T getStep() {
        return step;
    }
}

