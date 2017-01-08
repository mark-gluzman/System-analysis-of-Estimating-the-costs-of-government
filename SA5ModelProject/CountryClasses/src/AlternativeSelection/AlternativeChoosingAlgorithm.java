package AlternativeSelection;

import CountriesAndCountryDictionaries.Country;
import CountriesAndCountryDictionaries.IntegersForDictionaries;
import Courts.ConstitCourt;
import Courts.GeneralJurisdictionCourt;
import Executive.Ministers;
import Executive.NumberOfAgencies;
import LegisletureAndSeveralInfo.Legisleture;
import LegisletureAndSeveralInfo.SeveralInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Gregory on 17.02.2015.
 */
public class AlternativeChoosingAlgorithm {
    SeveralInfo chosenSeveralInfo;
    Legisleture chosenLegisleture;
    ConstitCourt chosenConstitCourt;
    GeneralJurisdictionCourt chosenGeneralJurisdictionCourt;
    Ministers chosenMinisters;
    NumberOfAgencies chosenNumberOfAgencies;

//    public Country(String identifier, Map<String, Integer> countryLegisleture, Map<String, Integer> countryMinisters,
//                   Integer countryNumberOfAgencies,
//                   Map<String, Integer> countryConstitCourt, Map<String, Integer> countryGeneralJurisdictionCourt,
//                   Map<String, Integer> countrySeveralInfo){

    // all this constraints are dictionaries with identical for Map, which above, keys. Value for certain key is Integer[2] array.
    // Integer [0] smaller value
    // Integer [1] bigger value
    Map<String, Integer[]> legisletureConstraints;
    Map<String, Integer[]> severalInfoConstraints;
    Map<String, Integer[]> constitCourtConstraints;
    Map<String, Integer[]> generalJurisdictionConstraints;
    Map<String, Integer[]> ministersConstraints;
    Integer[] numberOfAgenciesConstraints;
    private ArrayList<Country> dictionaryOfCountries;
    private Country chosenCountry;


    public  boolean isContainedInRange(Integer number, Integer[] range){
        if (range.length > 1){
            if (range[0] >= range[1]) System.out.println("    Inverted range" + range[0] +"  "+ range[1]);
            if (range[0] <= number && range[1] >= number) return true;
        }
        return false;
    }

    void createChosenCountry(){

            chosenCountry = new Country(chosenLegisleture, chosenMinisters, chosenNumberOfAgencies,
                                        chosenConstitCourt,chosenGeneralJurisdictionCourt,
                                        chosenSeveralInfo);

    }
    Integer[] randomIndexes(Integer size){
        Integer[] randArray = new Integer[size];
        int j;
        randArray[0] = (int)(Math.random() * size);

        for(int i = 1; i<size; ++i) {
            boolean isRepeat = true;
            while (isRepeat) {
                isRepeat = false;
                randArray[i] = (int) (Math.random() * size);
                for (j = 0; j < i; ++j) {
                    if (randArray[j] == randArray[i]) {
                        isRepeat = true;
                        break;
                    }
                }
            }
        }
        return randArray;

    }

    void makeChosenBranchesOfCountry(){
        //int rnd = 1 + (int)(Math.random() * 6);// delete one of chosen branches

        Integer countriesCount = dictionaryOfCountries.size();

        //---------------------------SeveralInfo-------------------------------
        Integer[] randIndexes = randomIndexes(countriesCount);

        for (int i = 0; i < countriesCount; ++i){
            Country country = dictionaryOfCountries.get(randIndexes[i]);
            Map <String, Integer> currentSeveralInfoDictionary = country.severalInfo.getSeveralInfoDictionary();
            if(doesFirstDictionaryInRangeOfSecond(currentSeveralInfoDictionary,severalInfoConstraints)) {
                chosenSeveralInfo = new SeveralInfo(country.severalInfo.getIdentifier(),currentSeveralInfoDictionary);
                break;
            }
        }
        //---------------------------Legisleture-------------------------------
        for (int i = 0; i < countriesCount; ++i){
            Country country = dictionaryOfCountries.get(randIndexes[i]);
            Map <String, Integer> currentLegisletureDictionary = country.legisleture.getLegisletureDictionary();
            if(doesFirstDictionaryInRangeOfSecond(currentLegisletureDictionary,legisletureConstraints)) {
                chosenLegisleture = new Legisleture(country.legisleture.getIdentifier(),currentLegisletureDictionary);
                break;
            }
        }

        //---------------------------executivePower.Ministers-------------------------------
        for (int i = 0; i < countriesCount; ++i){
            Country country = dictionaryOfCountries.get(randIndexes[i]);
            Map <String, Integer> currentMinistersDictionary = country.executivePower.getMinisters().getMinistersDictionary();
            if(doesFirstDictionaryInRangeOfSecond(currentMinistersDictionary,ministersConstraints)) {
                chosenMinisters = new Ministers(country.executivePower.getMinisters().getIdentifier(),currentMinistersDictionary);
                break;
            }
        }
        //---------------------------executivePower.NumberOfAgencies-------------------------------
        for (int i = 0; i < countriesCount; ++i){
            Country country = dictionaryOfCountries.get(randIndexes[i]);
            Integer currentNumberOfAgencies = country.executivePower.getNumberOfAgencies().getNumberOfAgencies();
            if(isContainedInRange(currentNumberOfAgencies,numberOfAgenciesConstraints)) {
                chosenNumberOfAgencies = new NumberOfAgencies(country.executivePower.getNumberOfAgencies().getIdentifier(),currentNumberOfAgencies);
                break;
            }
        }
        //---------------------------Judiciary.ConstitCourt-------------------------------
        for (int i = 0; i < countriesCount; ++i){
            Country country = dictionaryOfCountries.get(randIndexes[i]);
            Map <String, Integer> currentConstitJurisdictionDictionary = country.judiciary.getConstitCourt().getConstitJurisdictionDictionary();
            if(doesFirstDictionaryInRangeOfSecond(currentConstitJurisdictionDictionary,constitCourtConstraints)) {
                chosenConstitCourt = new ConstitCourt(country.judiciary.getConstitCourt().getIdentifier(),currentConstitJurisdictionDictionary);
                break;
            }
        }

        //---------------------------Judiciary.GeneralJurisdictionCourt-------------------------------
        for (int i = 0; i < countriesCount; ++i){
            Country country = dictionaryOfCountries.get(randIndexes[i]);
            Map <String, Integer> currentGeneralJurisdictionDictionary = country.judiciary.getGeneralJurisdictionCourt().getGeneralJurisdictionDictionary();
            if(doesFirstDictionaryInRangeOfSecond(currentGeneralJurisdictionDictionary,generalJurisdictionConstraints)) {
                chosenGeneralJurisdictionCourt = new GeneralJurisdictionCourt(country.judiciary.getGeneralJurisdictionCourt().getIdentifier(),currentGeneralJurisdictionDictionary);
                break;
            }
        }


    }

    boolean doesFirstDictionaryInRangeOfSecond(Map<String, Integer> info, Map<String, Integer[]> infoConstraints){
       if (info == null) {
           System.out.println(" doesFirstDictionaryInRangeOfSecond: Info is null");
           return false;
       }
       for (Map.Entry<String, Integer> entry: info.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key +"  "+value);
            Integer []range = infoConstraints.get(key);
            if (range == null ) System.out.println(key + "in constraints does not exist");
            if(!isContainedInRange(value,range)) return false;
        }
        return true;
    }

    public ArrayList<Country> createDictOfCountriesFromDictionaries(){
       ArrayList<Country> countriesList = new ArrayList<Country>(5);
        countriesList.add(new Country("India",IntegersForDictionaries.IndiaLegisletureInfo,
                IntegersForDictionaries.IndiaMinistersInfo,
                IntegersForDictionaries.IndiaAgenciesCount,IntegersForDictionaries.IndiaConstitJurisdictionCourt,
                IntegersForDictionaries.IndiaGeneralJurisdictionCourt,IntegersForDictionaries.IndiaSeveralInfo));
        countriesList.add(new Country("USA",IntegersForDictionaries.USALegisletureInfo,
                IntegersForDictionaries.USAMinistersInfo,
                IntegersForDictionaries.USAAgenciesCount,IntegersForDictionaries.USAConstitJurisdictionCourt,
                IntegersForDictionaries.USAGeneralJurisdictionCourt,IntegersForDictionaries.USASeveralInfo));
        countriesList.add(new Country("Ukraine",IntegersForDictionaries.UkraineLegisletureInfo,
                IntegersForDictionaries.UkraineMinistersInfo,
                IntegersForDictionaries.UkraineAgenciesCount,IntegersForDictionaries.UkraineConstitJurisdictionCourt,
                IntegersForDictionaries.UkraineGeneralJurisdictionCourt,IntegersForDictionaries.UkraineSeveralInfo));
        countriesList.add(new Country("GreatBritain",IntegersForDictionaries.GreatBritainLegisletureInfo,
                IntegersForDictionaries.GreatBritainMinistersInfo,
                IntegersForDictionaries.GreatBritainAgenciesCount,IntegersForDictionaries.GreatBritainConstitJurisdictionCourt,
                IntegersForDictionaries.GreatBritainGeneralJurisdictionCourt,IntegersForDictionaries.GreatBritainSeveralInfo));
        countriesList.add(new Country("Russian",IntegersForDictionaries.RussianLegisletureInfo,
                IntegersForDictionaries.RussianMinistersInfo,
                IntegersForDictionaries.RussianAgenciesCount,IntegersForDictionaries.GreatBritainConstitJurisdictionCourt,
                IntegersForDictionaries.RussianGeneralJurisdictionCourt,IntegersForDictionaries.RussianSeveralInfo));

        dictionaryOfCountries = countriesList;
        return countriesList;
    }
//
    public AlternativeChoosingAlgorithm(Map<String, Integer[]> legisletureConstraints,
                                        Map<String, Integer[]> ministersConstraints,Integer[] numberOfAgenciesConstraints,
                                        Map<String, Integer[]> constitCourtConstraints,
                                        Map<String, Integer[]> generalJurisdictionConstraints,
                                        Map<String, Integer[]> severalInfoConstraints
                                        )
    {
        this.legisletureConstraints = legisletureConstraints;
        this.ministersConstraints = ministersConstraints;
        this.numberOfAgenciesConstraints = numberOfAgenciesConstraints;
        this.constitCourtConstraints = constitCourtConstraints;
        this.generalJurisdictionConstraints = generalJurisdictionConstraints;
        this.severalInfoConstraints = severalInfoConstraints;
        createDictOfCountriesFromDictionaries();
    }
    public Country getChosenCountry() {
        return chosenCountry;
    }
    public void makeAllCalculationsInOneStep(){
        makeChosenBranchesOfCountry();
        createChosenCountry();
    }
}
