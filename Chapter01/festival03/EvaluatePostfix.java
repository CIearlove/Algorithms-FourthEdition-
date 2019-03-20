package festival03;

import edu.princeton.cs.algs4.StdIn;

/**
 * ������ʽ�ŵ㣺
 * ����������ʽת��Ϊ���������򵥵Ĳ�������ջ����ջ�����ܵõ��������ı��ʽ��
 * 
 * ˼�룺
 * �����ǰ�ַ���Ϊ���ֻ��������ѹ��ջ�ڣ�
 * ��������������ջ������Ԫ�ص���ջ�Ⲣ����Ӧ���㣬�ٽ����ѹ��ջ��
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
