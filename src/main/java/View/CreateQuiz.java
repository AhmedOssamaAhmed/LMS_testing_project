package View;

import View.Components.Page;
import View.Components.RoundContainer;
import engine.Ass;
import engine.Course;
import engine.Questions;
import engine.Quiz;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class CreateQuiz extends JPanel {
    public CreateQuiz(Course course){
        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());

        JPanel roundContainer = new RoundContainer();
        roundContainer.setBackground(Color.WHITE);
        JPanel formContainer = new JPanel();
        formContainer.setBorder(new EmptyBorder(20,20,20,20));
        formContainer.setBackground(Color.WHITE);
        BoxLayout formLayout = new BoxLayout(formContainer, BoxLayout.Y_AXIS);
        formContainer.setLayout(formLayout);

        JLabel errorMsg = new JLabel("");
        errorMsg.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        formContainer.add(errorMsg);

        JPanel field1 = new JPanel();
        field1.setBackground(Color.WHITE);
        field1.add(new JLabel("Name:          "));
        JTextField name = new JTextField();
        name.setColumns(13);
        field1.add(name);
        formContainer.add(field1);

        JPanel field2 = new JPanel();
        field2.setBackground(Color.WHITE);
        field2.add(new JLabel("Date:          "));
        JTextField email = new JTextField();
        email.setColumns(13);
        field2.add(email);
        formContainer.add(field2);

        JPanel field3 = new JPanel();
        field3.setBackground(Color.WHITE);
        field3.add(new JLabel("Start Time:"));
        JTextField pass = new JTextField();
        pass.setColumns(13);
        field3.add(pass);
        formContainer.add(field3);

        JPanel field4 = new JPanel();
        field4.setBackground(Color.WHITE);
        field4.add(new JLabel("End Time:"));
        JTextField endTime = new JTextField();
        endTime.setColumns(13);
        field4.add(endTime);
        formContainer.add(field4);

        JPanel field5 = new JPanel();
        field5.setBackground(Color.WHITE);
        field5.add(new JLabel("Time Limit:"));
        JTextField duration = new JTextField();
        duration.setColumns(13);
        field5.add(duration);
        formContainer.add(field5);

        formContainer.add(Box.createRigidArea(new Dimension(0,20)));

        JButton createUser = new JButton("Create Quiz");
        createUser.addActionListener(e->{
            Quiz quiz = new Quiz(name.getText(), pass.getText(), endTime.getText(), email.getText(), duration.getText(), new ArrayList<Questions>());
            course.quiz.add(quiz);
            Window.getInstance().setScreen(new CreateQuizQuestions(quiz));
        });
        createUser.setAlignmentX(JButton.CENTER_ALIGNMENT);
        createUser.setBackground(Window.primaryColor);
        createUser.setForeground(Window.secondaryColor);
        createUser.setBorderPainted(false);
        createUser.setOpaque(true);
        formContainer.add(createUser);

        roundContainer.add(formContainer);
        content.add(roundContainer);

        new Page("Create Quiz", this, content, false);
    }

}
