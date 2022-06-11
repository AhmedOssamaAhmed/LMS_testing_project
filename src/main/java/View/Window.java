package View;

import engine.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {
    final int WIDTH = 1080;
    final int HEIGHT = 720;
    final String TITLE = "Learning Management System - v1.0";
    static Window window;
    public static Color primaryColor = new Color(0xfff0c84a);
    public static Color secondaryColor = Color.BLACK;
    public User currentUser;

    private ArrayList<JPanel> history;

    private Window(){
        super();
        history = new ArrayList<JPanel>();

        setSize(WIDTH, HEIGHT);
        setTitle(TITLE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set starting screen
        LoginScreen screen = new LoginScreen();
        add(screen);
        history.add(screen);
        setVisible(true);
    }

    public static Window getInstance(){
        if(window == null)
            window = new Window();
        return window;
    }

    public void setScreen(JPanel panel){
        if(history.size() > 0){
            this.remove(history.get(history.size()-1));
        }
        this.add(panel);
        history.add(panel);
        this.revalidate();
        this.repaint();
    }

    public void historyPop(){
        this.remove(history.get(history.size()-1));
        history.remove(history.size() - 1);
        this.add(history.get(history.size() -1));
        this.revalidate();
        this.repaint();
    }

    public void logout(){
        setScreen(new LoginScreen());
    }

    public static void main(String args[]){
        Window.getInstance();
    }

}
