package com.dsr.java.experiments.customds;

import java.util.Stack;

/**
 * Design a data-structure SpecialStack (using the STL of stack) that supports
 * all the stack operations like push(), pop(), isEmpty(), isFull() and an
 * additional operation getMin() which should return minimum element from the
 * SpecialStack. Your task is to complete all the functions, using stack
 * data-Structure.
 * 
 * @author dharmendra
 *
 */
public class SpecialStack {

	public static void main(String[] args) {
		SpecialStack spclStack = new SpecialStack();
		Stack<Integer> stack = new Stack<>();
		stack.push(18);
		stack.push(19);
		stack.push(20);
		stack.push(21);
		stack.push(22);

		System.out.println(spclStack.min(stack));

	}

	public void push(int a, Stack<Integer> s) {
		s.push(a);
	}

	public int pop(Stack<Integer> s) {
		return s.pop();
	}

	public int min(Stack<Integer> s) {
		if (null == s) {
			return 0;
		} else {
			int min = s.pop();
			while (!s.isEmpty()) {

				int temp = s.pop();
				if (temp < min) {
					min = temp;
				}
			}
			return min;
		}

	}

	public boolean isFull(Stack<Integer> s, int n) {
		if (s.size() == n) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty(Stack<Integer> s) {
		if (s.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
