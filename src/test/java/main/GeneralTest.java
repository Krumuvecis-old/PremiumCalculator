package main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GeneralTest {

    @BeforeAll
    static void prepareRiskDatabase(){
        RiskGenerator.generateRiskDataBase();
    }

    static double calculatePremium(PolicyGenerator.PolicyVersion policyVersion){
        return PremiumCalculator.calculatePremium(
                PolicyGenerator.policy(policyVersion),
                RiskGenerator.riskDataBase);
    }

    static double
            policy1_expectedResult = 2.28,
            policy2_expectedResult = 17.13;

    @Test
    void testPolicy_1(){
        double expected = policy1_expectedResult;
        double actual = calculatePremium(PolicyGenerator.PolicyVersion._1);
    }

    @Test
    void testPolicy_2_A(){
        double expected = policy2_expectedResult;
        double actual = calculatePremium(PolicyGenerator.PolicyVersion._2_A);
    }

    @Test
    void testPolicy_2_B(){
        double expected = policy2_expectedResult;
        double actual = calculatePremium(PolicyGenerator.PolicyVersion._2_B);
    }

    static void output_results(String policyNumber, double premium){

        //Unused method

        System.out.println(policyNumber);
        System.out.println("total premium: " + premium);
    }

}
