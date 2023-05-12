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
import main.es.labturing.connect4.views.Language;
import main.es.labturing.connect4.views.console.MessageManager;

public class StartView extends JFrame implements ItemListener{

    private StartController startController;
    private JComboBox<Language> languagesComboBox = new JComboBox<Language>();
    private JComboBox<String> PlayersComboBox = new JComboBox<String>();
    
    public StartView (StartController startController){
        super("Connect4(msg)");
        this.startController = startController;
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
		this.setVisible(true);
    }

    public void interact(){
        JPanel startPanelLanguage = new JPanel();

        JLabel languageLabel = new JLabel("Language configuration");
		languageLabel.setBounds(50, 100, 80, 25);
        startPanelLanguage.add(languageLabel);

        this.languagesComboBox.setBounds(10,10,80,20);
        this.languagesComboBox.addItem(null);
        this.languagesComboBox.addItem(Language.SPANISH);  
        this.languagesComboBox.addItem(Language.ENGLISH);
        //TODO refactor addItems disponibles en Language
        this.languagesComboBox.addItemListener(this);
        startPanelLanguage.add(this.languagesComboBox);

        this.getContentPane().add(startPanelLanguage);

        JPanel startPanelPlayer = new JPanel();
        JLabel playerRed = new JLabel("Select red player type");
        JLabel playerYellow = new JLabel("Select yellow player type");
		playerRed.setBounds(50, 100, 80, 25);
		playerYellow.setBounds(50, 100, 80, 25);

        startPanelPlayer.add(playerRed);
        startPanelPlayer.add(playerYellow);

        this.getContentPane().add(startPanelPlayer);
        startPanelPlayer.setVisible(false);
        
        boolean config = false;
        do{
            if(MessageManager.getInstance().getLanguage() == null){
                startPanelLanguage.setVisible(true);
                
            } else if(!this.startController.isAllPlayersSetted()){
                startPanelLanguage.setVisible(false);
                startPanelPlayer.setVisible(true);  
            } else {
                config = true;
            }
        }while(!config);

        this.setSize(400, 400);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == this.languagesComboBox) {

            Language selectedLanguage = (Language) this.languagesComboBox.getSelectedItem();
            try{
                MessageManager.getInstance().setLanguage(selectedLanguage);
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
