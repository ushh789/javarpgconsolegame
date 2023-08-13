package com.softserve.edu.finalproject.services;

import com.softserve.edu.finalproject.constants.GameConstants;

import java.awt.*;
import java.awt.event.*;

import static java.lang.Thread.sleep;

public class KeyEventsHandler extends Frame implements KeyListener {
    Label l;
    TextArea area;

    KeyEventsHandler() throws InterruptedException {
        l = new Label(GameConstants.GAME_TITLE);
        sleep(3000);
    }

    public void keyPressed(KeyEvent e) {}

    public void keyReleased (KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) throws InterruptedException {
        new KeyEventsHandler();
    }
}
