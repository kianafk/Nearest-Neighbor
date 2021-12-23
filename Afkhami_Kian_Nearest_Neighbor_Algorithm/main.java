import java.text.NumberFormat;
import java.util.ArrayList;

public class main{
	
	public static void main(String[] args) {
		
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		
		final int MPH = 60, MPG = 7, DRIVER_SALARY = 1200, HELPER_SALARY = 900, HOTEL = 100, FOOD = 68, NUM_CITIES = 7;
		final double PRICE_PER_GALLON = 3.32, DRIVER_PER_MILE = 0.56, HELPER_PER_MILE = 0.42, WEAR = 0.88;
		int distance = 0, visits = 0, e = 0, hours = 0;
		double driverSalary = 0, helperSalary = 0, totalFuel = 0, maintenance = 0, totalTime = 0;
		String[] cityNames = {"Rockville", "Silver Spring", "Philadelphia", "Pittsburgh", "Baltimore", "Cleveland", "New York City"};
		int [][] d = {{0,   13,  142, 225, 40,  352, 227}, {13,  0,   136, 237, 34,  363, 222}, {141, 135, 0,   305, 101, 432, 97}, {226, 237, 304, 0,   248, 133, 371}, {40,  34,  106, 248, 0,   374, 192 }, {352, 364, 431, 133, 375, 0,   462}, {228, 222, 97,  370, 188, 462, 0}};

		ArrayList <Integer> citiesLeft = new ArrayList<>(); 
		ArrayList <String> route = new ArrayList<>();
		
		for (int i=1; i<=6; i++) {
            citiesLeft.add(i); 
            }
		route.add(cityNames[0]);
		
		driverSalary += DRIVER_SALARY;
		helperSalary += HELPER_SALARY;
		int it = 0;
		
		for( visits = 1; visits < 7; visits++) {
			int minDist = 99999;
			for(int i = 0; i < citiesLeft.size(); i++) {
		//		System.out.println(e + " " + citiesLeft.get(i) + " " + (d[e][citiesLeft.get(i)] < minDist) + " " + d[e][citiesLeft.get(i)] + " " + minDist);
				if(d[e][citiesLeft.get(i)] < minDist) {
					minDist = d[e][citiesLeft.get(i)];
					it = i;
				}	
			}
			e = citiesLeft.get(it);
			citiesLeft.remove((Integer)e);
			route.add(cityNames[e]);
			distance += minDist;
		}
		route.add(cityNames[0]);
		distance += d[5][0];
	
		totalFuel += (double)PRICE_PER_GALLON * (distance/MPG);
		driverSalary += (double)distance * DRIVER_PER_MILE;
		helperSalary += (double)distance * HELPER_PER_MILE;
		totalTime += (double)distance/MPH;
		maintenance += (double)distance * WEAR;
		double hotelCost = (double)HOTEL * NUM_CITIES * 2;
		double foodCost  = (double)FOOD * NUM_CITIES * 2;
		
		double total = (double)totalFuel + driverSalary + helperSalary + maintenance + hotelCost + foodCost;
		System.out.println();
		for( int i = 0; i < route.size(); i++) {
			System.out.println(route.get(i));
		}
		System.out.println("\nTotal Distance: " + distance);
		System.out.println("Driver Total: " + currencyFormat.format(driverSalary));
		System.out.println("Helper Total: " + currencyFormat.format(helperSalary));
		System.out.println("Maintenance Cost: " + currencyFormat.format(maintenance));
		System.out.println("Total Driving Time: " + totalTime);
		System.out.println("Total Fuel Cost: " + currencyFormat.format(totalFuel));
		System.out.println("Hotel Cost: " + currencyFormat.format(hotelCost));
		System.out.println("Food Cost: " + currencyFormat.format(foodCost));
		System.out.println("Total Cost: " + currencyFormat.format(total));
		
		
		
	}
}