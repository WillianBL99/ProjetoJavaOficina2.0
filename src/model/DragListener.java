package model;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.event.MouseInputAdapter;

public final class DragListener extends MouseInputAdapter {

    public static void add(JDialog jDialog) {
        if (!jDialog.isUndecorated()) {
            throw new IllegalArgumentException("Frame is not undecorated!");
        }
        DragListener listener = new DragListener();
        jDialog.addMouseListener(listener);
        jDialog.addMouseMotionListener(listener);
    }

    private Point location;
    private MouseEvent pressed;

    public void mousePressed(MouseEvent me) {
        pressed = me;
    }

    public void mouseDragged(MouseEvent me) {
    	if(pressed.getY() <= 20) {
    		Component component = me.getComponent();
            location = component.getLocation(location);
            int x = location.x - pressed.getX() + me.getX();
            int y = location.y - pressed.getY() + me.getY();
            component.setLocation(x, y);
    	}
        
    }

    private DragListener() {}
}