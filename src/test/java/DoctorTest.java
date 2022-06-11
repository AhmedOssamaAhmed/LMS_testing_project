import engine.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DoctorTest {


    public DoctorTest() {

    }

    @org.junit.Test
    public void calendar() {
        Course.initCourseArray();

        ArrayList<Calendar>c1=new ArrayList<Calendar>();
        ArrayList<Calendar>c2=new ArrayList<Calendar>();
        c1.add(new Calendar("Control","quiz1","1/6/2022","5:30"));
        ArrayList<String>currentcourses=new ArrayList<String>();
        currentcourses.add("Control");
        Doctor Doc = new Doctor("Yassin","01021300347","ahmed@","0102555525248",currentcourses);
        c2=Doc.calendar();
        assertEquals(c1.get(0).Coursename,c2.get(0).Coursename);
        assertEquals(c1.get(0).Date,c2.get(0).Date);
    }

    @org.junit.Test
    public void addASS() {
        ArrayList<Quiz> quiz = new ArrayList<Quiz>();
        ArrayList<Questions>questions=new ArrayList<Questions>();
        questions.add(new Mcqquestions("1+1=","2","1","2","3","4"));
        quiz.add(new Quiz("quiz1","5:30","5:45","1/6/2022","15 mins",questions));
        ArrayList<Ass>Assignment=new ArrayList<Ass>();
        File assfile=new File("C:\\Users");
        ArrayList<File>Lectures=new ArrayList<File>();
        ArrayList<File>Sections=new ArrayList<File>();
        Assignment.add(new Ass(assfile,"Ass1","25/5/2022","11:59"));
        ArrayList<String> Students = new ArrayList<String>();
        Students.add("Ahmed");
        Course c1;
        c1=new Course("Control","CSE556","Yassin","Ahmed","Ali",Students,quiz,Assignment,Lectures,Sections);
        ArrayList<String>currentcourses=new ArrayList<String>();
        currentcourses.add("Control");
        Doctor Doc = new Doctor("Yassin","01021300347","ahmed@","0102555525248",currentcourses);
        assertEquals("Successful",Doc.addASS(c1,"C:\\Users","Ass1","15/5/2022","12:00"));
        assertEquals("file not exist",Doc.addASS(c1,"C:\\User","Ass1","15/5/2022","12:00"));
    }

    @org.junit.Test
    public void addlecture() throws IOException {
        ArrayList<Quiz> quiz = new ArrayList<Quiz>();
        ArrayList<Questions>questions=new ArrayList<Questions>();
        questions.add(new Mcqquestions("1+1=","2","1","2","3","4"));
        quiz.add(new Quiz("quiz1","5:30","5:45","1/6/2022","15 mins",questions));
        ArrayList<Ass>Assignment=new ArrayList<Ass>();
        File assfile=new File("C:\\Users");
        ArrayList<File>Lectures=new ArrayList<File>();
        ArrayList<File>Sections=new ArrayList<File>();
        Assignment.add(new Ass(assfile,"Ass1","25/5/2022","11:59"));
        ArrayList<String> Students = new ArrayList<String>();
        Students.add("Ahmed");
        Course c1;
        c1=new Course("Control","CSE556","Yassin","Ahmed","Ali",Students,quiz,Assignment,Lectures,Sections);
        ArrayList<String>currentcourses=new ArrayList<String>();
        currentcourses.add("Control");
        Doctor Doc = new Doctor("Yassin","01021300347","ahmed@","0102555525248",currentcourses);
        assertEquals("Successful",Doc.addlecture(c1,"C:\\Users"));
        assertEquals("file not exist",Doc.addlecture(c1,"C:\\User"));
    }

    @org.junit.Test
    public void addsection() {
        ArrayList<Quiz> quiz = new ArrayList<Quiz>();
        ArrayList<Questions>questions=new ArrayList<Questions>();
        questions.add(new Mcqquestions("1+1=","2","1","2","3","4"));
        quiz.add(new Quiz("quiz1","5:30","5:45","1/6/2022","15 mins",questions));
        ArrayList<Ass>Assignment=new ArrayList<Ass>();
        File assfile=new File("C:\\Users");
        ArrayList<File>Lectures=new ArrayList<File>();
        ArrayList<File>Sections=new ArrayList<File>();
        Assignment.add(new Ass(assfile,"Ass1","25/5/2022","11:59"));
        ArrayList<String> Students = new ArrayList<String>();
        Students.add("Ahmed");
        Course c1;
        c1=new Course("Control","CSE556","Yassin","Ahmed","Ali",Students,quiz,Assignment,Lectures,Sections);
        ArrayList<String>currentcourses=new ArrayList<String>();
        currentcourses.add("Control");
        Doctor Doc = new Doctor("Yassin","01021300347","ahmed@","0102555525248",currentcourses);
        assertEquals("Successful",Doc.addsection(c1,"C:\\Users"));
        assertEquals("error",Doc.addsection(c1,"C:\\User"));
    }
}