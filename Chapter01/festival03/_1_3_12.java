package festival03;

import edu.princeton.cs.algs4.StdOut;

/**
 * 说明：
 * 它含有一个静态的copy（）方法，接受一个字符串的栈作为参数并返回该栈的一个副本。
 * @author Administrator
 *
 */
public class _1_3_12 {

	public static void main(String[] args) {
		DoubleNodeStack<String> s = new DoubleNodeStack<String>();
		for(int i = 0; i < 10; i++)
			s.push(i + "");
		StdOut.println("Stack :");
		StdOut.println(s);
	
		StdOut.println("Copy result:");
		DoubleNodeStack<String> copy1 = DoubleNodeStack.copy(s);
		StdOut.println(copy1);
		
		StdOut.println("Copy result:");
		DoubleNodeStack<String> copy2 = DoubleNodeStack.copy(s);
		StdOut.println(copy2);
	}
}
