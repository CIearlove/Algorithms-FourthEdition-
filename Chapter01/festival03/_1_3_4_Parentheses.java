package festival03;

import edu.princeton.cs.algs4.StdIn;

/**
 * 思路：
 * 将括号依次录入字符串栈中，当出现右括号时，比较右括号和前一个入栈的左括号是否配对。
 * 若配对，输出配对的是哪一种括号；接着继续向栈中录入括号。
 * 若不配对，输出False.
 * @author Administrator
 *
 */
public class _1_3_4_Parentheses {

	public static void main(String[] args) {
		ResizingArrayStack<String> brackets = new ResizingArrayStack<String>(1);
		
		while(StdIn.hasNextChar()){
			//读取字符，将括号则压入括号栈
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
