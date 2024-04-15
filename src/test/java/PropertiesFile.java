import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    static Properties prop = new Properties();

    public static void main(String[] args) throws IOException {
        readProperties();
        writeProperties();
        readProperties();
    }

    public static void readProperties() throws IOException {
        InputStream input = new FileInputStream("/Users/takiacademy/IdeaProjects/FirstTest/src/config/config.properties");
        prop.load(input);
        System.out.println(prop.getProperty("browser"));
        Modularcode.browser = prop.getProperty("browser");
        System.out.println(Modularcode.browser);
    }

    public static void writeProperties() throws IOException {
        OutputStream output = new FileOutputStream("/Users/takiacademy/IdeaProjects/FirstTest/src/config/config.properties");
        //prop.setProperty("browser","Firefox");
        prop.setProperty("result", "testpassed");
        prop.store(output, null);

    }
}
