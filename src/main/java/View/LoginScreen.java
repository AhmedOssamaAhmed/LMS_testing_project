package View;

import View.Components.RoundContainer;
import engine.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class LoginScreen extends JPanel {
    public LoginScreen(){
        super();
        GridBagLayout gb = new GridBagLayout();
        this.setLayout(gb);
        JPanel centeredContainer = new JPanel();
        this.add(centeredContainer);
        BoxLayout bx = new BoxLayout(centeredContainer, BoxLayout.Y_AXIS);
        centeredContainer.setLayout(bx);

        // Add Logo
        try{
            ImageIcon img = new ImageIcon(ImageIO.read(new File("graduation.png")));
            JLabel zero = new JLabel(ImageHandler.scaleImage(img, 100));
            zero.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            centeredContainer.add(zero);
        }catch(Exception e){
            e.printStackTrace();
        }

        // Add Spacer
        centeredContainer.add(Box.createRigidArea(new Dimension(0, 30)));

        // Add Labels
        JLabel two = new JLabel("Login to Your Account");
        two.setFont(new Font("Sans-Serif", Font.BOLD, 30));
        two.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        centeredContainer.add(two);
        JLabel one = new JLabel("Welcome Back! Please enter your Details.");
        one.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        centeredContainer.add(one);

        // Add Spacer
        centeredContainer.add(Box.createRigidArea(new Dimension(0, 10)));

        // error label
        JLabel errorMsg = new JLabel();
        errorMsg.setForeground(Color.red);
        errorMsg.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        centeredContainer.add(errorMsg);

        // Add Input Container
        JPanel roundContainer = new RoundContainer();
        roundContainer.setBackground(Color.white);
        JPanel inputContainer = new JPanel();
        inputContainer.setBackground(Color.white);
        BoxLayout bl = new BoxLayout(inputContainer, BoxLayout.Y_AXIS);
        inputContainer.setLayout(bl);

        inputContainer.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel field1 = new JPanel();
        field1.setBackground(Color.white);
        field1.add(new JLabel("Username: "));
        JTextField username = new JTextField();
        username.setColumns(13);
        field1.add(username);
        inputContainer.add(field1);

        JPanel field2 = new JPanel();
        field2.setBackground(Color.white);
        field2.add(new JLabel("Password: "));
        JTextField password = new JTextField();
        password.setColumns(13);
        field2.add(password);
        inputContainer.add(field2);

        inputContainer.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton loginButton = new JButton("Login");
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(e -> {
            User currentUser = User.Login(username.getText(), password.getText());
            if(currentUser == null){
                errorMsg.setText("Incorrect Username or Password");
                return;
            }
            Window.getInstance().currentUser = currentUser;
            if(currentUser.isAdmin()){
                Window.getInstance().setScreen(new CreateCourse());
            }else{
                Window.getInstance().setScreen(new ViewCourses());
            }
        });
        loginButton.setBackground(Window.primaryColor);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        inputContainer.add(loginButton);

        inputContainer.add(Box.createRigidArea(new Dimension(0, 20)));

        roundContainer.add(inputContainer);
        centeredContainer.add(roundContainer);
    }
}
