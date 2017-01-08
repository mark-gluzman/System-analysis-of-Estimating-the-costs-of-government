package Executive;

import java.util.Map;

public class Ministers{   // this class about ministers
    private Map<String, Integer> ministersDictionary; // includes fields ministersCount,
                                              // budget, scienceBudget, defenceBudget;
    private String identifier;

    public Ministers(String identifier, Map<String, Integer> ministersDictionary){
        this.identifier = identifier;
        this.ministersDictionary = ministersDictionary;
    }
    static String[] getKeysForMinistersDictionary(){
        String[] keysForMinistersDictionary = {"ministersCount", "budget", "scienceBudget", "defenceBudget"};
        return keysForMinistersDictionary;
    }

    public Map<String, Integer> getMinistersDictionary() {
        return ministersDictionary;
    }

    public String getIdentifier() {
        return identifier;
    }
}