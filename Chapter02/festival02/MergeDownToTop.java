package festival02;

import edu.princeton.cs.algs4.StdOut;

/**
 * 实现归并排序的另一种方法是先归并那些微型数组，然后再成对归并得到的子数组。
 * 对于长度为N的任意数组，自底向上的归并排序需要1/2N*log2N至N*log2N次比较，最多访问数组6*N*log2N次。
 * @author Administrator
 *
 */
public class MergeDownToTop {
	
	private static Comparable[] aux;//声明归并所需的辅助数组
	/**
	 * 排序代码
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];//一次性分配空间
		mergeSort(a);
	}
	
	private static void mergeSort(Comparable[] a) {
		//进行lgN次两两归并
		int N = a.length;
		for(int sz=1;sz<N;sz=sz*2){//子数组的大小
			for(int lo=0;lo<N-sz;lo+=sz*2){//子数组索引
				merge(a,lo,lo+sz-1,Math.min(lo+2*sz-1, N-1));
			}
		}
	}
	
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		//将a[lo..mid]和a[mid+1..hi]归并
		int i=lo,j=mid+1;
		Comparable[] aux = new Comparable[a.length];
		
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
	
	public static void main(String[] arg){
		Comparable[] a = {'E','E','G','M','R','A','C','E','R','T'};
		int lo=0,hi=a.length-1,mid=(lo+hi)/2;
		sort(a);
		if(isSorted(a)){
			show(a);
		}
	}
}
