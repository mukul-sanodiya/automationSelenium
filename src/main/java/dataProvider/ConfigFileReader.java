package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    public Properties properties;

    public ConfigFileReader() {
        String propertyFile = "src/test/resources/config/Config_QA.properties";

        try (BufferedReader reader = new BufferedReader(new FileReader(propertyFile))) {
            properties = new Properties();
            properties.load(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File Not Present");
        } catch (IOException e) {
            throw new RuntimeException("Error");
        }
    }

        public String getProperty(String key){
            String value=properties.getProperty(key);
            if(value==null || value.trim().isEmpty()){
                throw new RuntimeException("Value not found");
            }
            return value;
        }

        public String getUrl(){
        return getProperty("url");
        }
        public String getBrowser(){
        return getProperty("browser");
        }
        public int getImplicitWait(){
        return Integer.parseInt(getProperty("implicitWait"));
        }
        public int getExplicitWait(){
        return Integer.parseInt(getProperty("explicitWait"));
        }
}
