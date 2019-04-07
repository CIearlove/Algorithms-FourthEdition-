package festival01;

import edu.princeton.cs.algs4.StdOut;

public class Example {
	/**
	 * 排序代码
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		
	}
	/**
	 * 对元素进行比较
	 * @param v
	 * @param w
	 * @return
	 */
	public static  boolean less(Comparable v,Comparable w) {
		return v.compareTo(w) < 0;
		
	}
	/**
	 * 将元素交换位置
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
	 * 在单行中打印数组
	 * @param a
	 */
	public static void show(Comparable[] a) {
		for(int i=0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		StdOut.println();
	}
	/**
	 * 测试数组元素是否有序
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
	 * 从标准输入读取字符串，将它们排序并输出
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
