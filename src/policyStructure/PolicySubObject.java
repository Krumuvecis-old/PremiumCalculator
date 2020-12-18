package policyStructure;

import premiumCalculator.RiskRates;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PolicySubObject extends ObjectTemplate {

    public double sumInsured;
    public List<String> riskTypes; //Allows multiple risk types per policy sub-object.

    public PolicySubObject(
            String _objectName,
            double _sumInsured,
            String[] _riskTypes) {

        super(_objectName);
        sumInsured = _sumInsured;
        riskTypes = new LinkedList<>();
        riskTypes.addAll(Arrays.asList(_riskTypes));
    }

    public void addNewRiskType(String riskType) {

        //Currently unimplemented method for future functionality.

        if(RiskRates.checkRiskAvailability(riskType) &&
                !riskTypes.contains(riskType)) {

            riskTypes.add(riskType);
        }
    }

    @Override
    public double calculatePremium(){
        double totalPremium = 0;

        for (String riskType : riskTypes) {
            double applicableCoefficient = RiskRates.getApplicableCoefficient(riskType, sumInsured);
            double premiumPerRiskType = sumInsured * applicableCoefficient;
            totalPremium += premiumPerRiskType;
        }

        return totalPremium;
    }
}