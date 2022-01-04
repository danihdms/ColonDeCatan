package Display;

import javax.swing.JPanel;
import javax.swing.*;

public class JTile extends JPanel {
    private int x, y;
    private String type;

    public JTile(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;

        ImageIcon icon = new ImageIcon("CATANE.jpeg");
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);
        
        switch (type) {
            case "colline":
                this.add(thumb);

            case "plaine":
                this.add(thumb);

            case "foret":
                this.add(thumb);

            case "champ":
                this.add(thumb);

            case "montagne":
                this.add(thumb);
        }
    }
}
