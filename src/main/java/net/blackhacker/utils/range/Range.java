package net.blackhacker.utils.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import net.blackhacker.utils.Incrementable;

/**
 * 
 * @author ben
 * @param <T>
 *
 */
public class Range<T extends Number> implements Iterable<T> {
	
    static final private byte DEFAULT_START=0;

    static final private byte DEFAULT_STEP=1;

    /**
     * 
     */
    final private T minimum;

    /**
     * 
     */
    final private T maximum;
    
    
    final private Iterator<T> iterator;

    private Range(T min, T max, Iterator<T> iterator){
        this.minimum = min;
        this.maximum = max;
        this.iterator = iterator;
    }

    public T getMinimum() {
        return minimum;
    }

    public T getMaximum() {
        return maximum;
    }

    @Override
    public Iterator<T> iterator() {
        return iterator;
    }
        
    public static Iterable<Integer> makeRange(final int stop) {
        return makeRange(DEFAULT_START,stop,DEFAULT_STEP);
    }
        
    public static Iterable<Integer> makeRange(final int start, final int stop) {
        return makeRange(start,stop,DEFAULT_STEP);
    }
        
    public static Iterable<Integer> makeRange(final int minimum, final int maximum, final int step){
        if (minimum > maximum) {
            throw new IllegalArgumentException("If step is positive than start must be less than stop");
        }
        if (step==0){
            throw new IllegalArgumentException("step can't be 0");
        }
            
        final Iterator<Integer> itr;
        
        if (step > 0) {
            itr = new IncrIterator<>(Incrementable.wrap(minimum),step, maximum);
        } else {
            itr = new DecrIterator<>(Incrementable.wrap(maximum),step, minimum);
        } 
        return new Iterable<Integer>() {

            @Override
            public Iterator<Integer> iterator() {
                return itr;
            }
        };
    }

    public static Iterable<Integer> makeRange(final int[] array) {
        return makeRange(array, DEFAULT_START, array.length, DEFAULT_START);
    }

    public static Iterable<Integer> makeRange(final int[] array, final int maximum) {
        return makeRange(array, DEFAULT_START, maximum, DEFAULT_START);
    }

    public static Iterable<Integer> makeRange(final int[] array, final int minimum, final int maximum){
        return makeRange(array, minimum, maximum, DEFAULT_STEP);
    }

    public static Iterable<Integer> makeRange(final int[] array, final int minimum, final int maximum, final int step){
        if (minimum > maximum) {
            throw new IllegalArgumentException("If step is positive than start must be less than stop");
        }
        if (step==0){
            throw new IllegalArgumentException("step can't be 0");
        }

        if (minimum<0||maximum> array.length) {
            throw new IllegalArgumentException("step can't be 0");
        }


        return new Iterable<Integer>() {

            @Override
            public Iterator<Integer> iterator() {
                if (step > 0 )
                    return new Iterator<Integer>() {
                        int index=minimum;

                    @Override
                    public boolean hasNext() {
                        return index < maximum;
                    }

                    @Override
                    public Integer next() {
                        try {
                            return array[index++];
                        } catch(IndexOutOfBoundsException ex){
                            throw new NoSuchElementException("Index out of Range");
                        }
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException("Not supported.");
                    }
                };
                else 
                    return new Iterator<Integer>() {
                        int index = maximum;

                    @Override
                    public boolean hasNext() {
                        return index > minimum;
                    }

                    @Override
                    public Integer next() {
                        try {
                            return array[index--];
                        } catch(IndexOutOfBoundsException ex){
                            throw new NoSuchElementException("Index out of Range");
                        }
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException("Not supported.");
                    }
                };
            }
        };
    }

    public static Iterable<Float> makeRange(final float stop) {
        return makeRange(DEFAULT_START,stop,DEFAULT_STEP);
    }

    public static Iterable<Float> makeRange(final float start, final float stop) {
        return makeRange(start,stop,DEFAULT_STEP);
    }

    public static Iterable<Float> makeRange(final float minimum, final float maximum, final float step) {
        if (minimum > maximum) {
            throw new IllegalArgumentException("If step is positive than start must be less than stop");
        }
        if (step==0){
            throw new IllegalArgumentException("step can't be 0");
        }
            
        final Iterator<Float> itr;
        
        if (step > 0) {
            itr = new IncrIterator<>(Incrementable.wrap(minimum),step, maximum);
        } else {
            itr = new DecrIterator<>(Incrementable.wrap(maximum),step, minimum);
        } 
        return new Iterable<Float>() {

            @Override
            public Iterator<Float> iterator() {
                return itr;
            }
        };
    }

    public static Iterable<Long> makeRange(final long stop) {
        return makeRange(DEFAULT_START,stop,DEFAULT_STEP);
    }

    public static Iterable<Long> makeRange(final long start, final long stop) {
        return makeRange(start,stop,DEFAULT_STEP);
    }

    public static Iterable<Long> makeRange(final long minimum, final long maximum, final long step) {
        if (minimum > maximum) {
            throw new IllegalArgumentException("If step is positive than start must be less than stop");
        }
        if (step==0){
            throw new IllegalArgumentException("step can't be 0");
        }


        return new Iterable<Long>() {

            @Override
            public Iterator<Long> iterator() {

                    if (step > 0 )
                            return new Iterator<Long>() {
                                    private long index = minimum;

                                    @Override
                                    public boolean hasNext() {
                                        return index < maximum;
                                    }

                                    @Override
                                    public Long next() {
                                        if (hasNext()) {
                                                long next = index;
                                                index += step;
                                                return next;
                                        }
                                        throw new NoSuchElementException("Index out of Range");
                                    }				

                                    @Override
                                    public void remove() {
                                        throw new UnsupportedOperationException("Not supported.");
                                    }
                            };

                    else
                            return new Iterator<Long>() {
                                    private long index = maximum;

                                    @Override
                                    public boolean hasNext() {
                                        return index > minimum;
                                    }

                                    @Override
                                    public Long next() {
                                        if (hasNext()) {
                                                long next = index;
                                                index += step;
                                                return next;
                                        }
                                        throw new NoSuchElementException("Index out of Range");
                                    }

                                    @Override
                                    public void remove() {
                                        throw new UnsupportedOperationException("Not supported.");
                                    }
                            };
            }       
        };
    }

    public static Iterable<Double> makeRange(final double stop) {
        return makeRange(DEFAULT_START,stop,DEFAULT_STEP);
    }

    public static Iterable<Double> makeRange(final double start, final double stop) {
        return makeRange(start,stop,DEFAULT_STEP);
    }

    public static Iterable<Double> makeRange(final double minimum, final double maximum, final double step) {
        if (minimum > maximum) {
            throw new IllegalArgumentException("If step is positive than start must be less than stop");
        }
        if (step==0){
            throw new IllegalArgumentException("step can't be 0");
        }
            
        final Iterator<Double> itr;
        
        if (step > 0) {
            itr = new IncrIterator<>(Incrementable.wrap(minimum),step, maximum);
        } else {
            itr = new DecrIterator<>(Incrementable.wrap(maximum),step, minimum);
        } 
        return new Iterable<Double>() {

            @Override
            public Iterator<Double> iterator() {
                return itr;
            }
        };
    }

    public static Iterable<Character> makeRange(final char stop) {
        return makeRange((char)DEFAULT_START,stop,(char)DEFAULT_STEP);
    }

    public static Iterable<Character> makeRange(final char start, final char stop) {
        return makeRange(start,stop,(char)DEFAULT_STEP);
    }

    public static Iterable<Character> makeRange(final char minimum, final char maximum, final char step) {
        if (minimum > maximum) {
            throw new IllegalArgumentException("If step is positive than start must be less than stop");
        }
        if (step==0){
            throw new IllegalArgumentException("step can't be 0");
        }
            
        final Iterator<Character> itr = new Iterator<Character>() {
            private char index = step > 0 ? minimum : maximum;
            
            @Override
            public boolean hasNext() {
                return step > 0 ? (index < maximum) : (index > minimum);
            }

            @Override
            public Character next() {
                return index++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported");
            }
        };
        
        return new Iterable<Character>() {

            @Override
            public Iterator<Character> iterator() {
                return itr;
            }
        };
    }

    public static Iterable<Character> makeRange(final String str, final int maximum) {
        return makeRange(str, DEFAULT_START, maximum, DEFAULT_START);
    }

    public static Iterable<Character> makeRange(final String str, final int minimum, final int maximum){
        return makeRange(str, minimum, maximum, DEFAULT_STEP);
    }

    public static Iterable<Character> makeRange(final String str, final int minimum, final int maximum, final int step){
        if (minimum > maximum) {
            throw new IllegalArgumentException("If step is positive than start must be less than stop");
        }
        if (step==0){
            throw new IllegalArgumentException("step can't be 0");
        }

        if (minimum<0||maximum> str.length()) {
            throw new IllegalArgumentException("step can't be 0");
        }


        return new Iterable<Character>() {

            @Override
            public Iterator<Character> iterator() {
                if (step > 0 )
                    return new Iterator<Character>() {
                        int index=minimum;

                    @Override
                    public boolean hasNext() {
                        return index < maximum;
                    }

                    @Override
                    public Character next() {
                        try {
                            return str.charAt(index++);
                        } catch(IndexOutOfBoundsException ex){
                            throw new NoSuchElementException("Index out of Range");
                        }
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException("Not supported.");
                    }
                };
                else 
                    return new Iterator<Character>() {
                        int index = maximum;

                    @Override
                    public boolean hasNext() {
                        return index > minimum;
                    }

                    @Override
                    public Character next() {
                        try {
                            return str.charAt(index--);
                        } catch(IndexOutOfBoundsException ex){
                            throw new NoSuchElementException("Index out of Range");
                        }
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException("Not supported.");
                    }
                };
            }
        };
    }        

    public static Iterable<Byte> makeRange(final byte stop) {
        return makeRange(DEFAULT_START,stop,DEFAULT_STEP);
    }

    public static Iterable<Byte> makeRange(final byte start, final byte stop) {
        return makeRange(start,stop,DEFAULT_STEP);
    }

    public static Iterable<Byte> makeRange(final byte minimum, final byte maximum, final byte step) {
        if (minimum > maximum) {
            throw new IllegalArgumentException("If step is positive than start must be less than stop");
        }
        if (step==0){
            throw new IllegalArgumentException("step can't be 0");
        }
            
        final Iterator<Byte> itr;
        
        if (step > 0) {
            itr = new IncrIterator<>(Incrementable.wrap(minimum),step, maximum);
        } else {
            itr = new DecrIterator<>(Incrementable.wrap(maximum),step, minimum);
        } 
        return new Iterable<Byte>() {

            @Override
            public Iterator<Byte> iterator() {
                return itr;
            }
        };
    }
}