package festival03;

public class Node<Item>{
	Item item;
	Node<Item> next;
	
	Node(Item item){
		this.item = item;
		this.next = null;
	}
	Node(Item item,Node next){
		this.item = item;
		this.next = next;
	}
}
