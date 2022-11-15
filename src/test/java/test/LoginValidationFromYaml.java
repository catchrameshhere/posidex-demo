package test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.Login;
import utils.ReadFile;

public class LoginValidationFromYaml extends BaseTest{

	HashMap<String, Object> map;
	String fileName = "users.yaml";
	
	
	
	@BeforeClass
	public void beforeClass() {
		ReadFile rf = new ReadFile();
		map = rf.readYaml(fileName);
	}
	
	
	
	
	@Test
	public void asifDataTest() {
		HashMap<String, String> u1= (HashMap<String, String>) map.get("u1");

		Login login = new Login(driver);
		login.loginWithCredentials(u1.get("username"), u1.get("password"));
	}
	
	@Test
	public void rameshDataTest() {
		HashMap<String, String> u2= (HashMap<String, String>) map.get("u2");

		Login login = new Login(driver);
		login.loginWithCredentials(u2.get("username"), u2.get("password"));
	}
}
