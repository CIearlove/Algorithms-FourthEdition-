package festival01;

import edu.princeton.cs.algs4.StdOut;
/**
 * 希尔排序是基于插入排序的一下两点性质而提出改进方法的：
 * 1.插入排序在对几乎已经排好序的数据操作时，效率高；
 * 2.插入排序每次只能将数据移动一位。
 * 
 * 基本思想：
 * 将整个待排序序列分割成若干个子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
 * 
 * 算法步骤：
 * 1.选择一个增量序列t1 t2 ...... tk,其中ti>tk,tk=1;
 * 2.按增量序列个数k，对序列进行k趟排序;
 * 3.每次排序，根据对应的增量ti，将待排序序列分割成若干个长度为m的子序列，分别对各子序列进行直接插入排序。
 * @author Administrator
 *
 */
public class Shell {
	/**
	 * 排序代码
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		//增量1,4,13,40,121,364,1093...
		int increment = 1;
		while(increment<a.length/3){
			increment = 3*increment+1;
		}

		while(increment>=1){
			//System.out.println(increment);
			//每次排序，根据对应的增量increment，将待排序序列分割成若干个子序列，分别对各子序列进行直接插入排序
			for(int i=increment;i<a.length;i++){
				for(int j=i; j>=increment && less(a[j],a[j-increment]); j=j-increment){
					exch(a,j,j-increment);
				}
			}
			increment = increment/3;//新增量
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
	 * 将数组中的元素交换位置
	 * @param a 数组a
	 * @param i 元素下标i
	 * @param j 元素下标j
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
		Integer[] a = {12,10,8,6,4,2,0};
		sort(a);
		if(isSorted(a)){
			show(a);
		}
	}
}
