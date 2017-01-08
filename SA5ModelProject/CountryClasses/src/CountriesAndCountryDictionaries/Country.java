package CountriesAndCountryDictionaries;

import Courts.ConstitCourt;
import Courts.GeneralJurisdictionCourt;
import Courts.Judiciary;
import Executive.ExecutivePower;
import Executive.Ministers;
import Executive.NumberOfAgencies;
import LegisletureAndSeveralInfo.Legisleture;
import LegisletureAndSeveralInfo.SeveralInfo;

import java.util.Map;

/**
 * Created by Gregory on 16.02.2015.
 */


public class Country {
    public ExecutivePower executivePower;
    public Judiciary judiciary;
    public Legisleture legisleture;
    public SeveralInfo severalInfo;
    public String identifier;

    public Country(Legisleture legisleture,
                   Ministers ministers, NumberOfAgencies numberOfAgencies,
                   ConstitCourt constitCourt, GeneralJurisdictionCourt generalJurisdictionCourt,
                   SeveralInfo severalInfo)
    {
        this.legisleture = legisleture;
        this.severalInfo = severalInfo;
        this.judiciary = new Judiciary(constitCourt, generalJurisdictionCourt);
        this.executivePower = new ExecutivePower(ministers, numberOfAgencies);
    }

    public Country(String identifier, Map<String, Integer> countryLegisleture, Map<String, Integer> countryMinisters,
                   Integer countryNumberOfAgencies,Map<String, Integer> countryConstitCourt,
                   Map<String, Integer> countryGeneralJurisdictionCourt,
                   Map<String, Integer> countrySeveralInfo)
    {
        this.executivePower = new ExecutivePower(identifier,countryMinisters, countryNumberOfAgencies);
        this.severalInfo = new SeveralInfo(identifier,countrySeveralInfo);
        this.judiciary = new Judiciary(identifier,countryConstitCourt, countryGeneralJurisdictionCourt);
        this.legisleture = new Legisleture(identifier,countryLegisleture);
    }
}
