package premiumCalculator;

import policyStructure.*;

import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class PremiumCalculator {

    public static double calculatePremium(Policy policy){
        double policyPremium = policy.calculatePremium();
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