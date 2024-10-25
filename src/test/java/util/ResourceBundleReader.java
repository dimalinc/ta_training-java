package util;
import java.util.ResourceBundle;


public class ResourceBundleReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle
            (System.getProperty("env", "bundle"));

    private ResourceBundleReader(){}

    public static String readFromRecourceBundle(String key) {
        return resourceBundle.getString(key);
    }
}
