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
}//end class patient