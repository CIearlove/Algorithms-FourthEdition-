package festival03;

public class DoubleNode<Item> {
	Item item;
	Node<Item> pre;
	Node<Item> next;
	
	DoubleNode(Item item){
		this.item = item;
		this.pre = null;
		this.next = null;
	}
	DoubleNode(Item item,Node<Item> pre,Node<Item> next){
		this.item = item;
		this.pre = pre;
		this.next = next;
	}
}
