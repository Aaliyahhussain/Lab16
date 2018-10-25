package lab16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountriesTextFile {

private static Path filePath = Paths.get("countries.txt");
	

	static List<Country> readFile() throws IOException {
		
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Country> countries = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("\t");
				Country c = new Country();
				c.setName(parts[0]); 
				c.setPopulation((int) Long.parseLong(parts[1]));
				countries.add(c);
			}
			return countries;
		}  catch ( IOException ex) {

			CountriesApp.displayMenu();
			return new ArrayList<>();
		} 
	}
	
	static void appendToFile(String country, long population) throws IOException {
		if ( Files.notExists(filePath) ) {
			Files.createFile(filePath);
		}
		

		List<String> linesToAdd = Arrays.asList(country + "\t" + population);
		
		Files.write(filePath, linesToAdd, StandardOpenOption.APPEND);
	}

}

