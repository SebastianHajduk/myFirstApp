import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class Main extends JFrame {

    public Main()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        JFrame frame = this;
        this.setTitle("Wisielec");
        this.setPreferredSize(new Dimension(250, 220));
        this.setResizable(false);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        
        letter = new JTextField(1);
        letter.setEnabled(false);
        check = new JButton("Check");
        check.setEnabled(false);
        puzzle = new JLabel("Puzzle");
        tries = new JLabel("Health: " + health);
        usedLetters = new JLabel("Used:");
        newGame = new JButton("New Game");
        
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(puzzle)
            .addComponent(usedLetters)
            .addComponent(tries)
            .addComponent(letter)
            .addComponent(check)
            .addComponent(newGame)
            .addComponent(invisibleLabel))
        );
        
        layout.setVerticalGroup(
        layout.createSequentialGroup()
            .addComponent(puzzle)
            .addComponent(usedLetters)
            .addComponent(tries)
            .addComponent(letter)
            .addComponent(check)
            .addComponent(newGame)
            .addComponent(invisibleLabel)
            );
        
        // invisibleLabel is made for compare letter with puzzle
        invisibleLabel.setVisible(false);
        
        letter.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                
                String c = (e.getKeyChar()) + "";
                if(!c.matches("^[a-zA-Z]+$"))
                    e.consume();
            }
        
        });
        
        
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              char[] puzzleChars = (invisibleLabel.getText()).toCharArray();
              char[] tryChar = (letter.getText().toLowerCase()).toCharArray();
              char[] changeLetter = puzzle.getText().toCharArray();
              
              for(int i = 0; i < changeLetter.length; i++)
              {
                  if(tryChar.length == 1 && puzzleChars[i] == tryChar[0])
                  {
                      changeLetter[i] = tryChar[0];
                      String formattedText2 = Arrays.toString(changeLetter)
                              .replace("[", "")
                              .replace("]", "")
                              .replace(",", "")
                              .replace(" ", "");
                             
                      puzzle.setText(formattedText2);
                      
                      //System.out.println(WordDraw.easyWord);
                  }
                  
                  else if(tryChar.length > 1 && invisibleLabel.getText().equals(letter.getText()))
                  {
                      puzzle.setText(letter.getText());
                        break;
                  }
                  
                  else if(tryChar.length == 0)
                  {
                      JOptionPane writeLetter = new JOptionPane();
                      JOptionPane.showMessageDialog(writeLetter, "Write a letter");
                      break;
                      
                              
                  }
              }
              
              
              //Health
              if(checkString == puzzle.getText() && tryChar.length !=0)
              {
                    health = --health;
                    tries.setText("Health: " + health);
                    
              }
              else
              {
                  checkString = puzzle.getText();
              }
              
              
              //Win or lose
              if(health == 0)
              {
                  JOptionPane gameOver = new JOptionPane();
                  JOptionPane.showMessageDialog(gameOver, "Game over");
                  puzzle.setText("Start New game");
                  usedLetters.setText("Used: ");
                  check.setEnabled(false);
                  
              } else if(puzzle.getText().equals(invisibleLabel.getText()))
              {
                  JOptionPane victory = new JOptionPane();
                  JOptionPane.showMessageDialog(victory, "Victory!");
                  check.setEnabled(false);    
              }
              
              
              usedLetters.setText(usedLetters.getText() + letter.getText() + ", " );
              letter.setText("");
              frame.pack();
            }
        });
        
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewGame().setVisible(true);
            }
        });
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    static int health = 5;
    static JTextField letter;
    static JButton check;
    static JButton newGame;
    static JLabel usedLetters;
    static JLabel tries;
    static JLabel invisibleLabel = new JLabel("");
    static JLabel puzzle;
    static String checkString;
    
    
    
    public static void main(String[] args) {
        new Main().setVisible(true);
        new NewGame().setVisible(true);
    }
}