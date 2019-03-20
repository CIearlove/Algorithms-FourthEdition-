package festival03;

import edu.princeton.cs.algs4.StdIn;

public class _1_3_9 {

	/**
	 * 思路 :
	 * 准备两个栈，一个用于存放拼接字符串的结果栈，一个用于读取运算符的运算符栈
	 * 浏览表达式，读到 + - * '/' 就入运算符栈
	 * 读到 右括号 就在结果栈弹两个元素出来，再把运算符栈顶元素弹出来，拼接成 补全的字符串再放回结果栈
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<String> resultStack = new Stack<String>();
		Stack<String> operatorStack = new Stack<String>();
		
		while(StdIn.hasNextChar()){
			char c = StdIn.readChar();
			String s = Character.toString(c);
			
			if(s.equals("\r")) continue;
			if(s.equals("\n")) break;
			
			if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
				operatorStack.push(s);
			}
			else if(s.equals(")")){
				String operand2 = resultStack.pop();
				String operand1 = resultStack.pop();
				String operator = operatorStack.pop();
				String pushString = "("+operand1+operator+operand2+")";
				resultStack.push(pushString);
			}
			else{
				resultStack.push(s);
			}
		}
			System.out.print(resultStack.pop());
	}

}
