//object class; creates a patient object
class Patient {
    private String name;
    private int age;
    private boolean inCritCondition;
    private int admitTime;
    private int priorityLevel;

    //constructor
    public Patient(String name, int age, boolean inCritCondition, int admitTime, int priorityLevel) {
        this.name = name;
        this.age = age;
        this.inCritCondition = inCritCondition;
        this.admitTime = admitTime;
        this.priorityLevel = priorityLevel;
    }//end constructor

    //getters

    public String getName() {
        return name;
    }//end getName

    public int getAge() {
        return age;
    }//end getAge

    public boolean getInCritCondition() {
        return inCritCondition;
    }//end getInCritCondition

    public int getAdmitTime() {
        return admitTime;
    }//end getAdmitTime

    public int getPriorityLevel() {
        return priorityLevel;
    }//end getPriorityLevel

    //setters
    public void setName(String name) {
        this.name = name;
    }//end setName

    public void setAge(int age) {
        this.age = age;
    }//end setAge

    public void setInCritCondition(boolean inCritCondition) {
        this.inCritCondition = inCritCondition;
    }//end setInCritCondition

    public void setAdmitTime(int admitTime) {
        this.admitTime = admitTime;
    }//end setAdmitTime

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }//end setPriorityLevel

    //toString
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nCritical Condition: " + inCritCondition + "\nAdmit Time: " + admitTime + "\nPriority Level: " + priorityLevel;
    }//end toString

    
}//end class patient