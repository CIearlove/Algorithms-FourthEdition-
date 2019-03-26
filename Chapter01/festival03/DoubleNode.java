package festival03;

public class DoubleNode<Item> {
	
	Item item;
	DoubleNode<Item> pre;
	DoubleNode<Item> next;
	
	DoubleNode(Item item){
		this.item = item;
		this.pre = null;
		this.next = null;
	}
	DoubleNode(Item item,DoubleNode<Item> pre,DoubleNode<Item> next){
		this.item = item;
		this.pre = pre;
		this.next = next;
	}
}
