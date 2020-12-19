package riskStructure;

import java.util.List;

public class RiskTypeDetails {

    public List<RateStep> rateStepList;

    public static class RateStep{
        public double insuredSum_min; //Starting sum at which corresponding rate applies.
        public double rateCoefficient;
        public ComparisonType comparisonType;

        public enum ComparisonType{
            GREATER,
            GREATER_OR_EQUAL
        }

        public RateStep(
                double startingInsuredSum,
                double coefficient,
                ComparisonType _comparisonType){

            insuredSum_min = startingInsuredSum;
            rateCoefficient = coefficient;
            comparisonType  = _comparisonType;
        }
    }

    public RiskTypeDetails(List<RateStep> _rateStepList){
        rateStepList = _rateStepList;
    }
}
