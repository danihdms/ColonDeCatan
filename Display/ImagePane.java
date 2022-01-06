package Display;

import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import Game.*;

public class ImagePane extends JPanel {
    Image image;

    ImagePane(Image image) {
        this.image = image;
        setLayout(new BorderLayout());
    }

    public void appendObjects(Game game) {
        Tile[][] tiles = game.getBoard().getTiles();
        for (int i = 0; i < 7; i++) {
            // Premiere boucle sur lune ligne de tuiles
            for (int j = 0; j < 7; j++) {
                if (tiles[i][j] != null) {
                    // AJout de la colonie du Nord Ouest
                    if (tiles[i][j].getNo() != null) {
                        if (tiles[i][j].getNo().getType() == 0) {
                            try {
                                Image image = ImageIO.read(new File("res/colony.png"));
                                JStructure s = new JStructure(image, true, i, j, "no", 0);
                                s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                this.add(s);
                            } catch (Exception e) {
                                this.add(new JButton());
                                e.printStackTrace();
                            }
                        } else if (tiles[i][j].getNo().getType() == 1) {
                            try {
                                Image image = ImageIO.read(new File("res/city.png"));
                                JStructure s = new JStructure(image, false, i, j, "no", 1);
                                s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                this.add(s);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        JStructure s = new JStructure(image, true, i, j, "no", -1);
                        this.add(s);
                    }
                    // AJout de la route du nord
                    if (tiles[i][j].getN() != null) {
                        JRoad r = new JRoad(i, j, "horizontal", false);
                        r.setBackground(getColorRoad(tiles[i][j].getN()));
                        this.add(r);

                    } else {
                        JRoad r = new JRoad(i, j, "horizontal", true);
                        this.add(r);

                    }
                    // Ajout de la colonie du nord ouest dans les cas exceptionnels
                    if ((i == 0 && j == 0) || (i == 1 && j == 3) || (i == 2 && j == 4) || (i == 3 && j == 5)
                            || (i == 4 && j == 5) || (i == 5 && j == 5) || i == 6) {
                        if (tiles[i][j].getNe() != null) {

                            if (tiles[i][j].getNe().getType() == 0) {
                                try {
                                    Image image = ImageIO.read(new File("res/colony.png"));
                                    JStructure s = new JStructure(image, true, i, j, "ne", 0);
                                    s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                    this.add(s);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            if (tiles[i][j].getNe().getType() == 1) {
                                try {
                                    Image image = ImageIO.read(new File("res/city.png"));
                                    JStructure s = new JStructure(image, false, i, j, "ne", 1);
                                    s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                    this.add(s);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            JStructure s = new JStructure(image, true, i, j, "ne", -1);
                            this.add(s);
                        }
                    }
                    // Ajout des colonies du sud ouest dans les cas exceptionnels
                    if ((i == 3 && j == 1) || (i == 4 && j == 2) || (i == 5 && j == 3) || (i == 5 && j == 4)
                            || (i == 5 && j == 5)) {
                        if (tiles[i][j].getSo() != null) {

                            if (tiles[i][j].getSo().getType() == 0) {
                                try {
                                    Image image = ImageIO.read(new File("res/colony.png"));
                                    JStructure s = new JStructure(image, true, i, j, "so", 0);
                                    s.setBackground(getColorStructure(tiles[i][j].getSe()));
                                    this.add(s);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            if (tiles[i][j].getSo().getType() == 1) {
                                try {
                                    Image image = ImageIO.read(new File("res/city.png"));
                                    JStructure s = new JStructure(image, false, i, j, "so", 1);
                                    s.setBackground(getColorStructure(tiles[i][j].getSo()));
                                    this.add(s);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            JStructure s = new JStructure(image, true, i, j, "so", -1);
                            this.add(s);
                        }
                    }
                    // Ajout de la colonie du sud est de la derniere case du tableau
                    if (tiles[5][5].getSe() != null) {
                        if (tiles[5][5].getSe().getType() == 0) {
                            try {
                                Image image = ImageIO.read(new File("res/colony.png"));
                                JStructure s = new JStructure(image, true, 5, 5, "se", 0);
                                s.setBackground(getColorStructure(tiles[5][5].getSe()));
                                this.add(s);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (tiles[5][5].getSe().getType() == 1) {
                            try {
                                Image image = ImageIO.read(new File("res/city.png"));
                                JStructure s = new JStructure(image, false, 5, 5, "se", 1);
                                s.setBackground(getColorStructure(tiles[5][5].getSe()));
                                this.add(s);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    } else {
                        JStructure s = new JStructure(image, true, 5, 5, "se", -1);
                        this.add(s);
                    }
                } else {
                    // Si la tuile est nulle, on met un panel de la couleur de l'arriere plan
                    try {
                        this.add(new ImagePane(ImageIO.read(new File("res/ocean.jpg"))));
                        this.add(new ImagePane(ImageIO.read(new File("res/ocean.jpg"))));
                    } catch (Exception e) {
                        this.add(new JPanel());
                        this.add(new JPanel());
                        e.printStackTrace();
                    }
                }
            }
            // Deuxieme boucle sur la ligne de tuiles
            for (int j = 0; j < 7; j++) {
                if (tiles[i][j] != null) {
                    if (tiles[i][j].getO() != null) {
                        JRoad r = new JRoad(i, j, "o", false);
                        r.setBackground(getColorRoad(tiles[i][j].getO()));
                        this.add(r);

                    } else {
                        JRoad r = new JRoad(i, j, "o", true);

                        this.add(r);

                    }

                    try {
                        JTile tile = new JTile(getImageTypeTile(tiles[i][j]), false, i, j, tiles[i][j].getTypeTile());
                        this.add(tile);
                    } catch (Exception e) {
                        this.add(new JButton());
                    }
                    if (i == 0 || (i == 1 && j == 3) || (i == 2 && j == 4) || (i == 3 && j == 5)
                            || (i == 4 && j == 5) || (i == 5 && j == 5) || i == 6) {
                        addLastColRoads(tiles[i][j], i, j);
                    }
                    if (tiles[i][j].getE() != null) {
                        JRoad r = new JRoad(i, j, "e", false);
                        r.setBackground(getColorRoad(tiles[i][j].getE()));
                        this.add(r);

                    } else {
                        JRoad r = new JRoad(i, j, "e", true);
                        this.add(r);

                    }
                } else {
                    try {
                        this.add(new ImagePane(ImageIO.read(new File("res/ocean.jpg"))));
                        this.add(new ImagePane(ImageIO.read(new File("res/ocean.jpg"))));
                    } catch (Exception e) {
                        this.add(new JPanel());
                        this.add(new JPanel());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // clique road -> crée
    // clique sur un panel colonie sois add soit upgrade
    // tuile posé le voleur
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

    public void addLastColRoads(Tile tile, int i, int j) {
        if (tile.getE() != null) {
            JRoad r = new JRoad(i, j, "vertical", false);
            r.setBackground(getColorRoad(tile.getE()));
            this.add(r);
        } else {
            this.add(new JRoad(i, j, "vertical", true));
        }
    }
}