package Display;

import javax.swing.*;
import java.awt.*;
import Game.*;

public class JStructure extends ImagePane {
    private int x, y;
    private int type;

    public JStructure(Image image, boolean fit, int x, int y, int type) {
        super(image, fit);
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getType(){
        return this.type;
    }
}
