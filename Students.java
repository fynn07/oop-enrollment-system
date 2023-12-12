public class Students{
    private Person person;
    private String studentNumber;
    private boolean removed;

    public Students(){
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

    public void printDetails(){
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("First Name: " + this.getFirstName());
        System.out.println("Last Name: " + this.getLastName());
        System.out.println("Age: " + this.getAge());
    }
}