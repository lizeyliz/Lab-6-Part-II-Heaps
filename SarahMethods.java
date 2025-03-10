import java.util.ArrayList;
import java.util.Scanner;

public class SarahMethods {
    Scanner input = new Scanner(System.in);
    private ArrayList<Patient> patients = new ArrayList<>(); 

    public void updatePatientStatus(Patient patient) {
        System.out.println("What is the patient's new status?");
        int newStatus = input.nextInt();
        patient.setTriage(newStatus);
        System.out.println("Patient's status has been updated to: " + newStatus);

    }

    

    

    
}
