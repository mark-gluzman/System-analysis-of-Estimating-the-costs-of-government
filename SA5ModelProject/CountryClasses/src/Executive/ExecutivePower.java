package Executive;

import java.util.Map;

/**
 * Created by Gregory on 16.02.2015.
 */



public class ExecutivePower {
    private NumberOfAgencies numberOfAgencies;
    private Ministers ministers;

    public ExecutivePower( Ministers ministers, NumberOfAgencies numberOfAgencies){
        this.ministers = ministers;
        this.numberOfAgencies = numberOfAgencies;
    }

    public ExecutivePower(String identifier, Map<String, Integer> ministersDictionary, Integer numberOfAgencies){
         this.ministers = new Ministers(identifier, ministersDictionary);
         this.numberOfAgencies = new NumberOfAgencies(identifier, numberOfAgencies);
    }

    public NumberOfAgencies getNumberOfAgencies() {
        return numberOfAgencies;
    }

    public Ministers getMinisters() {
        return ministers;
    }
}
