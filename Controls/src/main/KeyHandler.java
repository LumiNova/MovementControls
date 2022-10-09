package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    boolean pressedW, pressedA, pressedS, pressedD;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();

        switch (keycode) {
            case KeyEvent.VK_W:
                pressedW = true;
                break;
            case KeyEvent.VK_A:
                pressedA = true;
                break;
            case KeyEvent.VK_S:
                pressedS = true;
                break;
            case KeyEvent.VK_D:
                pressedD = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyCode();

        switch (keycode) {
            case KeyEvent.VK_W:
                pressedW = false;
                break;
            case KeyEvent.VK_A:
                pressedA = false;
                break;
            case KeyEvent.VK_S:
                pressedS = false;
                break;
            case KeyEvent.VK_D:
                pressedD = false;
                break;
        }
    }
}
