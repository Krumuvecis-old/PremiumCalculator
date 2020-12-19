package policyStructure;

import riskStructure.RiskDataBase;

import java.util.List;

public class PolicySubObject extends ObjectTemplate {

    public double sumInsured;
    public List<RiskDataBase.RiskTypeName> riskTypes; //Allows multiple risk types per policy sub-object.

    public PolicySubObject(
            String _objectName,
            double _sumInsured,
            List<RiskDataBase.RiskTypeName> _riskTypes) {

        super(_objectName);
        sumInsured = _sumInsured;
        riskTypes = _riskTypes;
    }

    @Override
    public double calculatePremium(RiskDataBase riskDataBase){
        double totalPremium = 0;

        for (RiskDataBase.RiskTypeName riskType : riskTypes) {
            double applicableCoefficient = riskDataBase.getApplicableCoefficient(riskType, sumInsured);
            double premiumPerRiskType = sumInsured * applicableCoefficient;
            totalPremium += premiumPerRiskType;
        }

        return totalPremium;
    }
}