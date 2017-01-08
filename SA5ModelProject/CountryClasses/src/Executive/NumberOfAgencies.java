package Executive;

public class NumberOfAgencies{
    private Integer numberOfAgencies;
    private String identifier;
    public NumberOfAgencies(String identifier, Integer numberOfAgencies){
        this.numberOfAgencies = numberOfAgencies;
        this.identifier = identifier;
    }

    public Integer getNumberOfAgencies() {
        return numberOfAgencies;
    }

    public String getIdentifier() {
        return identifier;
    }
}
