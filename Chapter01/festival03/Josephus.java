package festival03;

import edu.princeton.cs.algs4.StdOut;
/**
 * 思路：
 * 人们围成圈报数，可以用环形链表表示，一个人代表一个结点。
 * cur引用环形链表的第一个结点。从1开始报数，报数M次，移动M次结点，此时cur指向待删除结点的后一个结点。
 * 将cur前面一个结点删除，打印出结点的信息，相当于该结点代表的人从游戏中出局，完成一次“杀人”过程。
 * 直到圈中还剩一人，他就是最后的幸存者。删除代表他的结点，打印出他的信息，游戏结束。
 * @author Administrator
 *
 */
public class Josephus {
	
	private int N;//N个人
	private int M;//报的数
	private int size;
	private DoubleNode<Integer> cur = null;
	
	private class doubleNode extends DoubleNode<Integer>{

		public doubleNode(Integer item) {
			super(item);
		}
		
	}
	
	public Josephus(int N,int M){
		if (N == 0 || M == 0)
			throw new RuntimeException("Please enter N and M.");
		this.M = M;
		this.N = N;
		
		/*
		 * 构建环形链表
		 */
		DoubleNode<Integer> header = new doubleNode(-1);
		DoubleNode<Integer> tailer = new doubleNode(-1);
		
		header.next = tailer;
		tailer.prev = header;
		
		for(int i=0;i<N;i++)
			tailer.insertBefore(size++);
		cur = header.next;
		header.next.prev = tailer.prev;
		tailer.prev.next = header.next;
	}
	
	public int size() { return size; }
	
	public void kill(){
		if (size == 0) return;
		if (size == 1) {
			StdOut.print("\nSurvivor : ");
			cur.deleteNode();
		} else {
			for(int i = 0; i < M; i++)
				cur = cur.next;
			
			// 此时 cur 指向报出死亡数字的下一个人，我们把上一个报数的人杀死
			cur.prev.deleteNode();
		} 
		size--;
	}
	
	public void play(){
		while(size() != 0)
			kill();
	}
	
}
