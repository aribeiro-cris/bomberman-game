package project.bomberman;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardLogic implements KeyboardHandler {

    private Keyboard keyboard;
    private String direction;
    KeyboardEvent right;
    KeyboardEvent left;
    KeyboardEvent down;
    KeyboardEvent up;
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
        //left
        left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);
        //Down
        down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);
        //Up
        up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);
        //Space
        space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);
    }

    public String getDirection(){
        return direction;
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

//    public void keyboardStopped(){
//        keyboard.removeEventListener(right);
//        keyboard.removeEventListener(right1);
//        keyboard.removeEventListener(left);
//        keyboard.removeEventListener(left1);
//        keyboard.removeEventListener(up);
//        keyboard.removeEventListener(up1);
//        keyboard.removeEventListener(down);
//        keyboard.removeEventListener(down1);
//    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        //Space
        if(keyboardEvent.getKey() == keyboardEvent.KEY_SPACE){

        }
    }

}

