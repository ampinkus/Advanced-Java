package DaoExample;
/*
    We are going to create:
    * Student object acting as a Model or Value Object.
    * StudentDao is Data Access Object Interface.
    * StudentDaoImpl is concrete class implementing Data Access Object Interface.
    * DaoPatternDemo, our demo class, will use StudentDao to demonstrate the use of Data Access Object pattern.
 */


public class DaoPatternDemo {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        //print all students
        for (Student student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }

        //update student
        Student student =studentDao.getAllStudents().get(0);
        student.setName("Michael");
        studentDao.updateStudent(student);


        //get the student
        studentDao.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");


    }
}