package festival03;

import edu.princeton.cs.algs4.StdOut;
/**
 * ˼·��
 * ����Χ��Ȧ�����������û��������ʾ��һ���˴���һ����㡣
 * cur���û�������ĵ�һ����㡣��1��ʼ����������M�Σ��ƶ�M�ν�㣬��ʱcurָ���ɾ�����ĺ�һ����㡣
 * ��curǰ��һ�����ɾ������ӡ��������Ϣ���൱�ڸý�������˴���Ϸ�г��֣����һ�Ρ�ɱ�ˡ����̡�
 * ֱ��Ȧ�л�ʣһ�ˣ������������Ҵ��ߡ�ɾ���������Ľ�㣬��ӡ��������Ϣ����Ϸ������
 * @author Administrator
 *
 */
public class Josephus {
	
	private int N;//N����
	private int M;//������
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
		 * ������������
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
			
			// ��ʱ cur ָ�򱨳��������ֵ���һ���ˣ����ǰ���һ����������ɱ��
			cur.prev.deleteNode();
		} 
		size--;
	}
	
	public void play(){
		while(size() != 0)
			kill();
	}
	
}
