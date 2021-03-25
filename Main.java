import java.util.Scanner;

public class Main {
	static class LinkedList{
		public class Node{
			int data;
			Node next;
			public Node(int object) {
				data = object;
				next = null;
			}
		}
		private Node head;
		private int currentSize;
		public LinkedList() {
			head = null;
			currentSize = 0;
		}
		// functions for linked list manipulations
		public void addFirst(int object) {
			Node node = new Node(object);
			node.next = head;
			head = node;	
			currentSize++;
		}
		public void addLast(int object) {
			Node newNode = new Node(object);
			Node temp = head;
			if (head == null) {
				head = newNode;
				currentSize++;
				return;
			}
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			currentSize++;
			return;
		}
		public void add(int object) {
			Node newNode = new Node(object);
			Node current = head;
			if (head == null || current.data > object) {
				addFirst(object);
				return;
			}
			while(current.next != null) {
				if (current.next.data > object) {
					newNode.next = current.next;
					current.next = newNode;
					return;
				}
				current = current.next;
			}
			addLast(object);
		}
		public int removeFirst() {
			if (head == null){
				return (Integer) null; 
			}
			int temp = head.data;
			if (head.next == null) {
				head = null;
			}else {
				head = head.next;
			}
			return temp;
		}
		public int removeLast() {
			if (head == null) {
				return (Integer)null;
			}
			if (head.next == null) {
				return removeFirst();
			}
			Node current = head;
			Node previous = null;
			while(current.next!=null) {
				previous = current;
				current = current.next;
			}
			previous.next = null;
			currentSize--;
			return current.data;
		}
		public void delete(int object) {
			if (head == null) {
				return;
			}
			
			Node current = head;
			Node previous = head;
			while(current!=null) {
				if (current.data == object) {
					if (current == head) {
						removeFirst();
						previous = head;
						current = current.next;
					}else {
						previous.next = current.next;
						current = current.next;
						currentSize--;
					}
				}else {
					previous = current;
					current = current.next;	
				}
				
			}
		}
		public void josephus(int number) {
			if(head == null) {
				return;
			}
			Node current = head;
			Node previous = head;
			while(currentSize != 1) {
				for(int i = 0; i< number;i++) {
					if(current.next == null) {
						previous = current;
						current = head;
					}else {
						previous = current;
						current = current.next;
					}
				}
				if(current.next == null) {
					previous.next = head;
					current = head;
				}else {
					previous.next = current.next;
					current = current.next;
				}
				currentSize--;
			}
			head = current;
			head.next = null;
			return ;
		}
		public int size() {
			return currentSize;
		}
		
		public void printAll() {
			if (head == null) {
				System.out.print("Empty list");
				return;
			}
			Node temp = head;
			while(temp!=null){
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println();
		}
		public void moveLastToHead() {
			addFirst(removeLast());
		}
		public void swap() {
			if (head == null) {
				System.out.println("Empty list");
				return;
			}
	        Node temp = head;
	        /* Traverse only till there are atleast 2 nodes left */
	        while (temp != null && temp.next != null) {
	            /* Swap the data */
	            int k = temp.data;
	            temp.data = temp.next.data;
	            temp.next.data = k;
	            temp = temp.next.next;
	        }
		}
		public void reverse() {
	        Node prev = null;
	        Node current = head;
	        Node next = null;
	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        head = prev;
		}
	}
	public static void main(String[] args) {
		start();
	}
	static void start() {
		LinkedList list = new LinkedList();
		Scanner sc=new Scanner(System.in);  
		String command = sc.next();
		int object = 0;
		while (true) {
			switch (command){
			case "i":
				object = sc.nextInt();
				list.addLast(object);
				break;
			case"p":
				list.printAll();
				break;
			case "d":
				object = sc.nextInt();
				list.delete(object);
				break;
			case "l":
				list.size();
				break;
			case "m":
				list.moveLastToHead();
				break;
			case "s":
				list.swap();
				break;
			case "r":
				list.reverse();
				break;
			case "j":
				object = sc.nextInt();
				list.josephus(object);
				break;
			case "e":
				return;
			}
			command = sc.next();
		}
	}

}
