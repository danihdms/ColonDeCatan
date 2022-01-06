package Display;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;

public class JTile extends ImagePane {
    private int x, y;
    private String type;

    public JTile(Image image, boolean fit, int x, int y, String type) {
        super(image);
        this.x = x;
        this.y = y;
        this.type = type;
        setSize(new Dimension(85, 85));
    }
}
