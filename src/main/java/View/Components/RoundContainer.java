package View.Components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoundContainer extends JPanel {
    public RoundContainer(){
       super();
        this.setBorder(new EmptyBorder(30,30,30,30));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Insets insets = getInsets();
        int x = insets.left;
        int y = insets.top;
        int w = getWidth() - insets.left - insets.right;
        int h = getHeight() - insets.top - insets.bottom;
        g2.setColor(getBackground());
        g2.fillRoundRect(x, y, w, h, 20, 20);
    }
}
