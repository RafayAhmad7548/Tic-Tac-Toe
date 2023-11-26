import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener{

    JFrame mainFrame;
    Panel panel;
    static JFrame restartFrame;
    static JButton restartButton;
    static JLabel winnerLabel;
    static boolean dispose;
    

    public TicTacToe(){

        mainFrame = new JFrame("Tic-Tac-Toe");
        panel = new Panel();
        restartFrame = new JFrame("Play Again?");
        restartButton = new JButton("Play again?");
        winnerLabel = new JLabel();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setTitle("Tic-Tac-Toe");
        mainFrame.setResizable(false);
        mainFrame.setLocation(660, 240);

        mainFrame.add(panel);
        mainFrame.pack();

        restartButton.addActionListener(this);
        restartButton.setPreferredSize(new Dimension(200, 50));

        winnerLabel.setFont(new Font(null, 0, 25));
        winnerLabel.setPreferredSize(new Dimension(250, 100));
        winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        restartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        restartFrame.setLayout(new FlowLayout());
        restartFrame.setPreferredSize(new Dimension(350, 250));
        restartFrame.setLocation(785, 415);
        restartFrame.setResizable(false);

        restartFrame.add(winnerLabel);
        restartFrame.add(restartButton);
        restartFrame.pack();
    
    }
    public static void main(String[] args) {
        new TicTacToe();
    }
    
    public void actionPerformed(ActionEvent e) {
        restartFrame.dispose();
        new TicTacToe();
        mainFrame.dispose();
        
    }
}