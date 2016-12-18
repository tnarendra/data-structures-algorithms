package com.naren.strings;

import java.util.Stack;

public class BalancedParenthesis {

	public static void main(String[] args) {
		String str = "({()})[]{([{()[]}()])}";

		System.out.println(isBalanced(str));
	}

	private static boolean isBalanced(String str) {

		Stack<Character> st = new Stack<Character>();
		for (char ch : str.toCharArray()) {

			if (ch == '[' || ch == '(' || ch == '{') {
				st.push(ch);
			} else if (ch == ')') {
				if (st.pop() != '(')
					return false;
			} else if (ch == ']') {
				if (st.pop() != '[')
					return false;
			} else if (ch == '}') {
				if (st.pop() != '{')
					return false;
			} else
				return false;
		}
		return st.isEmpty();
	}
}
