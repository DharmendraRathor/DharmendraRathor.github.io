package com.dsr.java.experiments.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of names of candidates in an election. 
 * A candidate name in array represents a vote casted to the candidate. Print the name of candidate that received Max votes.
 * If there is tie, print lexicographically smaller name.
 * @author dharmendra
 *
 */
public class WinnerOfElection {

	public static void main(String[] args) {
		String votingData = "john mike harry ron rob";
		String[] names = votingData.split(" ");
		// using HashMap
		winner(names, names.length);
		//using TreeMap
		winnerWithTreeMap(names, names.length);

	}

	static void winner(String arr[], int n) {

		Map<String, Integer> voteCount = new HashMap<>();

		int maxCount = 0;
		for (int i = 0; i < arr.length; i++) {

			if (voteCount.containsKey(arr[i])) {
				int count = voteCount.get(arr[i]);
				voteCount.put(arr[i], ++count);
				if(count > maxCount) {
					maxCount = count;
				}
			} else {
				voteCount.put(arr[i], 1);
				if(maxCount == 0) {
					maxCount = 1;
				}
			}
		}

		String name = "";
		List<String> nameList = new ArrayList<>();
		for (String key : voteCount.keySet()) {
			int currentCount = voteCount.get(key);
			if (currentCount == maxCount) {
				maxCount = currentCount;
				name = key;
				nameList.add(name);
			}

		}
		
		String lexicalName = nameList.stream().sorted().findFirst().get();

		System.out.println(lexicalName + " " + maxCount);

	}
	
	
	static void winnerWithTreeMap(String arr[], int n) {
		Map<String, Integer> voteCount = new TreeMap<>();

		for (int i = 0; i < arr.length; i++) {

				int count = voteCount.getOrDefault(arr[i], 0);
						voteCount.put(arr[i], count+1);
		}

		int maxCount = 0;
		String name = "";
		
		for (String key : voteCount.keySet()) {
			int currentCount = voteCount.get(key);
			if (currentCount > maxCount) {
				maxCount = currentCount;
				name = key;
			}

		}
		
		System.out.println(name + " " + maxCount);

	}

}
