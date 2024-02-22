package project.bomberman;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardLogic implements KeyboardHandler {

    private Keyboard keyboard;
    private String direction;
    private boolean requestBomb;
    KeyboardEvent right;
    KeyboardEvent right1;
    KeyboardEvent left;
    KeyboardEvent left1;
    KeyboardEvent down;
    KeyboardEvent down1;
    KeyboardEvent up;
    KeyboardEvent up1;
    KeyboardEvent space;

    public KeyboardLogic(){
        keyboard = new Keyboard(this);
        init();
    }

    public void init(){
        //right
        right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        //right
        right1 = new KeyboardEvent();
        right1.setKey(KeyboardEvent.KEY_RIGHT);
        right1.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(right1);

        //left
        left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);
        //left
        left1 = new KeyboardEvent();
        left1.setKey(KeyboardEvent.KEY_LEFT);
        left1.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(left1);
        //Down
        down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        down1 = new KeyboardEvent();
        down1.setKey(KeyboardEvent.KEY_DOWN);
        down1.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(down1);
        //Up
        up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        up1 = new KeyboardEvent();
        up1.setKey(KeyboardEvent.KEY_UP);
        up1.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(up1);
        //Space
        space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(space);
    }

    public String getDirection(){
        return direction;
    }

    public boolean getRequestBomb() {
        if(requestBomb) {
            requestBomb = false;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
            if(keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT){
                direction = "right";
            }
            else if(keyboardEvent.getKey() == keyboardEvent.KEY_LEFT){
                direction = "left";
            }
            else if(keyboardEvent.getKey() == keyboardEvent.KEY_UP){
                direction = "up";
            }
            else if(keyboardEvent.getKey() == keyboardEvent.KEY_DOWN){
                direction = "down";
            } else {
                direction = "stop";
            }
        }

    public void keyboardStopped(){
        keyboard.removeEventListener(right);
        keyboard.removeEventListener(left);
        keyboard.removeEventListener(up);
        keyboard.removeEventListener(down);
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        direction = "stop";
        //Space
        if(keyboardEvent.getKey() == keyboardEvent.KEY_SPACE){
            requestBomb = true;
        }
    }
}

