package Courts;

import java.util.Map;

/**
 * Created by Gregory on 16.02.2015.
 */
public class GeneralJurisdictionCourt {

    private Map<String, Integer> generalJurisdictionDictionary; // must have keys: courtsCount, dealCount, salary, judgeCount
    private String identifier; // name of country;

    public GeneralJurisdictionCourt(String identifier, Map<String, Integer> generalJurisdictionDictionary) {
        this.identifier = identifier;
        this.generalJurisdictionDictionary = generalJurisdictionDictionary;
    }

    static String[] getKeysForGeneralJurisdictionDictionary() {
        String[] keysForGeneralJurisdictionDictionary = {"courtsCount", "dealCount", "salary", "judgeCount"};
        return keysForGeneralJurisdictionDictionary;
    }

    public Map<String, Integer> getGeneralJurisdictionDictionary() {
        return generalJurisdictionDictionary;
    }

    public String getIdentifier() {
        return identifier;
    }
}
