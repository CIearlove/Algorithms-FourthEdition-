package festival03;

import edu.princeton.cs.algs4.StdIn;

public class _1_3_4_Parentheses {

	public static void main(String[] args) {
		ResizingArrayStack<String> brackets = new ResizingArrayStack<String>(1);
		
		while(StdIn.hasNextChar()){
			//∂¡»°◊÷∑˚£¨Ω´¿®∫≈‘Ú—π»Î¿®∫≈’ª
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
