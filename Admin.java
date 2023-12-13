import java.util.*;

public class Admin{
    public Admin(StudentDatabase database, Approver approver){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enrollment System");
        System.out.println("----------------------------------------\n");
        int flag = 0, op = 0;
        while(flag == 0){
            System.out.print("Login Menu\n\n[1] Enroller\n[2] Approver\n[3] Exit\nop: ");
            op = scan.nextInt();
            switch(op){
                case 1:
                    Enroller enroll = new Enroller(database);
                    break;
                case 2:
                    approver = database.getApprover();
                    approver.approverInterface();
                    break;
                case 3:
                    flag = 1;
                    System.out.print("Thank you for using enrollment system");
                    break;
                default:
                    System.out.println("Invalid Input\n");
            }
        }
    }
}