package View;

import View.Components.Page;
import View.Components.RoundContainer;
import engine.Ass;
import engine.Course;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class CreateAssignment extends JPanel {
    File assFile;
    JPanel field4;
    JButton pickFile;
    public CreateAssignment(Course course){
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
        field3.add(new JLabel("Dead Line Time:"));
        JTextField pass = new JTextField();
        pass.setColumns(13);
        field3.add(pass);
        formContainer.add(field3);

        field4 = new JPanel();
        field4.setBackground(Color.WHITE);
        field4.add(new JLabel("Problem File:  "));
        JFileChooser filePicker = new JFileChooser();
        pickFile = new JButton("Choose a file");
        pickFile.addActionListener(e ->{
            int result = filePicker.showSaveDialog(Window.getInstance());
            if(result == JFileChooser.APPROVE_OPTION){
                assFile = filePicker.getSelectedFile();
            }
            renderFile();
        });
        field4.add(pickFile);
        formContainer.add(field4);


        formContainer.add(Box.createRigidArea(new Dimension(0,20)));

        JButton createUser = new JButton("Create Assignment");
        createUser.addActionListener(e->{
            course.Assignment.add(new Ass(assFile, name.getText(), email.getText(), pass.getText()));
            errorMsg.setText("Assignment Added Successfully");
            errorMsg.setForeground(Color.green);
        });
        createUser.setAlignmentX(JButton.CENTER_ALIGNMENT);
        createUser.setBackground(Window.primaryColor);
        createUser.setForeground(Window.secondaryColor);
        createUser.setBorderPainted(false);
        createUser.setOpaque(true);
        formContainer.add(createUser);

        roundContainer.add(formContainer);
        content.add(roundContainer);

        new Page("Create Assignment", this, content, true);
    }

    public void renderFile(){
        field4.remove(pickFile);
        field4.add(new JLabel(assFile.getName())) ;
        this.revalidate();
        this.repaint();
    }
}
