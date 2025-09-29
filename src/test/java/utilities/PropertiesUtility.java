package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtility {

    public static String get(String key){
        Properties properties = new Properties();
        try(InputStream inputStream = PropertiesUtility.class.getClassLoader().getResourceAsStream("configs/appconfig.properties")){
            if (inputStream == null) {
                System.out.println("Unable to read the properties file!");
                return null;
            }
            properties.load(inputStream);
            return properties.getProperty(key);

        }catch (IOException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return null;
    }

}
