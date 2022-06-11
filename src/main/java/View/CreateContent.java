package View;

import View.Components.Page;
import View.Components.RoundContainer;
import engine.Ass;
import engine.Course;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class CreateContent extends JPanel {
    File assFile;
    JPanel field4;
    JButton pickFile;
    public CreateContent(Course course){
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

        field4 = new JPanel();
        field4.setBackground(Color.WHITE);
        field4.add(new JLabel("Lecture/Section File:  "));
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

        JButton createUser = new JButton("Add Course Content");
        createUser.addActionListener(e->{
            course.Lectures.add(assFile);
            errorMsg.setText("File Added Successfully");
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

        new Page("Add Course Content", this, content, true);
    }

    public void renderFile(){
        field4.remove(pickFile);
        field4.add(new JLabel(assFile.getName())) ;
        this.revalidate();
        this.repaint();
    }
}
