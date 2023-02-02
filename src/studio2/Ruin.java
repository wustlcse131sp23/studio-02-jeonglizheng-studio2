package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("What is the amount of money that you start with?");
		double startAmount = in.nextDouble();
		
		System.out.println("What is the probability (0 to 1) that you win a single play?");
		double winChance = in.nextDouble();
		
		System.out.println("What is the win limit for a day?");
		double winLimit = in.nextDouble();
		
		System.out.println("How many days do you paly?");
		int totalSimulations = in.nextInt();
		
		int i;
		double endAmount;
		boolean dayWinOrLose;
		int lossTime = 0;
		
		for (int simulation = 1; simulation < totalSimulations; simulation++)
		{
			endAmount = startAmount;
			i = 0;
			
			while (endAmount < winLimit & endAmount > 0)
			{
				boolean winOrLose = Math.random() <= winChance;
				
				if (winOrLose)
				{
					endAmount++;
				}
				else
				{
					endAmount--;
				}
				
				i++;
			}
			
			if (endAmount >= winLimit)
			{
				System.out.println("Simulation " + simulation + ": " + i + " WIN");
			}
			else if (endAmount <= 0)
			{
				System.out.println("Simulation " + simulation + ": " + i + " LOSE");
				
				lossTime++;
			}
		
		}
		
		System.out.println("Losses: " + lossTime + " Simulations: " + totalSimulations);
		
		double expectedRuinRate;
		double alpha;
		if (winChance == 0.5)
		{
			expectedRuinRate = 1 - startAmount / winLimit;
		}
		else
		{
			alpha = (1 - winChance) / winChance;
			expectedRuinRate = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1 - Math.pow(alpha, winLimit));
		}
		
		double ruinRate = (double) lossTime / totalSimulations;
		
		System.out.println("Ruin Rate from Simulation: " + ruinRate + " Expected Ruin Rate: " + expectedRuinRate);
	}

}
