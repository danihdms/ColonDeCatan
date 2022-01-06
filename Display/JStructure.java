package Display;

import java.awt.*;

public class JStructure extends ImageButton {
    private int x, y;
    private int type;
    private boolean isActive;
    private String pos;

    public JStructure(Image image, boolean isActive, int x, int y,String pos, int type) {
        super(image);
        this.x = x;
        this.y = y;
        this.type = type;
        this.isActive=isActive;
        this.pos=pos;
    }

    public int getType(){
        return this.type;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public String getPos(){return pos;}

    public void setActive(boolean b){this.isActive=b;}
    public boolean getActive(){return this.isActive;}
}
