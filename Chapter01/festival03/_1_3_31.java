package festival03;

public class _1_3_31 {

	public static void main(String[] args) {
		
		DoubleNode<String> header = new DoubleNode<String>("0",null,null);
		DoubleNode.insertAsLast(header, "10");
		DoubleNode.insertAsLast(header, "20");
		DoubleNode.insertAsLast(header, "30");
		DoubleNode.insertAsLast(header, "40");
		header.print();
		
		DoubleNode.insertAsFirst(header, "50");
		header.print();
		
		DoubleNode.insertAfter(header,"20","After20");
		header.print();
		DoubleNode.insertBefore(header,"20", "Before20");
		header.print();
		
		DoubleNode.deleteFirst(header);
		header.print();
		DoubleNode.deleteFirst(header);
		header.print();
		DoubleNode.deleteLast(header);
		header.print();
		
		DoubleNode.remove(header,"Before20");
		header.print();
		DoubleNode.remove(header,"0");
		header.print();
	}
	
	
}
