// Сделать свою реализацию списка ArrayList<T> (в C# - List<T>), сделать его generic’ом.
// Необходимо реализовать интерфейс List<T> (в C# - IList<T>).
// Нужно реализовать специфичный конструктор, принимающий вместимость,
// а также методы ensureCapacity и trimToSize.

// 1 size
// 2 isEmpty
// 3 contains
// 4 iterator
// 5 toArray
// 6 toArray
// 7 add
// 8 remove
// 9 containsAll
// 10 addAll
// 11 addAll
// 12 removeAll
// 13 retainAll
// 14 clear
// 15 get
// 16 set
// 17 add
// 18 remove
// 19 indexOf
// 20 lastIndexOf
// 21 increaseCapacity
// 22 ensureCapacity
// 23 trimToSize
package ru.academit.arrayList;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] items; //  items.length = вместимость, длина массива
    private int length; // реальное кол-во элементов, которые существуют в списке, 0 - by default, длина списка
    private int modCount;

    public ArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IndexOutOfBoundsException("Capacity must be greater than 0");
        }
        //noinspection unchecked
        items = (T[]) new Object[initialCapacity];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int currentModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < length;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("The end of collection is reached");
            }
            if (currentModCount != modCount) {
                throw new ConcurrentModificationException("The elements were changed");
            }
            currentIndex++;
            return items[currentIndex];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    public Object[] toArray() {
        return Arrays.copyOf(items, length);
    }

    public <S> S[] toArray(S[] a) {
        if (a.length < length) {
            //noinspection unchecked
            return (S[]) Arrays.copyOf(items, length, a.getClass());
        }
        System.arraycopy(items, 0, a, 0, length);
        if (a.length > length) {
            a[length] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        if (length >= items.length) {
            increaseCapacity();
        }
        items[length] = t;
        length++;
        modCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = 0;
        for (T arrayItem : items) {
            if (Objects.equals(arrayItem, o)) {
                remove(index);
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new NoSuchElementException("The collection does not exist");
        }
        for (Object cElement : c) {
            if (!this.contains(cElement)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) {
            throw new NoSuchElementException("The collection does not exist");
        }
        int i = 0;
        ensureCapacity(length + c.size());
        for (T cElement : c) {
            items[i + length] = cElement;
            i++;
        }
        length += c.size();
        modCount++;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c == null) {
            throw new NoSuchElementException("The collection does not exist");
        }
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Your index is greater than list's length or less than 0." +
                    System.lineSeparator() +
                    "Specify another index or paste more elements into the list to increase capacity...");
        }
        if (index == length) {
            addAll(c);
            return true;
        }
        ensureCapacity(length + c.size());
        System.arraycopy(items, index, items, index + c.size(), length - index);
        int i = index;
        for (T cElement : c) {
            items[i] = cElement;
            i++;
        }
        length += c.size();
        modCount++;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NoSuchElementException("The collection does not exist");
        }
        boolean isRemoved = false;
        for (Object cElement : c) {
            for (int i = 0; i < length; i++) {
                if (Objects.equals(items[i], cElement)) {
                    remove(items[i]);
                    i--;
                    isRemoved = true;
                }
            }
        }
        return isRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NoSuchElementException("The collection does not exist");
        }
        boolean areNotEquals = false;
        for (int i = size() - 1; i >= 0; i--) {
            if (!c.contains(get(i))) {
                remove(i);
                areNotEquals = true;
            }
        }
        return areNotEquals;
    }

    @Override
    public void clear() {
        modCount++;
        length = 0;
    }

    @Override
    public T get(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Your index is greater than list's length" + System.lineSeparator() +
                    "Specify another index or paste more elements into the list to increase capacity...");
        }
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Your index is greater than list's length" + System.lineSeparator() +
                    "Specify another index or paste more elements into the list to increase capacity...");
        }
        T prev = items[index];
        items[index] = element;
        return prev;
    }

    @Override
    public void add(int index, T element) {
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Your index is greater than list's length" + System.lineSeparator() +
                    "Specify another index or paste more elements into the list to increase capacity...");
        }
        if (index < length) {
            if (length >= items.length) {
                increaseCapacity();
            }
            System.arraycopy(items, index, items, index + 1, length - index);
            items[index] = element;
            length++;
            modCount++;
        } else { // index == length
            add(element);
        }
    }

    @Override
    public T remove(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Your index is greater than list's length");
        }
        T prev = items[index];
        System.arraycopy(items, index + 1, items, index, length - index - 1);
        length--;
        modCount++;
        return prev;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i >= 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    public void ensureCapacity(int capacity) {
        if (items.length < capacity) {
            items = Arrays.copyOf(items, capacity);
        }
    }

    public void trimToSize() {
        if (items.length > length) {
            items = Arrays.copyOf(items, length);
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}