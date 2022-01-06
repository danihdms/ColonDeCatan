package Display;

import javax.imageio.ImageIO;
import javax.swing.*;

import Game.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MenuWindow extends JFrame {
        private static JButton fourPButton;
        private static JLabel hLabel1;
        private static JLabel hLabel2;
        private static JLabel hLabel3;
        private static JLabel hLabel4;
        private static JPanel jPanel3;
        private static JLabel nameLabel1;
        private static JLabel nameLabel2;
        private static JLabel nameLabel3;
        private static JLabel nameLabel4;
        private static JLabel pLabel1;
        private static JLabel pLabel2;
        private static JLabel pLabel3;
        private static JLabel pLabel4;
        private static JButton startButton;
        private static JTextField textField1;
        private static JTextField textField2;
        private static JTextField textField4;
        private static JTextField textField3;
        private static JButton threePButton;
        private static JLabel titleLabel;
        private static JToggleButton toggleButton1;
        private static JToggleButton toggleButton2;
        private static JToggleButton toggleButton3;
        private static JToggleButton toggleButton4;

        private static Player[] players;

        public MenuWindow() {

                players = new Player[4];
                try {
                        Image img = ImageIO.read(new File("res/catan-promo-poster-small.jpg"));
                        jPanel3 = new ImagePane(img);
                } catch (Exception e) {
                        e.printStackTrace();
                        jPanel3 = new JPanel();
                }
                titleLabel = new JLabel();
                nameLabel1 = new JLabel("Name :");
                nameLabel2 = new JLabel("Name :");
                nameLabel3 = new JLabel("Name :");
                nameLabel4 = new JLabel("Name :");
                textField1 = new JTextField("Steve");
                textField2 = new JTextField("Tony");
                textField3 = new JTextField("Natasha");
                textField4 = new JTextField("Peter");
                hLabel1 = new JLabel("Human ?");
                hLabel2 = new JLabel("Human ?");
                hLabel3 = new JLabel("Human ?");
                hLabel4 = new JLabel("Human ?");
                pLabel1 = new JLabel("Player 1");
                pLabel2 = new JLabel("Player 2");
                pLabel3 = new JLabel("Player 3");
                pLabel4 = new JLabel("Player 4");
                toggleButton1 = new JToggleButton("Yes");
                toggleButton2 = new JToggleButton("Yes");
                toggleButton3 = new JToggleButton("Yes");
                toggleButton4 = new JToggleButton("Yes");
                startButton = new JButton("START");

                threePButton = new JButton("3 PLAYERS");
                threePButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                MenuWindow.players = new Player[3];
                                MenuWindow.nameLabel4.setVisible(false);
                                MenuWindow.textField4.setVisible(false);
                                MenuWindow.hLabel4.setVisible(false);
                                MenuWindow.toggleButton4.setVisible(false);
                                MenuWindow.pLabel4.setVisible(false);
                        }
                });

                fourPButton = new JButton("4 PLAYERS");
                fourPButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                MenuWindow.players = new Player[4];
                                MenuWindow.nameLabel4.setVisible(true);
                                MenuWindow.textField4.setVisible(true);
                                MenuWindow.hLabel4.setVisible(true);
                                MenuWindow.toggleButton4.setVisible(true);
                                MenuWindow.pLabel4.setVisible(true);
                        }
                });
                toggleButton1.addActionListener(e -> {
                        if(toggleButton1.getText().equals("Yes")){
                                toggleButton1.setText("No");
                        } else {
                                toggleButton1.setText("Yes");
                        }
                });
                toggleButton2.addActionListener(e -> {
                        if(toggleButton2.getText().equals("Yes")){
                                toggleButton2.setText("No");
                        } else {
                                toggleButton2.setText("Yes");
                        }
                });toggleButton3.addActionListener(e -> {
                        if(toggleButton3.getText().equals("Yes")){
                                toggleButton3.setText("No");
                        } else {
                                toggleButton3.setText("Yes");
                        }
                });toggleButton4.addActionListener(e -> {
                        if(toggleButton4.getText().equals("Yes")){
                                toggleButton4.setText("No");
                        } else {
                                toggleButton4.setText("Yes");
                        }
                });
                startButton.addActionListener(e -> {
                        int i = 0;
                        JToggleButton[] toggleButtons = { toggleButton1, toggleButton2, toggleButton3, toggleButton4 };
                        JTextField[] textFields = { textField1, textField2, textField3, textField4 };

                        for (Player p : MenuWindow.players) {
                                boolean human = false;
                                if (toggleButtons[i].getText().equals("Yes"))
                                        human = true;
                                p = new Player(textFields[i].getText(), "blue", human);
                                i++;
                        }

                        GameWindow gameWindow = new GameWindow(new Game(MenuWindow.players));
                        java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                        gameWindow.setVisible(true);
                                        dispose();
                                }
                        });
                });

                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap(48, Short.MAX_VALUE)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(startButton,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                426,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel3Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(140, 140, 140)
                                                                                                .addComponent(titleLabel)))
                                                                .addContainerGap(48, Short.MAX_VALUE))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.TRAILING, false)
                                                                                .addGroup(jPanel3Layout
                                                                                                .createParallelGroup(
                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(pLabel3)
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(23, 23, 23)
                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(hLabel3)
                                                                                                                                .addComponent(nameLabel3))
                                                                                                                .addPreferredGap(
                                                                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                .addComponent(textField3)
                                                                                                                                .addComponent(toggleButton3,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                71,
                                                                                                                                                GroupLayout.PREFERRED_SIZE))))
                                                                                .addGroup(jPanel3Layout
                                                                                                .createParallelGroup(
                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(pLabel1)
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(23, 23, 23)
                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(hLabel1)
                                                                                                                                .addComponent(nameLabel1))
                                                                                                                .addPreferredGap(
                                                                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                .addComponent(textField1)
                                                                                                                                .addComponent(toggleButton1,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                71,
                                                                                                                                                GroupLayout.PREFERRED_SIZE))))
                                                                                .addComponent(threePButton,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(pLabel2)
                                                                                .addComponent(pLabel4)
                                                                                .addGroup(jPanel3Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(23, 23, 23)
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                GroupLayout.Alignment.TRAILING)
                                                                                                                                                .addComponent(hLabel2)
                                                                                                                                                .addComponent(nameLabel2))
                                                                                                                                .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                                                                false)
                                                                                                                                                .addComponent(textField2)
                                                                                                                                                .addComponent(toggleButton2,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                71,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                GroupLayout.Alignment.TRAILING)
                                                                                                                                                .addComponent(hLabel4)
                                                                                                                                                .addComponent(nameLabel4))
                                                                                                                                .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                                                                false)
                                                                                                                                                .addComponent(textField4)
                                                                                                                                                .addComponent(toggleButton4,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                71,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)))))
                                                                                .addComponent(fourPButton,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap(10, Short.MAX_VALUE)
                                                                .addComponent(titleLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                                57, Short.MAX_VALUE)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(threePButton,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(fourPButton,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                54,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(pLabel1)
                                                                                .addComponent(pLabel2))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(nameLabel1)
                                                                                .addComponent(textField1,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(nameLabel2)
                                                                                .addComponent(textField2,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(hLabel1)
                                                                                .addComponent(toggleButton1)
                                                                                .addComponent(hLabel2)
                                                                                .addComponent(toggleButton2))
                                                                .addGap(27, 27, 27)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel3Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(pLabel3)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(nameLabel3)
                                                                                                                .addComponent(textField3,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(hLabel3)
                                                                                                                .addComponent(toggleButton3)))
                                                                                .addGroup(jPanel3Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(pLabel4)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(nameLabel4)
                                                                                                                .addComponent(textField4,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(hLabel4)
                                                                                                                .addComponent(toggleButton4))))
                                                                .addGap(67, 67, 67)
                                                                .addComponent(startButton, GroupLayout.PREFERRED_SIZE,
                                                                                80, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)));

                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
                this.setSize(new Dimension(845, 760));
                this.setLocationRelativeTo(null);
        }

        public static void main(String args[]) {
                try {
                        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new MenuWindow().setVisible(true);
                        }
                });
        }

}