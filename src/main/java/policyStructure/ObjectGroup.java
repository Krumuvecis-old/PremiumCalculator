package policyStructure;

import java.util.List;

public abstract class ObjectGroup extends ObjectTemplate {

    public List<? extends ObjectTemplate> subObjectList;

    public ObjectGroup(String _objectName, List<? extends ObjectTemplate> _subObjectList){
        super(_objectName);
        subObjectList = _subObjectList;
    }

    @Override
    public double calculatePremium(){
        double totalPremium = 0;

        for (ObjectTemplate subObject : subObjectList) {
            totalPremium += subObject.calculatePremium();
        }

        return totalPremium;
    }
}