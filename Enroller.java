import java.util.*;

public class Enroller{
    Scanner scan = new Scanner(System.in);

    public Enroller(){
        System.out.println("Enroller System");
        System.out.println("Please prepare the following: \nStudent First Name\nStudent Last Name\nStudent Age");
        this.confirm();
    }

    public boolean confirm(){
        int n = 0;

        while(n == 0){
            System.out.print("Are you ready to continue? [y/n]: ");
            char checker = scan.next().charAt(0);
            scan.nextLine();
            

            if(checker == 'y' || checker == 'Y'){
                return true;
            }
            else if(checker == 'n' || checker == 'N'){
                return false;
            }
            else{
                System.out.println("Invalid Input");
            }
        }
        return false;
    }

    public Students enrollStudent(){
        int op = 0;
        Students placeholder = new Students();
        if(!this.confirm()){
            System.out.println("Thank you for using the Enrollment System!");
            System.out.println("Exiting..");
            return null;
        }
        System.out.print("Student First Name: ");
        placeholder.setFirstName(scan.nextLine());
        System.out.print("Student Last Name: ");
        placeholder.setLastName(scan.nextLine());
        System.out.print("Enter Age: ");
        placeholder.setAge(scan.nextLine());
        placeholder.printDetails();
                
        while(op == 0){
            System.out.println("confirm? [y/n]: ");
            char checker = scan.next().charAt(0);

            if(checker == 'y' || checker == 'Y'){
                System.out.println("Student Added! ");
                System.out.println("Thank you for using the enrollment Systenm!");
                return placeholder;
            }
            else if (checker == 'n' || checker == 'N'){
                System.out.println("Thank you for using the enrollment System");
                return null;
            }
            else{
                System.out.print("Invalid input");
            }
        }
        return null;
    }
}