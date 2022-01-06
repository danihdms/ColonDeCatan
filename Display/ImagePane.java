package Display;

import java.awt.*;
import java.io.File;
import java.nio.file.NoSuchFileException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Game.*;

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

    public void appendObjects(Game game) {
        Tile[][] tiles = game.getBoard().getTiles();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (tiles[i][j] != null) {
                    if (tiles[i][j].getNo() != null) {
                        if (tiles[i][j].getNo().getType() == 0) {
                            try {
                                Image image = ImageIO.read(new File("res/colony.png"));
                                JStructure s = new JStructure(image, true, i, j, 0);
                                s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                this.add(s);
                            } catch (Exception e) {
                                this.add(new JPanel());
                                e.printStackTrace();
                            }
                        } else if (tiles[i][j].getNo().getType() == 1) {
                            try {
                                Image image = ImageIO.read(new File("res/city.png"));
                                JStructure s = new JStructure(image, true, i, j, 1);
                                s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                this.add(s);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        this.add(new JPanel());
                    }
                    if (tiles[i][j].getN() != null) {
                        JRoad r = new JRoad(i, j, "horizontal");
                        r.setBackground(getColorRoad(tiles[i][j].getN()));
                        this.add(r);

                    } else {
                        this.add(new JPanel());

                    }
                    if ((i == 0 && j == 0)|| (i == 1 && j == 3) || (i == 2 && j == 4) || (i == 3 && j == 5)
                            || (i == 4 && j == 5) || (i == 5 && j == 5) || i == 6) {
                        if (tiles[i][j].getNe() != null) {

                            if (tiles[i][j].getNe().getType() == 0) {
                                try {
                                    Image image = ImageIO.read(new File("res/colony.png"));
                                    JStructure s = new JStructure(image, true, i, j, 0);
                                    s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                    this.add(s);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            if (tiles[i][j].getNe().getType() == 1) {
                                try {
                                    Image image = ImageIO.read(new File("res/city.png"));
                                    JStructure s = new JStructure(image, true, i, j, 1);
                                    s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                    this.add(s);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            this.add(new JPanel());
                        }
                    }
                } else {
                    this.add(new JPanel());
                    this.add(new JPanel());
                }
            }
            for (int j = 0; j < 7; j++) {
                if (tiles[i][j] != null) {
                    if (tiles[i][j].getO() != null) {
                        JRoad r = new JRoad(i, j, "vertical");
                        r.setBackground(getColorRoad(tiles[i][j].getO()));
                        this.add(r);

                    } else {
                        this.add(new JPanel());

                    }

                    try {
                        JTile tile = new JTile(getImageTypeTile(tiles[i][j]), false, i, j, tiles[i][j].getTypeTile());
                        this.add(tile);
                    } catch (Exception e) {
                        this.add(new JPanel());
                    }
                    if (i == 0 || (i == 1 && j == 3) || (i == 2 && j == 4) || (i == 3 && j == 5)
                            || (i == 4 && j == 5) || (i == 5 && j == 5) || i == 6) {
                        addLastColRoads(tiles[i][j], i, j);
                    }
                    if (i == 15) {
                        if (tiles[i][j].getE() != null) {
                            JRoad r = new JRoad(i, j, "vertical");
                            r.setBackground(getColorRoad(tiles[i][j].getE()));
                            this.add(r);

                        } else {
                            this.add(new JPanel());

                        }
                    }
                } else {
                    this.add(new JPanel());
                    this.add(new JPanel());
                }
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

    public void addLastColRoads(Tile tile, int i, int j) {
        if (tile.getE() != null) {
            JRoad r = new JRoad(i, j, "vertical");
            r.setBackground(getColorRoad(tile.getE()));
            this.add(r);
        } else {
            this.add(new JRoad(i, j, "vertical"));
        }
    }

}