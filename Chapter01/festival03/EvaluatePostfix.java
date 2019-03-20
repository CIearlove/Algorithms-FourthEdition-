package festival03;

import edu.princeton.cs.algs4.StdIn;

/**
 * 后序表达式优点：
 * 它将中序表达式转换为可以依靠简单的操作（入栈、出栈）就能得到运算结果的表达式。
 * 
 * 思想：
 * 如果当前字符串为数字或变量，则压入栈内；
 * 如果是运算符，则将栈顶两个元素弹出栈外并作相应运算，再将结果压入栈内
 * @author Administrator
 *
 */
public class EvaluatePostfix {

	public static void main(String[] args) {
		Stack<Integer> operandStack = new Stack<Integer>();
		while (StdIn.hasNextChar()) {
        	
        	char c = StdIn.readChar();
			String s = Character.toString(c);
			if(s.equals("\r")) continue;
			if(s.equals("\n")) break;
			
			switch(s){
			case "+":
				int operand2 = operandStack.pop();
				int operand1 = operandStack.pop();
				operandStack.push(operand1+operand2);
				break;
			case "-":
				operand2 = operandStack.pop();
				operand1 = operandStack.pop();
				operandStack.push(operand1-operand2);
				break;
			case "*":
				operand2 = operandStack.pop();
				operand1 = operandStack.pop();
				operandStack.push(operand1*operand2);
				break;
			case "/":
				operand2 = operandStack.pop();
				operand1 = operandStack.pop();
				operandStack.push(operand1/operand2);
				break;
			default:
				operandStack.push(Integer.parseInt(s));
			}
		}
		System.out.println(operandStack.pop());
	}

}
