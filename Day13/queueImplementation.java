// Implement Queue Using Arrays
import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		Queue q = new Queue(5);
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		q.add(50);
		q.add(50);
		q.add(50);

		System.out.println("size  : "+q.size());
		System.out.println("peek : "+q.peek());;
		
		System.out.println("poll : "+q.poll());;
		System.out.println("size  : "+q.size());

		System.out.println("poll : "+q.poll());;		
		System.out.println("poll : "+q.poll());;
		System.out.println("size  : "+q.size());

		q.add(130);
		q.add(140);
		System.out.println("size  : "+q.size());
		q.add(150);
		
		System.out.println("---------------------------");
		System.out.println("size  : "+q.size());
		while(!q.empty()){

			System.out.println("poll : "+q.poll());;

		}
		System.out.println("size  : "+q.size());
		System.out.println("poll : "+q.poll());;

		

	}
	
}

class Queue{
	int data[];
	int capacity ;
	int front ;
	int rear ;
	int size;
	public Queue(){
		this.capacity =  1000;
		this.data =  new int[this.capacity];
		this.front =  this.rear =  -1;		
		this.size  = 0;
	}
	public Queue(int capacity){
		this.capacity =  capacity;
		this.data =  new int[this.capacity];
		this.front =  this.rear =  -1;
		this.size  = 0;
	}

	public void add(int val){
		if(size==capacity){
			System.out.println("Queue full");
			 return;
		}
		if(front==-1){
			++front;					
		}		
		rear =  (rear+1)%capacity;
		data[ rear] = val;		
		size+=1;			
	}

	public int peek(){
		if(size==0){
			System.out.println("Queue Empty");
			return -1;
		}
		return data[front];
	}
	public int poll(){
		if(size==0){
			System.out.println("Queue Empty");
			return -1;
		}
		int peekEle =  data[front];
		front =  (front+1)%capacity;
		size-=1;
		if(size==0){
			front =  rear =  -1;
		}
		return peekEle;
	}
	public int size(){
		return size;
	}
	public boolean empty(){
		return size==0;
	}
}