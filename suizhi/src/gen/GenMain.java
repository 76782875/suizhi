package gen;

public class GenMain {
	public static void main(String[] args) {
		String configFile = "generatorConfig.xml";
		try {
//			"activity", "admin",
//			"attendroster", "contact", "menu", "", "poster",
//			, , "user" "sponsor"
			String[] tableNames = new String[] {"info" };
			GenMybatisFiles.gen(configFile, tableNames);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
