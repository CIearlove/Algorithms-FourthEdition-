package festival04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 统计一个文件中所有和为0的三整数元组的数量。
 * @author Administrator
 *
 */
public class ThreeSum {
	public static int count(int[] a){
		//统计和为0的元组的数量
		int N = a.length;
		int cnt = 0;
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				for(int k=j+1;k<N;k++){
					if(a[i]+a[j]+a[k] == 0)
						cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] a = new int[1000];
		for(int i=0;i<1000;i++)
			a[i] = StdRandom.uniform(-1000000, 1000000);
		//int[] a = In.readInts();
		Stopwatch timer = new Stopwatch();
		int cnt = count(a);
		double time = timer.elapsedTime();
		
		StdOut.println(cnt+" triples "+time+" seconds");
	}

}
