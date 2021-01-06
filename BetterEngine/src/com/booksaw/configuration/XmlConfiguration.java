package com.booksaw.configuration;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlConfiguration extends FileConfiguration {

	private Document document;

	@Override
	public void loadFromString(String contents) {
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			document = dBuilder.parse(new ByteArrayInputStream(contents.getBytes()));

			document.getDocumentElement().normalize();

		} catch (Exception e) {
			throw new IllegalArgumentException("Could not load XML, invliad string: " + e.getMessage());
		}
	}

	@Override
	public ConfigurationOptions getConfigurationOptions() {
		return new ConfigurationOptions("");
	}

	@Override
	public Object get(String reference) {
		return getString(reference);
	}

	@Override
	public String getString(String reference) {

		Element element = getElement(reference);
		if (element == null) {
			return null;
		}

		return element.getTextContent();
	}

	public NodeList getNodeList(String reference) {
		NodeList nList = document.getElementsByTagName(reference);
		return nList;
	}

	public Node getNode(String reference) {
		NodeList nList = getNodeList(reference);

		if (nList == null || nList.getLength() == 0) {
			return null;
		}

		return nList.item(0);

	}

	public Element getElement(String reference) {
		Node n = getNode(reference);

		if (n == null || n.getNodeType() != Node.ELEMENT_NODE) {
			return null;
		}

		return (Element) n;

	}

	@Override
	public void save(File f) throws IOException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transf;
		try {
			transf = transformerFactory.newTransformer();

			transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transf.setOutputProperty(OutputKeys.INDENT, "yes");
			transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			DOMSource source = new DOMSource(document);
			StreamResult file = new StreamResult(f);
			transf.transform(source, file);
		} catch (TransformerException e) {
			throw new IOException(e);
		}

	}

}
