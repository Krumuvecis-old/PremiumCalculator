package main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GeneralTest {

    @BeforeAll
    static void prepareRiskDatabase(){
        RiskGenerator.generateRiskDataBase();
    }

    @Test
    void testPolicy1(){
        PremiumCalculator.calculatePremium(
                PolicyGenerator.policy1(),
                RiskGenerator.riskDataBase);
    }

    @Test
    void testPolicy2_a(){
        PremiumCalculator.calculatePremium(
                PolicyGenerator.policy2_a(),
                RiskGenerator.riskDataBase);
    }

    @Test
    void testPolicy2_b(){
        PremiumCalculator.calculatePremium(
                PolicyGenerator.policy2_b(),
                RiskGenerator.riskDataBase);
    }

    static void output_results(String policyNumber, double premium){

        //Unused method

        System.out.println(policyNumber);
        System.out.println("total premium: " + premium);
    }

}
