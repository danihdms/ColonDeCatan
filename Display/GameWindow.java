package Display;

import javax.imageio.ImageIO;
import javax.swing.*;

import Game.*;

import java.awt.*;
import java.io.File;

public class GameWindow extends JFrame {

        private JButton addRoadButton;
        private JButton addStructureButton;
        private JPanel boardPanel;
        private JList<String> cardsList;
        private JPanel centralPanel;
        private JScrollPane jScrollPane1;
        private JPanel menuPanel;
        private JButton pickCardButton;
        private JPanel playersPanel;
        private JButton upgradeButton;

        static JPanel[][] panels;

        public GameWindow(Game game) {
                panels = new JPanel[15][15];

                while (!game.endGame()) {
                        this.getContentPane().setBackground(new Color(0, 0, 0));
                        try {
                                Image menuImage = ImageIO.read(new File("res/old_map_vintage_background.jpg"));
                                menuPanel = new ImagePane(menuImage);

                                Image centralImage = ImageIO.read(new File("res/ocean.jpg"));
                                centralPanel = new ImagePane(centralImage);
                                boardPanel = new ImagePane(centralImage);

                                Image playersImage = ImageIO.read(new File("res/old_map_vintage_background.jpg"));
                                playersPanel = new ImagePane(playersImage);

                        } catch (Exception e) {
                                e.printStackTrace();
                                menuPanel = new JPanel();
                                menuPanel.setBackground(new Color(168, 121, 50));
                                centralPanel = new JPanel();
                                centralPanel.setBackground(new Color(45, 12, 232));
                                playersPanel = new JPanel();
                                playersPanel.setBackground(new Color(138, 46, 0));
                        }

                        jScrollPane1 = new JScrollPane();
                        cardsList = new JList<>();
                        addStructureButton = new JButton("Add Structure");
                        addStructureButton.addActionListener(e -> {
                                // TODO
                        });
                        addRoadButton = new JButton("Add Road");
                        addRoadButton.addActionListener(e -> {
                                // TODO
                        });
                        upgradeButton = new JButton("Upgrade Colony");
                        upgradeButton.addActionListener(e -> {
                                // TODO
                        });
                        pickCardButton = new JButton("Pick Card");
                        pickCardButton.addActionListener(e -> {
                                // TODO
                        });
                        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                        cardsList.setModel(new AbstractListModel<String>() {
                                String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

                                public int getSize() {
                                        return strings.length;
                                }

                                public String getElementAt(int i) {
                                        return strings[i];
                                }
                        });
                        jScrollPane1.setViewportView(cardsList);

                        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
                        menuPanel.setLayout(menuPanelLayout);
                        menuPanelLayout.setHorizontalGroup(
                                        menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addGroup(menuPanelLayout.createParallelGroup(
                                                                                        GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jScrollPane1)
                                                                                        .addComponent(addStructureButton,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        Short.MAX_VALUE)
                                                                                        .addComponent(addRoadButton,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        153,
                                                                                                        Short.MAX_VALUE)
                                                                                        .addComponent(upgradeButton,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        153,
                                                                                                        Short.MAX_VALUE)
                                                                                        .addComponent(pickCardButton,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        153,
                                                                                                        Short.MAX_VALUE))
                                                                        .addContainerGap()));
                        menuPanelLayout.setVerticalGroup(
                                        menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                                        .addContainerGap(205, Short.MAX_VALUE)
                                                                        .addComponent(jScrollPane1,
                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                        216, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(addStructureButton)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(addRoadButton)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(upgradeButton)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(pickCardButton)
                                                                        .addContainerGap(206, Short.MAX_VALUE)));

                        GroupLayout playersPanelLayout = new GroupLayout(playersPanel);
                        playersPanel.setLayout(playersPanelLayout);
                        playersPanelLayout.setHorizontalGroup(
                                        playersPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGap(0, 0, Short.MAX_VALUE));
                        playersPanelLayout.setVerticalGroup(
                                        playersPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGap(0, 135, Short.MAX_VALUE));

                        boardPanel.setLayout(new GridLayout(0, 15, 1, 1));
                        ((ImagePane) boardPanel).appendObjects(game);

                        GroupLayout centralPanelLayout = new GroupLayout(centralPanel);
                        centralPanel.setLayout(centralPanelLayout);
                        centralPanelLayout.setHorizontalGroup(
                                        centralPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(centralPanelLayout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addComponent(boardPanel,
                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                        .addContainerGap()));
                        centralPanelLayout.setVerticalGroup(
                                        centralPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(centralPanelLayout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addComponent(boardPanel,
                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                        .addContainerGap()));

                        GroupLayout layout = new GroupLayout(getContentPane());
                        getContentPane().setLayout(layout);
                        layout.setHorizontalGroup(
                                        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout
                                                                        .createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(
                                                                                        GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(centralPanel,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        Short.MAX_VALUE)
                                                                                        .addComponent(playersPanel,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        Short.MAX_VALUE))
                                                                        .addPreferredGap(
                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(menuPanel,
                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                        GroupLayout.PREFERRED_SIZE)));
                        layout.setVerticalGroup(
                                        layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(playersPanel,
                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(centralPanel,
                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE))
                                                        .addComponent(menuPanel, GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                        pack();
                        this.setSize(new Dimension(1000, 800));
                        this.setLocationRelativeTo(null);
                }
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
                        java.util.logging.Logger.getLogger(GameWindow.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(GameWindow.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(GameWindow.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(GameWindow.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
        }

}
