package riskStructure;

import java.util.Map;

public class RiskDataBase {

    public Map<RiskTypeName, RiskTypeDetails> riskTypeList;

    @SuppressWarnings("unused")
    public enum RiskTypeName{
        FIRE,
        THEFT,
        RISKTYPE_PLACEHOLDER
    }

    public RiskDataBase(Map<RiskTypeName, RiskTypeDetails> _riskTypeList){
        riskTypeList = _riskTypeList;
    }

    public double getApplicableCoefficient(
            RiskTypeName riskType,
            double sumInsured){

        double coefficient = 0;

        for (RiskTypeDetails.RateStep rateStep : riskTypeList.get(riskType).rateStepList) {
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