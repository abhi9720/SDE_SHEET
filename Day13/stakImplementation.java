//Stack Using Array
import java.io.*;
import java.util.*;



public class Main {
	public static void main(String[] args) {
		Stack  stk =  new Stack();
		stk.add(10);
		stk.add(20);
		stk.add(30);
		System.out.println("Peek  "+stk.peek() );
		System.out.println("Size : "+stk.size() );
		System.out.println("popped : "+stk.pop());
		System.out.println("Size : "+stk.size() );
		while(!stk.isEmpty() ){
			System.out.println("popped : "+stk.pop());
		}
		
	}
}


class Stack{	
	int data[];
	int top=-1;	
	int capacity ;
	public Stack(){		
		this.top = -1;
		this.capacity = 1000;
		data = new int[this.capacity];
	}
	public Stack(int capacity){
		this.top =  -1;
		this.capacity =  capacity;
		data = new int[this.capacity];
	}

	public void add(int val){
		if(top==capacity-1) {
			System.out.println("Stack OverFlow ");
			return;			 
		}
		data[++top] =  val;
	}
	public int peek(){
		if(top==-1 ){
			System.out.println("Stack underFlow");
			 return -1;
		}
		return data[top];
	}
	public int pop(){
		if(top==-1 ){
			System.out.println("underFlow");
			 return -1;
		}
		int popped =  data[top];
		top-=1;
		return popped;
	}

	public boolean isEmpty(){
		return top==-1;
	}

	public int size(){
		return top+1;
	}
	
}


// Using ArrayList

import java.io.*;
import java.util.*;



public class Main {
	public static void main(String[] args) {
		Stack  stk =  new Stack();
		stk.add(10);
		stk.add(20);
		stk.add(30);
		System.out.println("Peek  "+stk.peek() );
		System.out.println("Size : "+stk.size() );
		System.out.println("popped : "+stk.pop());
		System.out.println("Size : "+stk.size() );
		while(!stk.isEmpty() ){
			System.out.println("popped : "+stk.pop());
		}
	}
}


class Stack{	
	ArrayList<Integer> data;	
	public Stack(){
		data =  new ArrayList<>();
	}
	public void add(int val){
		data.add(val);
	}
	public int peek(){
		if(data.size() ==0 ){
			System.out.println("underFlow");
			 return -1;
		}
		return data.get(data.size() -1 );
	}
	public int pop(){
		if(data.size() == 0 ){
			System.out.println("underFlow");
			 return -1;
		}
		return data.remove(data.size()-1 );
	}

	public boolean isEmpty(){
		return data.size()==0;
	}

	public int size(){
		return data.size();
	}
	
}