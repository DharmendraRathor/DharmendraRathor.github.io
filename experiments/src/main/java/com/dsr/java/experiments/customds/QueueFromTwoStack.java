package com.dsr.java.experiments.customds;

/**
 * Implement a Queue using 2 stacks s1 and s2 .
 */
import java.util.Stack;

public class QueueFromTwoStack {

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	public static void main(String[] args) {
		QueueFromTwoStack queFromStack = new QueueFromTwoStack();
		queFromStack.add(1);
		queFromStack.add(2);
		System.out.println(queFromStack.remove());
		queFromStack.add(3);
		queFromStack.add(4);
		System.out.println(queFromStack.remove());
		System.out.println(queFromStack.remove());
	}

	private void add(Integer in) {
		s1.push(in);
	}

	private Integer remove() {
		if (null == s1 || s1.isEmpty()) {
			return -1;
		}

		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}

		Integer response = s2.pop();

		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}

		return response;
	}

}
