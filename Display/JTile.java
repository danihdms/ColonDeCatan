package Display;

import javax.swing.*;
import java.awt.*;

public class JTile extends ImagePane {
    private int x, y;
    private String type;

    public JTile(Image image, boolean fit, int x, int y, String type) {
        super(image, fit);
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
