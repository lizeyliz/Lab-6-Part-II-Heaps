import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
public class Schedule {
    //initialize section
    private Patient[] rooms = new Patient [10];//array of rooms with the patient currently in them, null if empty
    private ArrayList<Patient> patients = new ArrayList<>(); //min heap of patients (most urgent on top)
    Scanner input = new Scanner(System.in);

    //constructor
    public Schedule() {
        this.patients = new ArrayList<>(); //initalize empty ArrayList
    }//end constructor

    //add a new patient to patients heap
    public void insert(Patient patient){
        patients.add(patient);//add to patients array 
        heapifyUp(patients.size()-1);
    }//end insert

    //calls in the next patient
    public void callInNextPatient(){ 
        if (patients.isEmpty()) {//no patients added to waiting list
            System.out.println("No patients are waiting.");
            return;
        }//end if
        Patient nextPatient = patients.get(0); //gets the min of the heap
        for (int i = 0; i < rooms.length; i++) { //traverse rooms array
            if (rooms[i] == null){
                //place patient at that index
                rooms[i] = popRoot();
                System.out.println("The next patient is: \n" + nextPatient.toString() + "\n"); 
                return;//exit method because patient has been placed
            }//end if
            //rooms array has no empty spots
            if(i == rooms.length-1) { //prints out if all rooms are full
                System.out.println("All rooms are full.");
            }//end if    
        }//traverse room array
    }//end callInNextPatient

    //returns and removes root node: important for call next patient method
    public Patient popRoot(){
        Patient last = patients.get(patients.size()-1);//get node at last index
        Patient root = patients.get(0);//save current value at index 0
        //replace root (index 0) with last element in patients Arraylist
        patients.set(0, last);
        //remove the last element from the list
        patients.remove(patients.size() - 1);
        //heapify down to ensure the heap is properly organized
        heapifyDown(0);
        //return patient at root node
        return root;
    }//end popRoot
    
    //helper method that chooses a patient from the list
    public Patient choosePatient() {
        if(patients.isEmpty()){
            return null;
        }//end check if patients list is empty
        System.out.println("Enter 'y' for the patient you wish you update");
        for(Patient p: patients) {
            System.out.println(p.toString());
            String choice = input.next();
            if(choice.equals("y") || choice.equals("Y")) {
                return p;
            }
        }
        return null;
    }//end choosePatient

    //updates the triage status of a patient
    public void updatePatientStatus(Scanner input) {
        Patient patient = choosePatient();
        if(patient == null){
            System.out.println("No patients are currently on the waiting list.");
            return;
        }//end catch if waiting list is full
        System.out.println("What is the patient's new status?");
        int newStatus = input.nextInt();
        patient.setTriage(newStatus);
        System.out.println("Patient's status has been updated to: " + newStatus);

        int index = patients.indexOf(patient);
        //if the patient's triage number is less than the parent, then heapify up
        if(patient.getTriage() < patients.get(parent(index)).getTriage()) {
            heapifyUp(index);
        } else if (patient.getTriage() > patients.get(leftChild(index)).getTriage() || patient.getTriage() > patients.get(rightChild(index)).getTriage()) {
            heapifyDown(index);
        }
    }//end updatePatientStatus

    //creates a patient from user input and adds to heap
    public void createPatient(Scanner input) {
        LocalDateTime admitTime = LocalDateTime.now(); //current time when patient is added
        System.out.println("Enter patient's first name: ");
        String firstName = input.next();
        System.out.println("Enter patient's last name: ");
        String lastName = input.next();
        System.out.println("Enter patient's age: ");
        int age = input.nextInt();
        System.out.println("Enter patient's triage status: ");
        int triageNum = input.nextInt();

        Patient newPatient = new Patient(firstName, lastName, age, admitTime, triageNum);
        insert(newPatient);
    }//end createPatient

    //method to print out if the room is empty or not
    public void checkIfRoomEmpty(){
        for(int i = 0; i < rooms.length; i++) {
            if(!(rooms[i] == null)) { //if the room is empty
                System.out.println(rooms[i].getFirstName()+" " +rooms[i].getLastName() + " is in Room #" + (i+1));
            }
            else{
                System.out.println("Room #" + (i+1) + " is empty");
            }
        }
    }//end checkIfRoomEmpty

    //remove patient from rooms array, clearing a spot
    public void dischargePatient(Scanner input) {
        //check if rooms array is empty
        boolean allNull = true;
        for (Patient element : rooms) {
            if (element != null) {
                allNull = false;
                break;
            }
        }
        
        if (allNull) {
            // All elements in the array are null
            System.out.println("All rooms are empty.");
            return;
        }
        //end check if rooms array is empty
        while(true){
            try {
                System.out.println("Which patient would you like to discharge? Enter room number");
                for (int i = 0; i < rooms.length; i++) { //print all taken rooms and their occupants
                    if (rooms[i] != null){
                        System.out.println("Room " + (i+1) + ": " + rooms[i].getFirstName() + " " + rooms[i].getLastName());
                    }//end if
                }//end for loop
                int roomIndex = input.nextInt() - 1;
                if (roomIndex >= 0 && roomIndex < rooms.length && rooms[roomIndex] != null) {//check it's a number of an occupied room
                    Patient d = rooms[roomIndex];
                    rooms[roomIndex] = null;
                    System.out.println(d.getFirstName() + " " + d.getLastName() + " has been discharged. Room " + (roomIndex+1) + " is now free.");
                    return;
                } else {
                    System.out.println("Enter the number of an occupied room.");
                }
            } catch (Exception e) {
                System.out.println("Incorrect input.");
                input.nextLine();//consume newline
            }//end try/catch
        }//end while loop
    }//end dischargePatient

    //check node is placed correctly for a min heap by moving upwards
    public void heapifyUp(int index) {
        while (index > 0) { //loop until you get to first element
            Patient current = patients.get(index); //find the current node by its index
            Patient parent = patients.get(parent(index)); //get the parent of current node
            if (parent.getTriage() > current.getTriage() ){ //if parent's triage # is higher than current
                //swap parent and current's index
                swap(index, parent(index));
                index = parent(index);//move to nodes current location (since it swapped with parent)
            } else {break;}//end if/else
        }//end while
    }//end heapifyUp

    //check node is placed correctly for a min heap by moving down
    //improper value in at index is swapped with its smaller child until it is smaller than its children
    public void heapifyDown(int index) {
        while (hasLeftChild(index)) {
            int smallerChildIndex = leftChild(index);
            if (hasRightChild(index) && patients.get(rightChild(index)).getTriage() < patients.get(leftChild(index)).getTriage()) {
                smallerChildIndex = rightChild(index);
            }//checks if right child is smaller
            if (patients.get(index).getTriage() < patients.get(smallerChildIndex).getTriage()) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }//end while loop
    }//end heapifyDown

    //swaps two nodes
    public void swap(int index1, int index2){
        if (index1 >= 0 && index1 < patients.size() && index2 >= 0 && index2 < patients.size()) {
            //swap the two patients in the min heap
            Patient temp = patients.get(index1);
            patients.set(index1, patients.get(index2)); //puts node 2 in index 1
            patients.set(index2, temp); //puts node 1 in index 2
        } else {
            System.out.println("Error: Index out of bounds");
        }
    }//end swap

    //HELPERS FOR NAVIGATING INDEXES UP/DOWN THE TREE

    //return index of the parent of the given node: (takes in given node's index)
    private int parent(int index) {
        return (index - 1) / 2;
    }//end parent

    //returns index of left child of given node (takes in given node's index)
    private int leftChild(int index) {
        return index*2 + 1;
    }//end leftChild

    //returns index of right child of given node (takes in given node's index)
    private int rightChild(int index) {
        return index*2 + 2; 
    }//end rightChild

    //checks if node at given index has a left child
    private Boolean hasLeftChild(int index) {
        //returns true if the index of where the left child should be is less than ArrayList size
        return leftChild(index) < patients.size();
    }//end hasLeftChild

    //checks if node at given index has a right child
    private Boolean hasRightChild(int index) {
        //returns true if the index of where the right child should be is less than ArrayList size
        return rightChild(index) < patients.size();
    }//end hasRightChild

    //END POSITION HELPERS

    //prints out the heap of patients waiting
    public void print() {
        for(Patient p: patients) {
            System.out.println(p.toString() + "\n");
        }//end for loop
    }//end print method

    //user interface to interact with program
    public void userMenu(){
        int choice = 0;
        System.out.println("Welcome to the ER's Patient Scheduler.");
        
        while (choice <= 7) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a patient to the system\n"+
                            "2. Update the triage status of a patient\n" +
                            "3. Discharge patient\n" +
                            "4. Call next patient in\n" +
                            "5. Check which rooms are empty\n" +
                            "6. Print waiting list\n" +
                            "7. Exit Program");
            choice = input.nextInt();
            switch (choice) {
                case 1: //add patient
                    createPatient(input);
                    break;
    
                case 2: //change triage status 
                    updatePatientStatus(input);
                    break;
    
                case 3: //discharge patient
                    dischargePatient(input);
                    break;
    
                case 4: //call in next patient
                    callInNextPatient();
                    break;
    
                case 5: //check which rooms are empty
                    checkIfRoomEmpty();
                    break;
                
                case 6: //print out list of waiting patients
                    print();
                    break;
    
                case 7: //system exit
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid option.");
                    break;
            }//end switch/choice
        }//end while loop
    }//end user menu
}//end Schedule class
