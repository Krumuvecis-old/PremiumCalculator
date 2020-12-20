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
}