package View.Components;

import View.Window;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class Page extends JPanel {
    public Page(String title, JPanel parent, JComponent content, boolean showBack){
        parent.setLayout(new BorderLayout());

        // Add SideBar
        parent.add(new SideBar(), BorderLayout.WEST);

        // Main Container
        JPanel topContainer = new JPanel();
        BoxLayout topLayout = new BoxLayout(topContainer, BoxLayout.X_AXIS);
        topContainer.setLayout(topLayout);
        JLabel pageTitle = new JLabel(title);
        pageTitle.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        JPanel centerContainer = new JPanel();
        centerContainer.setBorder(new EmptyBorder(20,20,20,20));
        centerContainer.setLayout(new BorderLayout());
        if(showBack){
            try{
                ImageIcon img = new ImageIcon(ImageIO.read(new File("backIcon.png")));
                JButton back = new JButton(img);
                back.setCursor(new Cursor(Cursor.HAND_CURSOR));
                back.setBorderPainted(false);
                back.addActionListener(e ->{
                    Window.getInstance().historyPop();
                });
                topContainer.add(back);
                topContainer.add(Box.createRigidArea(new Dimension(5,0)));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        topContainer.add(pageTitle);
        centerContainer.add(topContainer, BorderLayout.NORTH);
        JScrollPane scrollableContent = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollableContent.setBorder(null);
        centerContainer.add(scrollableContent, BorderLayout.CENTER);
        parent.add(centerContainer, BorderLayout.CENTER);
    }
}
