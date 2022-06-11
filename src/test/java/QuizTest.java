import engine.Course;
import engine.Questions;
import engine.Quiz;
import engine.Student;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class QuizTest {
    Quiz Q;

    @Nested
    @DisplayName("Add Quiz")
    class NestedTest {
        @BeforeEach
        public void Before() {
            Quiz.initquestion();
            ArrayList<Questions> q = new ArrayList<Questions>();
            Q = new Quiz("Name1", "15:00", "15:15", "15/4/2022", "00:10", q);
        }

        @Test
        @DisplayName("Normal Case")
        public void Test1() {
            ArrayList<Questions> q = new ArrayList<Questions>();
            Course C = new Course();
            assertEquals("Quiz is Added", Quiz.addquiz(C, "Quiz1", "15:00", "15:15"
                    , "15/4/2022", "00:10", q));
        }
        @Test
        @DisplayName("Wrong Starttime")
        public void Test2(){
            ArrayList<Questions> q = new ArrayList<Questions>();
            Course C = new Course();
            assertEquals("Invalid Start Time", Quiz.addquiz(C,"Quiz1", "15@//0", "15:15"
                    , "15/4/2022", "00:10", q));
        }
        @Test
        @DisplayName("Wrong Endtime")
        public void Test3(){
            ArrayList<Questions> q = new ArrayList<Questions>();
            Course C = new Course();
            assertEquals("Invalid End Time", Quiz.addquiz(C,"Quiz1", "10:45", "15@//0"
                    , "15/4/2022", "00:10", q));}
        @Test
        @DisplayName("Wrong Date")
        public void Test4(){
            ArrayList<Questions> q = new ArrayList<Questions>();
            Course C = new Course();
            assertEquals("Invalid Date", Quiz.addquiz(C,"Quiz1", "10:00", "15:15"
                    , "15/41*/2022", "00:10", q));}
    }
    @Nested
    @DisplayName("Correct Questions")
    class NestedTest2{
        @BeforeEach
        public void Before(){
            Student.initStudentArray();
            Quiz.initquestion();
        }
        @Test
        @DisplayName("Normal input")
        public void Test1(){
//            Quiz.addquestion();
            ArrayList<Questions> q = new ArrayList<Questions>();
            Quiz q1 = new Quiz("Name1", "15:00", "15:15", "15/4/2022", "00:10", q);
            ArrayList<String> Answers= new ArrayList<String>();
            assertEquals(0, q1.quizgrade(Answers));
        }
//        @Test
//        @DisplayName("Wrong Email")
//        public void Test2(){
//            assertEquals("Invalid Email", Quiz.quizgrade();}
//        @Test
//        @DisplayName("Number Name")
//        public void Test3(){
////            assertEquals("Invalid Name", u1.Registerstudent("1548", "12345",
////                    "010","Ahmed@eng.asu.edu.eg"));}
//        @Test
//        @DisplayName("Name Phone Number")
//        public void Test4(){
//            assertEquals("Invalid Phone Number", u1.Registerstudent("Marawan", "12345",
//                    "Number","Ahmed@eng.asu.edu.eg"));
//        }
    }
//    @Nested
//    @DisplayName("Register TA/Doctor")
//    class NestedTest3{
//        @BeforeEach
//        public void Before(){
//            Doctor.initDoctorArray();
//            TA.initDoctorArray();
//        }
//        @Test
//        @DisplayName("Normal input")
//        public void Test1(){
//            assertEquals("Doctor Added Successfully", u1.Register("Doctor","Ibrahim", "010",
//                    "Ibrahim@eng.asu.edu.eg","010"));
//        }
//        @Test
//        @DisplayName("Wrong Email")
//        public void Test2(){
//            assertEquals("Invalid Email", u1.Register("TA","Marawan", "12345",
//                    "@.com","010"));}
//        @Test
//        @DisplayName("Number Name")
//        public void Test3(){
//            assertEquals("Invalid Name", u1.Register("Doctor","9877", "12345",
//                    "Ibrahim@eng.asu.edu.eg","010"));}
//        @Test
//        @DisplayName("Name Phone Number")
//        public void Test4(){
//            assertEquals("Invalid Phone Number", u1.Register("TA","Ibrahim", "12345",
//                    "Ibrahim@eng.asu.edu.eg","Valid"));
//        }
//        @Test
//        @DisplayName("Wrong Type")
//        public void Test5() {
//            assertEquals("Invalid Type", u1.Register("Dotor", "Ibrahim", "010",
//                    "Ibrahim@eng.asu.edu.eg", "010"));
//        }
//        @Test
//        @DisplayName("Student type")
//        public void Test6() {
//            assertEquals("Invalid Type", u1.Register("ta", "Ibrahim", "010",
//                    "Ibrahim@eng.asu.edu.eg", "010"));
//        }
//    }
        @AfterEach
        void After() {
            Q = null;
        }
    }