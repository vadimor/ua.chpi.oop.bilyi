package ua.khpi.oop.bilyi05;
import java.util.Iterator;
public class MyCollection implements Iterable<String> {
	private String [] mass = new String[10];
	private int Size = 0;
	private int ActualSize = 10;
	public void setMass(String[] mass) {
		this.mass = mass;
		this.Size = mass.length;
		this.ActualSize= mass.length;
	}
	public String[] getMass() {
		var masst = new String[Size];
		for(int i = 0; i<Size; i++) {
			masst[i] = mass[i];
		}
		return masst;
	}
	public String toString() {
		StringBuilder strB = new StringBuilder();
		for(var str : this)
			strB.append(str+" ");
		if(!(strB.length()==0))
		strB.deleteCharAt(strB.length()-1);
		return strB.toString();
	}
	public void add(String string) {
		if(Size==ActualSize) {
			String [] tempMass = new String[ActualSize+10];
			ActualSize += 10;
			for(int i = 0; i<Size; i++) 
				tempMass[i]=mass[i];
			mass=tempMass;
		}
		mass[Size++]= string;
	}
	public void clear() {
		mass = new String[10];
		Size = 0;
		ActualSize = 10;
	}
	public boolean remove(String string) {
		for(int i = 0; i<Size; i++) 
			if(mass[i].equals(string)) {
				delete(i);
				return true;
			}
		return false;
	}
	public Object[] toArray() {
		return getMass();
	}
	public int size() {
		return Size;
	}
	public boolean contains(String string) {
		for(var str : this) {
			if(str.equals(string))
				return true;
		}
		return false;
	}
	public boolean containsAll(MyCollection container) {
		for(var str : container)
			if(!contains(str)) {
				return false;
			}
		return true;//TODO
	}
	private void delete(int i) {
		String [] tempMass = new String[ActualSize];
		for(int j = 0; j<i;j++) {
			tempMass[j]=mass[j];
		}
		for(int j = i+1;j<Size;j++) {
			tempMass[j]=mass[j];		
		}
		mass = tempMass;
		Size -= 1;
	}
	public String get(int i) {
		if(i<Size)
			return mass[i];
			else
			return null;
	}
	public Iterator<String> iterator() {
		Iterator<String> MyIterator = new Iterator<String>(){
			private int i = 0;
			public String next() {
				return mass[i++];
			}
			public boolean hasNext() {
				return i<Size;
			}
			public void remove() {
				delete(i-1);
			}
		};
		return MyIterator;
	}
}
