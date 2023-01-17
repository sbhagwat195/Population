import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *	Population - <description goes here>
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	
 *	@since	
 */
public class Population {
	
	// List of cities
	private List<City> cities;
	
	//instance of SortMethods
	private SortMethods sm;
	
	// US data file
	private final String DATA_FILE = "usPopData2017.txt";
	
	//constructor
	public Population()
	{
		cities = new ArrayList<City>();
		sm = new SortMethods();
	}
	
	//create an instance of Population and use it to call run()
	public static void main(String[] args)
	{
		Population p = new Population();
		p.run();
	}
	
	public void run()
	{
		//print the introduction and scan the data to keep it in the list
		boolean running = true;
		printIntroduction();
		scanCities();
		
		while(running)
		{
			/*
			 * Print menu and prompt user for which list of data they want. If that choice
			 * is not available, prompt it again.
			 */
			printMenu();
			int choice = Prompt.getInt("Enter Selection");
			while(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 9)
			{
				choice = Prompt.getInt("Enter Selection");
			}
			
			//if the user picks 9, stop the program and thank them for playing.
			if(choice == 9)
			{
				running = false;
				System.out.println("\nThank you for using Population!");
			}
			/*
			 * If the user picks 1, sort the list in ascending order of its population,
			 * meaning from least to greatest, and record the time it takes. The method then
			 * prints the first 50 states on the newly sorted list and notes the time elapsed.
			 * This uses a selection sort method from SortMethods.
			 */
			else if(choice == 1)
			{
				long startMillisec = System.currentTimeMillis();
				sm.ascendingOrderPopSelectionSort(cities);
				long endMillisec = System.currentTimeMillis();
				long timeTaken = endMillisec - startMillisec;
				System.out.println("\nFifty least populous cities");
				System.out.printf("     %-22s %-22s %-12s %12s\n", "State", "City", "Type", "Population");
				for(int i = 0; i < 50; i ++)
				{
					System.out.printf("%4s ", "" + (i+1) + ":");
					System.out.println(cities.get(i));
				}
				System.out.println("\nElapsed Time " + timeTaken + " milliseconds\n");
			}
			/*
			 * If the user picks 2, sort the list in descending order of its population,
			 * meaning from greatest to least, and record the time it takes. The method then
			 * prints the first 50 states on the newly sorted list and notes the time elapsed.
			 * This uses a merge sort method from SortMethods.
			 */
			else if(choice == 2)
			{
				long startMillisec = System.currentTimeMillis();
				sm.descendingOrderPopMergeSort(cities);
				long endMillisec = System.currentTimeMillis();
				long timeTaken = endMillisec - startMillisec;
				System.out.println("\nFifty most populous cities");
				System.out.printf("     %-22s %-22s %-12s %12s\n", "State", "City", "Type", "Population");
				for(int i = 0; i < 50; i ++)
				{
					System.out.printf("%4s ", "" + (i+1) + ":");
					System.out.println(cities.get(i));
				}
				System.out.println("\nElapsed Time " + timeTaken + " milliseconds\n");
			}
			/*
			 * If the user picks 3, sort the list in ascending order by its name,
			 * meaning from a to z, and record the time it takes. The method then
			 * prints the first 50 states on the newly sorted list and notes the time elapsed.
			 * This uses a insertion sort method from SortMethods.
			 */
			else if(choice == 3)
			{
				long startMillisec = System.currentTimeMillis();
				sm.nameInsertionSort(cities);
				long endMillisec = System.currentTimeMillis();
				long timeTaken = endMillisec - startMillisec;
				System.out.println("\nFifty cities sorted by name");
				System.out.printf("     %-22s %-22s %-12s %12s\n", "State", "City", "Type", "Population");
				for(int i = 0; i < 50; i ++)
				{
					System.out.printf("%4s ", "" + (i+1) + ":");
					System.out.println(cities.get(i));
				}
				System.out.println("\nElapsed Time " + timeTaken + " milliseconds\n");
			}
			/*
			 * If the user picks 4, sort the list in descending order by its name,
			 * meaning from z to a, and record the time it takes. The method then
			 * prints the first 50 states on the newly sorted list and notes the time elapsed.
			 * This uses a merge sort method from SortMethods.
			 */
			else if(choice == 4)
			{
				long startMillisec = System.currentTimeMillis();
				sm.nameMergeSort(cities);
				long endMillisec = System.currentTimeMillis();
				long timeTaken = endMillisec - startMillisec;
				System.out.println("\nFifty cities sorted by name descending");
				System.out.printf("     %-22s %-22s %-12s %12s\n", "State", "City", "Type", "Population");
				for(int i = 0; i < 50; i ++)
				{
					System.out.printf("%4s ", "" + (i+1) + ":");
					System.out.println(cities.get(i));
				}
				System.out.println("\nElapsed Time " + timeTaken + " milliseconds\n");
			}
			/*
			 * If the user chooses 5, prompt them for a state name. If the name
			 * is a valid name for a state in the text file, continue with the program.
			 * If not, prompt them again. Create a new ArrayList of only the cities in
			 * the text file that are from the correct state, and sort that list by population,
			 * from greatest to least. This method uses a merge sort method from SortMethods to 
			 * do this. Print the first 50 cities from the list, or less if there aren't 50.
			 */
			else if(choice == 5)
			{
				String stateChoice = Prompt.getString("\n\nEnter state name (ie. Alabama)");
				
				while(!isState(stateChoice))
				{
					System.out.println("ERROR: " + stateChoice + " is not valid");
					stateChoice = Prompt.getString("Enter state name (ie. Alabama)");
				}
				
				List<City> stateList = new ArrayList<City>();
				
				for(int i = 0; i < cities.size(); i ++)
				{
					if(stateChoice.equals(cities.get(i).getStateName()))
						stateList.add(cities.get(i));
				}
				sm.descendingOrderPopMergeSort(stateList);
				System.out.println("\nFifty most populous cities in " + stateChoice);
				System.out.printf("     %-22s %-22s %-12s %12s\n", "State", "City", "Type", "Population");
				
				if(stateList.size() > 50)
				{
					while(stateList.size() > 50)
					{
						stateList.remove(stateList.size()-1);
					}
				}
				
				for(int i = 0; i < stateList.size(); i ++)
				{
					System.out.printf("%4s ", "" + (i+1) + ":");
					System.out.println(stateList.get(i));
				}
				
				System.out.println();
			}
			/*
			 * If the user chooses 6, prompt them for a city name. If the name
			 * is a valid name for a city in the text file, continue with the program.
			 * If not, prompt them again. Create a new ArrayList of only the cities in
			 * the text file that have that name, and sort that list by population,
			 * from greatest to least. This method uses a merge sort method from SortMethods to 
			 * do this. Print the first 50 cities from the list, or less if there aren't 50.
			 */
			else if(choice == 6)
			{
				String cityChoice = Prompt.getString("\n\nEnter city name");
				
				while(!isCity(cityChoice))
				{
					System.out.println("ERROR: " + cityChoice + " is not valid");
					cityChoice = Prompt.getString("Enter city name");
				}
				
				List<City> cityList = new ArrayList<City>();
				
				for(int i = 0; i < cities.size(); i ++)
				{
					if(cityChoice.equals(cities.get(i).getName()))
						cityList.add(cities.get(i));
				}
				sm.descendingOrderPopMergeSort(cityList);
				System.out.println("\nCity " + cityChoice + " by population");
				System.out.printf("     %-22s %-22s %-12s %12s\n", "State", "City", "Type", "Population");
				
				if(cityList.size() > 50)
				{
					while(cityList.size() > 50)
					{
						cityList.remove(cityList.size()-1);
					}
				}
				
				for(int i = 0; i < cityList.size(); i ++)
				{
					System.out.printf("%4s ", "" + (i+1) + ":");
					System.out.println(cityList.get(i));
				}
				
				System.out.println();
			}
		}
	}
	
	/**
	 * Returns true if the String is the name of a state on the usPopData2017
	 * list. If not, returns false;
	 */
	public boolean isState(String str)
	{
		for(int i = 0; i < cities.size(); i ++)
		{
			if(str.equals(cities.get(i).getStateName()))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Returns true if the String is the name of a city on the usPopData2017
	 * list. If not, returns false;
	 */
	public boolean isCity(String str)
	{
		for(int i = 0; i < cities.size(); i ++)
		{
			if(str.equals(cities.get(i).getName()))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Scans the data from the file usPopData2017.txt and stores
	 * the various values in different City objects.
	 */
	public void scanCities()
	{
		Scanner scan = FileUtils.openToRead("usPopData2017.txt");
		scan.useDelimiter("[\t\n]");
		
		for(int i = 0; i < 31765; i++)
		{
			cities.add(new City(scan.next(), scan.next(), scan.next(), scan.nextInt()));
		}
		/*
		sm.nameMergeSort(cities);
		
		for(int i = 0; i < 50; i ++)
		{
			System.out.println(cities.get(i));
		}
		*/
	}
	
	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
	}
	
	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}
	
}
