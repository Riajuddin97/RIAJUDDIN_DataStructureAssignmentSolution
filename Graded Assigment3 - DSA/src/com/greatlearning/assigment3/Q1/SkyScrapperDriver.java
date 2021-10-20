package com.greatlearning.assigment3.Q1;

public class SkyScrapperDriver {

	// main methods to display and call the data of constructions
	public static void main(String args[]) {
		while (true) {
			System.out.println("\n------------------------------");
			System.out.println("WELCOME TO SKYSCRAPPER, MUMBAI");
			System.out.println("------------------------------");
			System.out.println("1.Construction Process");
			System.out.println("0.Close Application");
			System.out.println("______________________________");
			System.out.println("Enter your choice");
			int choice = SkyScrapperData.sc.nextInt();
			
		switch (choice) {
				// case to call the functions to show the data of construction proceeder 
			case 1:
				SkyScrapperData skyScrapperData = new SkyScrapperData();
				skyScrapperData.setScappersData();
				skyScrapperData.constructionProcess();
				break;
				// case to exit the application
			case 0:
				System.out.println("Exited Successfully!!");
				SkyScrapperData.sc.close();
				System.exit(0);
				break;
				// default to chose the correct option
			default:
				System.out.println("Chose the correct option ");
			}
		}
	}

}
