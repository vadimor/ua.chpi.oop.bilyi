package ua.khpi.oop.bilyi10;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Створити власний клас-контейнер, що параметризується (Generic Type), на основі зв'язних списків для реалізації колекції domain-об’єктів лабораторної роботи №7.
//
//Для розроблених класів-контейнерів забезпечити можливість використання їх об'єктів у циклі foreach в якості джерела даних.
//
//Забезпечити можливість збереження та відновлення колекції об'єктів: 1) за допомогою стандартної серіалізації; 2) не використовуючи протокол серіалізації.
//
//Продемонструвати розроблену функціональність: створення контейнера, додавання елементів, видалення елементів, очищення контейнера, перетворення у масив, перетворення у рядок, перевірку на наявність елементів.

public class MyCollection<T> implements Iterable<T>, Serializable {
	static final long serialVersionUID = 1L;
	private int size;
	private Member<T> start;
	private Member<T> last;

	public void saveSer(String fileName) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(fileName);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		for (T value : this)
			objectOutputStream.writeObject(value);
		objectOutputStream.close();
	}

	@SuppressWarnings("unchecked")
	public void downloadSer(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream inStream = new FileInputStream(fileName);
		ObjectInputStream objectInStream = new ObjectInputStream(inStream);
		try {
			while (true) {
				add((T) objectInStream.readObject());
			}
		} catch (EOFException e) {
			objectInStream.close();
		}

	}

	public void swap(int itr1, int itr2) {
		if (itr1 >= size && itr2 >= size && itr1 == itr2)
			return;

		Member<T> temp1 = start.next;
		Member<T> temp2 = start.next;
		for (int i = 0; i < itr1; i++) {
			temp1 = temp1.next;
		}

		for (int i = 0; i < itr2; i++) {
			temp2 = temp2.next;
		}
		T temp = temp1.obj;
		temp1.obj = temp2.obj;
		temp2.obj = temp;

	}

	public boolean find(T obj) {
		for (T value : this) {
			if (value.equals(obj))
				return true;
		}
		return false;
	}

	public String toString() {
		String str = new String();
		for (T value : this) {
			str += value + "\n";
		}
		return str;
	}

	public void clear() {
		start.next = last;
		last.prev = start;
		size = 0;
	}

	public void saveXml(String fileName) throws FileNotFoundException {
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));

		for (T value : this)
			encoder.writeObject(value);
		encoder.close();
		System.out.println("Serialization successful\n");
	}

	@SuppressWarnings("unchecked")
	public void downloadXml(String fileName) throws FileNotFoundException {
		XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)));
		try {
			while (true) {
				add((T) d.readObject());
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			d.close();
			System.out.println("Serialization successful\n");
		} catch (Exception e) {
			throw e;
		}

	}

	public int getSize() {
		return size;
	}

	MyCollection() {
		size = 0;
		start = new Member<T>(null, null, null);
		last = new Member<T>(null, start, null);
		start.next = last;
	}

	void add(T obj) {
		Member<T> temp = last.prev;
		temp.next = new Member<T>();
		last.prev = temp.next;

		temp.next.obj = obj;

		temp.next.next = last;
		temp.next.prev = temp;
		size++;
	}

	void delete(int itr) {
		if (itr >= size)
			return;

		Member<T> temp = start.next;
		Member<T> temp2 = null;

		for (int i = 0; i < itr; i++) {
			temp = temp.next;
		}

		temp2 = temp.prev;
		temp2.next = temp.next;
		temp.next.prev = temp2;
		size--;
	}

	T get(int itr) {
		if (itr >= size && itr < 0)
			return null;

		Member<T> temp = start.next;

		for (int i = 0; i < itr; i++) {
			temp = temp.next;
		}

		return temp.obj;
	}

	public T[] toArray(T[] arr) {
		for (int i = 0; i < size; i++) {
			arr[i] = get(i);
		}
		return arr;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int itr = 0;

			@Override
			public boolean hasNext() {

				return itr < size;
			}

			@Override
			public T next() {
				return get(itr++);
			}

			@Override
			public void remove() {
				delete(itr - 1);
			}
		};
	}
}
