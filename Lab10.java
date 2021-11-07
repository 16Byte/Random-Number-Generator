import java.util.Scanner;

public class Lab10 {
		
	static boolean debugging = false;
	
	static int[][] nTable = new int[7][7];
	
	static Scanner scan = new Scanner(System.in);
	
	static int curNum;
	
	public static void main(String[] args) {
		//Start
		random(nTable);
	}
	
	public static void random(int[][] table) {
		table = new int[7][7];
		int min = 0;
		int max = 99;
		
		for(int x = 0; x < table.length; x++) {
			for(int y = 0; y < table.length; y++) {
				curNum = getRandomNumber(min, max);
				replaceValues(x, y, curNum, table);
				check(min, max, x, y, table);
				multiply(x, y, table, false);
			}//end y loop
			//System.out.println();
		}//end x loop
		
		printArray(table);
		
		System.out.println();
		System.out.println();
		
		nextStep(min, max, table);
	}
	
	public static void replaceValues(int x, int y, int curNum, int[][] table) {
		table[x][y] = curNum;
	}
	
	public static int getRandomNumber(int min, int max) {
		
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	
	//maybe just input the values into the actual method as seen in the line below and then passing it through a for loop in the random method. We can iron it out later but I think it's a good debugging solution.
	public static void printArray(int[][] table) {
		System.out.println("_____________________________________________________________");
		for(int x = 0; x < table.length; x++) {
			for(int y = 0; y < table.length; y++) {
				System.out.print(" |\t| " + table[x][y]);
			}//end y loop
			System.out.print(" |");
			System.out.println();
		}//end x loop
	}
	
	public static boolean check (int min, int max, int x, int y, int[][] table) {
		
		boolean TorF = false;
		
		//checks that each number added to the  is in range
		if(table[x][y] <= max && table[x][y] >= min) {
			TorF = true;
				//debug tool
				//System.out.println("X: " + x + " | Y: " + y + " | Compliant: " + TorF);
		} else {
			TorF = false;
				//debug tool
				//System.out.println("X: " + x + " | Y: " + y + " | Compliant: " + TorF);
		}
		return TorF;
	}
	
	public static int multiply (int x, int y, int[][] table, boolean display) {
		
		int value = 0;
	
		value = value + (table[x][y] * table[y][x]);
		if(display) {
			System.out.println("XY * YX = " + value);
		}
		return value;
	}
	
	public static void nextStep(int min, int max, int[][] table) {
	
		int x = 0;
		int y = 0;
	
		//ask the user for X and Y values
		System.out.println("Please enter an X value: ");
		x = scan.nextInt();
		System.out.println("Please enter a Y value: ");
		y = scan.nextInt();
		
		if(check(min, max, x, y, table)) {
			//show the user the value of XY and YX
			System.out.println();
			System.out.println("X: " + x + " | Y: " + y + " | Value: " + table[x][y]);
			System.out.println("Y: " + y + " | X: " + x + " | Value: " + table[y][x]);
			System.out.println();
			multiply(x, y, table, true);
		} else {
			//error message
			System.out.println("Error: \t X: " + x + " | Y: " + y + " | Array index out of bound value: " + table[x][y]);
		}	
	}
}