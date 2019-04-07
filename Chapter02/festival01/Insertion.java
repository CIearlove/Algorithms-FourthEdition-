package festival01;

import edu.princeton.cs.algs4.StdOut;
/**
 * 原理：
 * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 
 * 算法步骤：
 * 1.将待排序序列的第一个元素看作一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * 2.扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
 * 
 * 最坏情况下需要N^2/2次比较和N^2/2次交换
 * 最好情况下需要N-1次比较和0次交换
 * @author Administrator
 *
 */
public class Insertion {
	/**
	 * 排序代码
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		for(int i=1;i<a.length;i++){//扫描未排序序列
			for(int j=i; j>0 && less(a[j],a[j-1]); j--){//将扫描到的每个元素插入有序序列的适当位置。
					exch(a,j,j-1);
			}
		}
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
