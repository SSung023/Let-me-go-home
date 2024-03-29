package ui;

import java.awt.*;
import java.awt.event.MouseEvent;

//base entity class
// other object extends this class
public abstract class UIObject {

    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    protected boolean hovering = false;

    // position and 크기
    public UIObject(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        // collision rectangle을 만드나?
        bounds = new Rectangle((int)x, (int)y, width, height);

    }

    public abstract void tick();

    public abstract void render(Graphics g);

    //recognize when mouse Clicked
    public abstract void onClick();

    public void onMouseMove(MouseEvent e){
        //check weather mouse point is on the button
        if(bounds.contains(e.getX(), e.getY()))
            hovering = true;
        else
            hovering = false;

    }

    public void onMouseRelease(MouseEvent e){
        if(hovering)
            onClick();
    }


    //GETTERS AND SETTERS
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isHovering() {
        return hovering;
    }
    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }



}
