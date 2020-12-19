package main;

import riskStructure.RiskDataBase;
import riskStructure.RiskTypeDetails;
import riskStructure.RiskTypeDetails.RateStep.ComparisonType;

import java.util.HashMap;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RiskGenerator {

    static RiskDataBase riskDataBase;

    @BeforeAll
    static void generateRiskDataBase(){
        riskDataBase = new RiskDataBase(new HashMap<>(){{
            put(RiskDataBase.RiskTypeName.FIRE, new RiskTypeDetails(new LinkedList<>(){{
                add(new RiskTypeDetails.RateStep(
                        0,
                        0.014,
                        ComparisonType.GREATER_OR_EQUAL
                ));
                add(new RiskTypeDetails.RateStep(
                        100,
                        0.024,
                        ComparisonType.GREATER));
            }}));
            put(RiskDataBase.RiskTypeName.THEFT, new RiskTypeDetails(new LinkedList<>(){{
                add(new RiskTypeDetails.RateStep(
                        0,
                        0.011,
                        ComparisonType.GREATER_OR_EQUAL
                ));
                add(new RiskTypeDetails.RateStep(
                        15,
                        0.05,
                        ComparisonType.GREATER_OR_EQUAL));
            }}));
        }});
    }

    @Test
    void testRiskDataBase(){

    }

}
