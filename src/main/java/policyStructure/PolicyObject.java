package policyStructure;

import riskStructure.RiskDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolicyObject extends ObjectGroup {

    public PolicyObject(
            String objectName,
            List<PolicySubObject> subObjectList) {

        super(objectName, subObjectList);
    }

    @Override
    public double premium(RiskDataBase riskDataBase){
        Map<RiskDataBase.RiskTypeName, Double> totalInsuredSumPerRisk = getTotalInsuredSumPerRisk();
        double totalPremium = 0;

        for (RiskDataBase.RiskTypeName riskType : totalInsuredSumPerRisk.keySet()) {
            double sumInsured = totalInsuredSumPerRisk.get(riskType);
            double applicableCoefficient = riskDataBase.getApplicableCoefficient(
                    riskType,
                    sumInsured);
            totalPremium += sumInsured * applicableCoefficient;
        }
        return totalPremium;
    }

    private Map<RiskDataBase.RiskTypeName, Double> getTotalInsuredSumPerRisk(){
        Map<RiskDataBase.RiskTypeName, Double> returnableMap = new HashMap<>();
        for (ObjectTemplate subObject : subObjectList){
            if (subObject instanceof PolicySubObject) {
                returnableMap.putAll(checkSingleSubObject(
                        returnableMap,
                        (PolicySubObject) subObject));
            }
        }
        return returnableMap;
    }

    private static Map<RiskDataBase.RiskTypeName, Double> checkSingleSubObject(
            Map<RiskDataBase.RiskTypeName, Double> returnableMap,
            PolicySubObject subObject){

        for (RiskDataBase.RiskTypeName riskType : subObject.riskTypes){
            if (returnableMap.containsKey(riskType)){
                returnableMap.replace(
                        riskType,
                        returnableMap.get(riskType) + subObject.sumInsured);
            } else {
                returnableMap.put(
                        riskType,
                        subObject.sumInsured);
            }
        }
        return returnableMap;
    }



}