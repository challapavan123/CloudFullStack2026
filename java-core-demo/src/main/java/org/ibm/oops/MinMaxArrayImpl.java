package org.ibm.oops;

public class MinMaxArrayImpl<T extends Comparable<T>> implements MinMaxArray<T> {

    private T[] array;

    public MinMaxArrayImpl(T ... array) {
        this.array = array;
    }
    @Override
    public T findMax() {
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }   
        return max;
    }

    @Override
    public T findMin() {
        T min = array[0];
        for (T element : array) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }
}
