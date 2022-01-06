package Display;

import javax.swing.*;
import java.awt.*;
import Game.*;

public class JStructure extends ImagePane {
    private int x, y;
    private int type;

    public JStructure(Image image, boolean fit, int x, int y, int type) {
        super(image);
        this.x = x;
        this.y = y;
        this.type = type;
        setSize(new Dimension(85, 85));

    }

    public int getType(){
        return this.type;
    }
}
