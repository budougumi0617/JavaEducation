package ex24_01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;


/**
 * @note http://docs.oracle.com/javase/jp/6/api/java/util/ResourceBundle.html
 */
public class GlobalRes_en_US extends ResourceBundle {

    public Object handleGetObject(String key) {
        
        if (key.equals(GlobalRes.GOODBYE)) return "GoodBye in en_US.java";
        return null;
    }

    public Enumeration<String> getKeys() {
        return Collections.enumeration(keySet());
    }

    // Overrides handleKeySet() so that the getKeys() implementation
    // can rely on the keySet() value.
    protected Set<String> handleKeySet() {
        return new HashSet<String>(Arrays.asList(GlobalRes.HELLO, GlobalRes.GOODBYE));
    }
}

