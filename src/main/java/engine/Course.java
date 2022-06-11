package engine;

import java.io.File;
import java.util.ArrayList;

public class Course {
    public String coursename;
    public String CourseID;
    public String CourseInstructor;
    public String TAname;
    public String TA2name;
    public ArrayList<Quiz> quiz = new ArrayList<Quiz>();
    public ArrayList<String> Students = new ArrayList<String>();
    public ArrayList<Ass>Assignment=new ArrayList<>();
    public ArrayList<File>Lectures=new ArrayList<File>();
    public ArrayList<File>Sections=new ArrayList<File>();
    public static ArrayList<Course> Courses;

    public static void initCourseArray() {
        if (Courses == null) {
            Course.Courses = new ArrayList<Course>();
            ArrayList<Quiz> quiz = new ArrayList<Quiz>();
            ArrayList<Questions>questions=new ArrayList<Questions>();
            questions.add(new Mcqquestions("1+1=","2","1","2","3","4"));
            questions.add(new Mcqquestions("1+2","3","3","no correct answer","5","4"));
            questions.add(new WrittenQuestion("what is the dr name ? ", "Eslam"));
            quiz.add(new Quiz("quiz1","5:30","5:45","1/6/2022","15 mins",questions));
            ArrayList<Ass>Assignment=new ArrayList<Ass>();
            File assfile=new File("C:\\");
            ArrayList<File>Lectures=new ArrayList<File>();
            ArrayList<File>Sections=new ArrayList<File>();
            Lectures.add(assfile);
            Assignment.add(new Ass(assfile,"Ass1","25/5/2022","11:59"));
            ArrayList<String> Students = new ArrayList<String>();
            Students.add("Ahmed");
            Course.Courses.add(new Course("Control","CSE556","Yassin","Ahmed","Ali",Students,quiz,Assignment,Lectures,Sections));
        }
    }

    public Course(String coursename){
        Course.initCourseArray();
        for(int i = 0; i < Courses.size(); i++){
            if(Courses.get(i).coursename.equals(coursename)){
                Course c = Courses.get(i);
                this.coursename=c.coursename;
                this.CourseID=c.CourseID;
                this.CourseInstructor=c.CourseInstructor;
                this.TAname=c.TAname;
                this.TA2name=c.TA2name;
                this.Students=c.Students;
                this.quiz=c.quiz;
                this.Assignment=c.Assignment;
                this.Lectures=c.Lectures;
                this.Sections=c.Sections;
                break;
            }
        }
    }

    public Course(String coursename,String CourseID,String CourseInstrctor,String TAname,String TA2name,ArrayList<String> Students,ArrayList<Quiz>quizes,ArrayList<Ass>Assignment,ArrayList<File>Lectures,ArrayList<File>sections){
        Course.initCourseArray();
        this.coursename=coursename;
        this.CourseID=CourseID;
        this.CourseInstructor=CourseInstrctor;
        this.TAname=TAname;
        this.TA2name=TA2name;
        this.Students=Students;
        this.quiz=quizes;
        this.Assignment=Assignment;
        this.Lectures=Lectures;
        this.Sections=sections;
    }
    public Ass showAss(Course course,String Assname){
        for(int i=0;i<course.Assignment.size();i++){
            if(course.Assignment.get(i).name.equals(Assname)){
                return course.Assignment.get(i);
            }
        }
        return null;
    }
    public Course(){

    }
}

