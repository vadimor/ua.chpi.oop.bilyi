package ua.khpi.oop.bilyi09;

public class Member <T> {

	public T obj;
	
	public Member<T> next;
	
	public Member<T> prev;
	
	Member(){
		
	}
	Member(T obj, Member<T> prev, Member<T> next){
		this.obj = obj;
		this.next = next;
		this.prev = prev;
	}
}
