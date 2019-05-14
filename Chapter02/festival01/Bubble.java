package festival01;

import edu.princeton.cs.algs4.StdOut;
/**
 * @see <a href="https://www.cnblogs.com/shen-hua/p/5422676.html">冒泡排序思路来源</a>
 * 原理：
 * 	比较相邻的元素，将值大的元素交换至右端
 * 思路：
 * 	设待排序数组由N个元素，需进行N-1趟排序
 * 	第一趟：首先比较第1个和第2个数，将小数放前，大数放后。然后比较第2个和第三个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数放前，大数放后。
 * 	第一趟比较完成后，最后一个数不参与第二趟比较。一共进行N-1次比较。
 *  第二趟：一共进行N-2次比较。
 * 	第二趟比较完成后，倒数第二个数不参与第三趟比较。
 * 	...
 * 	以此类推，每一趟比较次数减1
 * 
 * 时间复杂度分析：
 * 	1.如果数据正序，所需比较次数为(N-1)*(N-1-i),移动数组次数0;最好的时间复杂度为O(n)
 * 	2.数据反序时，所需比较次数为(N-1)*(N-1-i),移动数组次数为(N-1)*(N-1-i);最差的时间复杂度为O(n^2)
 * @author Administrator
 *
 */
public class Bubble {
	/**
	 * 排序代码
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		for(int i=0;i<a.length-1;i++){//N-1趟排序
			//每一趟进行N-1-i次比较
			for(int j=0;j<a.length-1-i;j++){
				//小数放前，大数放后
				if(less(a[j+1],a[j])){
					exch(a,j+1,j);
				}
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
		String[] a = "Java#HTML#Perl#A#B#E#F".split("#");
		sort(a);
		if(isSorted(a)){
			show(a);
		}
	}
}
