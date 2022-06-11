package engine;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Courses {
    public static ArrayList<String>students=new ArrayList<String>();

    public Courses() {
        Student.initStudentArray();
        Doctor.initDoctorArray();
        TA.initDoctorArray();
    }

    public static String checkcourse(String CourseName, String CourseCode, String CourseInstructor, String TA1, String TA2, ArrayList<String>students ) {
        Course.initCourseArray();
       int Count=0;
        for (int i = 0; i < Doctor.Doctors.size(); i++) {
            if (Doctor.Doctors.get(i).Name.equals(CourseInstructor)) {
                Count++;
            }
        }
        for (int i = 0; i < TA.TAS.size(); i++) {
            if (TA.TAS.get(i).Name.equals(TA1)) {
                Count++;
            }
            if (TA.TAS.get(i).Name.equals(TA2)) {
                Count++;
            }
        }
        for(int i =0;i<Course.Courses.size();i++){
            if(CourseName.equals(Course.Courses.get(i).coursename)) {
                return "Course already exists";
            }
        }
        if (Count == 3) {
            ArrayList<Quiz> quiz= new ArrayList<Quiz>();
            ArrayList<Ass>Assignment=new ArrayList<Ass>();
            ArrayList<File>Lectures=new ArrayList<File>();
            ArrayList<File>Sections=new ArrayList<File>();

            String regex = "[A-Za-z]+[ ][A-Za-z]+|[A-Za-z]+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(CourseName);
            if(matcher.matches()==false){
                return "Invalid Course name";
            }

            String regexCode = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*";
            Pattern patternCode = Pattern.compile(regexCode);
            Matcher matcherCode = patternCode.matcher(CourseCode);
            if(matcherCode.matches()==false){
                return "Invalid Course code";
            }

            Course.Courses.add(new Course(CourseName,CourseCode,CourseInstructor,TA1,TA2,students,quiz,Assignment,Lectures,Sections));
            for(int i = 0;i<Student.students.size();i++){
                for(int j = 0; j< Student.students.size(); j++){
                    if(students.get(i).equals(Student.students.get(j).name)){
                        Student.students.get(j).currentcourses.add(CourseName);
                        students=null;
                        Count=0;
                    }
                }
            }
            for(int i=0;i< TA.TAS.size();i++){
                if(TA.TAS.get(i).Name.equals(TA1)||TA.TAS.get(i).Name.equals(TA2)){
                    TA.TAS.get(i).currentcourses.add(CourseName);
                }
            }
            for(int i=0;i< Doctor.Doctors.size();i++){
                if(Doctor.Doctors.get(i).Name.equals(CourseInstructor)){
                    Doctor.Doctors.get(i).currentcourses.add(CourseName);
                }
            }
            for(int i = 0; i< Student.students.size(); i++){
                System.out.println(Student.students.get(i).currentcourses);
            }
            return "The course is added";
        }
        return "The instructor/TA name does not exists";
    }
    public static String Checkstudent(String Studentname,String coursename){
        for(int i = 0; i< Student.students.size(); i++){
            if(Student.students.get(i).name.equals(Studentname)) {
                addstudent(Studentname, coursename);
                return "Student is added Successfully";
            }
        }
        return "Student does not exist";
    }
public static String addstudent(String Studentname,String coursename){
        for(int i = 0 ; i<Course.Courses.size();i++){
            if(Course.Courses.get(i).coursename.equals(coursename)){
                Course.Courses.get(i).Students.add(Studentname);
            }
        }
        return "Student is found";
}

public ArrayList<File>ShowContentLecSec(Course course){
        ArrayList<File> content=new ArrayList<File>();
        for(int i =0;i<course.Lectures.size();i++){
            content.add(course.Lectures.get(i));
        }
        for(int i = 0;i<course.Sections.size();i++){
            content.add(course.Sections.get(i));
        }
        return content;
}
public ArrayList<String>ShowContentAssQuiz(Course course){

    ArrayList<String> content=new ArrayList<String>();
    for(int i =0;i<course.Assignment.size();i++){
        content.add(course.Assignment.get(i).name);
    }
    for(int i = 0;i<course.quiz.size();i++){
        content.add(course.quiz.get(i).Quizname);
    }
    return content;
}
}