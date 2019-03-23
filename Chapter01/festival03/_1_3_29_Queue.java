package festival03;

public class _1_3_29_Queue<Item> {
	/**
	 * 思路：
	 * 环形链表也是一条链表，只是没有任何结点的链接为空，且只要链表非空则last.next的值为first。
	 */
	private Node<Item> first;
	private Node<Item> last;
	private int N;
	
	public _1_3_29_Queue(){
		this.first = null;
		this.last = null;
		this.N = 0;
	}
	
	public void enqueue(Item item){
		Node<Item> oldLast = last;
		last = new Node<Item>(item);
		if(isEmpty())
			first = last;
		else
			oldLast.next = last;
		last.next = first;
		N++;
	}
	public Item dequeue(){
		Item item = first.item;
		last.next = first.next;
		first = first.next;
		N--;
		if(isEmpty()){
			first = null;
			last = null;
		}
		return item;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
}
