package View;

import View.Components.Page;
import engine.Ass;
import engine.Course;
import engine.Quiz;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CoursePage extends JPanel{
    public CoursePage(Course course){
       JPanel content = new JPanel();
       BoxLayout contentLayout = new BoxLayout(content, BoxLayout.Y_AXIS);
       content.setLayout(contentLayout);

       JLabel courseContent = new JLabel("Course Content");
       courseContent.setFont(new Font("Sans-Serif", Font.BOLD, 17));

       JLabel assigments = new JLabel("Assignments");
       assigments.setFont(new Font("Sans-Serif", Font.BOLD, 17));

       JLabel quizzes = new JLabel("Quizzes");
       quizzes.setFont(new Font("Sans-Serif", Font.BOLD, 17));
       content.add(Box.createRigidArea(new Dimension(0,20)));

       content.add(courseContent);
       for(int i = 0; i < course.Lectures.size(); i++){
          File lec = course.Lectures.get(i);
          JButton quiz1 = new JButton(lec.getName());
          quiz1.setCursor(new Cursor(Cursor.HAND_CURSOR));
          quiz1.setForeground(new Color(0x87a0ff));
          quiz1.setBorderPainted(false);
          content.add(quiz1);
       }
       for(int i = 0; i < course.Sections.size(); i++){
          File lec = course.Sections.get(i);
          JButton quiz1 = new JButton(lec.getName());
          quiz1.setCursor(new Cursor(Cursor.HAND_CURSOR));
          quiz1.setForeground(new Color(0x87a0ff));
          quiz1.setBorderPainted(false);
          content.add(quiz1);
       }
       if(Window.getInstance().currentUser.isDoctor() || Window.getInstance().currentUser.isTA()){
          JButton addAss = new JButton("Add Course Content");
          addAss.setBorderPainted(false);
          addAss.setBackground(Window.primaryColor);
          addAss.setOpaque(true);
          addAss.addActionListener(e ->{
             Window.getInstance().setScreen(new CreateContent(course));
          });
          content.add(addAss);
       }
       content.add(Box.createRigidArea(new Dimension(0,20)));

       content.add(assigments);
       for(int i = 0; i < course.Assignment.size(); i++){
          Ass assignment = course.Assignment.get(i);
          JButton quiz1 = new JButton(assignment.name);
          quiz1.setCursor(new Cursor(Cursor.HAND_CURSOR));
          quiz1.setForeground(new Color(0x87a0ff));
          quiz1.setBorderPainted(false);
          content.add(quiz1);
       }
       if(Window.getInstance().currentUser.isDoctor() || Window.getInstance().currentUser.isTA()){
          JButton addAss = new JButton("Add Assignment");
          addAss.setBorderPainted(false);
          addAss.setBackground(Window.primaryColor);
          addAss.setOpaque(true);
          addAss.addActionListener(e ->{
             Window.getInstance().setScreen(new CreateAssignment(course));
          });
          content.add(addAss);
       }
       content.add(Box.createRigidArea(new Dimension(0,20)));

       content.add(quizzes);
       for(int i = 0; i < course.quiz.size(); i++){
          Quiz quiz = course.quiz.get(i);
          JButton quiz1 = new JButton(quiz.Quizname);
          quiz1.setCursor(new Cursor(Cursor.HAND_CURSOR));
          quiz1.setForeground(new Color(0x87a0ff));
          quiz1.setBorderPainted(false);
          quiz1.addActionListener(e->{
             Window.getInstance().setScreen(new TakeQuiz(quiz));
          });
          content.add(quiz1);
       }
       if(Window.getInstance().currentUser.isDoctor() || Window.getInstance().currentUser.isTA()){
          JButton addAss = new JButton("Add Quiz");
          addAss.setBorderPainted(false);
          addAss.setBackground(Window.primaryColor);
          addAss.setOpaque(true);
          addAss.addActionListener(e ->{
             Window.getInstance().setScreen(new CreateQuiz(course));
          });
          content.add(addAss);
       }
       new Page(course.CourseID + " - " + course.coursename, this, content, true);
    }
}
