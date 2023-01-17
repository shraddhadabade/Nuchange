package ds_prgs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ElectionStatistics {
	
	
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public ElectionStatistics() {
		
	}
	
	public static void main(String []args) {
		
		ElectionStatistics es = new ElectionStatistics();
		
		while(true) {
		
		System.out.println("Enter the command");
		Scanner sc = new Scanner(System.in);
		
		String command = sc.next();
		
		switch(command) {
		
		case "entercandidate": es.createCandidate(sc);
		break;
		
		case "castvote" : es.castVote(sc);
		break;
		
		case "countvote": es.countVote(sc);
		break;
		
		case "listvote": es.listVote();
		break;
		
		case "getwinner": es.getWinner();
		break;
		
		case "exit" :
			System.out.println("Thank you!!");
			return;
		
		}
		
		}
	}

	private void getWinner() {
		
		int result = Integer.MIN_VALUE;
		String candidateName = null;
	
		for(Map.Entry<String,Integer> entry : map.entrySet()) {
			
			if(entry.getValue() > result) {
				candidateName = entry.getKey();
				result = entry.getValue();
			}
		}
		
		System.out.println("And the winner is "+ candidateName + " toatl vote "+ result);
		
		
	}

	private void listVote() {
		// TODO Auto-generated method stub
		System.out.println("Results");
		
		for(Map.Entry<String,Integer> entry : map.entrySet()) {
			System.out.println("name of the candidate "+ entry.getKey() + " vote "+ entry.getValue());
		}
		
	}

	private void countVote(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Please enter candidateName to get vote count");
		String candidateName = sc.next();
		
		if(map.containsKey(candidateName)) {
			
			System.out.println(candidateName + " votes "+ map.get(candidateName));
		} else {
			System.out.println(candidateName + " is not a valid candidate");
		}
		
	}

	private void castVote(Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("Please enter candidateName to cast vote");
		String candidateName = sc.next();
		
		if(map.containsKey(candidateName)) {
			
			map.put(candidateName, map.get(candidateName)+1);
		} else {
			System.out.println(candidateName + " is not a valid candidate");
		}
		
	}

	private void createCandidate(Scanner sc) {
		
		System.out.println("Please enter candidateName");
		String candidateName = sc.next();
		map.put(candidateName, 0);
		
	}
}
