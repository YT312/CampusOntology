package competition;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

public class Question1 {
	Model model;
	final String rdf = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
	final String rdfs = "http://www.w3.org/2000/01/rdf-schema#";
	final String ex = "http://example.com/";
	final String owl = "http://www.w3.org/2002/07/owl#";
	Property type;
	Property label;
	Property nearest_station;
	Property address; 
	Resource klass;
	Resource bicycle_parking;
	Resource station;
	
	public Question1() {
		model = ModelFactory.createDefaultModel();
		
		// set namespaces
		
		
		
		
		// create properties
		
		
		
		
		// create classes
		
		
		
		
		// set bicycle_parking's type and station's type
		
		
		
	}
	
	private void createStationAndParkingGraph(String[] array) {
		// create the station RDF graph
		Resource sta = model.getResource(ex + array[0].replaceAll(" ", "_"));

		
		
		// create the bicycle parking RDF graph
		Resource r = model.createResource(ex + array[1].replaceAll(" ", "_"));
		
		
		
	}
	
	public static void main(String[] args) {
		try {
				FileReader fr = new FileReader("opendata/Sample/bicycle_20151029_en_ascii.tsv");
				BufferedReader br = new BufferedReader(fr);
				String line;
				String[] array = null;
				
				Question1 q1 = new Question1();
				
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					if(!line.contains("Name")) {
						array = line.split("	");
						q1.createStationAndParkingGraph(array);
					}
				}
				br.close();
				
				FileOutputStream fout = new FileOutputStream("sumida_bicycle_parking_1.rdf"); 
				q1.model.write(fout,"RDF/XML");
				fout.close();
				q1.model.write(System.out, "RDF/XML");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
