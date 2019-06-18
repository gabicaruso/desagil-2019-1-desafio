package br.pro.hashi.ensino.desagil.desafio;

import br.pro.hashi.ensino.desagil.desafio.model.HumanPlayer;
import br.pro.hashi.ensino.desagil.desafio.model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener, ActionListener {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void keyTyped(KeyEvent event) {
        System.out.println("keyTyped");
    }

    @Override
    public void keyPressed(KeyEvent event) {
        HumanPlayer humanPlayer = model.getHumanPlayer();

        if (event.getKeyCode() == KeyEvent.VK_UP) {
            humanPlayer.moveUp();
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            humanPlayer.moveRight();
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            humanPlayer.moveDown();
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            humanPlayer.moveLeft();
        }

        view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent event) {
        System.out.println("keyReleased");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        System.out.println("actionPerformed");
    }
}
