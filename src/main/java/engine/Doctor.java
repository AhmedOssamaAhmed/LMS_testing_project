package engine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Doctor extends User{
    public String Name;
    String Password;
    String email;
    String Phonenumber;
    ArrayList<String>currentcourses=new ArrayList<String>();
    public static ArrayList<Doctor>Doctors;
    public static void initDoctorArray() {
        if (Doctors == null) {
            ArrayList<String> course =new ArrayList<String>();
            course.add("Control");
            Doctor.Doctors = new ArrayList<Doctor>();
            Doctor.Doctors.add(new Doctor("Yassin", "010", "ahmed@", "0102555525248",course));
        }
    }
    public Doctor(String Name,String Password,String email , String Phonenumber,ArrayList<String>currentcourses){
        this.Name=Name;
        this.email=email;
        this.Password=Password;
        this.Phonenumber=Phonenumber;
        this.currentcourses=currentcourses;
    }
    public  ArrayList<Calendar> calendar(){
        ArrayList<Calendar>calendars=new ArrayList<Calendar>();
        for(int i = 0 ; i<this.currentcourses.size();i++){
            for(int j = 0 ; i<Course.Courses.size();i++){
                if(this.currentcourses.get(i).equals(Course.Courses.get(j).coursename)){
                    for(int k =0;k<Course.Courses.get(j).quiz.size();k++){
                        calendars.add(new Calendar(Course.Courses.get(j).coursename,Course.Courses.get(j).quiz.get(k).Quizname,Course.Courses.get(j).quiz.get(k).Date,Course.Courses.get(j).quiz.get(k).Starttime));}
                }
            }

        }

        return calendars;
    }
    public String addASS(Course course, String Path,String Assname,String Date, String Deadline){

        File Ass = new File(Path);
        if(Ass.exists()==true) {
            course.Assignment.add(new Ass( Ass, Assname, Date, Deadline));
            return "Successful";
        }
        else{
            return"file not exist";
        }
    }
    public String addlecture(Course course, String Path) throws IOException {
        File Lecture = new File(Path);
        if(Lecture.exists()==true) {
            course.Lectures.add(Lecture);
            return "Successful";
        }
        else{
            return"file not exist";
        }

    }
    public String addsection(Course course, String Path){
        File section = new File(Path);
        if(section.exists()==true) {
            course.Sections.add(section);
            return "Successful";
        }
        else{
            return"error";
        }
    }

    public ArrayList<Course> showcourses(){
        ArrayList<Course> courses = new ArrayList<>();
        for(int i = 0; i < currentcourses.size(); i++) {
            courses.add(new Course(currentcourses.get(i)));
        }
        return courses;
    }
}
