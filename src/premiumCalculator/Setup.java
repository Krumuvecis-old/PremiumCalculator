package premiumCalculator;

import java.util.ArrayList;
import java.util.HashMap;

import policyStructure.*;

public class Setup {

    public static void main(String[] args) {
        populateRiskDataBase();

        String policyNumber;
        Policy policy;
        double policyPremium;

        policyNumber = "policy1: houseExample";
        policy = policy1(policyNumber);
        policyPremium = PremiumCalculator.calculatePremium(policy);
        output_results(policyNumber, policyPremium);

        policyNumber = "policy2: carExample";
        policy = policy2(policyNumber);
        policyPremium = PremiumCalculator.calculatePremium(policy);
        output_results(policyNumber, policyPremium);

    }

    private static void populateRiskDataBase(){
        RiskRates.riskRateList = new HashMap<>();
        String riskName;

        riskName = "FIRE";
        RiskRates.addNewRiskType(riskName,0.014);
        RiskRates.addNewCoefficientStep(
                riskName,
                100,
                0.024,
                RiskRates.RateStep.ComparisonType.GREATER);

        riskName = "THEFT";
        RiskRates.addNewRiskType(riskName,0.11);
        RiskRates.addNewCoefficientStep(
                riskName,
                15,
                0.05,
                RiskRates.RateStep.ComparisonType.GREATER_OR_EQUAL);
    }

    private static Policy policy1(String policyNumber){
        return new Policy(
                policyNumber,
                Policy.PolicyStatus.REGISTERED,
                new ArrayList<>() {{
                    add(new PolicyObject(
                            "House",
                            new ArrayList<>() {{
                                add(new PolicySubObject(
                                        "TV",
                                        100.00,
                                        new String[]{"FIRE"}
                                ));
                                add(new PolicySubObject(
                                        "Radio",
                                        8.00,
                                        new String[]{"THEFT"}
                                ));
                            }}
                    ));
                }}
        );
    }

    private static Policy policy2(String policyNumber){
        double totalSum_FIRE = 500.00, totalSum_THEFT = 102.51;
        double valueOf_unstealableItems = Math.max(0, totalSum_FIRE - totalSum_THEFT);

        return new Policy(
                policyNumber,
                Policy.PolicyStatus.APPROVED,
                new ArrayList<>() {{
                    add(new PolicyObject(
                            "Car",
                            new ArrayList<>() {{
                                add(new PolicySubObject(
                                        "Stealable items",
                                        totalSum_THEFT,
                                        new String[]{"FIRE", "THEFT"}
                                ));
                                add(new PolicySubObject(
                                        "Unstealable items",
                                        valueOf_unstealableItems,
                                        new String[]{"FIRE"}
                                ));
                            }}
                    ));
                }}
        );
    }

    private static void output_results(String policyNumber, double premium){
        System.out.println(policyNumber);
        System.out.println("total premium: " + premium);
    }
}