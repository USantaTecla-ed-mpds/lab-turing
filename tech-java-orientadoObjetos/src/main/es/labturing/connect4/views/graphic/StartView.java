package main.es.labturing.connect4.views.graphic;

import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.es.labturing.connect4.controllers.StartController;
import main.es.labturing.connect4.models.Color;
import main.es.labturing.connect4.types.PlayerType;
import main.es.labturing.connect4.views.Language;
import main.es.labturing.connect4.views.console.MessageManager;

public class StartView extends JFrame implements ItemListener{

    private StartController startController;
    private JComboBox<Language> languagesComboBox;
    private JComboBox<PlayerType> playersComboBox;
    private boolean languageSetted;
    private boolean playersSetted;
    private JPanel languagePanel;
    private JPanel playerPanel;
    
    public StartView (StartController startController){
        super("Connect4(msg)");
        this.languagesComboBox  = new JComboBox<Language>();
        this.playersComboBox = new JComboBox<PlayerType>();
        this.startController = startController;
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
		this.setVisible(true);
        this.languageSetted = false;
        this.playersSetted = false;
        this.languagePanel = new JPanel();
        this.playerPanel = new JPanel();
    }

    public void interact(){
        this.configLanguagePanel();
        do{
            this.languagePanel.setVisible(true);
            System.out.println("test");
        }while(!this.languageSetted);
        this.languagePanel.setVisible(false);

        for (int i = 0; i < Color.values().length; i++) {
            if(Color.values()[i] != Color.NULL){
                JOptionPane.showMessageDialog(null, Color.values()[i]);
                this.configPlayersPanel(Color.values()[i]);
                do{
                    this.playerPanel.setVisible(true);
                }while(!this.playersSetted);
                this.playersSetted = false;
            }
        }
        this.playerPanel.setVisible(false);
        JOptionPane.showMessageDialog(null, "start game!");

        //boolean config = false;
        // do{
        //     if(MessageManager.getInstance().getLanguage() == null){
            //        
        //     } else if(!this.startController.isAllPlayersSetted()){
        //         startlanguagePanel.setVisible(false);
        //         playerPanel.setVisible(true);  
        //     } else {
        //         config = true;
        //     }
        // }while(!config);
    }

    private void configLanguagePanel(){
        JLabel languageLabel = new JLabel("Language configuration");
		languageLabel.setBounds(50, 100, 80, 25);
        this.languagePanel.add(languageLabel);
        this.languagesComboBox.setBounds(10,10,80,20);
        this.languagesComboBox.addItem(null);
        for (int i = 0; i < Language.values().length; i++) {
            this.languagesComboBox.addItem(Language.values()[i]);
        }
        this.languagesComboBox.addItemListener(this);
        this.languagePanel.add(this.languagesComboBox);
        this.languagePanel.setVisible(false);
        this.getContentPane().add(this.languagePanel);
    }

    private void configPlayersPanel(Color color){
        this.getContentPane().removeAll();
        this.playerPanel.removeAll();
        JLabel playerColor = new JLabel("Select " + color.toString() + " player type");
		playerColor.setBounds(50, 100, 80, 25);
        this.playerPanel.add(playerColor);
        this.addPlayerTypes();
        this.playerPanel.setVisible(false);
        this.getContentPane().add(this.playerPanel);
    }

    private void addPlayerTypes(){
        this.playersComboBox.removeAllItems();
        this.playersComboBox.addItem(null);
        for (int i = 0; i < PlayerType.values().length; i++) {
            this.playersComboBox.addItem(PlayerType.values()[i]);
        }
        this.playersComboBox.addItemListener(this);
        this.playerPanel.add(this.playersComboBox);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == this.languagesComboBox) {

            Language selectedLanguage = (Language) this.languagesComboBox.getSelectedItem();
            if(selectedLanguage != null){
                try{
                    MessageManager.getInstance().setLanguage(selectedLanguage);
                    this.languageSetted = true;
                } catch(IOException ex){
                    ex.printStackTrace();
                }
            }   
        }

        if(e.getSource() == this.playersComboBox){
            PlayerType selectedPlayerType = (PlayerType) this.playersComboBox.getSelectedItem();
            this.startController.addPlayer(selectedPlayerType);
            this.playersSetted = true;
        }
    }
}
