package list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<String> implements List<String> {

    private int size;
    private String[] array;

    public MyArrayList() {
        this.size = 0;
        this.array = (String[]) new Object[5];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean add(String element) {
        if (size >= array.length) {
            String[] bigger = (String[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int index, String element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(element);

        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends String> collection) {
        boolean flag = true;
        for (String element : collection) {
            flag &= add(element);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> collection) {
        //TODO: 구현해보세요.
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (equals(object, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }


    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public String set(int index, String element) {
        String old = get(index);
        array[index] = element;
        return old;
    }

    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    @Override
    public boolean remove(Object o) {

        for (int i = 0; i < size; i++) {
            if (o.equals(array[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String remove(int index) {
        String tmp = null;
        if (index < 0 || index > size) {
            throw new UnsupportedOperationException();
        }
        if (size != 0) {
            tmp = array[index];
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
        }
        return tmp;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object element : c) {
            while (!(remove(element))) {
                for (int i = 0; i < size; i++) {
                    if (element.equals(array[i])) {
                        remove(i);
                    }
                }
            }
        }
        return false;
    }


    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }



}
