public class StudentDatabase{
    private Students[] student_list;
    private int studentCount;

    public StudentDatabase(){
        this.student_list = new Students[100];
        this.studentCount = 0;
    }

    public int getStudentCount(){
        return this.studentCount;
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
}