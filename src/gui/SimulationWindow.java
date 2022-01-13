package gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationWindow extends JFrame {
    public SimulationWindow() {
        super("Simulation Zone");
        setSize(new Dimension(800,800));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SimulationWindowContent SWC = new SimulationWindowContent();
        getContentPane().add(SWC);
        setVisible(true);
    }
}

class SimulationWindowContent extends JPanel {
    private SimulationOptionsSelectionPane SOSP;
    private SimulationResultsPane SRP;
    public SimulationWindowContent() {
        super(new MigLayout("wrap 1"));
        SOSP = new SimulationOptionsSelectionPane();
        SRP = new SimulationResultsPane();
        add(SOSP,"grow");
        add(SRP,"grow");
    }

}

class SimulationOptionsSelectionPane extends JPanel {
    private JComboBox<String> simulationTypeSelection;
    private SimulationOptionsDetailsPane detailPane;
    public SimulationOptionsSelectionPane(){
        super(new MigLayout("wrap 3"));
        setSize(new Dimension(300,300));
        JLabel simulationTypeSelectionLabel = new JLabel("Simulation Type:");
        String[] optionsToChoose = {"Character", "Weapon"};
        simulationTypeSelection = new JComboBox<>(optionsToChoose);
        detailPane = new SimulationOptionsDetailsPane();
        add(simulationTypeSelectionLabel,"grow");
        add(simulationTypeSelection,"grow");
        add(detailPane, "span");
        simulationTypeSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userSelection = simulationTypeSelection.getItemAt(simulationTypeSelection.getSelectedIndex());
                if (userSelection == "Weapon") {
                    detailPane.renderWeaponSimOptions();
                } else if (userSelection == "Character") {
                    detailPane.renderCharacterSimOptions();
                }
            }
        });
    }

    public void renderWeaponSimOptions() {
      System.out.println("Rendering weapon sim options");
    };

    public void renderCharacterSimOptions() {
        System.out.println("Rendering character sim options");
    };

}

class SimulationOptionsDetailsPane extends JPanel {
    public SimulationOptionsDetailsPane() {
        super(new MigLayout("wrap 2"));
    }

    public void renderWeaponSimOptions() {
        removeAll();
        JLabel weaponName = new JLabel("Weapon Name:");
        JTextField weaponNameInput = new JTextField();
        JLabel weaponDamage = new JLabel("Weapon Damage:");
        JTextField weaponDamageInput = new JTextField();
        add(weaponName,"grow");
        add(weaponNameInput,"grow");
        add(weaponDamage,"grow");
        add(weaponDamageInput,"grow");
    }

    public void renderCharacterSimOptions() {
        removeAll();
        JLabel weaponName = new JLabel("Character Name:");
        JTextField weaponNameInput = new JTextField();
        JLabel weaponDamage = new JLabel("Character Damage:");
        JTextField weaponDamageInput = new JTextField();
        add(weaponName,"grow");
        add(weaponNameInput,"grow");
        add(weaponDamage,"grow");
        add(weaponDamageInput,"grow");

    }
}

class SimulationResultsPane extends JPanel {
    public SimulationResultsPane(){
        super(new MigLayout("al center center, wrap 1"));
        setSize(new Dimension(300,300));
        JLabel simulationTypeSelectionLabel = new JLabel("Simulation Type:");
        String[] optionsToChoose = {"Character", "Weapon"};
        JComboBox<String> simulationTypeSelection = new JComboBox<>(optionsToChoose);
        add(simulationTypeSelection,"span");
        add(simulationTypeSelection,"grow");
    }
}