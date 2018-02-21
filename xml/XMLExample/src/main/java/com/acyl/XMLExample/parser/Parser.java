package com.acyl.XMLExample.parser;


import com.acyl.XMLExample.filechecker.ExtensionChecker;

import com.acyl.XMLExample.model.Device;
import com.acyl.XMLExample.parser.dom.DOMParserUser;

import java.io.File;
import java.util.List;

public class Parser {

  public static void main(String[] args) {
    File xml = new File("src\\main\\resources\\device.xml");
    File xsd = new File("src\\main\\resources\\deviceXSD.xsd");

    if (checkIfXML(xml) && checkIfXSD(xsd)) {

//            DOM
      printList(DOMParserUser.getDeviceList(xml, xsd), "DOM");
    }
  }

  private static boolean checkIfXSD(File xsd) {
    return ExtensionChecker.isXSD(xsd);
  }

  private static boolean checkIfXML(File xml) {
    return ExtensionChecker.isXML(xml);
  }

  private static void printList(List<Device> devices, String parserName) {
    System.out.println(parserName);
    for (Device device : devices) {
      System.out.println(device);
    }
  }

}
