package net.blackhacker.utils.range;

import net.blackhacker.utils.Incrementable;

/**
 *
 * @author ben
 * @param <T>
 */
public class DecrIterator<T extends Number> extends RangeIterator<T> {
    final private T minimum;

    public DecrIterator(Incrementable<T> index, T step, T minimum){
        super(index, step);
        this.minimum = minimum;
    }

    @Override
    public boolean hasNext() {
        return getIndex().gt(minimum);
    }
}

