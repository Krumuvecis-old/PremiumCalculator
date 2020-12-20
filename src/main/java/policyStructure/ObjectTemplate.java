package policyStructure;

import riskStructure.RiskDataBase;

public abstract class ObjectTemplate {
    public String objectName;

    public ObjectTemplate(String _objectName){
        objectName = _objectName;
    }

    public double premium(RiskDataBase riskDataBase){
        return 0;
    }
}