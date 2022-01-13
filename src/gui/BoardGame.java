package gui;

import javax.swing.*;
import java.awt.*;

public class BoardGame extends JFrame {
    public BoardGame() {
        super("New Game");
        SplashScreenLayout SSL = new SplashScreenLayout();
        setSize(new Dimension(800,800));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(SSL);
        setVisible(true);
    }
}
