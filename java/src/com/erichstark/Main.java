package com.erichstark;

import com.erichstark.base.Arc;
import com.erichstark.base.Place;
import com.erichstark.base.Transition;
import com.erichstark.parser.PflowParser;

import java.util.List;

/**
 * Created by Erich on 10/05/15.
 */
public class Main {
	public static void main(String[] args) {
		List<Place> placeList;
		List<Transition> transitionList;
		List<Arc> arcList;
		String fileName;

		// Release: ak sa zada cesta z konzole alebo nazov suboru tak ju zoberie ako prvu
		// java -jar boundedness.jar /cesta/k/subor.pflow
		if (args.length > 0) {
			fileName = args[0];
		} else {
			// Debug: potom zmazat pri release
			fileName = "/Users/Erich/Desktop/pflow/safe_ohr.pflow";
		}

		// parameter je cesta k suboru .pflow
		PflowParser pflowParser = new PflowParser(fileName);


		// zavola sa metoda triedy PflowParser a nasledne podla typu
		// sa vyparsovane data ulozia do listu pre dalsie spracovanie do algoritmu
		placeList = pflowParser.parsePlaces();
		transitionList = pflowParser.parseTransitions();
		arcList = pflowParser.parseArcs();


		// Debug: vypisanie ulozenych objektov pre kontrolu
		for (Place place : placeList) {
			System.out.println("Place");
			System.out.println("ID: " + place.getId());
			System.out.println("Label: " + place.getLabel());
			System.out.println("isStatic: " + place.isStatic());
			System.out.println("Tokens: " + place.getTokens() + "\n");
		}

		for (Transition transition : transitionList) {
			System.out.println("Transition");
			System.out.println("ID: " + transition.getId());
			System.out.println("Label: " + transition.getLabel() + "\n");
		}

		for (Arc arc : arcList) {
			System.out.println("Arc");
			System.out.println("Type: " + arc.getType());
			System.out.println("SourceId: " + arc.getSourceId());
			System.out.println("DestinationId: " + arc.getDestinationId());
			System.out.println("Multiplicity: " + arc.getMultiplicity() + "\n");
		}

	}
}
