package Display;

import javax.swing.*;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

import java.awt.*;
import Game.*;

public class JStructure extends ImagePane{
    private int x, y;
    private int type;
    private String pos;

    public JStructure(Image image,int x, int y, int type,String pos) {
        super(image);
        this.x = x;
        this.y = y;
        this.type = type;
        this.pos=pos;
        setSize(new Dimension(85, 85));

    }

    public int getType(){
        return this.type;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public String getpos(){return pos;}

    
}
