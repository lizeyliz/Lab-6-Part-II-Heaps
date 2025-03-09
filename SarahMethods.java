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

    public void swap(int index1, int index2){
        if (index1 >= 0 && index1 < patients.size() && index2 >= 0 && index2 < patients.size()) {
            //swap the two patients in the min heap
            Patient temp = patients.get(index1);
            patients.set(index1, patients.get(index2));
            patients.set(index2, temp);

            //System.out.println(patients.get(index1));
            //System.out.println(patients.get(index2));
        } else {
            System.out.println("Error: Index out of bounds");
        }
    }


    

    
}
