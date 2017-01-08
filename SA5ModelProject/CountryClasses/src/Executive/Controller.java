package Executive;

import AlternativeSelection.AlternativeChoosingAlgorithm;
import CountriesAndCountryDictionaries.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Марк on 21.02.2015.
 */
public class Controller {

    public TextField Text_population_from;
    public TextField Text_population_to;
    public Button Button_run;
    public TextField Text_gdp_from;
    public TextField Text_gdp_to;
    public TextField Text_NumDealsConst_from;
    public TextField Text_NumDealsConst_to;
    public TextField Text_NumJudgesConst_from;
    public TextField Text_JudgeSalaryConst_from;
    public TextField Text_JudgeSalaryConst_to;
    public TextField Text_NumJudges_to;
    public TextField Text_NumJudges_from;
    public TextField Text_JudgeSalary_from;
    public TextField Text_JudgeSalary_to;
    public TextField Text_NumDeals_from;
    public TextField Text_NumDeals_to;
    public TextField Text_NumCounts_to;
    public TextField Text_NumCounts_from;
    public TextField Text_NumJudgesConst_to;
    public TextField Text_NumberDepartments_from;
    public TextField Text_NumberDepartments_to;
    public TextField Text_NumberMinistries_to;
    public TextField Text_NumberMinistries_from;
    public TextField Text_NumberPassedLaws_to;
    public TextField Text_NumberPassedLaws_from;
    public TextField Text_SalaryParliamentMember_to;
    public TextField Text_SalaryParliamentMember_from;
    public TextField Text_NumberParliamentMembers_from;
    public TextField Text_NumberParliamentMembers_to;
    public TextField Text_BudgetCabinet_from;
    public TextField Text_BudgetCabinet_to;
    public TextField Text_BudgetDefence_to;
    public TextField Text_BudgetDefence_from;
    public TextField Text_BudgetEducation_from;
    public TextField Text_BudgetEducation_to;
    public TextField Text_departments;
    public TextField Text_Ministries;
    public TextField Text_GeneralCourts;
    public TextField Text_Parliament;
    public TextField Text_ConstCount;
    public TextField Text_Several_Info;
    public TextArea TextArea_Ministries;
    public TextArea TextArea_Executive;
    public TextArea TextArea_ConstCount;
    public TextArea TextArea_BasicCharact;
    public TextArea TextAreaParliament;
    public TextArea TextArea_GenetalCounts;
    public Button Button_run2;
    public TextField Text_departments2;
    public TextField Text_Ministries2;
    public TextField Text_ConstCount2;
    public TextField Text_GeneralCourts2;
    public TextField Text_Parliament2;
    public TextArea TextArea_Executive2;
    public TextField Text_Several_Info2;
   
    public TextArea TextArea_Ministries2;
    public TextArea TextArea_ConstCount2;
    public TextArea TextArea_GenetalCounts2;
    public TextArea TextAreaParliament2;
    public TextArea TextArea_BasicCharact2;
    public javafx.scene.control.ComboBox ComboBox;


    public void parseVocabulary(Map<String, Integer> info, TextArea Text) {
        if(info!=null) {
            for (Map.Entry<String, Integer> entry : info.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                Text.setText(Text.getText()+key + "  " + value+"\n");
                //     System.out.println(key +"  "+value);

            }
        }
        else Text.setText(Text.getText() + "\n" + "info is null");
    }


    public void Button_run_on(ActionEvent actionEvent) {

        final Integer[] population = {Integer.parseInt(Text_population_from.getText()),Integer.parseInt(Text_population_to.getText())};
        final Integer[] vvp = {Integer.parseInt(Text_gdp_from.getText()),Integer.parseInt(Text_gdp_to.getText())};

        Map<String, Integer[]> severalInfoConstraints = new HashMap<String, Integer[]>(){{
            put("population", population);  // millions;
            put("vvp", vvp);
        }
        };

        final Integer[] deputiesCount = {Integer.parseInt(Text_NumberParliamentMembers_from.getText()),Integer.parseInt(Text_NumberParliamentMembers_to.getText())};
        final Integer[] deputiesSalary = {Integer.parseInt(Text_SalaryParliamentMember_from.getText()),Integer.parseInt(Text_SalaryParliamentMember_to.getText())};
        final Integer[] lawsCount = {Integer.parseInt(Text_NumberPassedLaws_from.getText()),Integer.parseInt(Text_NumberPassedLaws_to.getText())};
        Map<String, Integer[]> legisletureInfoConstraints = new HashMap<String, Integer[]>(){{
            put("deputiesCount",deputiesCount);
            put("deputiesSalary", deputiesSalary);
            put("lawsCount", lawsCount);
        }
        };
        final Integer[] ministersCount = {Integer.parseInt(Text_NumberMinistries_from.getText()),Integer.parseInt(Text_NumberMinistries_to.getText())};
        final Integer[] scienceBudget = {Integer.parseInt(Text_BudgetEducation_from.getText()),Integer.parseInt(Text_BudgetEducation_to.getText())};// millions
        final Integer[] defenceBudget = {Integer.parseInt(Text_BudgetDefence_from.getText()),Integer.parseInt(Text_BudgetDefence_to.getText())};// millions
        final Integer[] budget = {Integer.parseInt(Text_BudgetCabinet_from.getText()),Integer.parseInt(Text_BudgetCabinet_to.getText())};// millions
        Map<String, Integer[]> ministersInfoConstraints = new HashMap<String, Integer[]>(){{
            put("ministersCount",ministersCount);
            put("scienceBudget", scienceBudget);
            put("defenceBudget", defenceBudget);
            put("budget", budget);

        }
        };

        final Integer [] courtsCount = {Integer.parseInt(Text_NumCounts_from.getText()),Integer.parseInt(Text_NumCounts_to.getText())};
        final Integer[] dealCount = {Integer.parseInt(Text_NumDeals_from.getText()),Integer.parseInt(Text_NumDeals_to.getText())};
        final Integer[] judgeCount = {Integer.parseInt(Text_NumJudges_from.getText()),Integer.parseInt(Text_NumJudges_to.getText())};
        final Integer[] salary = {Integer.parseInt(Text_JudgeSalary_from.getText()),Integer.parseInt(Text_JudgeSalary_to.getText())};
        Map<String, Integer[]> generalJurisdictionCourtConstraints = new HashMap<String, Integer[]>(){{
            put("courtsCount", courtsCount);
            put("dealCount", dealCount);
            put("judgeCount", judgeCount);
            put("salary", salary);
        }
        };


        final Integer[] constitDealCount = {Integer.parseInt(Text_NumDealsConst_from.getText()),Integer.parseInt(Text_NumDealsConst_to.getText())};
        final Integer[] constitJudgeCount = {Integer.parseInt(Text_NumJudgesConst_from.getText()),Integer.parseInt(Text_NumJudgesConst_to.getText())};
        final Integer[] constitSalary = {Integer.parseInt(Text_JudgeSalaryConst_from.getText()),Integer.parseInt(Text_JudgeSalaryConst_to.getText())};
        Map<String, Integer[]> constitJurisdictionCourtConstraints = new HashMap<String, Integer[]>(){{
            put("dealCount", constitDealCount);
            put("judgeCount", constitJudgeCount);
            put("salary", constitSalary);
        }
        };

        Integer[] agenciesCountConstraints = {Integer.parseInt(Text_NumberDepartments_from.getText()),Integer.parseInt(Text_NumberDepartments_to.getText())};
//        Text_Details.setText("");
        TextArea_Executive.setText("");
        TextArea_BasicCharact.setText("");
        TextArea_ConstCount.setText("");
        TextArea_GenetalCounts.setText("");
        TextAreaParliament.setText("");
        TextArea_Ministries.setText("");
        // contry chosing
        AlternativeChoosingAlgorithm alternativeChoosingAlgorithm = new AlternativeChoosingAlgorithm(legisletureInfoConstraints,
                ministersInfoConstraints, agenciesCountConstraints, constitJurisdictionCourtConstraints,
                generalJurisdictionCourtConstraints, severalInfoConstraints );
        alternativeChoosingAlgorithm.makeAllCalculationsInOneStep();
        Country expectedCountry = alternativeChoosingAlgorithm.getChosenCountry();


        Text_Several_Info.setText(expectedCountry.severalInfo.getIdentifier());
        Text_departments.setText(expectedCountry.executivePower.getNumberOfAgencies().getIdentifier());
        Text_ConstCount.setText(expectedCountry.judiciary.getConstitCourt().getIdentifier());
        Text_GeneralCourts.setText(expectedCountry.judiciary.getGeneralJurisdictionCourt().getIdentifier());
        Text_Parliament.setText(expectedCountry.legisleture.getIdentifier());
        Text_Ministries.setText(expectedCountry.executivePower.getMinisters().getIdentifier());


        parseVocabulary(expectedCountry.severalInfo.getSeveralInfoDictionary(), TextArea_BasicCharact);
        parseVocabulary(expectedCountry.executivePower.getMinisters().getMinistersDictionary(), TextArea_Ministries);
      //  parseVocabulary(expectedCountry.executivePower.getNumberOfAgencies(), TextArea_Executive);
        parseVocabulary(expectedCountry.judiciary.getConstitCourt().getConstitJurisdictionDictionary(), TextArea_ConstCount);
        parseVocabulary(expectedCountry.judiciary.getGeneralJurisdictionCourt().getGeneralJurisdictionDictionary(), TextArea_GenetalCounts);
        parseVocabulary(expectedCountry.legisleture.getLegisletureDictionary(), TextAreaParliament);

        TextArea_Executive.setText("number of Agencies "+Integer.toString(expectedCountry.executivePower.getNumberOfAgencies().getNumberOfAgencies()));

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "The most cheapest",
                        "The number of members in power is minimum",
                        "The most value of population",
                        "The least value of population",
                        "The most value of GDP",
                        "The least value of GDP",
                        "The least number of members in parliament",
                        "The highest salary of parliament's member",
                        "The smallest salary of parliament's member",

                        "The most passed laws",
                        "The most number of ministers",
                        "The least number of ministers",
                        "The most number of agencies",
                        "The least number of agencies",
                        "The most number of judges",
                        "The least number of judges",
                        "The most number of courts",
                        "The least number of courts",
                        "The highest salary of judges",
                        "The smallest salary of judges"


        );
        ComboBox.setItems(options);
      /*  System.out.println("SeveralInfo " + expectedCountry.severalInfo.getIdentifier());
        System.out.println("NumberOfAgencies " +expectedCountry.executivePower.getNumberOfAgencies().getIdentifier());
        System.out.println("Ministers " + expectedCountry.executivePower.getMinisters().getIdentifier());
        System.out.println("ConstitCourt " + expectedCountry.judiciary.getConstitCourt().getIdentifier());
        System.out.println("GeneralCourt " + expectedCountry.judiciary.getGeneralJurisdictionCourt().getIdentifier());
        System.out.println("Legisleture " + expectedCountry.legisleture.getIdentifier());
*/
    }

    public void Button_run_on2(ActionEvent actionEvent) {
        final Integer[] population = {Integer.parseInt(Text_population_from.getText()),Integer.parseInt(Text_population_to.getText())};
        final Integer[] vvp = {Integer.parseInt(Text_gdp_from.getText()),Integer.parseInt(Text_gdp_to.getText())};

        Map<String, Integer[]> severalInfoConstraints = new HashMap<String, Integer[]>(){{
            put("population", population);  // millions;
            put("vvp", vvp);
        }
        };

        final Integer[] deputiesCount = {Integer.parseInt(Text_NumberParliamentMembers_from.getText()),Integer.parseInt(Text_NumberParliamentMembers_to.getText())};
        final Integer[] deputiesSalary = {Integer.parseInt(Text_SalaryParliamentMember_from.getText()),Integer.parseInt(Text_SalaryParliamentMember_to.getText())};
        final Integer[] lawsCount = {Integer.parseInt(Text_NumberPassedLaws_from.getText()),Integer.parseInt(Text_NumberPassedLaws_to.getText())};
        Map<String, Integer[]> legisletureInfoConstraints = new HashMap<String, Integer[]>(){{
            put("deputiesCount",deputiesCount);
            put("deputiesSalary", deputiesSalary);
            put("lawsCount", lawsCount);
        }
        };
        final Integer[] ministersCount = {Integer.parseInt(Text_NumberMinistries_from.getText()),Integer.parseInt(Text_NumberMinistries_to.getText())};
        final Integer[] scienceBudget = {Integer.parseInt(Text_BudgetEducation_from.getText()),Integer.parseInt(Text_BudgetEducation_to.getText())};// millions
        final Integer[] defenceBudget = {Integer.parseInt(Text_BudgetDefence_from.getText()),Integer.parseInt(Text_BudgetDefence_to.getText())};// millions
        final Integer[] budget = {Integer.parseInt(Text_BudgetCabinet_from.getText()),Integer.parseInt(Text_BudgetCabinet_to.getText())};// millions
        Map<String, Integer[]> ministersInfoConstraints = new HashMap<String, Integer[]>(){{
            put("ministersCount",ministersCount);
            put("scienceBudget", scienceBudget);
            put("defenceBudget", defenceBudget);
            put("budget", budget);

        }
        };

        final Integer [] courtsCount = {Integer.parseInt(Text_NumCounts_from.getText()),Integer.parseInt(Text_NumCounts_to.getText())};
        final Integer[] dealCount = {Integer.parseInt(Text_NumDeals_from.getText()),Integer.parseInt(Text_NumDeals_to.getText())};
        final Integer[] judgeCount = {Integer.parseInt(Text_NumJudges_from.getText()),Integer.parseInt(Text_NumJudges_to.getText())};
        final Integer[] salary = {Integer.parseInt(Text_JudgeSalary_from.getText()),Integer.parseInt(Text_JudgeSalary_to.getText())};
        Map<String, Integer[]> generalJurisdictionCourtConstraints = new HashMap<String, Integer[]>(){{
            put("courtsCount", courtsCount);
            put("dealCount", dealCount);
            put("judgeCount", judgeCount);
            put("salary", salary);
        }
        };


        final Integer[] constitDealCount = {Integer.parseInt(Text_NumDealsConst_from.getText()),Integer.parseInt(Text_NumDealsConst_to.getText())};
        final Integer[] constitJudgeCount = {Integer.parseInt(Text_NumJudgesConst_from.getText()),Integer.parseInt(Text_NumJudgesConst_to.getText())};
        final Integer[] constitSalary = {Integer.parseInt(Text_JudgeSalaryConst_from.getText()),Integer.parseInt(Text_JudgeSalaryConst_to.getText())};
        Map<String, Integer[]> constitJurisdictionCourtConstraints = new HashMap<String, Integer[]>(){{
            put("dealCount", constitDealCount);
            put("judgeCount", constitJudgeCount);
            put("salary", constitSalary);
        }
        };

        Integer[] agenciesCountConstraints = {Integer.parseInt(Text_NumberDepartments_from.getText()),Integer.parseInt(Text_NumberDepartments_to.getText())};
//        Text_Details.setText("");
        TextArea_Executive2.setText("");
        TextArea_BasicCharact2.setText("");
        TextArea_ConstCount2.setText("");
        TextArea_GenetalCounts2.setText("");
        TextAreaParliament2.setText("");
        TextArea_Ministries2.setText("");
        // contry chosing
        AlternativeChoosingAlgorithm alternativeChoosingAlgorithm = new AlternativeChoosingAlgorithm(legisletureInfoConstraints,
                ministersInfoConstraints, agenciesCountConstraints, constitJurisdictionCourtConstraints,
                generalJurisdictionCourtConstraints, severalInfoConstraints );
        alternativeChoosingAlgorithm.makeAllCalculationsInOneStep();
        Country expectedCountry = alternativeChoosingAlgorithm.getChosenCountry();


        Text_Several_Info2.setText(expectedCountry.severalInfo.getIdentifier());
        Text_departments2.setText(expectedCountry.executivePower.getNumberOfAgencies().getIdentifier());
        Text_ConstCount2.setText(expectedCountry.judiciary.getConstitCourt().getIdentifier());
        Text_GeneralCourts2.setText(expectedCountry.judiciary.getGeneralJurisdictionCourt().getIdentifier());
        Text_Parliament2.setText(expectedCountry.legisleture.getIdentifier());
        Text_Ministries2.setText(expectedCountry.executivePower.getMinisters().getIdentifier());


        parseVocabulary(expectedCountry.severalInfo.getSeveralInfoDictionary(), TextArea_BasicCharact2);
        parseVocabulary(expectedCountry.executivePower.getMinisters().getMinistersDictionary(), TextArea_Ministries2);
        //  parseVocabulary(expectedCountry.executivePower.getNumberOfAgencies(), TextArea_Executive);
        parseVocabulary(expectedCountry.judiciary.getConstitCourt().getConstitJurisdictionDictionary(), TextArea_ConstCount2);
        parseVocabulary(expectedCountry.judiciary.getGeneralJurisdictionCourt().getGeneralJurisdictionDictionary(), TextArea_GenetalCounts2);
        parseVocabulary(expectedCountry.legisleture.getLegisletureDictionary(), TextAreaParliament2);

        TextArea_Executive2.setText("number of Agencies "+Integer.toString(expectedCountry.executivePower.getNumberOfAgencies().getNumberOfAgencies()));
    }
}
