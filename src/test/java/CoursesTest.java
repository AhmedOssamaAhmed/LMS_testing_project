import engine.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CoursesTest {
    Courses C1;
    Course c;

    public CoursesTest() {
        ArrayList<Questions> questions = new ArrayList<Questions>();
        ArrayList<Quiz> quiz = new ArrayList<Quiz>();
        questions.add(new Mcqquestions("1+1=","2","1","2","3","4"));
        quiz.add(new Quiz("Quiz1","5:30","5:45","1/6/2022","15 mins",questions));
        ArrayList<Ass>Assignment=new ArrayList<Ass>();
        File assfile = new File("C:\\Users");
        ArrayList<File> Lectures = new ArrayList<File>();
        Lectures.add(new File("C:\\Users"));
        ArrayList<File>Sections = new ArrayList<File>();
        Sections.add(new File("C:\\Users"));
        Assignment.add(new Ass(assfile,"Ass1","25/5/2022","11:59"));
        ArrayList<String> Students = new ArrayList<String>();
        Students.add("Ahmed");
        c = new Course("Control","CSE556","Yassin","Ahmed","Ali",Students,quiz,Assignment,Lectures,Sections);
    }


    @Nested
    @DisplayName("Check Courses")
    class Check{
        @BeforeEach
        public void before(){
            C1 = new Courses();
        }
        ArrayList<String> S = new ArrayList<String>();
        @Test
        @DisplayName("Invalid TA name")
        public void Test1() {
            assertEquals("The instructor/TA name does not exists", C1.checkcourse("AI",
                    "CSE333", "Hany", "Fady", "Ahmed", S));
        }
        @Test
        @DisplayName("Course name invalid")
        public void Test2(){
            assertEquals("Invalid Course name", C1.checkcourse("Control66", "CSE333",
                    "Yassin", "Ali", "Ali", S));
        }
        @Test
        @DisplayName("Course code invalid")
        public void Test3(){
            assertEquals("Invalid Course code", C1.checkcourse("Testing", "Cps@666",
                    "Yassin", "Ali", "Ali", S));
        }
    }

    @Nested
    @DisplayName("Check Student")
    class studentCheck{
        @BeforeEach
        public void before(){
            C1 = new Courses();
            Student.initStudentArray();
            Course.initCourseArray();
        }
        @Test
        @DisplayName("Check already saved student")
        public void Test1(){
            assertEquals("Student is added Successfully", C1.Checkstudent("Ahmed", "Control"));
        }
        @Test
        @DisplayName("Check new student")
        public void Test2(){
            assertEquals("Student does not exist", C1.Checkstudent("Ali", "Control"));
        }
    }

    @Nested
    @DisplayName("Lec and Sec Content")
    class LecSecContent{
        @BeforeEach
        public void before(){
            C1 = new Courses();
        }
        ArrayList<File> F1 = new ArrayList<File>();
        @Test
        @DisplayName("Lec Section Check")
        public void Test1(){

            F1.add(new File("C:\\Users"));
            F1.add(new File("C:\\Users"));

            assertEquals(F1, C1.ShowContentLecSec(c));
        }
    }

    @Nested
    @DisplayName("Assignment Quiz Content")
    class AssQuizContent{
        @BeforeEach
        public void before(){
            C1 = new Courses();
        }
        ArrayList<String> S1 = new ArrayList<String>();
        @Test
        @DisplayName("Assignment Quiz Check")
        public void Test1(){
            S1.add("Ass1");
            S1.add("Quiz1");

            assertEquals(S1, C1.ShowContentAssQuiz(c));
        }
    }
}