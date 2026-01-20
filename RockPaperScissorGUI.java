
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RockPaperScissorGUI extends JFrame implements ActionListener {

    private JButton rockBtn, paperBtn, scissorBtn;
    private JLabel resultLabel, playerLabel, computerLabel;
    private Random random = new Random();
    private String[] choices = {"rock", "paper", "scissor"};

    public RockPaperScissorGUI() {
        setTitle("Rock Paper Scissor Game");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));
        mainPanel.setBackground(new Color(214, 234, 248)); 

        JLabel title = new JLabel("WELCOME TO THE GAME ROCK PAPER SCISSOR", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(title);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(214, 234, 248)); 
        rockBtn = new JButton("Rock");
        paperBtn = new JButton("Paper");
        scissorBtn = new JButton("Scissor");

        rockBtn.addActionListener(this);
        paperBtn.addActionListener(this);
        scissorBtn.addActionListener(this);

        buttonPanel.add(rockBtn);
        buttonPanel.add(paperBtn);
        buttonPanel.add(scissorBtn);

        mainPanel.add(buttonPanel);

        playerLabel = new JLabel("You chose: ", SwingConstants.CENTER);
        computerLabel = new JLabel("Computer chose: ", SwingConstants.CENTER);
        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);

        mainPanel.add(playerLabel);
        mainPanel.add(computerLabel);
        mainPanel.add(resultLabel);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String playerchoice = "";
        if (e.getSource() == rockBtn) playerchoice = "rock";
        if (e.getSource() == paperBtn) playerchoice = "paper";
        if (e.getSource() == scissorBtn) playerchoice = "scissor";

        String computerchoice = choices[random.nextInt(3)];

        playerLabel.setText("You chose: " + playerchoice);
        computerLabel.setText("Computer chose: " + computerchoice);

        String result;

        if (playerchoice.equals(computerchoice)) {
            result = "It is a Tie!";
        } else if (
                (playerchoice.equals("rock") && computerchoice.equals("scissor")) ||
                (playerchoice.equals("paper") && computerchoice.equals("rock")) ||
                (playerchoice.equals("scissor") && computerchoice.equals("paper"))
        ) {
            result = "You Win!";
        } else {
            result = "Computer Wins!";
        }

        resultLabel.setText("Result: " + result);
    }

    public static void main(String[] args) {
        new RockPaperScissorGUI();
    }
}
