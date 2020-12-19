package main;

import policyStructure.Policy;
import policyStructure.PolicyObject;
import policyStructure.PolicySubObject;
import riskStructure.RiskDataBase;

import java.util.ArrayList;
import java.util.LinkedList;

public class PolicyGenerator {

    static String policyNumber_standard = "LV-1234-polise";

    static Policy policy1(){
        String policyNumber = policyNumber_standard + ": house example";

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
                                        new LinkedList<>(){{
                                            add(RiskDataBase.RiskTypeName.FIRE);
                                        }}
                                ));
                                add(new PolicySubObject(
                                        "Radio",
                                        8.00,
                                        new LinkedList<>(){{
                                            add(RiskDataBase.RiskTypeName.THEFT);
                                        }}
                                ));
                            }}
                    ));
                }}
        );
    }

    static class policyGenerator_policy2{

    }

    static class Policy2_details{
        static String policyNumber = policyNumber_standard + ": car example";

        static double totalSum_FIRE = 500.00, totalSum_THEFT = 102.51;
        static double valueOf_unstealableItems = Math.max(0, totalSum_FIRE - totalSum_THEFT);
    }

    static Policy policy2_a(){
        return new Policy(
                Policy2_details.policyNumber + " A",
                Policy.PolicyStatus.APPROVED,
                new ArrayList<>() {{
                    add(new PolicyObject(
                            "Car",
                            new ArrayList<>() {{
                                add(new PolicySubObject(
                                        "Stealable items",
                                        Policy2_details.totalSum_THEFT,
                                        new LinkedList<>(){{
                                            add(RiskDataBase.RiskTypeName.FIRE);
                                            add(RiskDataBase.RiskTypeName.THEFT);
                                        }}
                                ));
                                add(new PolicySubObject(
                                        "Unstealable items",
                                        Policy2_details.valueOf_unstealableItems,
                                        new LinkedList<>(){{
                                            add(RiskDataBase.RiskTypeName.FIRE);
                                        }}
                                ));
                            }}
                    ));
                }}
        );
    }

    static Policy policy2_b(){
        return new Policy(
                Policy2_details.policyNumber + " B",
                Policy.PolicyStatus.APPROVED,
                new ArrayList<>() {{
                    add(new PolicyObject(
                            "Car",
                            new ArrayList<>() {{
                                add(new PolicySubObject(
                                        "Stealable items",
                                        Policy2_details.totalSum_THEFT,
                                        new LinkedList<>(){{
                                            add(RiskDataBase.RiskTypeName.THEFT);
                                        }}
                                ));
                                add(new PolicySubObject(
                                        "Burnable items",
                                        Policy2_details.totalSum_FIRE,
                                        new LinkedList<>(){{
                                            add(RiskDataBase.RiskTypeName.FIRE);
                                        }}
                                ));
                            }}
                    ));
                }}
        );
    }

}
