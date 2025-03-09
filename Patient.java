//object class; creates a patient object
import java.time.LocalDateTime;
class Patient {
    private String firstName;
    private String lastName;
    private int age;
    private LocalDateTime admitTime;
    private int triage; //triage level: shows urgency of patient (between 1-5)

    /*Level 1 (resuscitation): requires immediate, life-saving intervention and includes patients with 
    cardiopulmonary arrest, major trauma, severe  respiratory distress, and seizures. 

    Level 2 (emergent): requires an immediate nursing assessment and rapid treatment and includes patients who
    are in a high-risk situation, are  confused, lethargic, or disoriented, or have severe pain or distress, 
    including  patients with stroke, head injuries, asthma, and sexual-assault injuries.  

    Level 3 (urgent): includes patients who need quick attention but can wait as long as 30 minutes for 
    assessment and treatment and includes patients with signs of infection, mild respiratory distress, 
    or moderate pain.

    Level 4: less urgent

    Level 5: non urgent*/

    //constructor
    public Patient(String firstName, String lastName, int age, LocalDateTime admitTime, int triage) {
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

    public LocalDateTime getAdmitTime() {
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

    public void setAdmitTime(LocalDateTime admitTime) {
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