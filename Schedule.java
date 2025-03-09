import java.util.ArrayList;
public class Schedule {
    private Boolean[] openRooms = new Boolean [10];//true if room open, false if room occupied
    private ArrayList<Patient> patients = new ArrayList<>(); //min heap of patients (most urgent on top)
    //one open room for super urgent patients

    //what to do if several urgent patients arrive at once?

    //constructor
    public Schedule() {
        this.patients = new ArrayList<>(); //initalize empty ArrayList
    }//end constructor

}//end Schedule class
