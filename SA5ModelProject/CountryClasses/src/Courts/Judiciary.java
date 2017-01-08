package Courts;

import java.util.Map;

public class Judiciary {
    private ConstitCourt constitCourt;
    private GeneralJurisdictionCourt generalJurisdictionCourt;

    public Judiciary(ConstitCourt constitCourt,GeneralJurisdictionCourt generalJurisdictionCourt){
        this.constitCourt = constitCourt;
        this.generalJurisdictionCourt = generalJurisdictionCourt;
    }
    public Judiciary(String identifier, Map<String,Integer> constitCourtDictionary,
              Map<String, Integer> generalJurisdictionCourtDictionary){
        this.constitCourt = new ConstitCourt(identifier, constitCourtDictionary);
        this.generalJurisdictionCourt = new GeneralJurisdictionCourt (identifier, generalJurisdictionCourtDictionary);
    }

    public ConstitCourt getConstitCourt() {
        return constitCourt;
    }

    public GeneralJurisdictionCourt getGeneralJurisdictionCourt() {
        return generalJurisdictionCourt;
    }
}
