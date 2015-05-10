package com.erichstark.parser;

import com.erichstark.base.Arc;
import com.erichstark.base.Place;
import com.erichstark.base.Transition;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erich on 10/05/15.
 */
public class PflowParser {
	private File pflow;
	private List<Place> placeList;
	private List<Arc> arcList;
	private List<Transition> transitionList;


	public PflowParser(String fileName) {
		this.pflow = new File(fileName);
	}

	public List<Place> parsePlaces() {
		try {
			placeList = new ArrayList<Place>();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(pflow);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("place");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					Place tmpPlace = new Place();
					tmpPlace.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
					tmpPlace.setIsStatic(Boolean.parseBoolean(eElement.getElementsByTagName("isStatic").item(0).getTextContent()));
					tmpPlace.setLabel(eElement.getElementsByTagName("label").item(0).getTextContent());
					tmpPlace.setTokens(Integer.parseInt(eElement.getElementsByTagName("tokens").item(0).getTextContent()));

					placeList.add(tmpPlace);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return placeList;
	}

	public List<Transition> parseTransitions() {
		try {
			transitionList = new ArrayList<Transition>();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(pflow);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("transition");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					Transition tmpTransition = new Transition();
					tmpTransition.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
					tmpTransition.setLabel(eElement.getElementsByTagName("label").item(0).getTextContent());

					transitionList.add(tmpTransition);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return transitionList;
	}

	public List<Arc> parseArcs() {
		try {
			arcList = new ArrayList<Arc>();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(pflow);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("arc");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					Arc tmpArc = new Arc();
					tmpArc.setType(eElement.getElementsByTagName("type").item(0).getTextContent());
					tmpArc.setSourceId(Integer.parseInt(eElement.getElementsByTagName("sourceId").item(0).getTextContent()));
					tmpArc.setDestinationId(Integer.parseInt(eElement.getElementsByTagName("destinationId").item(0).getTextContent()));
					tmpArc.setMultiplicity(Integer.parseInt(eElement.getElementsByTagName("multiplicity").item(0).getTextContent()));

					arcList.add(tmpArc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arcList;
	}
}
