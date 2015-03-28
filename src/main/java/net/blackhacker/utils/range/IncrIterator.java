package net.blackhacker.utils.range;

import net.blackhacker.utils.Incrementable;

/**
 *
 * @author ben
 * @param <T>
 */
public class IncrIterator<T extends Number> extends RangeIterator<T> {
    final private T maximum;

    public IncrIterator(Incrementable<T> index, T step, T maximum){
        super(index, step);
        this.maximum = maximum;
    }

    @Override
    public boolean hasNext() {
        return getIndex().lt(maximum);
    }
}

