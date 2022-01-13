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

class Game  extends JFrame {
    public Game() {
        super("WarHammer 40k Simulator");
        SplashScreenLayout SSL = new SplashScreenLayout();
        setSize(new Dimension(200,200));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(SSL);
        setVisible(true);
    }
}

class SplashScreenLayout extends JPanel {
    OptionsWindow optionsWindow;

    public SplashScreenLayout() {
        super(new MigLayout("al center center, wrap 1"));
        JLabel title = new JLabel("KillTeam Simulator 1.0");
        JButton newGame = new JButton("NEW GAME");
        JButton newSim = new JButton("NEW SIMULATION");
        JButton options = new JButton("OPTIONS");
        JButton exit = new JButton("EXIT");
        add(title,"grow");
        add(newGame,"grow");
        add(newSim);
        add(options,"grow");
        add(exit,"grow");
        //The cool new way we can do it with lambda, as actionPerformed is the default actionListened event for a button I guess?
        newGame.addActionListener(e -> pressedNewGame());
        newSim.addActionListener(e -> pressedNewSim());
        options.addActionListener(e -> pressedOptions());
        exit.addActionListener(e -> pressedExit());
    }

    private void pressedNewSim() {
        SwingUtilities.invokeLater(() -> new SimulationWindow());
    }

    public void pressedNewGame() {
        SwingUtilities.invokeLater(() -> new BoardGame());
//        System.out.println("Making new game");
    }

    public void pressedOptions() {
        System.out.println("Setting current panel invisible");
        setVisible(false);
        System.out.println("Showing options panel");
        optionsWindow.setVisible(true);
        System.out.println("Done");
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
        add(title, "span");
        JLabel someText = new JLabel("Some text");
        add(someText, "span");
        System.out.println("Made Options JPanel");
    }
}