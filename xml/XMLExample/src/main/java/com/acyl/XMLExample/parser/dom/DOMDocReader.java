package com.acyl.XMLExample.parser.dom;


import com.acyl.XMLExample.model.Device;
import com.acyl.XMLExample.model.Type;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMDocReader {
	public List<Device> readDoc(Document doc) {
		doc.getDocumentElement().normalize();
		List<Device> devices = new ArrayList<>();

		NodeList nodeList = doc.getElementsByTagName("device");

		for (int i = 0; i < nodeList.getLength(); i++) {
			Device device = new Device();
			Type type;

			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;

				device.setName(element.getElementsByTagName("name").item(0).getTextContent());
				device.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());
				device.setPrice(Integer.parseInt(element.getElementsByTagName("price").item(0).getTextContent()));
				device.setCritical(Boolean.parseBoolean(element.getAttribute("critical")));

				type = getType(element.getElementsByTagName("type"));

				device.setType(type);
				devices.add(device);
			}
		}
		return devices;
	}

	private Type getType(NodeList nodes) {
		Type type = new Type();
		if (nodes.item(0).getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) nodes.item(0);
			type.setGroup(element.getElementsByTagName("group").item(0).getTextContent());
			type.setPeripheral(Boolean.parseBoolean(element.getElementsByTagName("peripheral").item(0).getTextContent()));
			type.setEnergyConsumption(Integer.parseInt(element.getElementsByTagName("energyConsumption").item(0).getTextContent()));
			if(element.getElementsByTagName("port").item(0)!=null)
				type.setPort(element.getElementsByTagName("port").item(0).getTextContent());
		}
		return type;
	}
}
