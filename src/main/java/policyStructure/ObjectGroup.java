package policyStructure;

import riskStructure.RiskDataBase;

import java.util.List;

public abstract class ObjectGroup extends ObjectTemplate {

    public List<? extends ObjectTemplate> subObjectList;

    public ObjectGroup(
            String _objectName,
            List<? extends ObjectTemplate> _subObjectList){

        super(_objectName);
        subObjectList = _subObjectList;
    }

    @Override
    public double calculatePremium(RiskDataBase riskDataBase){
        double totalPremium = 0;
        for (ObjectTemplate subObject : subObjectList) {
            totalPremium += subObject.calculatePremium(riskDataBase);
        }
        return totalPremium;
    }
}