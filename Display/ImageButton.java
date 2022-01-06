package Display;

import javax.swing.*;


import java.awt.*;

public class ImageButton extends JButton {
    Image image;

    public ImageButton(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    

}