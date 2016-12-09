package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class ConfigUtil {
	private static Properties pro;
	static {
		pro=new Properties();
		try {
			InputStream input=ConfigUtil.class.getResourceAsStream("/config.properties");
			pro.load(new InputStreamReader(input,
					"UTF-8"));
			input.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getValue(String key){
		return pro.getProperty(key);
	}
	public static void main(String[] args) {
		System.out.println(getValue("appsecret"));
	}
}
