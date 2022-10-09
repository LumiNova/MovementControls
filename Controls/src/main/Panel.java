package main;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {

    final int screenWidth = 1280;
    final int screenHeight = 720;

    int playerX;
    int playerY;
    int playerSize = 50;
    int speed = 10;

    float FPS = 60;

    Thread gameThread;

    KeyHandler handler = new KeyHandler();

    public Panel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(handler);

        setDefaultValues();
        startGameThread();
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {

                movement();
                repaint();
                checkCollisions();
                delta--;
            }
        }
    }

    public void setDefaultValues() {

        playerX = 0;
        playerY = 0;
    }

    public void checkCollisions() {

        if (playerY <= 0) {
            playerY = 0;
        }

        else if (playerY >= screenHeight - playerSize) {
            playerY = screenHeight - playerSize;
        }

        if (playerX <= 0) {
            playerX = 0;
        }

        else if (playerX >= screenWidth - playerSize) {
            playerX = screenWidth - playerSize;
        }
    }

    public void movement() {

        if (handler.pressedW) {
            playerY -= speed;
        }

        else if (handler.pressedS) {
            playerY += speed;
        }

        if (handler.pressedA) {
            playerX -= speed;
        }

        else if (handler.pressedD) {
            playerX += speed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.orange);
        g.fillRect(playerX,playerY,playerSize,playerSize);

        g.dispose();
    }
}
