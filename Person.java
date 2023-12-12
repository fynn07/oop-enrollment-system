public class Person{
    private String firstName;
    private String lastName;
    private String age;

    public void setFirstName(String name){
        this.firstName = name;
    }

    public void setLastName(String name){
        this.lastName = name;
    }

    public void setAge(String age){
        this.age = age;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getAge(){
        return this.age;
    }

}