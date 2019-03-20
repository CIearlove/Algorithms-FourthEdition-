package festival03;

import edu.princeton.cs.algs4.StdIn;

public class _1_3_9 {

	/**
	 * ˼· :
	 * ׼������ջ��һ�����ڴ��ƴ���ַ����Ľ��ջ��һ�����ڶ�ȡ������������ջ
	 * ������ʽ������ + - * '/' ���������ջ
	 * ���� ������ ���ڽ��ջ������Ԫ�س������ٰ������ջ��Ԫ�ص�������ƴ�ӳ� ��ȫ���ַ����ٷŻؽ��ջ
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
