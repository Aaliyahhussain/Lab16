package lab16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class CountriesApp {

	private static Path filePath = Paths.get("countries.txt");
	
	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);

		System.out.print("Enter a country: ");
		String name = scnr.nextLine();
		System.out.print("Enter the population: ");
		int population = scnr.nextInt();
		Country newCountry = new Country(name, population);
		appendToFile(newCountry);

		List<Country> countries = readFile(); 
		for (Country c : countries) {
			System.out.println(c.getName() + " has " + c.getPopulation());
		}
		
		scnr.close();
	}

	private static List<Country> readFile() {
	
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Country> country = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("\t");
				Country c = new Country();
				c.setName(parts[0]);
				country.add(c);
			}
			return country;

		} catch (NoSuchFileException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	private static void appendToFile(Country country) throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}


		String line = country.getName() + "\t" + country.getPopulation();


		List<String> linesToAdd = Arrays.asList(line);

		Files.write(filePath, linesToAdd, StandardOpenOption.APPEND);
	}

	public static void displayMenu() {
		// TODO Auto-generated method stub
		
	}

	
	
}