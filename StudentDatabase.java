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
        
        for(int i = 0; i <= this.getStudentCount() - 1; i++){
            System.out.print(student_list[i].getFirstName());
        }
    }

    public void searchStudentId(String id){
        for(int i = 0; i < this.getStudentCount(); i++){
            if(id.equals(this.student_list[i].getStudentNumber())){
                student_list[i].printDetailsWithId();
                return;
            }
        }
        System.out.print("Student not found");
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
    
    public void searchChoose(){
        Scanner scan = new Scanner(System.in);
        int op = 0;
        int flag = 0;
        char tempflag;
        String text;
        while(flag == 0){
            System.out.println("View Students by.. \n");
            System.out.print("[1] Id\n[2] Name\n[3] Course\nop: ");
            op = scan.nextInt();
            switch(op){
                case 1:
                    System.out.print("Enter Student Id: ");
                    text = scan.next();
                    this.searchStudentId(text);
                    System.out.print("Do you wish to search again? [y/n]: ");
                    tempflag = scan.next().charAt(0);
                    if(tempflag == 'n' || tempflag == 'N'){flag = 1;}
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter Student Last Name: ");
                    text = scan.next();
                    this.searchStudentName(text);
                    System.out.print("Do you wish to search again? [y/n]: ");
                    tempflag = scan.next().charAt(0);
                    if(tempflag == 'n' || tempflag == 'N'){flag = 1;}
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter Student Course: ");
                    text = scan.next();
                    this.searchStudentCourse(text);
                    System.out.print("Do you wish to search again? [y/n]: ");
                    tempflag = scan.next().charAt(0);
                    if(tempflag == 'n' || tempflag == 'N'){flag = 1;}
                    System.out.println();
                    break;
            }
        }
    }

    
}