package Display;

import java.awt.*;

import javax.swing.JPanel;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

public class JRoad extends JPanel implements MouseEvent{
    private int x, y;
    private String pos;

    public JRoad(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.pos = type;

        
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public String getpos(){return pos;}
    @Override
    public AbstractView getView() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int getDetail() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void initUIEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, AbstractView viewArg,
            int detailArg) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public EventTarget getTarget() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public EventTarget getCurrentTarget() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public short getEventPhase() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public boolean getBubbles() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean getCancelable() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public long getTimeStamp() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void stopPropagation() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void preventDefault() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void initEvent(String eventTypeArg, boolean canBubbleArg, boolean cancelableArg) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public int getScreenX() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int getScreenY() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int getClientX() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int getClientY() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public boolean getCtrlKey() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean getShiftKey() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean getAltKey() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean getMetaKey() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public short getButton() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public EventTarget getRelatedTarget() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void initMouseEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, AbstractView viewArg,
            int detailArg, int screenXArg, int screenYArg, int clientXArg, int clientYArg, boolean ctrlKeyArg,
            boolean altKeyArg, boolean shiftKeyArg, boolean metaKeyArg, short buttonArg, EventTarget relatedTargetArg) {
        // TODO Auto-generated method stub
        
    }
}
