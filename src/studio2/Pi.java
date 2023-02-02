package studio2;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double dust;
		int inCircle = 0;
		int outCircle = 0;
		int simulations = 1000000;
		
		for (int i = 1; i <= simulations; i++)
		{
			double x = Math.random();
			double y = Math.random();
			dust = x * y;
			
			if (Math.pow(x, 2) + Math.pow(y, 2) <= 1)
			{
				inCircle++;
			}
			else
			{
				outCircle++;
			}
		}
		
		double Pi = (double) inCircle / simulations * 4;
		
		System.out.println("The Pi is: " + Pi);

	}

}
