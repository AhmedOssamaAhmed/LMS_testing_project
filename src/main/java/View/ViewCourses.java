package View;

import View.Components.CourseCard;
import View.Components.Page;
import engine.Course;
import engine.Doctor;
import engine.Student;
import engine.TA;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewCourses extends JPanel {
    public ViewCourses(){
        ArrayList<Course> courses = new ArrayList<>();
        if(Window.getInstance().currentUser.isStudent()){
            Student user = (Student)Window.getInstance().currentUser;
            courses = user.showcourses();
        }else if(Window.getInstance().currentUser.isTA()){
            TA user = (TA)Window.getInstance().currentUser;
            courses = user.showcourses();
        }else if(Window.getInstance().currentUser.isDoctor()){
            Doctor user = (Doctor)Window.getInstance().currentUser;
            courses = user.showcourses();
        }
        JPanel content = new JPanel();
        GridLayout grid = new GridLayout((int)Math.ceil(1.0*courses.size() / 3), 3);
        content.setLayout(grid);
        for(int i = 0; i < courses.size(); i++){
            content.add(new CourseCard(courses.get(i)));
        }
        JScrollPane scrollableContent = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollableContent.setBorder(null);
        new Page("View Courses", this, scrollableContent, false);
    }
}
