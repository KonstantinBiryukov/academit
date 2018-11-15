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
        for (T arrayItem : items) {
            if (Objects.equals(arrayItem, o)) {
                return true;
            }
        }
        return false;
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

    public <T> T[] toArray(T[] a) {
        if (a.length < length) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(items, length, a.getClass());
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
        if (c != null) {
            int count = 0;
            for (Object cElement : c) {
                boolean isContains = this.contains(cElement);
                if (isContains) {
                    count++;
                }
            }
            return count == c.size();
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c != null) {
            ensureCapacity(length + c.size());
            for (T cElement : c) {
                items[length] = cElement;
                length++;
            }
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c != null) {
            if (index == length) {
                addAll(c);
                return true;
            }
            if (index > length || index < 0) {
                throw new IndexOutOfBoundsException("Your index is greater than list's length" + System.lineSeparator() +
                        "Specify another index or paste more elements into the list to increase capacity...");
            }
            ensureCapacity(length + c.size());
            System.arraycopy(items, index, items, index + c.size(), length - index);
            int indexCounter = 0;
            int indexCurrent = index;
            for (T cElement : c) {
                if (indexCounter < c.size()) {
                    items[indexCurrent] = cElement;
                    indexCounter++;
                    length++;
                    indexCurrent++;
                }
            }
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c != null) {
            int count = 0;
            for (int index = 0; index < length; index++) {
                for (Object cItem : c) {
                    if (Objects.equals(items[index], cItem)) {
                        remove(index);
                        count++;
                    }
                }
            }
            modCount++;
            return count > 0;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c != null) {
            int count = 0;
            boolean areEquals;
            int index = 0;
            int tempLength = length;
            for (int i = 0; i < tempLength; ++i) {
                areEquals = false;
                for (Object cItem : c) {
                    if (Objects.equals(items[index], (cItem))) {
                        areEquals = true;
                    }
                }
                if (!areEquals) {
                    remove(index);
                    count++;
                } else {
                    index++;
                }
            }
            if (c != this) {
                modCount++;
            }
            return count > 0;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = length - 1; i >= 0; i--) {
            remove(i);
        }
    }

    @Override
    public T get(int index) {
        if (index >= length) {
            throw new ArrayIndexOutOfBoundsException("Your index is greater than list's length" + System.lineSeparator() +
                    "Specify another index or paste more elements into the list to increase capacity...");
        }
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        T prev;
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Your index is greater than list's length" + System.lineSeparator() +
                    "Specify another index or paste more elements into the list to increase capacity...");
        }
        prev = items[index];
        items[index] = element;
        return prev;
    }

    @Override
    public void add(int index, T element) {
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Your index is greater than list's length" + System.lineSeparator() +
                    "Specify another index or paste more elements into the list to increase capacity...");
        } else if (index < length) {
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
        T prev;
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Your index is greater than list's length");
        } else if (index < length - 1) {
            prev = items[index];
            System.arraycopy(items, index + 1, items, index, length - index - 1);
        } else {
            prev = items[index];
        }
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