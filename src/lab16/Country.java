package lab16;

public class Country {

	public Country( ) {
		super();
	}
	String name;
	int population;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public Country(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", population=" + population + "]";
	}

}


// to string method used for debugging 
// Java-bean "Pojo"
// fields
// constructors - required* default no argument (other kind), overloaded
// getters/setters
// main method class - not the same thing as java bean
// writing keyword class doesn't make everything a class
// when talking about OOP(java bean), referring to java bean 
// big class, keyword - lowercase class
// constructors/fields should always be private
// overload public country (string name, int pop)
// default public country () { super(); }