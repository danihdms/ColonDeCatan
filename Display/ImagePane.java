package Display;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Game.*;
import Cards.*;

public class ImagePane extends JPanel {
    Image image;
    boolean fit;

    ImagePane(Image image) {
        this.image = image;
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    public static void appendObjects2(Game game, Player player) {
        Tile[][] tiles = game.getBoard().getTiles();
        int x = 0, y = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (tiles[i][j] == null) {
                    x+=2;
                } else {
                    if (tiles[i][j].getNo() != null) {
                        if (tiles[i][j].getNo().getType() == 0) {
                            try {
                                Image image = ImageIO.read(new File("res/colony.png"));
                                JStructure s = new JStructure(image, i, j, 0, "no");
                                s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                GameWindow.panels[y][x] = s;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (tiles[i][j].getNo().getType() == 1) {
                            try {
                                Image image = ImageIO.read(new File("res/city.png"));
                                JStructure s = new JStructure(image, i, j, 1, "no");
                                s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                GameWindow.panels[y][x] = s;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    x++;
                    if (tiles[i][j].getN() != null) {
                        JRoad r = new JRoad(i, j, "n");
                        r.setBackground(getColorRoad(tiles[i][j].getN()));
                        GameWindow.panels[y][x] = r;
                    }
                    x++;
                }
            }
            for (int j = 0; j < 7; j++) {
                if (tiles[i][j] == null) {
                    x+=2;
                } else {
                    if (tiles[i][j].getO() != null) {
                        JRoad r = new JRoad(i, j, "o");
                        r.setBackground(getColorRoad(tiles[i][j].getO()));
                        GameWindow.panels[y][x] = r;

                    }
                    x++;
                    try {
                        JTile tile = new JTile(getImageTypeTile(tiles[i][j]), false, i, j, tiles[i][j].getTypeTile());
                        GameWindow.panels[y][x] = tile;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    x++;
                }
            }
        }
    }

    public static void appendObjects(Game game, Player p) {
        Tile[][] tiles = game.getBoard().getTiles();
        int x = 0, y = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (tiles[i][j] != null) {
                    if (tiles[i][j].getNo() != null) {
                        if (tiles[i][j].getNo().getType() == 0) {
                            try {
                                Image image = ImageIO.read(new File("res/colony.png"));
                                JStructure s = new JStructure(image, i, j, 0, "no");
                                s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                /*
                                 * ResCard[] coutUpgrade = { new ResCard("blé"), new ResCard("blé"),
                                 * new ResCard("minerais"), new ResCard("minerais"), new ResCard("minerais") };
                                 * s.addMouseListener(new MouseEvent(){
                                 * 
                                 * 
                                 * if (game.getBoard().getTiles()[i][j].getStructure("no").getOwner() == p ){//
                                 * 
                                 * game.getBoard().getTiles()[i][j].getStructure("no").setType(1);
                                 * game.giveVictoryP(p);
                                 * p.nbCities--;
                                 * p.nbSettelments++;
                                 * game.PrendrePaiement(p, coutUpgrade);
                                 * 
                                 * }
                                 * 
                                 * });
                                 */
                                GameWindow.panels[y][x] = s;
                            } catch (Exception e) {
                                // this.add(new JPanel());

                                e.printStackTrace();
                            }
                        } else if (tiles[i][j].getNo().getType() == 1) {
                            try {
                                Image image = ImageIO.read(new File("res/city.png"));
                                JStructure s = new JStructure(image, i, j, 1, "no");
                                s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                GameWindow.panels[y][x] = s;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        /*
                         * JPanel c=new JPanel();
                         * ResCard[] coutStructure = { new ResCard("argile"), new ResCard("bois"), new
                         * ResCard("blé"),new ResCard("laine") };
                         * 
                         * game.getBoard().addStructure(i, j, new Structure(0,p), "no");
                         * game.PrendrePaiement(p, coutStructure);
                         * game.giveVictoryP(p);
                         */
                        // this.add(new JPanel());

                    }
                    x++;
                    if (tiles[i][j].getN() != null) {
                        JRoad r = new JRoad(i, j, "n");
                        r.setBackground(getColorRoad(tiles[i][j].getN()));
                        GameWindow.panels[y][x] = r;
                    } else {
                        /*
                         * JPanel n =new JPanel();
                         * ResCard[] coutRoad = { new ResCard("argile"), new ResCard("bois") };
                         * game.getBoard().addRoad(i,j, new Road(p),pos));
                         * p.nbRoads--;
                         * if (game.seeHasTheLonguest(p,i,j, pos)) {
                         * game.getBoard().rebootList();
                         * 
                         * }
                         * 
                         * game.PrendrePaiement(p, coutRoad);
                         */

                    }
                    x++;
                    if ((i == 0 && j == 0) || (i == 1 && j == 3) || (i == 2 && j == 4) || (i == 3 && j == 5)
                            || (i == 4 && j == 5) || (i == 5 && j == 5) || i == 6) {
                        if (tiles[i][j].getNe() != null) {

                            if (tiles[i][j].getNe().getType() == 0) {
                                try {
                                    Image image = ImageIO.read(new File("res/colony.png"));
                                    JStructure s = new JStructure(image, i, j, 0, "ne");
                                    s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                    ResCard[] coutUpgrade = { new ResCard("blé"), new ResCard("blé"),
                                            new ResCard("minerais"), new ResCard("minerais"), new ResCard("minerais") };
                                    // s.addActionListener(new MouseEvent() {
                                    // //pas oublier de verifier ressources
                                    // public static void actionPerformed(){

                                    // if (game.getBoard().getTiles()[i][j].getStructure("ne").getOwner() == p ){//
                                    // à changer
                                    // game.getBoard().getTiles()[i][j].getStructure("ne").setType(1);
                                    // game.giveVictoryP(p);
                                    // p.nbCities--;
                                    // p.nbSettelments++;
                                    // game.PrendrePaiement(p, coutUpgrade);

                                    // }
                                    // }

                                    // });

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            if (tiles[i][j].getNe().getType() == 1) {
                                try {
                                    Image image = ImageIO.read(new File("res/city.png"));
                                    JStructure s = new JStructure(image, i, j, 1, "ne");
                                    s.setBackground(getColorStructure(tiles[i][j].getNo()));

                                    GameWindow.panels[y][x] = s;

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {

                            /*
                             * JPanel c=new JPanel();
                             * ResCard[] coutStructure = { new ResCard("argile"), new ResCard("bois"), new
                             * ResCard("blé"),new ResCard("laine") };
                             * 
                             * game.getBoard().addStructure(i, j, new Structure(0,p), "no");
                             * game.PrendrePaiement(p, coutStructure);
                             * game.giveVictoryP(p);
                             */
                            // this.add(new JPanel());

                        }
                        x++;
                    }
                } else {
                    // this.add(new JPanel());
                    // this.add(new JPanel());
                    x += 2;
                }
                if (x == 15) {
                    x = 0;
                    y++;
                }
                ;
            }
            for (int j = 0; j < 7; j++) {
                if (tiles[i][j] != null) {
                    if (tiles[i][j].getO() != null) {
                        JRoad r = new JRoad(i, j, "o");
                        r.setBackground(getColorRoad(tiles[i][j].getO()));
                        GameWindow.panels[y][x] = r;

                    } else {
                        // this.add(new JPanel());

                    }
                    x++;
                    try {
                        JTile tile = new JTile(getImageTypeTile(tiles[i][j]), false, i, j, tiles[i][j].getTypeTile());
                        GameWindow.panels[y][x] = tile;

                    } catch (Exception e) {
                        // this.add(new JPanel());
                    }
                    x++;
                    if (i == 0 || (i == 1 && j == 3) || (i == 2 && j == 4) || (i == 3 && j == 5)
                            || (i == 4 && j == 5) || (i == 5 && j == 5) || i == 6) {
                        addLastColRoads(tiles[i][j], i, j);
                    }
                    x++;

                } else {
                    // this.add(new JPanel());
                    // this.add(new JPanel());
                    x += 2;
                }
                if (x >= 15) {
                    x = 0;
                    y++;
                }
                ;
            }
        }
    }

    public static Color getColorStructure(Structure s) {
        if (s != null) {

            switch (s.getOwner().getColor()) {
                case "red":
                    return new Color(255, 0, 0);
                case "blue":
                    return new Color(0, 0, 255);
                case "green":
                    return new Color(0, 255, 0);
                case "yellow":
                    return new Color(255, 255, 0);
                default:
                    return new Color(0, 0, 0);
            }
        }
        return new Color(255, 255, 255);
    }

    public static Color getColorRoad(Road r) {
        switch (r.getOwner().getColor()) {
            case "red":
                return new Color(255, 0, 0);
            case "blue":
                return new Color(0, 0, 255);
            case "green":
                return new Color(0, 255, 0);
            case "yellow":
                return new Color(255, 255, 0);
            default:
                return new Color(0, 0, 0);
        }
    }

    public static Image getImageTypeTile(Tile tile) {
        switch (tile.getTypeTile()) {
            case "colline":
                try {
                    return ImageIO.read(new File("res/colline.jpg"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "plaine":
                try {
                    return ImageIO.read(new File("res/plaine.jpg"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "foret":
                try {
                    return ImageIO.read(new File("res/foret.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "champ":
                try {
                    return ImageIO.read(new File("res/champ.jpg"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "montagne":
                try {
                    return ImageIO.read(new File("res/montagne.jpeg"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "desert":
                try {
                    return ImageIO.read(new File("res/error.jpg"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        return null;
    }

    public static void addLastColRoads(Tile tile, int i, int j) {
        if (tile.getE() != null) {
            JRoad r = new JRoad(i, j, "e");
            r.setBackground(getColorRoad(tile.getE()));
            GameWindow.panels[i][j] = r;
        }
    }

}