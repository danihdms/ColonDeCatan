package Display;


import java.awt.*;

public class JTile extends ImageButton {
    private int x, y;
    private String type;

    public JTile(Image image, boolean fit, int x, int y, String type) {
        super(image);
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
