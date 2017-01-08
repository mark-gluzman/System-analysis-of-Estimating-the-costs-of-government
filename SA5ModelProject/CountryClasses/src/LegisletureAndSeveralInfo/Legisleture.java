package LegisletureAndSeveralInfo;

import java.util.Map;

/**
 * Created by Gregory on 16.02.2015.
 */


public class Legisleture {
    private Map<String, Integer> legisletureDictionary; // includes palatesCount, deputiesCount, deputiseSalary
    private String identifier;
    public Legisleture(String identifier, Map <String, Integer> legisletureDictionary){
        this.identifier = identifier;
        this.legisletureDictionary = legisletureDictionary;
    }
    static String[] getKeysForLegisletureDictionary(){
        String[] keysForLegisletureDictionary = {"lawsCount", "deputiesCount", "deputiesSalary"};
        return keysForLegisletureDictionary;
    }

    public Map<String, Integer> getLegisletureDictionary() {
        return legisletureDictionary;
    }

    public String getIdentifier() {
        return identifier;
    }
}
