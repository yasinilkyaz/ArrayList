package com.company;

public class MyList<T> {

    private Object[] array;
    private int countOfElement;
    private int initialCapacity;

    public MyList() {
        this.countOfElement = 0;
        this.initialCapacity = 10;

        this.array = (T[]) new Object[this.initialCapacity];

    }

    public MyList(int capacity) {
        this.initialCapacity = 10;
        this.countOfElement = this.initialCapacity;
        this.array = (T[]) new Object[this.initialCapacity];
    }

    public int size() {
        return this.countOfElement;
    }

    public int getCapacity() {
        return this.array.length;
    }

    public void add(T data) {
        if (this.size() == this.getCapacity()) {
            Object[] o = this.array;

            this.array = new Object[o.length * 2];
            for (int i = 0; i < this.size(); i++) {
                this.array[i] = o[i];
            }
        }

        this.array[this.countOfElement++] = data;
    }


    public T get(int index) {
        if (index < 0 || index >= this.countOfElement)
            return null;

        return (T) this.array[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= this.countOfElement)
            return null;

        T temp = (T) this.array[index];
        for (int i = index + 1; i < this.getCapacity(); i++)
            this.array[i - 1] = this.array[i];

        this.array[this.countOfElement--] = null;

        return (T) temp;
    }

    public boolean set(int index, T data) {
        if (index <= 0 || index >= this.countOfElement) {
            return false;
        }
        this.array[index] = data;
        return true;
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.size(); i++) {
            if (this.array != null) {
                temp += this.array[i];
                if (i != this.size() - 1) {
                    temp += ",";
                }
            }

        }
        temp = "[" + temp + "]";

        return temp;
    }

    public int indexOf(T data) {
        for (int i = 0; i < this.size(); i++) {
            if (this.array[i].equals(data))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = this.size() - 1; i >= 0; i--) {
            if (this.array[i].equals(data))
                return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public T[] toArray() {
        Object[] temp = new Object[this.size()];
        for (int i = 0; i < temp.length; i++)
            temp[i] = this.array[i];

        return (T[]) this.array;
    }

    public void clear() {
        for (int i = 0; i < this.size(); i++)
            this.array[i] = null;

        this.array = (T[]) new Object[this.initialCapacity];
    }

    public boolean contains(T data) {
        for (int i = 0; i < this.size(); i++) {
            if (this.array[i].equals(data))
                return true;
        }
        return false;
    }

    public MyList<T> subList(int start, int finish) {
        if ((start < 0 || start >= this.size()) || (finish < 0 || finish >= this.size()))
            return null;

        MyList<T> arr = new MyList<>(finish - start + 1);

        for (int i = start; i <= finish; i++) {
            arr.add((T) this.array[i]);
        }
        return arr;
    }


}

