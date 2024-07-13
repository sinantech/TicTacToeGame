import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(Color.BLACK);
        text_field.setForeground(Color.ORANGE);
        text_field.setFont(new Font("Ink Free", Font.BOLD, 75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic Tac Toe");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().isEmpty()) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("X");
                        player1_turn = false;
                        text_field.setText("O Turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().isEmpty()) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("O");
                        player1_turn = true;
                        text_field.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            text_field.setText("X Turn");
        } else {
            player1_turn = false;
            text_field.setText("O Turn");
        }

    }

    public void check() {

        // X wins conditions

        if ((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
            xWins(0, 1, 2);
        }
        if ((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))) {
            xWins(3, 4, 5);
        }
        if ((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(6, 7, 8);
        }
        if ((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(0, 3, 6);
        }
        if ((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
            xWins(1, 4, 7);
        }
        if ((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(2, 5, 8);
        }
        if ((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(0, 4, 8);
        }
        if ((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(0, 4, 6);
        }

        // O wins conditions

        if ((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))) {
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(6, 7, 8);
        }
        if ((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(0, 3, 6);
        }
        if ((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))) {
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(2, 5, 8);
        }
        if ((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(0, 4, 8);
        }
        if ((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(0, 4, 6);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.MAGENTA);
        buttons[b].setBackground(Color.MAGENTA);
        buttons[c].setBackground(Color.MAGENTA);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("X Wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.MAGENTA);
        buttons[b].setBackground(Color.MAGENTA);
        buttons[c].setBackground(Color.MAGENTA);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("O Wins");
    }

}
