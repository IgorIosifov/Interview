package Lesson2;

public class ArrayList<T extends Comparable<T>> {

    private int size = 0;
    private Object[] list = new Object[1];

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        if (size >= 0) System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }

    public int size() {
        return size;
    }

    public void add(T t) {
        if (size == list.length) {
            resize(2 * list.length);
        }
        list[size++] = t;
    }

    public boolean delete(T t) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(t)) {
                Object[] temp = new Object[size - 1];
                System.arraycopy(list, 0, temp, 0, i);
                System.arraycopy(list, i + 1, temp, i, size - i - 1);
                size--;
                list = temp;
                if (size == list.length / 4 && size > 0) {
                    resize(list.length / 2);
                }
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (T) list[index];
    }

    public T set(int index, T item) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        T t = (T) list[index];
        list[index] = item;
        return t;
    }

    public boolean find(T t) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(t)) {
                return true;
            }
        }
        return false;
    }
}
