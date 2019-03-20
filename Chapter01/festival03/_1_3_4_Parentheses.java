package festival03;

import edu.princeton.cs.algs4.StdIn;

/**
 * ˼·��
 * ����������¼���ַ���ջ�У�������������ʱ���Ƚ������ź�ǰһ����ջ���������Ƿ���ԡ�
 * ����ԣ������Ե�����һ�����ţ����ż�����ջ��¼�����š�
 * ������ԣ����False.
 * @author Administrator
 *
 */
public class _1_3_4_Parentheses {

	public static void main(String[] args) {
		ResizingArrayStack<String> brackets = new ResizingArrayStack<String>(1);
		
		while(StdIn.hasNextChar()){
			//��ȡ�ַ�����������ѹ������ջ
			char c = StdIn.readChar();
			String s = Character.toString(c);
			
			if(s.equals("\r")) continue;
			if(s.equals("\n")) break;
			
			if(s.equals("{")||s.equals("[")||s.equals("(")){
				brackets.push(s);
			}
			else{
				switch(s){
				case ")":
					if(brackets.pop().equals("("))
						System.out.println("Eliminate a pair of parentheses ().");
					else
						System.out.println("False.");
					break;
				
				case "]":
					if(brackets.pop().equals("["))
						System.out.println("Eliminate a pair of parentheses [].");
					else
						System.out.println("False.");	
					break;
					
				case "}":
					if(brackets.pop().equals("{"))
						System.out.println("Eliminate a pair of parentheses {}.");
					else
						System.out.println("False.");
					break;
				}
			}
		}
		System.out.print(brackets.size());
	}

}
