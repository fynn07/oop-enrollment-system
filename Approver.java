import java.util.Scanner;

public class Approver {
    private Students[] approval_list;
    private String[] approval_list_section;
    private int queue_size;

    public Approver(){
        this.approval_list = new Students[100];
        this.approval_list_section = new String[100];
        this.queue_size = 0;
    }

    public int getQueue(){
        return queue_size;
    }

    public void incrementQueueSize(){
        this.queue_size++;
    }

    public void decrementQueueSize(){
        this.queue_size--;
    }

    public boolean isIn(Students student){
        for(int i = 0; i < this.getQueue(); i++){
            if(student == approval_list[i]){
                return true;
            }
        }
        return false;
    }

    public void addQeuery(Students student, String string){
        this.approval_list[getQueue()] = student;
        this.approval_list_section[getQueue()] = string;
        incrementQueueSize();
        System.out.println("Course change request has been sent to the Approver. \n");
    }

    public void handleApproval(Students student){
        Scanner scan = new Scanner(System.in);
        char op;
        while(true){
            System.out.print(student.getStudentNumber() + " | " + student.getCourse() + " to " + approval_list_section[getQueue()-1]
            + " [y/n]: "); 
            op = scan.next().charAt(0);
            if(op == 'y' || op == 'Y'){
                System.out.println("Course Changed Successfully!");
                student.setCourse(approval_list_section[getQueue() -1]);
                student.printDetailsWithId();
                approval_list[getQueue()-1] = null;
                approval_list_section[getQueue()-1] = null;
                this.decrementQueueSize();
                break;
            }
            else if(op == 'n' || op == 'N'){
                student.printDetailsWithId();
                approval_list[getQueue()-1] = null;
                approval_list_section[getQueue()-1] = null;
                this.decrementQueueSize(); 
                break;
            }
            else{
                System.out.println("Invalid Input");
            }
        }
    }

    public void approverInterface(){
        char op;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome Mr. Sayson\n");
        System.out.println("Pending Course Changes: ");
        for(int i = getQueue() - 1; i >= 0; i--){
            System.out.println(approval_list[i].getStudentNumber() + " | " + approval_list[i].getCourse() + " to " + 
            approval_list_section[i]);
        }
        if(this.getQueue() == 0){
            System.out.println("No requests at the moment\n");
            return;
        }
        while(true){
            System.out.print("Do you wish to start approving requests? [y/n]: ");
            op = scan.next().charAt(0);
            if(op == 'y' || op == 'Y' || op == 'n' || op == 'N'){
                break;
            }
            else{
                System.out.println("Invalid Input");
            }
        }
        if(op == 'n' || op == 'N'){
            return;
        }

        for(int i = getQueue() - 1; i >= 0 ; i --){
            handleApproval(this.approval_list[i]);
        }
    }

}
