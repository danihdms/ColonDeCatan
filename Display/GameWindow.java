package Display;

import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameWindow extends JFrame {

    private JButton addStructButton;
    private JButton addRoadButton;
    private JButton upgradeButton;
    private JButton pickCardButton;
    private JList<String> jList1;
    private JPanel menuPanel;
    private JPanel boardPanel;
    private JPanel playersPanel;
    private JScrollPane jScrollPane1;
    // End of variables declaration

    public GameWindow() {
        initComponents();
    }

    private void initComponents() {
        this.getContentPane().setBackground(new Color(0,0,0));
        try {
            Image menuImage = ImageIO.read(new File("res/old_map_vintage_background.jpg"));
            menuPanel = new ImagePane(menuImage, true);

            Image boardImage = ImageIO.read(new File("res/ocean.jpg"));
            boardPanel = new ImagePane(boardImage, false);

            Image playersImage = ImageIO.read(new File("res/old_map_vintage_background.jpg"));
            playersPanel = new ImagePane(playersImage, true);
        } catch (Exception e) {
            e.printStackTrace();
            menuPanel = new JPanel();
            menuPanel.setBackground(new Color(168, 121, 50));
            boardPanel = new JPanel();
            boardPanel.setBackground(new Color(45, 12, 232));
            playersPanel = new JPanel();
            playersPanel.setBackground(new Color(138, 46, 0));
        }
        
        jScrollPane1 = new JScrollPane();
        jList1 = new JList<>();
        addStructButton = new JButton("addStructButton");
        addRoadButton = new JButton("addRoadButton");
        upgradeButton = new JButton("upgradeButton");
        pickCardButton = new JButton("Pick a card");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jList1.setModel(new AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(jList1);

        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(upgradeButton)
                                        .addComponent(addRoadButton)
                                        .addComponent(addStructButton)
                                        .addComponent(pickCardButton))
                                .addContainerGap(45, Short.MAX_VALUE)));
        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addStructButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addRoadButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(upgradeButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pickCardButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        GroupLayout boardPanelLayout = new GroupLayout(boardPanel);
        boardPanel.setLayout(boardPanelLayout);
        boardPanelLayout.setHorizontalGroup(
                boardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 500, Short.MAX_VALUE));
        boardPanelLayout.setVerticalGroup(
                boardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 550, Short.MAX_VALUE));

        GroupLayout playersPanelLayout = new GroupLayout(playersPanel);
        playersPanel.setLayout(playersPanelLayout);
        playersPanelLayout.setHorizontalGroup(
                playersPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 125, Short.MAX_VALUE));
        playersPanelLayout.setVerticalGroup(
                playersPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 125, Short.MAX_VALUE));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(boardPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(playersPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(1,1,1)
                                .addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(playersPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addGap(1,1,1)
                                .addComponent(boardPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addGap(1,1,1)));

        pack();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameWindow().setVisible(true);
            }
        });
    }
}