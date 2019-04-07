package festival01;

import edu.princeton.cs.algs4.StdOut;

public class Example {
	/**
	 * �������
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		
	}
	/**
	 * ��Ԫ�ؽ��бȽ�
	 * @param v
	 * @param w
	 * @return
	 */
	public static  boolean less(Comparable v,Comparable w) {
		return v.compareTo(w) < 0;
		
	}
	/**
	 * ��Ԫ�ؽ���λ��
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void exch(Comparable[] a,int i,int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	/**
	 * �ڵ����д�ӡ����
	 * @param a
	 */
	public static void show(Comparable[] a) {
		for(int i=0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		StdOut.println();
	}
	/**
	 * ��������Ԫ���Ƿ�����
	 * @param a
	 * @return
	 */
	public static boolean isSorted(Comparable[] a) {
		for(int i=1;i<a.length;i++)
			if(less(a[i],a[i-1]))
				return false;
		
		return true;
	}
	/**
	 * �ӱ�׼�����ȡ�ַ������������������
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = "Java#HTML#Perl".split("#");
		sort(a);
		if(isSorted(a)){
			show(a);
		}
	}
}
