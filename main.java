public class main{
    public static void main(String[] args){
        Approver approver = new Approver();
        StudentDatabase database = new StudentDatabase(approver);
        Admin admin = new Admin(database, approver);
    }
}