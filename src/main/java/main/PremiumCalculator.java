package main;

import policyStructure.Policy;
import riskStructure.RiskDataBase;

import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class PremiumCalculator {

    public static double calculatePremium(Policy policy, RiskDataBase riskDataBase){
        double policyPremium = policy.calculatePremium(riskDataBase);
        return roundedValue(policyPremium);
    }

    private static double roundedValue(double valueToRound){
        DecimalFormat currencyFormat = new DecimalFormat("0.00");
        currencyFormat.setRoundingMode(RoundingMode.HALF_UP);

        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.getDefault());
        formatSymbols.setDecimalSeparator('.');
        currencyFormat.setDecimalFormatSymbols(formatSymbols);

        return Double.parseDouble(String.valueOf(currencyFormat.format(valueToRound)));
    }
}