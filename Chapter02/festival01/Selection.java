package festival01;

import edu.princeton.cs.algs4.StdOut;
/**
 * ���ȣ��ҵ���������С���Ǹ�Ԫ�أ�����������ĵ�һ��Ԫ�ؽ���λ�ã������һ��Ԫ�ؾ�����СԪ����ô���ͺ��Լ���������
 * ���ţ���ʣ�µ�Ԫ�����ҵ���С��Ԫ�أ�����������ĵڶ���Ԫ�ؽ���λ�á�
 * ���������ֱ����������������
 * 
 * ����Ԫ�صĴ���д����ѭ��֮�⣬ÿ�ν��������Ŷ�һ��Ԫ�أ���˽������ܴ�����N��
 * ���ڳ���ΪN�����飬ѡ�������Լ��ҪN^2/2�αȽϡ�
 * 
 * ����ʱ��������޹أ�Ϊ���ҳ���С��Ԫ�ض�ɨ��һ�����鲢����Ϊ��һ��ɨ���ṩʲô��Ϣ��
 * �����ƶ������ٵģ����������������С�����Թ�ϵ��
 * @author Administrator
 *
 */
public class Selection {
	/**
	 * �������
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		
		for(int i=0;i<a.length;i++){
			//��a[i]��a[i+1..a.length]����С��Ԫ�ؽ���
			int minIndex = i;
			for(int j=i+1;j<a.length;j++)
				if(less(a[j],a[minIndex]))//�Ƚ�
					minIndex = j;
			exch(a,i,minIndex);//����
		}
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
		String[] a = "1#2#3#4".split("#");
		sort(a);
		if(isSorted(a)){
			show(a);
		}
	}
}
