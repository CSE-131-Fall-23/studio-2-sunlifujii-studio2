package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
				
		System.out.print("What is the start amount?:");
		double startAmount = in.nextDouble();
		
		System.out.print("What is the win chance?:");
		double winChance = in.nextDouble();
		
		System.out.print("What is the win limit?:");
		int winLimit = in.nextInt();
		
		System.out.print("What is the total number of simulations?:");
		int totalSimulations = in.nextInt();
		
		
		
		
		
		int totalSuccess = 0;
		int totalRuin = 0;
		for(int i = 1; i <= totalSimulations; i++) {
			int win = 0;
			int lose = 0;
			
			// one day
			while(win != winLimit || startAmount == 0) {
				
				double number = Math.random();
				if(number < winChance) {
					win ++;
					startAmount ++;
				}
				else {
					startAmount --;
					lose ++;
				}
			}
			String result = "";
			if(win == winLimit) {
				result = "SUCCESS";
			}
			else if(startAmount == 0) {
				result = "LOSE";
			}
			System.out.println("Simulation " + i + ": " + (win + lose) + " " + result);
			if(result == "LOSE") {
				totalRuin ++;
			}
			else if (result == "SUCCESS")
			{
				totalSuccess ++;
			}
		}
		
		double expectedruin = (1 - (startAmount / winLimit));
		double actualruin = totalRuin / (totalRuin + totalSuccess);
		System.out.println("Expected ruin rate: " + expectedruin);
		System.out.println("Actual ruin rate: " + actualruin);
	}
}
	
	
