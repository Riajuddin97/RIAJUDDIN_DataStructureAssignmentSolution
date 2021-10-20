package com.greatlearning.assigment3.Q1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class SkyScrapperData {
	int totalFloors;
	int noOfWorkingDays;
	public static Scanner sc = new Scanner(System.in);
	LinkedList<Integer> FloorSize = new LinkedList<Integer>(); // to store the floor size data
	LinkedList<Integer> SortedFloorSize = new LinkedList<Integer>();// to store the sorted floor size
	
	//function to take inputs from user and sort the entered Data 
	void setScappersData() {
		System.out.println("Enter the total no of floors in the building");
		totalFloors = sc.nextInt();
		noOfWorkingDays= totalFloors;
		
		int floorSize;
		for (int floorNumber = 0; floorNumber < totalFloors; floorNumber++) {
			System.out.print("Enter the floor size given on day : " + (floorNumber + 1) +  "\n");
			floorSize = sc.nextInt();
			FloorSize.add(floorSize);
			SortedFloorSize.add(floorSize);
		}
		Collections.sort(SortedFloorSize, Collections.reverseOrder());

	}
	
	// function to find the largest floor size and pop out from the linkedlist
	void constructionProcess() {
		System.out.println("\n*************************************** ");
		System.out.println("The order of construction is as follows: ");
		int sortedfloorNumber = 0;
		for (int dayOfConstruction = 0; dayOfConstruction < noOfWorkingDays; dayOfConstruction++) {
			System.out.println("\nDay: " + (dayOfConstruction + 1));
			int largestAvailableFloorSize = SortedFloorSize.get(sortedfloorNumber);
			if (FloorSize.get(dayOfConstruction) < largestAvailableFloorSize) {
				continue;
			}
			System.out.print(largestAvailableFloorSize + " ");

			// The used floors are marked as -1 so as not to repeatedly search them.
			FloorSize.set(dayOfConstruction, -1);

			// Having two different Arrays, one to keep track of number of the floor
			// Another one to keep track of the size of the floors.
			SortedFloorSize.remove(sortedfloorNumber);

			int tempdayOfConstruction = 0;

			// Since elements of listOfAvailableFloorSizeSorted is deleted after use its
			// size will be variable
			// Thus, checking the size before going into loop to access this.
			while ((tempdayOfConstruction <= dayOfConstruction) && SortedFloorSize.size() > 0) {
				if (FloorSize.get(tempdayOfConstruction) < SortedFloorSize.get(sortedfloorNumber)) {
					tempdayOfConstruction++;
					continue;
				} else {
					System.out.print(FloorSize.get(tempdayOfConstruction) + " ");
					FloorSize.set(tempdayOfConstruction, -1);
					SortedFloorSize.remove(sortedfloorNumber);
					tempdayOfConstruction = 0;
				}
			}
		}

		// If there are any floor blocks remaining on the last day of construction they
		// are place on top of each other.
		for (int i = 0; i < SortedFloorSize.size(); i++) {
			System.out.print(SortedFloorSize.get(i) + " ");
			
		}
	}
}