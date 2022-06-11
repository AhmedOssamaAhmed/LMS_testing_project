package View.Components;

import View.*;
import View.Window;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class SideBar extends JPanel {
    public SideBar(){
        this.setBackground(Window.primaryColor);
        BoxLayout sidebarLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(sidebarLayout);
        this.setBorder(new EmptyBorder(20,20,20,20));

        // Add Logo
        try{
            ImageIcon img = new ImageIcon(ImageIO.read(new File("graduation.png")));
            JLabel zero = new JLabel(ImageHandler.scaleImage(img, 100));
            zero.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            this.add(zero);
        }catch(Exception e){
            e.printStackTrace();
        }

        this.add(Box.createRigidArea(new Dimension(0,20)));

        // Add name
        JLabel title  = new JLabel("LMS");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        this.add(title);

        this.add(Box.createRigidArea(new Dimension(0,20)));

        JButton linkCourses = new JButton("View Courses");
        linkCourses.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        linkCourses.setBorderPainted(false);
        linkCourses.setCursor(new Cursor(Cursor.HAND_CURSOR));
        linkCourses.setForeground(new Color(0x404040));
        linkCourses.addActionListener(e->{
            Window.getInstance().setScreen(new ViewCourses());
        });

        JButton linkCalendar = new JButton("My Calendar");
        linkCalendar.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        linkCalendar.setBorderPainted(false);
        linkCalendar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        linkCalendar.setForeground(new Color(0x404040));
        linkCalendar.addActionListener(e->{
            Window.getInstance().setScreen(new Calendar());
        });

        JButton linkCreateUser = new JButton("Create User");
        linkCreateUser.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        linkCreateUser.setBorderPainted(false);
        linkCreateUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        linkCreateUser.setForeground(new Color(0x404040));
        linkCreateUser.addActionListener(e->{
            Window.getInstance().setScreen(new CreateUser());
        });

        JButton linkCreateCourse = new JButton("Create Course");
        linkCreateCourse.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        linkCreateCourse.setBorderPainted(false);
        linkCreateCourse.setCursor(new Cursor(Cursor.HAND_CURSOR));
        linkCreateCourse.setForeground(new Color(0x404040));
        linkCreateCourse.addActionListener(e ->{
            Window.getInstance().setScreen(new CreateCourse());
        });

        JButton logout = new JButton("Logout");
        logout.addActionListener(e ->{
            Window.getInstance().logout();
        });
        logout.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        logout.setBorderPainted(false);
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setForeground(new Color(0x404040));

        if(!Window.getInstance().currentUser.isAdmin()){
            this.add(linkCourses);
            this.add(linkCalendar);
        }
        if(Window.getInstance().currentUser.isAdmin()){
            this.add(linkCreateUser);
            this.add(linkCreateCourse);
        }
        this.add(logout);
    }
}
