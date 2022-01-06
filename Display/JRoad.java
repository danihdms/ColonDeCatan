package Display;

import java.awt.*;

import javax.swing.JPanel;

public class JRoad extends Button {
    private int x, y;
    private String pos;
    private boolean isActive;

    public JRoad(int x, int y, String pos, boolean  active) {
        this.x = x;
        this.y = y;
        this.pos = pos;
        this.isActive = active;

        
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public String getPos(){return pos;}
    public void setActive(boolean b){this.isActive=b;}
    public boolean getActive(){return this.isActive;}

}
