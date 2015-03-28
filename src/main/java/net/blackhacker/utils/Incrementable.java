package net.blackhacker.utils;

/**
 *
 * @author ben
 * @param <T>
 */
abstract public class Incrementable<T extends Number>  {
    
    /**
     * 
     */
    protected T value;
    
    protected Incrementable(T t) {
        this.value = t;
    }
    
    final public T getValue() {
        return value;
    }
    
    abstract public Incrementable<T> incr();
    abstract public Incrementable<T> incr(T t);
    
    abstract public Incrementable<T> decr();
    abstract public Incrementable<T> decr(T t);
    
    abstract public boolean lt(T t);
    abstract public boolean le(T t);
    abstract public boolean gt(T t);
    abstract public boolean ge(T t);
    abstract public boolean eq(T t);
    abstract public boolean ne(T t);
    
    public static Incrementable<Byte> wrap(byte value){
        return new Incrementable<Byte>(value) {

            @Override
            public Incrementable<Byte> incr() {
                this.value++;
                return this;
            }

            @Override
            public Incrementable<Byte> decr() {
                this.value--;
                return this;
            }

            @Override
            public Incrementable<Byte> incr(Byte t) {
                this.value= (byte)(this.value + t);
                return this;
            }

            @Override
            public Incrementable<Byte> decr(Byte t) {
                this.value= (byte)(this.value - t);
                return this;
            }
            
            @Override
            public boolean lt(Byte x) {
                return this.value<x;
            }
            
            @Override
            public boolean le(Byte x) {
                return this.value<=x;
            }
            
            @Override
            public boolean gt(Byte x) {
                return this.value>x;
            }
            
            @Override
            public boolean ge(Byte x) {
                return this.value>=x;
            }
            
            @Override
            public boolean eq(Byte x) {
                return this.value.equals(x);
            }
            
            @Override
            public boolean ne(Byte x) {
                return !this.value.equals(x);
            }
        };
    }

    public static Incrementable<Short> wrap(short value){
        return new Incrementable<Short>(value) {

            @Override
            public Incrementable<Short> incr() {
                this.value++;
                return this;
            }

            @Override
            public Incrementable<Short> decr() {
                this.value--;
                return this;
            }

            @Override
            public Incrementable<Short> incr(Short t) {
                this.value=(short)(this.value+t);
                return this;
            }

            @Override
            public Incrementable<Short> decr(Short t) {
                this.value=(short)(this.value-t);
                return this;
            }
            
            @Override
            public boolean lt(Short x) {
                return this.value<x;
            }
            
            @Override
            public boolean le(Short x) {
                return this.value<=x;
            }
            
            @Override
            public boolean gt(Short x) {
                return this.value>x;
            }
            
            @Override
            public boolean ge(Short x) {
                return this.value>=x;
            }
            
            @Override
            public boolean eq(Short x) {
                return this.value.equals(x);
            }
            
            @Override
            public boolean ne(Short x) {
                return !this.value.equals(x);
            }
        };
    }
    
    public static Incrementable<Integer> wrap(int value){
        return new Incrementable<Integer>(value) {

            @Override
            public Incrementable<Integer> incr() {
                this.value++;
                return this;
            }

            @Override
            public Incrementable<Integer> decr() {
                this.value--;
                return this;
            }

            @Override
            public Incrementable<Integer> incr(Integer t) {
                this.value=this.value+t;
                return this;
            }

            @Override
            public Incrementable<Integer> decr(Integer t) {
                this.value=this.value-t;
                return this;
            }

            @Override
            public boolean lt(Integer x) {
                return this.value<x;
            }
            
            @Override
            public boolean le(Integer x) {
                return this.value<=x;
            }
            
            @Override
            public boolean gt(Integer x) {
                return this.value>x;
            }
            
            @Override
            public boolean ge(Integer x) {
                return this.value>=x;
            }
            
            @Override
            public boolean eq(Integer x) {
                return this.value.equals(x);
            }
            
            @Override
            public boolean ne(Integer x) {
                return !this.value.equals(x);
            }
        };
    }
    
    public static Incrementable<Long> wrap(long value){
        return new Incrementable<Long>(value) {

            @Override
            public Incrementable<Long> incr() {
                this.value++;
                return this;
            }

            @Override
            public Incrementable<Long> decr() {
                this.value--;
                return this;
            }

            @Override
            public Incrementable<Long> incr(Long t) {
                this.value=(long)(this.value+t);
                return this;
            }

            @Override
            public Incrementable<Long> decr(Long t) {
                this.value=(long)(this.value+t);
                return this;
            }
            @Override
            public boolean lt(Long x) {
                return this.value<x;
            }
            
            @Override
            public boolean le(Long x) {
                return this.value<=x;
            }
            
            @Override
            public boolean gt(Long x) {
                return this.value>x;
            }
            
            @Override
            public boolean ge(Long x) {
                return this.value>=x;
            }
            
            @Override
            public boolean eq(Long x) {
                return this.value.equals(x);
            }
            
            @Override
            public boolean ne(Long x) {
                return !this.value.equals(x);
            }
        };
    }

    public static Incrementable<Float> wrap(float value){
        return new Incrementable<Float>(value) {

            @Override
            public Incrementable<Float> incr() {
                this.value++;
                return this;
            }

            @Override
            public Incrementable<Float> decr() {
                this.value--;
                return this;
            }

            @Override
            public Incrementable<Float> incr(Float t) {
                this.value=this.value+t;
                return this;
            }

            @Override
            public Incrementable<Float> decr(Float t) {
                this.value=(float)(this.value+t);
                return this;
            }

            @Override
            public boolean lt(Float x) {
                return this.value<x;
            }
            
            @Override
            public boolean le(Float x) {
                return this.value<=x;
            }
            
            @Override
            public boolean gt(Float x) {
                return this.value>x;
            }
            
            @Override
            public boolean ge(Float x) {
                return this.value>=x;
            }
            
            @Override
            public boolean eq(Float x) {
                return this.value.equals(x);
            }
            
            @Override
            public boolean ne(Float x) {
                return !this.value.equals(x);
            }        
        };
    }

    public static Incrementable<Double> wrap(double value){
        return new Incrementable<Double>(value) {

            @Override
            public Incrementable<Double> incr() {
                this.value++;
                return this;
            }

            @Override
            public Incrementable<Double> decr() {
                this.value--;
                return this;
            }

            @Override
            public Incrementable<Double> incr(Double t) {
                this.value=(double)(this.value+t);
                return this;
            }

            @Override
            public Incrementable<Double> decr(Double t) {
                this.value=(double)(this.value+t);
                return this;
            }

            @Override
            public boolean lt(Double x) {
                return this.value<x;
            }
            
            @Override
            public boolean le(Double x) {
                return this.value<=x;
            }
            
            @Override
            public boolean gt(Double x) {
                return this.value>x;
            }
            
            @Override
            public boolean ge(Double x) {
                return this.value>=x;
            }
            
            @Override
            public boolean eq(Double x) {
                return this.value.equals(x);
            }
            
            @Override
            public boolean ne(Double x) {
                return !this.value.equals(x);
            }            
        };
    }
}
