package LegisletureAndSeveralInfo;

import java.util.Map;

/**
 * Created by Gregory on 16.02.2015.
 */
public class SeveralInfo {
    private Map<String, Integer> severalInfoDictionary; // includes population, vvp;
    private String identifier;

    public SeveralInfo(String identifier, Map<String, Integer> severalInfoDictionary){
        this.severalInfoDictionary = severalInfoDictionary;
        this.identifier = identifier;
    }

    static String[] getKeysForSeveralInfoDictionary(){
        String[] keysForSeveralInfoDictionary = {"population", "vvp"};
        return keysForSeveralInfoDictionary;
    }

    public Map<String, Integer> getSeveralInfoDictionary() {
        return severalInfoDictionary;
    }

    public String getIdentifier() {
        return identifier;
    }
}
