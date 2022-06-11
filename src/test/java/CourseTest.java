import engine.Ass;
import engine.Course;
import engine.Quiz;
import engine.Student;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseTest {
    Course C1;
    @BeforeEach
    public void before(){
        Student.initStudentArray();
        ArrayList<Quiz> Q1=new ArrayList<Quiz>();
        ArrayList<Ass> A1=new ArrayList<Ass>();
        ArrayList<File> L1=new ArrayList<File>();
        ArrayList<File> S1=new ArrayList<File>();
        ArrayList<String> St1 =new ArrayList<String>();
        C1 = new Course("Ai","CSE473","Ammar","Mahmoud","Mahmoud",St1,Q1,A1,L1,S1);
    }
    @Test
    public void Test1(){
        File j = new File("F:\\");
        Ass Assignment1= new Ass(j,"Assignment 1","12/5/2022","12:00");
        Course.initCourseArray();
        C1.Assignment.add(Assignment1);
        assertEquals("Assignment 1",C1.showAss(C1,"Assignment 1").name);
    }
    @Test
    public void Test2(){
        File j = new File("F:\\");
        Ass Assignment1= new Ass(j,"Assignment 1","12/5/2022","12:00");
        Course.initCourseArray();
        C1.Assignment.add(Assignment1);
        assertEquals(null,C1.showAss(C1,"A@#pL"));
    }
    @Test
    public void Test3(){
        File j = new File("F:\\");
        Course.initCourseArray();
        assertEquals(null,C1.showAss(C1,"Assignment 1"));
    }
}