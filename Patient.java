//object class; creates a patient object
class Patient {
    private String firstName;
    private String lastName;
    private int age;
    private int admitTime;//String?
    private int triage; //triage level: shows urgency of patient (between 1-5)

    //constructor
    public Patient(String firstName, String lastName, int age, int admitTime, int triage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.admitTime = admitTime;
        this.triage = triage;
    }//end constructor

    //getters
    public String getFirstName() {
        return firstName;
    }//end getName

    public String getLastName() {
        return lastName;
    }//end getName

    public int getAge() {
        return age;
    }//end getAge

    public int getAdmitTime() {
        return admitTime;
    }//end getAdmitTime

    public int getTriage() {
        return triage;
    }//end getTriage

    //setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }//end setName

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }//end setName

    public void setAge(int age) {
        this.age = age;
    }//end setAge

    public void setAdmitTime(int admitTime) {
        this.admitTime = admitTime;
    }//end setAdmitTime

    public void setTriage(int triage) {
        this.triage = triage;
    }//end setTriage

    //toString: need to update
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
         "\nAge: " + age +  "\nAdmit Time: " + admitTime + "\nTriage Level: " + triage;
    }//end toString

    
}//end class patient