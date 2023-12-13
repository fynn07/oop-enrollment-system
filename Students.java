import java.util.*;

public class Students{
    private Person person;
    private String studentNumber;
    private String course;
    private boolean removed;

    public Students(){
        this.person = new Person();
        this.removed = false;
    }
    
    public void setFirstName(String name){
        this.person.setFirstName(name);
    }

    public void setLastName(String name){
        this.person.setLastName(name);
    }

    public void setAge(String age){
        this.person.setAge(age);
    }

    public void setStudentNumber(String number){
        this.studentNumber = number;
    }

    public String getFirstName(){
        return this.person.getFirstName();
    }

    public String getLastName(){
        return this.person.getLastName();
    }

    public String getAge(){
        return this.person.getAge();
    }

    public String getStudentNumber(){
        return this.studentNumber;
    }

    public void setRemove(){
        this.removed = true;
    }

    public boolean getRemove(){
        return this.removed;
    }

    public void setCourse(String course){
        this.course = course;
    }
    public String getCourse(){
        return this.course;
    }

    public void setCourse(){
        Scanner scan = new Scanner(System.in);
        int flag = 0;
        while(flag == 0){
            System.out.print("Enter your Course [BSIT BSCS BSCE BSCPE BSA]: ");
            String input = scan.next();
            
            if (input.equals("BSCS") || input.equals("BSIT") || input.equals("BSCE") || 
                input.equals("BSCPE") || input.equals("BSA")){
                this.course = input;
                flag = 1;
            }
            else{
                System.out.println("Invalid Course");
            }
        }
    }

    public void printDetails(){
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("First Name: " + this.getFirstName());
        System.out.println("Last Name: " + this.getLastName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Course: " + this.getCourse());
        System.out.println("-----------------------------------------"); 
    }

    public void printDetailsWithId(){
        String text;
        if(this.getRemove()){
            text = "REMOVED";
        }
        else{text = "ENROLLED";}

        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("First Name: " + this.getFirstName());
        System.out.println("Last Name: " + this.getLastName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Course: " + this.getCourse());
        System.out.println("Student Id: " + this.getStudentNumber());
        System.out.println("Status: " + text);
        System.out.println("-----------------------------------------"); 
    }
}