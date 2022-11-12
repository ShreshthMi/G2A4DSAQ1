package Q1;

import java.util.Scanner;

public class MainActivity {

	MainActivity(Scanner sc) {
		System.out.println("Enter the total number of floors in the building:");
		Integer totalFloors = 0;
		try {
			totalFloors = sc.nextInt();
			if (totalFloors < 1) {
				System.out.println("Total floors has to be greater than 1");
			} else {
				Integer[] sizeOfFloors = inputFloorSize(sc, totalFloors);
				AssemblyOfFloors floor = new AssemblyOfFloors(totalFloors);
				outputActivity(floor, totalFloors, sizeOfFloors);
			}

		} catch (Exception e) {
			System.out.println("Numbers Allowed Only!!");
		}
	}

	Integer[] inputFloorSize(Scanner sc, int totalFloors) {
		Integer[] sizeOfFloors = new Integer[totalFloors];
		for (int day = 0; day < totalFloors; day++) {

			System.out.println("Enter the floor size given on day: " + (day + 1));
			int input = Integer.valueOf(sc.nextInt());

			if (badFloorSizeCheck(input, sizeOfFloors, totalFloors, day) == false) {
				sizeOfFloors[day] = input;
			} else {
				day--;
			}
		}		
		return sizeOfFloors;
	}

	void outputActivity(AssemblyOfFloors floor, Integer totalFloors, Integer[] sizeOfFloors) {
		System.out.println("The order of construction is as follows:");
		for (int i = 0; i < totalFloors; i++) {
			System.out.println("Day: " + (i + 1));
			floor.floorConstruction(sizeOfFloors[i]);
			System.out.println();
		}
	}

	boolean badFloorSizeCheck(int input, Integer[] sizeOfFloors, Integer totalFloors, int day) {
		boolean badInput = false;
		if (input < 1) {
			System.out.println("Size < 1");
			return true;
		}
		if (input > totalFloors) {
			System.out.println("Size > Total number of Floors");
			return true;
		}
		for (int j = 0; j < day; j++) {
			if (input == sizeOfFloors[j]) {
				badInput = true;
				System.out.println("Not distinct Input");
				break;
			}
		}
		return badInput;
	}
}