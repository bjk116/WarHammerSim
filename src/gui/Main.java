package gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String args[]) {
        //Old code
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Game();
//            }
//        });
        // This is using an anonymous function the ()
        // which is the newly intstantiated class of new Runnable.  How?  Cause invokeLaters first argument is a Runnable I assume
        // And new Runnables default Override is run which is what our gets put into I guess?
        // TODO figure out these two are equivalent
        SwingUtilities.invokeLater(() -> new Game());
    }
}

class Game {
    public Game() {
        JFrame frame = new JFrame("WarHammer Sim40k");
        SplashScreenLayout SSL = new SplashScreenLayout();
        frame.setSize(new Dimension(800,800));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(SSL);
        frame.setVisible(true);
    }
}

class SplashScreenLayout extends JPanel {
    public SplashScreenLayout() {
        super(new MigLayout("al center center, wrap 1"));
        JLabel title = new JLabel("KillTeam Simulator 1.0");
        JButton newGame = new JButton("NEW GAME");
        JButton options = new JButton("OPTIONS");
        JButton exit = new JButton("EXIT");
        this.add(title,"grow");
        this.add(newGame,"grow");
        this.add(options,"grow");
        this.add(exit,"grow");
        //The cool new way we can do it with lambda, as actionPerformed is the default actionListened event for a button.
        newGame.addActionListener(e -> pressedNewGame());
        options.addActionListener(e -> pressedOptions());
        exit.addActionListener(e -> pressedExit());
    }

    public void pressedNewGame() {
        System.out.println("Making new game");
    }

    public void pressedOptions() {
        System.out.println("Pressed options");
    }

    public void pressedExit() {
        //TODO look up real way to do this for swing somewhere
        System.exit(0);
    }
}

class OptionsWindow extends JPanel {
    public OptionsWindow() {
        super(new MigLayout("al center center, wrap 1"));
        JLabel title = new JLabel("Options");
        this.add(title);
    }
}