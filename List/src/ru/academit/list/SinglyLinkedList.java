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

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;
        count++;
    }

    public void setHead(ListItem<T> head) {
        this.head = head;
    }

    public int getCount() {
        if (count > 0) {
            return count;
        } else {
            return 0;
        }
    }

    public T getFirst() {
        return head.getData();
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public T removeFirst() {
        if (count == 1) {
            System.out.println("The list contains only head that can't be removed");
            return null;
        }
        T prev = head.getData();
        head = head.getNext();
        count--;
        return prev;
    }

    public T getDataByIndex(int index) {
        if (index > count) {
            System.out.println("Index greater than quantity of objects in the list...");
            return null;
        } else if (index < 0) {
            System.out.println("Index has to be a positive number...");
            return null;
        } else {
            int counter = 0;
            for (ListItem<T> p = head; p != null; p = p.getNext()) {
                counter++;
                if (counter == index) {
                    return p.getData();
                }
            }
            return null;
        }
    }

    public T setDataByIndex(T newData, int index) {
        if (index > count) {
            System.out.println("Index greater than quantity of objects in the list...");
            return null;
        } else if (index < 0) {
            System.out.println("Index has to be a positive number...");
            return null;
        } else {
            int counter = 0;
            for (ListItem<T> p = head; p != null; p = p.getNext()) {
                counter++;
                if (counter == index) {
                    T prev = p.getData();
                    p.setData(newData);
                    return prev;
                }
            }
            return null;
        }
    }

    public void addByIndex(T data, int index) {
        if (index > count) {
            System.out.println("Index greater than quantity of objects in the list...");
        } else if (index < 0) {
            System.out.println("Index has to be a positive number...");
        } else {
            int counter = 0;
            for (ListItem<T> p = head; p != null; p = p.getNext()) {
                counter++;
                if (counter == index) {
                    ListItem<T> q = new ListItem<>(data);
                    q.setNext(p.getNext());
                    p.setNext(q);
                    count++;
                }
            }
        }
    }

    public T removeByIndex(int index) {
        if (index > count) {
            System.out.println("Index greater than quantity of objects in the list...");
            return null;
        } else if (index < 0) {
            System.out.println("Index has to be a positive number...");
            return null;
        } else if (count == 1) {
            System.out.println("The list contains only head that can't be removed");
            return null;
        } else {
            int counter = 0;
            for (ListItem<T> p = head; p != null; p = p.getNext()) {
                counter++;
                if (counter == index) {
                    T prev = p.getData();
                    p.setNext(p.getNext().getNext());
                    count--;
                    return prev;
                }
            }
            return null;
        }
    }

    public boolean removeByData(T data) {
        if (head == null) {
            return false;
        } else {
            for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
                if (p.getData().equals(data)) {
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
    }

    public void reverseList() {
        if (count <= 1 || head == null || head.getNext() == null) {
            System.out.println("there're not enough list_items to make a reverse...");
        } else {
            ListItem<T> prev = null;
            for (ListItem<T> p = head, pNext; p != null; prev = p, p = pNext) {
                pNext = p.getNext();
                p.setNext(prev);
            }
            head = prev;
        }
    }

    public SinglyLinkedList<T> copyList() {
        if (head == null) {
            return null;
        } else {
            ListItem<T> newHead = new ListItem<>(head.getData());
            SinglyLinkedList<T> newList = new SinglyLinkedList<>(newHead);
            for (ListItem<T> p = head.getNext(), c = newHead; p != null; p = p.getNext(), c = c.getNext()) {
                ListItem<T> q = new ListItem<>(p.getData());
                c.setNext(q);
            }
            newList.count = this.getCount();
            return newList;
        }
    }
}