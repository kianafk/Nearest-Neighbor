package MethodofExhaustion;
import java.text.NumberFormat;
import java.util.ArrayList;

public class main{
	
	static int[][] allRoutes = new int[720][8];
	static int fCounter = 0;
	
	public static void main(String[] args)
    {	
    	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
   		
   		final int MPH = 60, MPG = 7, DRIVER_SALARY = 1200, HELPER_SALARY = 900, HOTEL = 100, FOOD = 68, NUM_CITIES = 7;
   		final double PRICE_PER_GALLON = 3.32, DRIVER_PER_MILE = 0.56, HELPER_PER_MILE = 0.42, WEAR = 0.88;
   		int minDistance = 99999;
   		int [][] d = {{0,   13,  142, 225, 40,  352, 227}, {13,  0,   136, 237, 34,  363, 222}, {141, 135, 0,   305, 101, 432, 97}, {226, 237, 304, 0,   248, 133, 371}, {40,  34,  106, 248, 0,   374, 192 }, {352, 364, 431, 133, 375, 0,   462}, {228, 222, 97,  370, 188, 462, 0}};
   		int distance;
   		double driverSalary = 0, helperSalary = 0, totalFuel = 0, maintenance = 0, totalTime = 0;
   		String[] cityNames = {"Rockville", "Silver Spring", "Philadelphia", "Pittsburgh", "Baltimore", "Cleveland", "New York City"};
   		
   		
        String cities = "123456";
        int[] finalRoute = new int[8];
        exhaustionMethod(cities.toCharArray(), 0);
      
        for( int r = 0; r < 720; r++) {
        	distance = 0;
        	for(int t = 0; t<7; t++) {
        		distance += d[allRoutes[r][t]][allRoutes[r][t+1]];
        	}
        	if(distance < minDistance) {
        		minDistance = distance;
        		
        		for(int i = 0; i<8; i++) {
            		finalRoute[i] = allRoutes[r][i];
            	}
        		
        	}
     }
        
        for(int i = 0; i<7; i++) {
    		System.out.println(d[finalRoute[i]][finalRoute[i+1]]);
    	}
        System.out.println("The cities are visited in the following order: ");
        for(int i = 0; i<8; i++) {
    		System.out.println(cityNames[finalRoute[i]] );
    	}

        
		driverSalary += DRIVER_SALARY;
		helperSalary += HELPER_SALARY;
		totalFuel +=(double)PRICE_PER_GALLON * (minDistance/MPG);
		driverSalary += (double)minDistance * DRIVER_PER_MILE;
		helperSalary += (double)minDistance * HELPER_PER_MILE;
		totalTime += (double)minDistance/MPH;
		maintenance += (double)minDistance * WEAR;
		double hotelCost = (double)HOTEL * NUM_CITIES * 2;
		double foodCost  = (double)FOOD * NUM_CITIES * 2;
		
		double total = (double)totalFuel + driverSalary + helperSalary  + maintenance + hotelCost + foodCost;
		
		System.out.println("\nTotal Distance: " + minDistance);
		System.out.println("Driver Total: " + currencyFormat.format(driverSalary));
		System.out.println("Helper Total: " + currencyFormat.format(helperSalary));
		System.out.println("Maintenance Cost: " + currencyFormat.format(maintenance));
		System.out.println("Total Driving Time: " + totalTime);
		System.out.println("Total Fuel Cost: " + currencyFormat.format(totalFuel));
		System.out.println("Hotel Cost: " + currencyFormat.format(hotelCost));
		System.out.println("Food Cost: " + currencyFormat.format(foodCost));
		System.out.println("Total Cost: " + currencyFormat.format(total));
	
    }
	
    public static void swap(char[] place, int i, int j){
        char temp = place[i];
        place[i] = place[j];
        place[j] = temp;
    }
 
    public static void exhaustionMethod(char[] place, int currentIndex){	
 
		if (currentIndex == place.length - 1) {
	        	ArrayList<Integer> route = new ArrayList<>();
	        	for( int c = 0; c < place.length; c++) {
	        		route.add(Character.getNumericValue(place[c]));
	        	}
	        	route.add(0,0);
	        	route.add(0);
	        	
	        	for(int u = 0; u< 8; u++) {
	        		allRoutes[fCounter][u] = route.get(u);
	        	}
	        	fCounter++;	
	        }
	       
	        for (int i = currentIndex; i < place.length; i++){
	            swap(place, currentIndex, i);
	            exhaustionMethod(place, currentIndex + 1);
	            swap(place, currentIndex, i);
	        }
	    }
}

