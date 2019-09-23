package festival02;

import edu.princeton.cs.algs4.StdOut;
/**
 * 归并排序原理：
 * 要将一个数组排序，可以先（递归地）将它分成两半分别排序，然后将结果归并起来。
 * 
 * 自顶向下的归并排序
 * 性质1：对于长度为N的任意数组，自顶向下的归并排序需要1/2N*log2N至N*log2N次比较。
 * 性质2：对于长度为N的任意数组，自顶向下的归并排序最多需要访问数组6*N*log2N次。
 * 
 * 优点：可以用归并排序处理数百万甚至更大规模的数组，这是插入排序或者选择排序做不到的。
 * 缺点：辅助函数所使用的额外空间和N的大小成正比。
 * @author Administrator
 *
 */
public class MergeTopToDown {
	
	private static Comparable[] aux;//声明归并所需的辅助数组
	/**
	 * 排序代码
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];//一次性分配空间
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		//将数组a[lo..hi]排序
		if(hi<=lo)
			return;
		int mid = lo+(hi-lo)/2;
		sort(a,lo,mid);//将左半边排序
		sort(a,mid+1,hi);//将右半边排序
		merge(a,lo,mid,hi);
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
	 * 归并
	 * @param a 待归并数组
	 * @param lo 开始下标
	 * @param mid 中间下标
	 * @param hi 结束下标
	 */
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		//将a[lo..mid]和a[mid+1..hi]归并
		int i=lo,j=mid+1;
		//Comparable[] aux = new Comparable[a.length];
		
		for(int k=lo;k<=hi;k++){//将a[lo..hi]复制到aux[lo..hi]
			aux[k] = a[k];
		}
		
		for(int k=lo;k<=hi;k++){//归并回到a[lo..hi]
			if(i>mid) //左半边用尽（取右半边的元素）
				a[k] = aux[j++];
			else if(j>hi) //右半边用尽（取左半边的元素）
				a[k] = aux[i++];
			else if(less(aux[j],aux[i])) //右半边的当前元素小于左半边的当前元素（取右半边的元素）
				a[k] = aux[j++];
			else //右半边的当前元素大于等于左半边的当前元素（取左半边的元素）
				a[k] = aux[i++];
		}
	}
	/**
	 * 从标准输入读取字符串，将它们排序并输出
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = "M#E#R#G#E#S#O#R#T#E#X#A#M#P#L#E".split("#");
		sort(a);
		if(isSorted(a)){
			show(a);
		}
	}
}
