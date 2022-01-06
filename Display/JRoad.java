package Display;

import java.awt.*;

import javax.swing.JPanel;

public class JRoad extends JPanel {
    private int x, y;
    private String type;

    public JRoad(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;

        if (type.equals("horizontal")) {
            setSize(new Dimension(85, 20));
        } else {
            setSize(new Dimension(20, 85));
        }
    }
}
