package main;

import policyStructure.Policy;
import policyStructure.PolicyObject;
import policyStructure.PolicySubObject;
import riskStructure.RiskDataBase;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class PolicyGenerator {

    static String policyNumber_standard = "LV-1234-polise";

    enum PolicyVersion{
        _1,
        _2_A,
        _2_B
    }

    static Policy policy(PolicyVersion version){
        return switch (version) {
            case _1 -> new Policy(
                    policyNumber_standard + ": house example",
                    Policy.PolicyStatus.REGISTERED,
                    policyObjectList(version)
            );
            case _2_A -> new Policy(
                    policyNumber_standard + Policy_2_commonDetails.policyNumberExtension + "A",
                    Policy_2_commonDetails.policyStatus,
                    policyObjectList(version)
            );
            case _2_B -> new Policy(
                    policyNumber_standard + Policy_2_commonDetails.policyNumberExtension + " B",
                    Policy_2_commonDetails.policyStatus,
                    policyObjectList(version)
            );
            default -> null;
        };
    }

    static List<PolicyObject> policyObjectList(PolicyVersion version){
        String policyObjectName = switch (version) {
            case _1 -> "House";
            case _2_A, _2_B -> "Car";
            default -> "Undefined";
        };

        return new ArrayList<>() {{
            add(new PolicyObject(
                    policyObjectName,
                    policySubObjectList(version)
            ));
        }};
    }

    static List<PolicySubObject> policySubObjectList(PolicyVersion version){
        List<PolicySubObject> returnableList = new ArrayList<>();
        switch (version) {
            case _1 -> {
                returnableList.add(new PolicySubObject(
                        "TV",
                        100.00,
                        new LinkedList<>() {{
                            add(RiskDataBase.RiskTypeName.FIRE);
                        }}
                ));
                returnableList.add(new PolicySubObject(
                        "Radio",
                        8.00,
                        new LinkedList<>() {{
                            add(RiskDataBase.RiskTypeName.THEFT);
                        }}
                ));
            }
            case _2_A -> {
                double valueOf_unstealableItems = Math.max(
                        0,
                        Policy_2_commonDetails.totalSum_FIRE - Policy_2_commonDetails.totalSum_THEFT);

                returnableList.add(new PolicySubObject(
                        "Stealable items",
                        Policy_2_commonDetails.totalSum_THEFT,
                        new LinkedList<>() {{
                            add(RiskDataBase.RiskTypeName.FIRE);
                            add(RiskDataBase.RiskTypeName.THEFT);
                        }}
                ));
                returnableList.add(new PolicySubObject(
                        "Unstealable items",
                        valueOf_unstealableItems,
                        new LinkedList<>() {{
                            add(RiskDataBase.RiskTypeName.FIRE);
                        }}
                ));
            }
            case _2_B -> {
                returnableList.add(new PolicySubObject(
                        "Stealable items",
                        Policy_2_commonDetails.totalSum_THEFT,
                        new LinkedList<>() {{
                            add(RiskDataBase.RiskTypeName.THEFT);
                        }}
                ));
                returnableList.add(new PolicySubObject(
                        "Burnable items",
                        Policy_2_commonDetails.totalSum_FIRE,
                        new LinkedList<>() {{
                            add(RiskDataBase.RiskTypeName.FIRE);
                        }}
                ));
            }
            default -> {}
        }
        return returnableList;
    }

    static class Policy_2_commonDetails{
        static String policyNumberExtension = ": car example";
        static Policy.PolicyStatus policyStatus = Policy.PolicyStatus.APPROVED;

        static double
                totalSum_FIRE = 500.00,
                totalSum_THEFT = 102.51;
    }
}
