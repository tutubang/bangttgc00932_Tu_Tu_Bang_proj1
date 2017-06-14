package project.my_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyList<T> implements Iterable<T> {
	MyNode<T> head;
	MyNode<T> tail;
	int size = 0;

	public boolean isEmpty() {
		return head == null;
	}

	public void add(T t) {
		MyNode<T> q = new MyNode<T>(t);
		if (isEmpty()) {
			head = tail = q;
		} else {
			tail.next = q;
			tail = q;
		}
		size++;
	}

	public List<T> toList() {
		List<T> list = new ArrayList<>();
		for (MyNode<T> myNode = head; myNode != null; myNode = myNode.next) {
			list.add(myNode.t);
		}
		return list;
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {
			MyNode<T> current = head;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				T t = current.t;
				current = current.next;
				return t;
			}
		};
		return iterator;
	}

	public MyNode<T> get(int i) {
		MyNode<T> myNode = head;
		for (int j = 0; j < size; j++) {
			if (j == i) {
				return myNode;
			}
			myNode = myNode.next;
		}
		return null;
	}

	public void remove(T t) {
		for (MyNode<T> temp = head; temp.next != null; temp = temp.next) {
			if (temp.t.equals(t)) {
				head = head.next;
				size--;
			} else if (temp.next.next == null) {
				temp.next = null;
				tail = temp;
				size--;
				break;
			} else if (temp.next.t.equals(t)) {
				temp.next = temp.next.next;
				size--;
			}
		}
	}

	public void removeAfter(T t) {
		for (MyNode<T> temp = head; temp.next != null; temp = temp.next) {
			if (temp.t.equals(t)) {
				temp.next = temp.next.next;
				size--;
			} else if (temp.next.next == null) {
				break;
			}
		}
	}
}
