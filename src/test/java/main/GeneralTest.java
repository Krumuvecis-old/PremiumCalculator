package main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(expected, actual, "Testing premium for policy 1");
    }

    @Test
    void testPolicy_2_A(){
        double expected = policy2_expectedResult;
        double actual = calculatePremium(PolicyGenerator.PolicyVersion._2_A);
        assertEquals(expected, actual, "Testing premium for policy 2_A");
    }

    @Test
    void testPolicy_2_B(){
        double expected = policy2_expectedResult;
        double actual = calculatePremium(PolicyGenerator.PolicyVersion._2_B);
        assertEquals(expected, actual, "Testing premium for policy 2_B");
    }

    @Test
    void testPolicy_3(){
        double expected = 1.24; //Manually calculated
        double actual = calculatePremium(PolicyGenerator.PolicyVersion._3);
        assertEquals(expected, actual, "Testing premium for policy 3");
    }
}
