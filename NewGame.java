import javax.swing.*;
import java.awt.*;
import static java.awt.PageAttributes.MediaType.A;
import java.awt.event.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager.*;


public class NewGame extends JFrame {

    
    
    public NewGame() {
        newComponents();
        isEmpty();
        
    }
    
    public void newComponents(){
        JFrame ngFrame = this;
        this.setTitle("New Game");
        this.setPreferredSize(new Dimension(250, 140));
        this.setResizable(false);
                
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(enterWord)
                        .addComponent(word)
                        .addComponent(play))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(playRandomEasy)
                        .addComponent(playRandomMedium)
                        .addComponent(playRandomHard)
                )
                
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(enterWord)
                .addComponent(playRandomEasy))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(word)
                .addComponent(playRandomMedium))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(play)
                .addComponent(playRandomHard))
         );
        
        
        
        word.addKeyListener(new KeyAdapter() {
        
            public void keyReleased(KeyEvent e)
            {
                isEmpty();
            }
            
        });
        
        
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String formattedString = Arrays.toString(word.getPassword())
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .replaceAll("([A-Z])", "_ ")
                    .replaceAll("([a-z])", "_ ")
                    .replace(" ", "")
                    .toLowerCase();
                    
                
                String formattedString2 = Arrays.toString(word.getPassword())
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .replace(" ", "")
                    .toLowerCase();
                
                if(! formattedString2.matches("^[a-zA-Z]+$"))
                {
                    JOptionPane error1 = new JOptionPane();
                    JOptionPane.showMessageDialog(error1, "Use only letters", "Letter Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                (Main.puzzle).setText(formattedString);
                (Main.invisibleLabel).setText(formattedString2);
                (Main.checkString) = formattedString;
                (Main.health) = 5;
                (Main.tries).setText("Health: " + (Main.health));
                (Main.usedLetters).setText("Used: ");
                (Main.letter).setEnabled(true);
                (Main.check).setEnabled(true);
                dispose();
                }
                
                
            }
        });
        
        playRandomEasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newEasyGame();
            }
        });
        
        playRandomMedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newMediumGame();
            }
        });
        
        playRandomHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newHardGame();
            }
        });
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    JPasswordField word = new JPasswordField(1);
    JButton play = new JButton("Start Game");
    JButton playRandomEasy = new JButton("Easy word");
    JButton playRandomMedium = new JButton("Medium word");
    JButton playRandomHard = new JButton("Hard word");
    JLabel enterWord = new JLabel("Enter your word");
    JRadioButton onePlayer = new JRadioButton("Single Player");
    JRadioButton morePlayers = new JRadioButton("Multiplayer");
    
    public void isEmpty()
    {
        if(word.getPassword().length == 0){
            play.setEnabled(false);
        }
        else if(word.getPassword().length != 0)
        {
            play.setEnabled(true);   
        }
    }
    
    public void newEasyGame()
    {
        int rEasyNumber = (WordDraw.rEasy).nextInt((WordDraw.easy).length);
                String easyWord = WordDraw.easy[rEasyNumber]+"";
                String formattedString = easyWord
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .replaceAll("([A-Z])", "_")
                    .replaceAll("([a-z])", "_")
                    .replace(" ", "")
                    .toLowerCase();
                
                String formattedString2 = easyWord
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .replace(" ", "")
                    .toLowerCase();
                
                (Main.puzzle).setText(formattedString);
                (Main.invisibleLabel).setText(easyWord);
                (Main.checkString) = easyWord;
                (Main.health) = 5;
                (Main.tries).setText("Health: " + (Main.health));
                (Main.usedLetters).setText("Used: ");
                (Main.letter).setEnabled(true);
                (Main.check).setEnabled(true);
                System.out.println(easyWord);
                dispose();
    }
    
    public void newMediumGame()
    {
        int rEasyNumber = (WordDraw.rMedium).nextInt((WordDraw.medium).length);
        String mediumWord = WordDraw.medium[rEasyNumber]+"";
        String formattedString = mediumWord
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .replaceAll("([A-Z])", "_")
                    .replaceAll("([a-z])", "_")
                    .replace(" ", "")
                    .toLowerCase();
                
        String formattedString2 = mediumWord
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .replace(" ", "")
                    .toLowerCase();
                
                (Main.puzzle).setText(formattedString);
                (Main.invisibleLabel).setText(mediumWord);
                (Main.checkString) = mediumWord;
                (Main.health) = 5;
                (Main.tries).setText("Health: " + (Main.health));
                (Main.usedLetters).setText("Used: ");
                (Main.letter).setEnabled(true);
                (Main.check).setEnabled(true);
                System.out.println(mediumWord);
                dispose();
    }
    
    public void newHardGame()
    {
        int rEasyNumber = (WordDraw.rHard).nextInt((WordDraw.hard).length);
        String hardWord = WordDraw.hard[rEasyNumber]+"";
        String formattedString = hardWord
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .replaceAll("([A-Z])", "_")
                    .replaceAll("([a-z])", "_")
                    .replace(" ", "")
                    .toLowerCase();
                
        String formattedString2 = hardWord
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .replace(" ", "")
                    .toLowerCase();
                
                (Main.puzzle).setText(formattedString);
                (Main.invisibleLabel).setText(hardWord);
                (Main.checkString) = hardWord;
                (Main.health) = 5;
                (Main.tries).setText("Health: " + (Main.health));
                (Main.usedLetters).setText("Used: ");
                (Main.letter).setEnabled(true);
                (Main.check).setEnabled(true);
                System.out.println(hardWord);
                dispose();
    }
}
