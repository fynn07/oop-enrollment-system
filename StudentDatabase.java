import java.util.Scanner;

public class StudentDatabase{
    private Students[] student_list;
    private int studentCount;
    private Approver approver;

    public StudentDatabase(Approver approver){
        this.student_list = new Students[100];
        this.studentCount = 0;
        this.approver = approver;
    }

    public Approver getApprover(){
        return this.approver;
    }

    public Students[] getStudentList(){
        return this.student_list;
    }

    public int getStudentCount(){
        return this.studentCount;
    }

    public void incrementStudentCount(){
        this.studentCount++;
    }

    public void addStudent(Students student){
        this.student_list[studentCount] = student;
        this.studentCount++;
    }

    public boolean idIsRepeated(String text){
        for(int i = 0; i < this.getStudentCount(); i++){
            if(text.equals(this.student_list[i])){
                return true;
            }
        }
        return false;
    }

    public void printStudent(){
        System.out.println("STUDENT LIST\n");
        for(int i = 0; i < this.getStudentCount(); i++){
            String text;
            if(student_list[i].getRemove()){
                text = "REMOVED";
            }
            else{text = "ENROLLED";}
            System.out.println( (i + 1) + ".) " + student_list[i].getStudentNumber() + " | " +  
            student_list[i].getLastName() + ", " + student_list[i].getFirstName() + " | " + student_list[i].getCourse() + " | " +
            text + " | ");
        }
    }

    public Students searchStudentId(String id){
        for(int i = 0; i < this.getStudentCount(); i++){
            if(id.equals(this.student_list[i].getStudentNumber())){
                student_list[i].printDetailsWithId();
                return student_list[i];
            }
        }
        System.out.println("Student not found");
        return null;
    }

    public void searchStudentName(String name){
        int count = 0;
        for(int i = 0; i < this.getStudentCount(); i++){
            if(name.equals(this.student_list[i].getLastName())){
                student_list[i].printDetailsWithId();
                count++;
            }
        }
        if(count == 0){
            System.out.println("Student not found!");
        }
        else{
            System.out.println("Students Found: " + count);
        }
    }

    public void searchStudentCourse(String course){
        int count = 0;
        for(int i = 0; i < this.getStudentCount(); i++){
            if(course.equals(this.student_list[i].getCourse())){
                student_list[i].printDetailsWithId();
                count++;
            }
        }
        if(count == 0){
            System.out.println("Student not found!\n");
        }
        else{
            System.out.println("Students found: " + count);
        }
    }    

    public void studentRemover(Students student){
        if(approver.isIn(student)){
            System.out.print("Cannot remove Student with pending course change. \n");
            return;
        }
        Scanner scan = new Scanner(System.in);
        int flag = 0;
        char choice;
        while(flag == 0){
            while(true){
                System.out.println("Are you sure you want to remove this student? [y/n]: ");
                choice = scan.next().charAt(0);
                scan.nextLine();

                if(choice == 'y' || choice == 'Y'){
                    student.setRemove();
                    System.out.println("Student has been removed.\n");
                    break;
                }
                else if(choice == 'n' || choice == 'N'){
                    break;
                }
                else{
                    System.out.println("Invalid Operation.");
                }
            }

            System.out.println("Thank you for using the Student Removal System.\n");
            student.printDetailsWithId();       
            flag = 1; 
        }    
    }

    public void modifyStudentChooser(Students student){
        Scanner scan = new Scanner(System.in);
        int flag = 0;
        int op;
        char n;
        String text;
        while(flag == 0){
            System.out.println("modify student " + student.getStudentNumber() + " by:");
            System.out.println("[1] First Name\n[2] Last Name\n[3] Age\n[4] Course\n[5] Exit\nop: ");
            op = scan.nextInt();
            switch(op){
                case 1:
                    System.out.println("Previous First Name: " + student.getFirstName());
                    System.out.print("Change First Name to: ");
                    scan.nextLine();
                    text = scan.nextLine();
                    while(true){
                        System.out.print("Are you sure you want to change " + student.getFirstName() +" to " + text + "? [y/n]: ");
                        n = scan.next().charAt(0);
                        if(n == 'y' || n =='Y'){
                            student.setFirstName(text);
                            student.printDetailsWithId();
                            break;
                        }
                        else if(n == 'n' || n == 'N'){
                            break;
                        }
                        else{
                            System.out.println("Invalid Operation\n");
                        }
                    }
                    flag = 1;
                    break;
                case 2:
                    System.out.println("Previous Last Name: " + student.getLastName());
                    System.out.print("Change Last Name to: ");
                    scan.nextLine();
                    text = scan.nextLine();
                    while(true){
                        System.out.print("Are you sure you want to change " + student.getLastName() +" to " + text + "? [y/n]: ");
                        n = scan.next().charAt(0);
                        if(n == 'y' || n =='Y'){
                            student.setLastName(text);
                            student.printDetailsWithId();
                            break;
                        }
                        else if(n == 'n' || n == 'N'){
                            break;
                        }
                        else{
                            System.out.println("Invalid Operation\n");
                        }
                    }
                    flag = 1;
                    break;
                case 3:
                    System.out.println("Previous Age: " + student.getAge());
                    System.out.print("Change Age to: ");
                    scan.nextLine();
                    text = scan.nextLine();
                    while(true){
                        System.out.print("Are you sure you want to change " + student.getAge() +" to " + text + "? [y/n]: ");
                        n = scan.next().charAt(0);
                        if(n == 'y' || n =='Y'){
                            student.setAge(text);
                            student.printDetailsWithId();
                            break;
                        }
                        else if(n == 'n' || n == 'N'){
                            break;
                        }
                        else{
                            System.out.println("Invalid Operation\n");
                        }
                    }
                    flag = 1;
                    break;
                case 4:
                    if(approver.isIn(student)){
                        System.out.print("Already has pending course change. \n");
                        return;
                    }
                    if(student.getRemove()){
                        System.out.print("Cannot change course for removed student. \n");
                        return;
                    }
                    while(true){
                        System.out.println("Previous Course: " + student.getCourse());
                        System.out.println("Enter new course [BSIT BSCS BSCE BSCPE BSA]: ");                        
                        text = scan.next();

                        if(text.equals(student.getCourse())){
                            System.out.println("Already in " + student.getCourse() + " program.\n");
                        }
                        else if (text.equals("BSCS") || text.equals("BSIT") || text.equals("BSCE") || 
                            text.equals("BSCPE") || text.equals("BSA")){
                            this.approver.addQeuery(student, text);
                            break;
                        }
                        else{
                            System.out.println("Invalid Course");
                        }                        
                    }
                    break;
                case 5:
                    flag = 1;
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    public void studentActivityChooser(Students student){
        Scanner scan = new Scanner(System.in);
        int op = 0;
        int flag = 0;
        while(flag == 0){
            System.out.println("[1] Modify Student\n[2] Remove Student\n[3] Exit\nop: ");
            op = scan.nextInt();
            
            switch(op){
                case 1:
                    this.modifyStudentChooser(student);
                    break;
                case 2:
                    if(student.getRemove()){
                        System.out.println("Student is already removed.");
                        break;
                    }
                    this.studentRemover(student);
                    break;
                case 3:
                    flag = 1;
                    break;
                default:
                    System.out.print("Invalid Input\n");
                    break;
            }
        }
    }
    
    public void searchChoose(){
        Scanner scan = new Scanner(System.in);
        int op = 0;
        int flag = 0;
        char tempflag;
        String text;
        while(flag == 0){
            System.out.println("View Students by.. \n");
            System.out.print("[1] Id\n[2] Name\n[3] Course\n[4] Print All\nop: ");
            op = scan.nextInt();
            switch(op){
                case 1:
                    System.out.print("Enter Student Id: ");
                    text = scan.next();
                    Students temp = searchStudentId(text);
                    if(temp != null){
                        this.studentActivityChooser(temp);                        
                    }
                    System.out.print("Do you wish to search again? [y/n]: ");
                    tempflag = scan.next().charAt(0);
                    scan.nextLine();

                    if(tempflag == 'n' || tempflag == 'N'){flag = 1;}
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter Student Last Name: ");
                    text = scan.next();
                    this.searchStudentName(text);
                    System.out.print("Do you wish to search again? [y/n]: ");
                    tempflag = scan.next().charAt(0);
                    scan.nextLine();

                    if(tempflag == 'n' || tempflag == 'N'){flag = 1;}
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter Student Course: ");
                    text = scan.next();
                    this.searchStudentCourse(text);
                    System.out.print("Do you wish to search again? [y/n]: ");
                    tempflag = scan.next().charAt(0);
                    scan.nextLine();

                    if(tempflag == 'n' || tempflag == 'N'){flag = 1;}
                    System.out.println();
                    break;
                case 4:
                    this.printStudent();
                    System.out.print("Do you wish to search again? [y/n]: ");
                    tempflag = scan.next().charAt(0);
                    scan.nextLine();

                    if(tempflag == 'n' || tempflag == 'N'){flag = 1;}
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid Input\n");
                    break;
                    
            }
        }
    }

    
}