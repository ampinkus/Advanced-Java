package SQLexample;

import java.io.IOException;
import java.util.Properties;

public class Profile  {
    public static Properties getProperties(String name){
        Properties prop = new Properties();

        // include the properties dp.properties file
        // we will switch the properties files based on an env variable
        String env = System.getProperty("env");
        Properties props = new Properties();
        if (env == null)  //if no environment is supplied use dev
            env = "dev";
        String propertiesFile = String.format("/config/db.%s.properties", env); // %s get replaced which whatever %s is
        System.out.println(propertiesFile); // which file are we using?
        try {
            props.load(App.class.getResourceAsStream(propertiesFile));
        } catch (NullPointerException | IOException e) {
            throw new RuntimeException("Can't load properties file: " + propertiesFile);
        }
        return props;
    }
}
