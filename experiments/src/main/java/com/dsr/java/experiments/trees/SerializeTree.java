package com.dsr.java.experiments.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SerializeTree {

	public static int index = 0;

	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.right.right = new Node(5);
		List<Integer> list = new ArrayList<>();
		String data = serialize(n, list);
		System.out.println(data);
		
		
		//List<Integer> aa = Arrays.asList(data.split(" ")).stream().filter(x->!x.equals(" ")).map(Integer::parseInt).collect(Collectors.toList());
		int[] aa1 = Arrays.asList(data.split(" ")).stream().filter(x->!x.equals(" ")).mapToInt(Integer::parseInt).toArray();

		List<Integer> list1 = new ArrayList<>();
		 for (int i : aa1)
           {
           list1.add(i);
           }
		

		Node root = deSerialize(list1);
		
		System.out.println(serialize(root, list));

	}
	
	
	List<Integer> list = null;
	
	private static Node deSerialize(List<Integer> list) {
		if (list.isEmpty() || index > list.size()-1) {
			return null;
		}

		int val = list.get(index);

		if (val == -1) {
			index++;
			return null;
		}

		Node n = new Node(list.get(index));
		index++;

		n.left = deSerialize(list);
		n.right = deSerialize(list);
		
		return n;

	}

	private static String serialize(Node root, List<Integer> aa) {
		if (root == null) {
			aa.add(-1);
			return "";
		}

		aa.add(root.data);
		return root.data + " " + serialize(root.left, aa) + serialize(root.right, aa);

	}

}
