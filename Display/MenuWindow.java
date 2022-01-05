package Display;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MenuWindow extends JFrame {
    private JButton fourPButton;
    private JLabel hLabel1;
    private JLabel hLabel2;
    private JLabel hLabel3;
    private JLabel hLabel4;
    private JPanel jPanel3;
    private JLabel nameLabel1;
    private JLabel nameLabel2;
    private JLabel nameLabel3;
    private JLabel nameLabel4;
    private JLabel pLabel1;
    private JLabel pLabel2;
    private JLabel pLabel3;
    private JLabel pLabel4;
    private JButton startButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField3;
    private JButton threePButton;
    private JLabel titleLabel;
    private JToggleButton toggleButton1;
    private JToggleButton toggleButton2;
    private JToggleButton toggleButton3;
    private JToggleButton toggleButton4;

    public MenuWindow() {
        try {
            Image img = ImageIO.read(new File("res/catan-promo-poster-small.jpg"));
            jPanel3 = new ImagePane(img, true);
        } catch (Exception e) {
            e.printStackTrace();
            jPanel3 = new JPanel();
        }
        titleLabel = new JLabel();
        threePButton = new JButton("3 PLAYERS");
        fourPButton = new JButton("4 PLAYERS");
        nameLabel1 = new JLabel("Name :");
        nameLabel2 = new JLabel("Name :");
        nameLabel3 = new JLabel("Name :");
        nameLabel4 = new JLabel("Name :");
        textField1 = new JTextField("Steve");
        textField2 = new JTextField("Peter");
        textField3 = new JTextField("Tony");
        textField4 = new JTextField("Natasha");
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
    
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(48, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 426,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(140, 140, 140)
                                                .addComponent(titleLabel)))
                                .addContainerGap(48, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(pLabel3)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGap(23, 23, 23)
                                                        .addGroup(jPanel3Layout
                                                                .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(hLabel3)
                                                                .addComponent(nameLabel3))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel3Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(textField3)
                                                                .addComponent(toggleButton3, GroupLayout.PREFERRED_SIZE,
                                                                        71, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(pLabel1)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGap(23, 23, 23)
                                                        .addGroup(jPanel3Layout
                                                                .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(hLabel1)
                                                                .addComponent(nameLabel1))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel3Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(textField1)
                                                                .addComponent(toggleButton1, GroupLayout.PREFERRED_SIZE,
                                                                        71, GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(threePButton, GroupLayout.PREFERRED_SIZE, 172,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pLabel2)
                                        .addComponent(pLabel4)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout
                                                                        .createParallelGroup(
                                                                                GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(hLabel2)
                                                                        .addComponent(nameLabel2))
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel3Layout
                                                                        .createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(textField2)
                                                                        .addComponent(toggleButton2,
                                                                                GroupLayout.PREFERRED_SIZE, 71,
                                                                                GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout
                                                                        .createParallelGroup(
                                                                                GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(hLabel4)
                                                                        .addComponent(nameLabel4))
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel3Layout
                                                                        .createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(textField4)
                                                                        .addComponent(toggleButton4,
                                                                                GroupLayout.PREFERRED_SIZE, 71,
                                                                                GroupLayout.PREFERRED_SIZE)))))
                                        .addComponent(fourPButton, GroupLayout.PREFERRED_SIZE, 172,
                                                GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addComponent(titleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(threePButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(fourPButton, GroupLayout.PREFERRED_SIZE, 54,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(pLabel1)
                                        .addComponent(pLabel2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel1)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameLabel2)
                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(hLabel1)
                                        .addComponent(toggleButton1)
                                        .addComponent(hLabel2)
                                        .addComponent(toggleButton2))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(pLabel3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nameLabel3)
                                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(hLabel3)
                                                        .addComponent(toggleButton3)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(pLabel4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nameLabel4)
                                                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(hLabel4)
                                                        .addComponent(toggleButton4))))
                                .addGap(67, 67, 67)
                                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)));
    
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    
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
            java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
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