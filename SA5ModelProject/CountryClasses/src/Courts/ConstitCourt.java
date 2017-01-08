package Courts;

import java.util.Map;

/**
 * Created by Gregory on 16.02.2015.
 */

public class ConstitCourt{

   private Map<String, Integer> constitJurisdictionDictionary; // must have keys: judgesCount, salary, decisionsCount
   private String identifier;                    // name of country;
   public ConstitCourt(String identifier, Map<String, Integer> constitJurisdictionDictionary){
       this.identifier = identifier;
       this.constitJurisdictionDictionary = constitJurisdictionDictionary;
   }
   static String[] getKeysForConstitJurisdictionDictionary(){
       String[] keysForConstitJurisdictionDictionary = {"judgeCount, salary, dealCount"};
       return keysForConstitJurisdictionDictionary;
    }

    public Map<String, Integer> getConstitJurisdictionDictionary() {
        return constitJurisdictionDictionary;
    }

    public String getIdentifier() {
        return identifier;
    }
}
