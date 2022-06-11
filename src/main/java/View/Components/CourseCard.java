package View.Components;
import View.CoursePage;
import View.Window;
import engine.Course;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CourseCard extends JPanel {
    public CourseCard(Course course){
       JPanel roundedContainer = new RoundContainer();
       roundedContainer.setBackground(Color.WHITE);
       JPanel courseContainer = new JPanel();
       courseContainer.setBorder(new EmptyBorder(20,20,20,20));
       courseContainer.setBackground(Color.WHITE);
       BoxLayout courseLayout = new BoxLayout(courseContainer, BoxLayout.Y_AXIS);
       courseContainer.setLayout(courseLayout);

       JLabel name = new JLabel(course.CourseID + " - " + course.coursename);
       name.setAlignmentX(JLabel.CENTER_ALIGNMENT);
       JLabel instructor = new JLabel("Instructor: " + course.CourseInstructor);
       instructor.setAlignmentX(JLabel.CENTER_ALIGNMENT);
       courseContainer.add(name);
       courseContainer.add(instructor);

       courseContainer.add(Box.createRigidArea(new Dimension(0,20)));

       JButton viewCourse = new JButton("View Course");
       viewCourse.addActionListener(e ->{
           Window.getInstance().setScreen(new CoursePage(course));
       });
       viewCourse.setAlignmentX(JButton.CENTER_ALIGNMENT);
       viewCourse.setBackground(Window.primaryColor);
       viewCourse.setOpaque(true);
       viewCourse.setBorderPainted(false);
       courseContainer.add(viewCourse);

       roundedContainer.add(courseContainer);
       this.add(roundedContainer);
    }
}
