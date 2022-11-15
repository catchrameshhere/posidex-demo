package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.yaml.snakeyaml.Yaml;

public class ReadFile {

	public Properties readPropertyFile(String fileName) {
		FileReader file;
		Properties prop = null;

		try {
			file = new FileReader(fileName);
			prop = new Properties();
			prop.load(file);

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public HashMap<String, Object> readYaml(String fileName) {
		Yaml yaml = new Yaml();
		InputStream inputStream = this.getClass()
		  .getClassLoader()
		  .getResourceAsStream(fileName);
		HashMap<String, Object> map = yaml.load(inputStream);
		
		return map;
	}

}
