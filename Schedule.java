import java.util.ArrayList;
import java.util.Scanner;

public class Schedule {
    private Boolean[] openRooms = new Boolean [10];//true if room open, false if room occupied
    private ArrayList<Patient> patients = new ArrayList<>(); //min heap of patients (most urgent on top)
    Scanner input = new Scanner(System.in);
    //one open room for super urgent patients

    //what to do if several urgent patients arrive at once?

    //constructor
    public Schedule() {
        this.patients = new ArrayList<>(); //initalize empty ArrayList
    }//end constructor

    //add a new patient to patients heap
    public void insert(Patient patient){
        patients.add(patient);//add to patients array 
        heapifyUp();
    }//end insert

    //returns and removes root node: important for call next patient method
    public void popRoot(){
        Patient last = patients.get(patients.size()-1);//get node at last index
        Patient root = patients.get(0);//save current value at index 0
        //replace root (index 0) with last element in patients Arraylist
        patients.set(0, last);
        //heapify down
    }//end popRoot

    //check node is placed correctly for a min heap by moving upwards
    public void heapifyUp() {
        int index = patients.size() - 1; //start at last element in
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
    public void heapifyDown() {
        int index = 0;//start at top
        while (index < patients.size() - 1){
            Patient current = patients.get(index);

        }//end while loop
    }//end heapifyDown

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
    //figure out if node is leaf (return true if leaf): takes in index in ArrayList
    public Boolean isLeaf(int index) {
        if (index > patients.size()/2){
            return true; 
        } else {
            return false;
        }//end if else
    }//end isLeaf

    //return index of the parent of the given node: (takes in given node's index)
    private int parent(int index) {
        return index/2;
    }//end parent

    //returns index of left child of given node (takes in given node's index)
    private int leftChild(int index) {
        return index*2;
    }//end leftChild

    //returns index of right child of given node (takes in given node's index)
    private int rightChild(int index) {
        return index*2 + 1; 
    }//end rightChild

    //returns true if node has parent: takes in node's index
    private Boolean hasParent(int index) {
        return index < 1;//returns true if index is 0
    }//end hasParent

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

    public void updatePatientStatus(Patient patient) {
        System.out.println("What is the patient's new status?");
        int newStatus = input.nextInt();
        patient.setTriage(newStatus);
        System.out.println("Patient's status has been updated to: " + newStatus);

    }

}//end Schedule class
