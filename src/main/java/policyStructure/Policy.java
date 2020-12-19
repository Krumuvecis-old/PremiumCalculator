package policyStructure;

import java.util.List;

public class Policy extends ObjectGroup {

    public enum PolicyStatus {
        REGISTERED,
        APPROVED
    }

    public PolicyStatus policyStatus;

    public Policy(
            String policyNumber,
            PolicyStatus _policyStatus,
            List<PolicyObject> policyObjectList){

        super(policyNumber, policyObjectList);
        policyStatus = _policyStatus;
    }
}