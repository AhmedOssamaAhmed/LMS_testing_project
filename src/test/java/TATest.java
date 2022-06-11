import engine.Calendar;
import engine.Course;
import engine.Doctor;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TATest {

    @Test
    public void calendar() {
        Course.initCourseArray();
        ArrayList<Calendar> c1=new ArrayList<Calendar>();
        ArrayList<Calendar>c2=new ArrayList<Calendar>();
        c1.add(new Calendar("Control","quiz1","1/6/2022","5:30"));
        ArrayList<String>currentcourses=new ArrayList<String>();
        currentcourses.add("Control");
        Doctor Doc = new Doctor("Yassin","01021300347","ahmed@","0102555525248",currentcourses);
        c2=Doc.calendar();
        assertEquals(c1.get(0).Coursename,c2.get(0).Coursename);
        assertEquals(c1.get(0).Date,c2.get(0).Date);
    }
}