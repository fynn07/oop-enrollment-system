import java.util.*;

public class Enroller{
    Scanner scan = new Scanner(System.in);

    public Enroller(StudentDatabase database){
        int op = 0;
        int flag = 0;
        
        while(flag == 0){
            System.out.println("main menu\n");
            System.out.print("Enroller tools\n[1] Add student\n[2] View student\n[3] Logout enroller\nop: ");
            op = scan.nextInt();
            switch(op){
                case 1:
                    this.addStudentChooser(database);
                    break;
                case 2:
                    database.searchChoose();
                    break;
                case 3:
                    flag = 1;
                    break;
                default:
                 System.out.println("Invalid Input\n");
                    break;
            }
        }
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

    public void addStudentChooser(StudentDatabase database){
        int op = 0;
        int flag = 0;

        while(flag == 0){
            System.out.println("Student Menu\n");
            System.out.print("[1] Add a student\n[2] Add batch of students\n[3] Exit to main menu\nop: ");
            op = scan.nextInt();
            switch(op){
                case 1:
                    this.enrollStudent(database);
                    break;
                case 2:
                    this.enrollBatchStudents(database);
                    break;
                case 3:
                    flag = 1;
                    break;
                default:
                    System.out.print("Invalid Input\n");
            }
        }
    }

    public void enrollStudent(StudentDatabase database){
        int op = 0;

        Students placeholder = new Students();
        System.out.println();

        scan.nextLine();
        System.out.print("Student First Name: ");
        placeholder.setFirstName(scan.nextLine());
        System.out.print("Student Last Name: ");
        placeholder.setLastName(scan.nextLine());
        System.out.print("Enter Age: ");
        placeholder.setAge(scan.nextLine());
        placeholder.setCourse();
        placeholder.printDetails();
                
        while(op == 0){
            System.out.print("confirm? [y/n]: ");
            char checker = scan.next().charAt(0);
            
            if(checker == 'y' || checker == 'Y'){
                String student_id = this.generateId(database);
                placeholder.setStudentNumber(student_id);
                System.out.println("STUDENT ADDED! ");
                System.out.println("STUDENT ID: " + student_id);
                System.out.println("Thank you for using the enrollment Systenm!\n");
                database.addStudent(placeholder);
                return;
            }
            else if (checker == 'n' || checker == 'N'){
                System.out.println("Thank you for using the enrollment System\n");
                return;
            }
            else{
                System.out.print("Invalid input");
            }
        }
        return;
    }

    public void enrollBatchStudents(StudentDatabase database){
        int number;
        System.out.print("How many students would you like to enroll: ");
        number = scan.nextInt();
        System.out.println();

        for(int i = 0; i < number; i++){
            System.out.println("Student #" + (i+1));
            this.enrollStudent(database);
        }
    }

    public String generateId(StudentDatabase database){
        Random random = new Random();
        String characters = "0123456789";
        while(true){
            char[] text = new char[5];
            for(int i = 0; i < 5; i++){
                text[i] = characters.charAt(random.nextInt(characters.length()));
            }
            String new_string = new String(text);

            if(database.idIsRepeated(new_string)){
                continue;
            }
            else{
                return new String(text);   
            }
                     
        }

    }

    public void viewStudent(){
        
    }
}