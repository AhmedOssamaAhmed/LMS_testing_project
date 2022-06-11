package engine;

import java.util.ArrayList;

public class TA extends User {
    public String Name;
    String Password;
    String email;
    String Phonenumber;
    ArrayList<String>currentcourses=new ArrayList<String>();
    public static ArrayList<TA> TAS;
    public static void initDoctorArray() {
        if (TAS == null) {
            ArrayList<String> course =new ArrayList<String>();
            course.add("Control");
            TA.TAS = new ArrayList<TA>();
            TA.TAS.add(new TA("Hawary", "010", "hawa@", "0102555525248",course));
            TA.TAS.add(new TA("Ali", "010", "ahmed@", "0102555525248",course));
        }
    }
    public TA(String Name,String Password,String email , String Phonenumber,ArrayList<String>currentcourses){
        this.Name=Name;
        this.email=email;
        this.Password=Password;
        this.Phonenumber=Phonenumber;
        this.currentcourses=currentcourses ;  }
    public  ArrayList<Calendar> calendar(){
        ArrayList<Calendar>calendars=new ArrayList<Calendar>();
        for(int i = 0 ; i<this.currentcourses.size();i++){
            for(int j = 0; i< Course.Courses.size(); i++){
                if(this.currentcourses.get(i).equals(Course.Courses.get(j).coursename)){
                    for(int k = 0; k< Course.Courses.get(j).quiz.size(); k++)
                        calendars.add(new Calendar(Course.Courses.get(j).coursename, Course.Courses.get(j).quiz.get(k).Quizname, Course.Courses.get(j).quiz.get(k).Date, Course.Courses.get(j).quiz.get(k).Starttime));
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
