import engine.Doctor;
import engine.Student;
import engine.TA;
import engine.User;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User u1;
    Student S1;

    @Nested
    @DisplayName("Log in")
    class NestedTest{
        @BeforeEach
        public void Before(){
            u1 = new User();
        }
        @Test
        @DisplayName("Case Student")
        public void Test1(){
            assertEquals("engine.Student", u1.Login("Ahmed", "010").getClass().getName());
        }
        @Test
        @DisplayName("Case TA")
        public void Test2(){
            assertEquals("engine.TA", u1.Login("Ali", "010").getClass().getName());}
        @Test
        @DisplayName("Case Doctor")
        public void Test3(){
            assertEquals("engine.Doctor", u1.Login("Yassin", "010").getClass().getName());}
        @Test
        @DisplayName("Case NULL")
        public void Test4(){
            assertEquals(null, u1.Login("@1235.", "03@2"));
        }
    }
    @Nested
    @DisplayName("Register Student")
    class NestedTest2{
        @BeforeEach
        public void Before(){
            Student.initStudentArray();
        }
        @Test
        @DisplayName("Normal input")
        public void Test1(){
            assertEquals("Student Added Successfully", u1.Registerstudent("Ahmed", "010",
                    "010","Ahmed@eng.asu.edu.eg"));
        }
        @Test
        @DisplayName("Wrong Email")
        public void Test2(){
            assertEquals("Invalid Email", u1.Registerstudent("Marawan", "12345",
                    "010","Ahmedasu"));}
        @Test
        @DisplayName("Number Name")
        public void Test3(){
            assertEquals("Invalid Name", u1.Registerstudent("1548", "12345",
                    "010","Ahmed@eng.asu.edu.eg"));}
        @Test
        @DisplayName("Name Phone Number")
        public void Test4(){
            assertEquals("Invalid Phone Number", u1.Registerstudent("Marawan", "12345",
                    "Number","Ahmed@eng.asu.edu.eg"));
        }
    }
    @Nested
    @DisplayName("Register TA/Doctor")
    class NestedTest3{
        @BeforeEach
        public void Before(){
            Doctor.initDoctorArray();
            TA.initDoctorArray();
        }
        @Test
        @DisplayName("Normal input")
        public void Test1(){
            assertEquals("Doctor Added Successfully", u1.Register("Doctor","Ibrahim", "010",
                    "Ibrahim@eng.asu.edu.eg","010"));
        }
        @Test
        @DisplayName("Wrong Email")
        public void Test2(){
            assertEquals("Invalid Email", u1.Register("TA","Marawan", "12345",
                    "@.com","010"));}
        @Test
        @DisplayName("Number Name")
        public void Test3(){
            assertEquals("Invalid Name", u1.Register("Doctor","9877", "12345",
                    "Ibrahim@eng.asu.edu.eg","010"));}
        @Test
        @DisplayName("Name Phone Number")
        public void Test4(){
            assertEquals("Invalid Phone Number", u1.Register("TA","Ibrahim", "12345",
                    "Ibrahim@eng.asu.edu.eg","Valid"));
        }
        @Test
        @DisplayName("Wrong Type")
        public void Test5() {
            assertEquals("Invalid Type", u1.Register("Dotor", "Ibrahim", "010",
                    "Ibrahim@eng.asu.edu.eg", "010"));
        }
        @Test
        @DisplayName("Student type")
        public void Test6() {
            assertEquals("Invalid Type", u1.Register("ta", "Ibrahim", "010",
                    "Ibrahim@eng.asu.edu.eg", "010"));
        }
    }
    @AfterEach
    void After() {
        u1 = null;
    }
}