package ru.academit.list;

public class ListItem<T> {
    private T data;
    private ListItem<T> next;

    public ListItem(T data) {
        this.data = data;
    }

    public ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(ListItem<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public ListItem<T> getNext() {
        return next;
    }
}
