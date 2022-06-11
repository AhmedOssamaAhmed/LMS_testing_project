package View;

import View.Components.Page;
import View.Components.RoundContainer;
import engine.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CreateUser extends JPanel {
    public CreateUser(){
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
        field2.add(new JLabel("Email:          "));
        JTextField email = new JTextField();
        email.setColumns(13);
        field2.add(email);
        formContainer.add(field2);

        JPanel field3 = new JPanel();
        field3.setBackground(Color.WHITE);
        field3.add(new JLabel("Password:      "));
        JTextField pass = new JTextField();
        pass.setColumns(13);
        field3.add(pass);
        formContainer.add(field3);

        JPanel field4 = new JPanel();
        field4.setBackground(Color.WHITE);
        field4.add(new JLabel("Phone Number:"));
        JTextField num = new JTextField();
        num.setColumns(13);
        field4.add(num);
        formContainer.add(field4);

        JPanel field5 = new JPanel();
        field5.setBackground(Color.WHITE);
        field5.add(new JLabel("Type:"));
        String choices[] = {"Student", "TA", "Doctor"};
        JComboBox<String> type = new JComboBox<>(choices);
        field5.add(type);
        formContainer.add(field5);


        formContainer.add(Box.createRigidArea(new Dimension(0,20)));

        JButton createUser = new JButton("Create User");
        createUser.addActionListener(e->{
            String selectedType = (String)type.getSelectedItem();
            if(selectedType.equals("Student")){
                String result = User.Registerstudent(name.getText(), pass.getText(), num.getText(), email.getText());
                errorMsg.setForeground(Color.red);
                errorMsg.setText(result);
                if(result.equals("Student Added Successfully")){
                    errorMsg.setForeground(Color.green);
                }
            }else{
                String result = User.Register(selectedType, name.getText(), pass.getText(), email.getText(), num.getText());
                errorMsg.setForeground(Color.red);
                errorMsg.setText(result);
                if(result.equals("Doctor Added Successfully")){
                    errorMsg.setForeground(Color.green);
                }
                if(result.equals("TA Added Successfully")){
                    errorMsg.setForeground(Color.green);
                }
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

        new Page("Create User", this, content, false);
    }
}
