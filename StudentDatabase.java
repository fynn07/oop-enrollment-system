import java.util.Scanner;

public class StudentDatabase{
    private Students[] student_list;
    private int studentCount;

    public StudentDatabase(){
        this.student_list = new Students[100];
        this.studentCount = 0;
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
        System.out.print("Student not found");
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
            System.out.println("Student not found!");
        }
        else{
            System.out.println("Students found: " + count);
        }
    }    

    public void studentRemover(Students student){
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

    public void modifyStudentChooser(){

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
                    //modify student
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
                    
            }
        }
    }

    
}