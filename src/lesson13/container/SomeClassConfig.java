package lesson13.container;

import lesson6.SomeClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Config
public class SomeClassConfig {
    private String name;
    private int version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public static void main(String[] args) {
        SomeClassConfig config = new SomeClassConfig();
        try (InputStream inputStream =
                     SomeClassConfig.class
                             .getClassLoader()
                             .getResourceAsStream("someClass.properties")) {

            Properties properties = new Properties();
            properties.load(inputStream);
            String name = properties.getProperty("name");
            int vertion = Integer.parseInt(properties.getProperty("version"));
            config.setName(name);
            config.setVersion(vertion);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
