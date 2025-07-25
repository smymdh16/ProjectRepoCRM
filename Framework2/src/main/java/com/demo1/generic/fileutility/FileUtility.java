package com.demo1.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	 public String toReadDataFromPropertyFile(String key) throws IOException
	 {
		  FileInputStream fis=new FileInputStream("./configAppData/commonData.properties");
		  Properties p=new Properties();
		  p.load(fis);
		  String value=p.getProperty(key);
		  return value;
	 }
}
