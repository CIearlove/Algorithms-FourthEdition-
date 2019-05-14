package festival01;

import edu.princeton.cs.algs4.StdOut;
/**
 * @see <a href="https://www.cnblogs.com/shen-hua/p/5422676.html">ð������˼·��Դ</a>
 * ԭ��
 * 	�Ƚ����ڵ�Ԫ�أ���ֵ���Ԫ�ؽ������Ҷ�
 * ˼·��
 * 	�������������N��Ԫ�أ������N-1������
 * 	��һ�ˣ����ȱȽϵ�1���͵�2��������С����ǰ�������ź�Ȼ��Ƚϵ�2���͵�����������С����ǰ�������ź���˼�����ֱ���Ƚ��������������С����ǰ�������ź�
 * 	��һ�˱Ƚ���ɺ����һ����������ڶ��˱Ƚϡ�һ������N-1�αȽϡ�
 *  �ڶ��ˣ�һ������N-2�αȽϡ�
 * 	�ڶ��˱Ƚ���ɺ󣬵����ڶ���������������˱Ƚϡ�
 * 	...
 * 	�Դ����ƣ�ÿһ�˱Ƚϴ�����1
 * 
 * ʱ�临�Ӷȷ�����
 * 	1.���������������Ƚϴ���Ϊ(N-1)*(N-1-i),�ƶ��������0;��õ�ʱ�临�Ӷ�ΪO(n)
 * 	2.���ݷ���ʱ������Ƚϴ���Ϊ(N-1)*(N-1-i),�ƶ��������Ϊ(N-1)*(N-1-i);����ʱ�临�Ӷ�ΪO(n^2)
 * @author Administrator
 *
 */
public class Bubble {
	/**
	 * �������
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		for(int i=0;i<a.length-1;i++){//N-1������
			//ÿһ�˽���N-1-i�αȽ�
			for(int j=0;j<a.length-1-i;j++){
				//С����ǰ�������ź�
				if(less(a[j+1],a[j])){
					exch(a,j+1,j);
				}
			}
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
		String[] a = "Java#HTML#Perl#A#B#E#F".split("#");
		sort(a);
		if(isSorted(a)){
			show(a);
		}
	}
}
