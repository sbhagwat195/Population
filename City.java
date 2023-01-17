/**
 *	City data - the city name, state name, location designation,
 *				and population est. 2017
 *
 *	@author	
 *	@since	
 */
public class City implements Comparable<City> {
	
	// fields
	private String name, stateName, type;
	private int population;
	
	// constructor
	public City(String stateNameIn, String nameIn, String typeIn, int populationIn)
	{
		name = nameIn;
		stateName = stateNameIn;
		type = typeIn;
		population = populationIn;
	}
	
	//copy constructor to make copy objects
	public City(City other)
	{
		name = other.name;
		stateName = other.stateName;
		type = other.type;
		population = other.population;
	}
	
	/**	Compare two cities populations
	 *	@param other		the other City to compare
	 *	@return				the following value:
	 *		If populations are different, then returns (this.population - other.population)
	 *		else if states are different, then returns (this.state - other.state)
	 *		else returns (this.name - other.name)
	 */
	 
	 public int compareTo(City other)
	 {
		if(this.population != other.population)
			return this.population - other.population;
		else if(!(this.stateName.equals(other.stateName)))
			return this.stateName.compareTo(other.stateName);
		
		return this.name.compareTo(other.name);
	 }
	
	/**
	 * Compares just the name of the city, and not the population.
	 * However, if the names match, the population is compared.
	 */
	public int compareNameTo(City other)
	{
		if(!(this.name.equals(other.name)))
			return this.name.compareTo(other.name);
		
		
		return other.population - this.population;
	}
	
	/**	Equal city name and state name
	 *	@param other		the other City to compare
	 *	@return				true if city name and state name equal; false otherwise
	 */
	 public boolean equals(City other)
	 {
		 if(this.name == other.name && this.stateName == other.stateName)
			return true;
			
		return false;
	 }
	 
	/**	Accessor methods */
	public String getStateName()
	{
		return stateName;
	}
	
	public String getName()
	{
		return name;
	}
	
	/**	toString */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", stateName, name, type,
						population);
	}
}
