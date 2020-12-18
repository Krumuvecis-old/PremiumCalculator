package premiumCalculator;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class RiskRates {

    public static Map<String, List<RateStep>> riskRateList;

    public static class RateStep{

        public double insuredSum_min; //Starting sum at which corresponding rate applies.
        public double rateCoefficient;
        public ComparisonType comparisonType;

        public enum ComparisonType{
            GREATER,
            GREATER_OR_EQUAL
        }

        public RateStep(double startingInsuredSum, double coefficient, ComparisonType _comparisonType){
            insuredSum_min = startingInsuredSum;
            rateCoefficient = coefficient;
            comparisonType  = _comparisonType;
        }
    }

    public static void addNewRiskType(String riskName, double baseCoefficient){
        riskRateList.put(riskName, new LinkedList<>());

        //Assuming that each risk type has a base coefficient starting from insured sum value of 0.
        addNewCoefficientStep(
                riskName,
                0,
                baseCoefficient,
                RateStep.ComparisonType.GREATER_OR_EQUAL);
    }

    public static void addNewCoefficientStep(
            String riskName,
            double startingInsuredSum,
            double coefficient,
            RateStep.ComparisonType comparisonType){

        riskRateList.get(riskName).add(new RateStep(
                startingInsuredSum,
                coefficient,
                comparisonType));

    }

    public static boolean checkRiskAvailability(String riskType){
        return !RiskRates.riskRateList.containsKey(riskType);
    }

    public static double getApplicableCoefficient(String riskType, double sumInsured){
        double coefficient = 0;

        for (RateStep rateStep : riskRateList.get(riskType)) {
            switch (rateStep.comparisonType) {

                case GREATER :
                    if (sumInsured > rateStep.insuredSum_min) {
                        coefficient = rateStep.rateCoefficient;
                    }
                    break;

                case GREATER_OR_EQUAL :
                    if (sumInsured >= rateStep.insuredSum_min) {
                        coefficient = rateStep.rateCoefficient;
                    }
                    break;

                default : {}
            }
        }

        return coefficient;
    }
}