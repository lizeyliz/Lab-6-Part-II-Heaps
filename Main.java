import java.util.ArrayList;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();

        Patient John = new Patient("John", "Doe", 19, LocalDateTime.now(), 3);
        schedule.insert(John);

        Patient Sarah = new Patient("Sarah", "Smith", 19, LocalDateTime.now(), 5);
        schedule.insert(Sarah);

        Patient Tommy = new Patient("Tommy", "Innit", 16, LocalDateTime.now(), 1);
        schedule.insert(Tommy);

        Patient Aliza = new Patient("Aliza", "E", 16, LocalDateTime.now(), 2);
        schedule.insert(Aliza);

        Patient Techno = new Patient("Techno", "Blade", 21, LocalDateTime.now(), 3);
        schedule.insert(Techno);


        //schedule.print();
        //schedule.updatePatientStatus();
        schedule.userMenu();
        

        


    }//end main
    
}
