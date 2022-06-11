package View;

import View.Components.Page;
import View.Components.RoundContainer;
import engine.Courses;
import engine.Doctor;
import engine.Student;
import engine.TA;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class CreateCourse extends JPanel {
    private ArrayList<String> doctors = new ArrayList<>();
    private ArrayList<String> tas = new ArrayList<>();
    private ArrayList<String> students = new ArrayList<>();
    private ArrayList<String> currStudents = new ArrayList<>();

    JPanel studentsList;

    public CreateCourse(){
        // initialize data
        for(int i=0; i < Doctor.Doctors.size(); i++){
            doctors.add(Doctor.Doctors.get(i).Name);
        }
        for(int i = 0; i < Student.students.size(); i++){
            students.add(Student.students.get(i).name);
        }
        for(int i = 0; i < TA.TAS.size(); i++){
            tas.add(TA.TAS.get(i).Name);
        }

        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());

        JPanel roundContainer = new RoundContainer();
        roundContainer.setBackground(Color.WHITE);
        JPanel formContainer = new JPanel();
        formContainer.setBorder(new EmptyBorder(20,20,20,20));
        formContainer.setBackground(Color.WHITE);
        BoxLayout formLayout = new BoxLayout(formContainer, BoxLayout.Y_AXIS);
        formContainer.setLayout(formLayout);

        JLabel errorMsg = new JLabel();
        errorMsg.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        formContainer.add(errorMsg);

        JPanel field1 = new JPanel();
        field1.setBackground(Color.WHITE);
        field1.add(new JLabel("Name:   "));
        JTextField name = new JTextField();
        name.setColumns(13);
        field1.add(name);
        formContainer.add(field1);

        JPanel field2 = new JPanel();
        field2.setBackground(Color.WHITE);
        field2.add(new JLabel("Code:   "));
        JTextField email = new JTextField();
        email.setColumns(13);
        field2.add(email);
        formContainer.add(field2);

        JPanel field3 = new JPanel();
        field3.setBackground(Color.WHITE);
        field3.add(new JLabel("Instructor:"));
        JComboBox<String> instructor = new JComboBox<>(doctors.toArray(new String[0]));
        field3.add(instructor);
        formContainer.add(field3);

        JPanel field4 = new JPanel();
        field4.setBackground(Color.WHITE);
        field4.add(new JLabel("First TA:"));
        JComboBox<String> firstTA = new JComboBox<>(tas.toArray(new String[0]));
        field4.add(firstTA);
        formContainer.add(field4);

        JPanel field5 = new JPanel();
        field5.setBackground(Color.WHITE);
        field5.add(new JLabel("Second TA:"));
        JComboBox<String> secondTA = new JComboBox<>(tas.toArray(new String[0]));
        field5.add(secondTA);
        formContainer.add(field5);

        JPanel field6 = new JPanel();
        field6.setBackground(Color.WHITE);
        field6.add(new JLabel("Students: "));
        JComboBox<String> studentsCombo = new JComboBox<>(students.toArray(new String[0]));
        field6.add(studentsCombo);
        JButton addStudent = new JButton("Add Student");
        addStudent.addActionListener(e ->{
            currStudents.add((String)studentsCombo.getSelectedItem());
            studentsList.add(new JLabel((String)studentsCombo.getSelectedItem()));
            studentsList.revalidate();
            studentsList.repaint();
        });
        addStudent.setCursor(new Cursor(Cursor.HAND_CURSOR));
        field6.add(addStudent);
        formContainer.add(field6);

        studentsList = new JPanel();
        studentsList.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        BoxLayout studentsListLayout = new BoxLayout(studentsList, BoxLayout.Y_AXIS);
        studentsList.setLayout(studentsListLayout);
        studentsList.setBackground(Color.WHITE);
        formContainer.add(Box.createRigidArea(new Dimension(0,10)));
        formContainer.add(studentsList);
        formContainer.add(Box.createRigidArea(new Dimension(0,10)));

        formContainer.add(Box.createRigidArea(new Dimension(0,20)));

        JButton createUser = new JButton("Create Course");
        createUser.addActionListener(e ->{
            String result = Courses.checkcourse(name.getText(), email.getText(), (String)instructor.getSelectedItem(), (String)firstTA.getSelectedItem(), (String)secondTA.getSelectedItem(), currStudents);
            errorMsg.setForeground(Color.red);
            errorMsg.setText(result);
            if(result.equals("The course is added")){
                errorMsg.setForeground(Color.green);
            }
        });
        createUser.setAlignmentX(JButton.CENTER_ALIGNMENT);
        createUser.setBackground(Window.primaryColor);
        createUser.setForeground(Window.secondaryColor);
        createUser.setBorderPainted(false);
        createUser.setOpaque(true);
        formContainer.add(createUser);

        roundContainer.add(formContainer);
        content.add(roundContainer);
        new Page("Create Course", this, content, false);
    }
}
