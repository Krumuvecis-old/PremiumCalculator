package policyStructure;

public abstract class ObjectTemplate {
    public String objectName;

    public ObjectTemplate(String _objectName){
        objectName = _objectName;
    }

    public double calculatePremium(){ return 0; }
}