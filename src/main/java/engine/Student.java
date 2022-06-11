package engine;

import java.util.ArrayList;

public class Student extends User {
    public String name;
    String Password;
    String GPA;
    String number;
    String ID;

    String email;
    ArrayList<String>currentcourses=new ArrayList<String>();
    Boolean Firsttime =true;
    public static ArrayList<Student> students;

    public static void initStudentArray(){
        if(students==null) {
            Student.students = new ArrayList<Student>();
            ArrayList<String> course =new ArrayList<>();
            course.add("Control");
            Student.students.add(new Student("Ahmed", "010", "3.9","19p5555", "ahmed@","0102555525248", true,course));
        }

        //}

    }
    public Student(String name,String Password,String Gpa,String ID,String email,String number,Boolean Firsttime,ArrayList<String>course){
        //this.currentcourses=currentcourses;
        this.name=name;
        this.Firsttime=Firsttime;
        this.GPA=Gpa;
        this.number=number;
        this.Password=Password;
        this.currentcourses=course;
        this.ID=ID;
        this.email=email;
    }

    public ArrayList<Calendar> calendar(){
        ArrayList<Calendar>calendars=new ArrayList<Calendar>();
        for(int i = 0 ; i<this.currentcourses.size();i++){
            for(int j = 0 ; i<Course.Courses.size();i++){
                if(this.currentcourses.get(i).equals(Course.Courses.get(j).coursename)) {
                    for (int k = 0; k < Course.Courses.get(j).quiz.size(); k++) {
                        calendars.add(new Calendar(Course.Courses.get(j).coursename, Course.Courses.get(j).quiz.get(k).Quizname, Course.Courses.get(j).quiz.get(k).Date, Course.Courses.get(j).quiz.get(k).Starttime));
                    }
                    for(int k =0;k<Course.Courses.get(j).Assignment.size();k++){
                        calendars.add(new Calendar(Course.Courses.get(j).coursename,Course.Courses.get(j).Assignment.get(k).name,Course.Courses.get(j).Assignment.get(k).Date,Course.Courses.get(j).Assignment.get(k).Deadlinetime));
                    }
                }
            }

        }
        return calendars;
    }

    public ArrayList<Course> showcourses(){
        ArrayList<Course> courses = new ArrayList<>();
       for(int i = 0; i < currentcourses.size(); i++) {
          courses.add(new Course(currentcourses.get(i)));
       }
       return courses;
    }

}
