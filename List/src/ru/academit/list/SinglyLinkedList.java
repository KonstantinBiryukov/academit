//• получение размера списка
//•	получение значение первого элемента
//•	вставка элемента в начало
//•	удаление первого элемента, пусть выдает значение элемента
//•	получение/изменение значения по указанному индексу. Изменение значения по индексу пусть выдает старое значение
//•	вставка элемента по индексу
//•	удаление элемента по индексу, пусть выдает значение элемента
//•	удаление узла по значению, пусть выдает true, если элемент был удален
//•	разворот списка за линейное время
//•	копирование списка
package ru.academit.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    private ListItem<T> getSinglyLinkedListIterator(int index) {
        if (index >= count) {
            throw new IndexOutOfBoundsException("Index greater than quantity of objects in the list...");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("Index has to be a positive number...");
        }
        int counter = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (counter == index) {
                return p;
            }
            counter++;
        }
        return head;
    }

    public int getCount() {
        return count;
    }

    public T getFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException("The list is empty");
        }
        return head.getData();
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public T removeFirst() {
        T prev = head.getData();
        head = head.getNext();
        count--;
        return prev;
    }

    public T getDataByIndex(int index) {
        ListItem<T> p = getSinglyLinkedListIterator(index);
        return p.getData();
    }

    public T setDataByIndex(T newData, int index) {
        ListItem<T> p = getSinglyLinkedListIterator(index);
        T prev = p.getData();
        p.setData(newData);
        return prev;
    }

    public void addByIndex(T data, int index) {
        ListItem<T> p = getSinglyLinkedListIterator(index);
        ListItem<T> q = new ListItem<>(data);
        q.setNext(p.getNext());
        p.setNext(q);
        count++;
    }

    public T removeByIndex(int index) {
        ListItem<T> p = getSinglyLinkedListIterator(index);
        T prev = p.getData();
        p.setNext(p.getNext().getNext());
        count--;
        return prev;
    }

    public boolean removeByData(T data) {
        if (head == null) {
            return false;
        }
        if (data == null) {
            for (ListItem<T> p = head; p != null; p = p.getNext()) {
                if (p.getData() == null) {
                    return true;
                }
            }
        }
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (p.getData() == null) {
                if (data == null) {
                    return true;
                }
                break;
            } else if (p.getData().equals(data)) {
                if (prev == null) {
                    head = p.getNext();
                    return true;
                }
                prev.setNext(p.getNext());
                count--;
                return true;
            }
        }
        return false;
    }

    public void reverseList() {
        ListItem<T> prev = null;
        for (ListItem<T> p = head, pNext; p != null; prev = p, p = pNext) {
            pNext = p.getNext();
            p.setNext(prev);
        }
        head = prev;
    }

    public SinglyLinkedList<T> copyList() {
        if (count == 0) {
            return new SinglyLinkedList<>();
        }
        ListItem<T> newHead = new ListItem<>(head.getData());
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();
        newList.head = newHead;
        for (ListItem<T> p = head.getNext(), c = newHead; p != null; p = p.getNext(), c = c.getNext()) {
            ListItem<T> q = new ListItem<>(p.getData());
            c.setNext(q);
        }
        newList.count = this.getCount();
        return newList;
    }
}