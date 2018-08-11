package stack.data_structures;

public class Main {
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);

		System.out.println(stack.pop());
		System.out.println(stack);
	}

	public boolean isValid(String s) {
		ArrayStack<Character> stack = new ArrayStack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (!stack.isEmpty()) {
					char curChar = s.charAt(i);
					char topChar = stack.pop();
					if (curChar == ')' && topChar != '(')
						return false;
					if (curChar == ']' && topChar != '[')
						return false;
					if (curChar == '}' && topChar != '{')
						return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
