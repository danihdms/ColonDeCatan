package Display;

import java.awt.*;

import javax.swing.JPanel;

public class ImagePane extends JPanel {
    Image image;
    boolean fit;

    ImagePane(Image image, boolean fit) {
            this.image = image;
            this.fit = fit;
            setLayout(new BorderLayout());
        }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(fit){
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.drawImage(image, 0, 0, null);
        }
    }
}