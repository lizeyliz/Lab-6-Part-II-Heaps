import java.util.ArrayList;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();

        Patient John = new Patient("John", "Doe", 19, LocalDateTime.now(), 3);
        schedule.insert(John);

        Patient Mary = new Patient("Mary", "Smith", 27, LocalDateTime.now(), 5);
        schedule.insert(Mary);

        Patient Robert = new Patient("Robert", "Grayson", 16, LocalDateTime.now(), 1);
        schedule.insert(Robert);

        Patient Olivia = new Patient("Olivia", "Evans", 35, LocalDateTime.now(), 2);
        schedule.insert(Olivia);

        Patient Charles = new Patient("Charles", "Watson", 21, LocalDateTime.now(), 3);
        schedule.insert(Charles);

        Patient Ella = new Patient("Ella", "Jones", 54, LocalDateTime.now(), 4);
        schedule.insert(Ella);

        Patient Jack = new Patient("Jack", "Thomas", 72, LocalDateTime.now(), 1);
        schedule.insert(Jack);


        //schedule.print();
        //schedule.updatePatientStatus();
        schedule.userMenu();
        

        


    }//end main
    
}
