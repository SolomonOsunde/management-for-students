import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private Integer studentYear;
    private String studentId;
    private static Integer courseCost = 600;
    private Integer tuitionBalance = 0;
    private ArrayList<String> coursesEnrolled;
    private static Integer id = 1000;

    public Student() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student first name: ");
        this.firstName = input.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = input.nextLine();

        System.out.print("1. Freshman\n2. Sophomore\n3. Junior\n4. Senior\nEnter student class level according to  the list above: ");
        this.studentYear = input.nextInt();

        setStudentId();
        enrollCourse();

        System.out.println(firstName + " " + lastName + " " + studentId);
        System.out.println("The courses enrolled are");

        for(int i =0; i < coursesEnrolled.size(); i++){
            if(coursesEnrolled.get(i).equals("0")){
                continue;
            }
            System.out.println(i+1 +". " + coursesEnrolled.get(i));
        }
        System.out.println("Tuition Balance: " + tuitionBalance);

    }
    private void enrollCourse(){
        System.out.println("Enter course to enroll\n Click \"0\" to quit");
        Scanner input = new Scanner(System.in);
        String course;
        coursesEnrolled = new ArrayList<>();
        do {
           course = input.nextLine();
           coursesEnrolled.add(course);

           if(coursesEnrolled.isEmpty()){
               tuitionBalance= 0;
           }else{
               tuitionBalance += courseCost;
           }

        } while(!(course.equals("0")));
    }

    private String setStudentId(){
        id++;
       this.studentId = studentYear + "" + id;
       return this.studentId;
    }
}
