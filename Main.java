import java.time.LocalDateTime;
public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();

        //preloading patients into system
        Patient John = new Patient("John", "Ferrell", 19, LocalDateTime.now(), 3);
        schedule.insert(John);

        Patient Mary = new Patient("Mary", "Smith", 27, LocalDateTime.now(), 5);
        schedule.insert(Mary);

        Patient Robert = new Patient("Robert", "Grayson", 16, LocalDateTime.now(), 1);
        schedule.insert(Robert);

        Patient Olivia = new Patient("Olivia", "Evans", 35, LocalDateTime.now(), 2);
        schedule.insert(Olivia);

        //run the program
        schedule.userMenu();
    }//end main
    
}//end class main1

