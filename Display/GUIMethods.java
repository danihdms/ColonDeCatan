package Display;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.NoSuchFileException;

import Game.*;

public interface GUIMethods {

    public static GridBagLayout appendObjects(Game game, JPanel panel) {
        GridBagLayout gbl = new GridBagLayout();
        panel.setLayout(gbl);
        GridBagConstraints gc = new GridBagConstraints();
        Tile[][] tiles = game.getBoard().getTiles();
        int x = 0, y = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] != null) {
                    if (tiles[i][j].getNo() != null) {
                        gc.weightx = 0.2;
                        gc.weighty = 0.2;
                        gc.gridx = x;
                        gc.gridy = y;
                        if (tiles[i][j].getNo().getType() == 0) {
                            try {
                                Image image = ImageIO.read(new File("res/colony.jpg"));
                                JStructure s = new JStructure(image, true, x, y, 0);
                                s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                panel.add(s);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (tiles[i][j].getNo().getType() == 1) {
                            try {
                                Image image = ImageIO.read(new File("res/city.jpg"));
                                JStructure s = new JStructure(image, true, x, y, 1);
                                s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                panel.add(s);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        x++;
                    } else {
                        gc.weightx = 0.2;
                        gc.weighty = 0.2;
                        gc.gridx = x;
                        gc.gridy = y;
                        panel.add(new JPanel());
                        x++;
                    }
                    if (tiles[i][j].getN() != null) {
                        gc.weightx = 0.8;
                        gc.weighty = 0.2;
                        gc.gridx = x;
                        gc.gridy = y;
                        JRoad r = new JRoad(x, y, "horizontal");
                        r.setBackground(getColorRoad(tiles[i][j].getN()));
                        panel.add(r);
                        x++;
                    } else {
                        gc.weightx = 0.8;
                        gc.weighty = 0.2;
                        gc.gridx = x;
                        gc.gridy = y;
                        panel.add(new JPanel());
                        x++;
                    }
                    if (x == 15) {
                        if (tiles[i][j].getNe() != null) {
                            gc.weightx = 0.2;
                            gc.weighty = 0.2;
                            gc.gridx = x;
                            gc.gridy = y;
                            if (tiles[i][j].getNe().getType() == 0) {
                                try {
                                    Image image = ImageIO.read(new File("res/colony.jpg"));
                                    JStructure s = new JStructure(image, true, x, y, 0);
                                    s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                    panel.add(s);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            if (tiles[i][j].getNo().getType() == 1) {
                                try {
                                    Image image = ImageIO.read(new File("res/city.jpg"));
                                    JStructure s = new JStructure(image, true, x, y, 1);
                                    s.setBackground(getColorStructure(tiles[i][j].getNo()));
                                    panel.add(s);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            x = 0;
                        } else {
                            gc.weightx = 0.2;
                            gc.weighty = 0.2;
                            gc.gridx = x;
                            gc.gridy = y;
                            panel.add(new JPanel());
                            x = 0;
                        }
                    }
                } else {
                    gc.weightx = 1;
                    gc.weighty = 1;
                    gc.gridx = x;
                    gc.gridy = y;
                    panel.add(new JPanel());
                }
            }
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] != null) {
                    if (tiles[i][j].getO() != null) {
                        gc.weightx = 0.2;
                        gc.weighty = 0.8;
                        gc.gridx = x;
                        gc.gridy = y;
                        JRoad r = new JRoad(x, y, "vertical");
                        r.setBackground(getColorRoad(tiles[i][j].getO()));
                        panel.add(r);
                        x++;
                    } else {
                        gc.weightx = 0.2;
                        gc.weighty = 0.8;
                        gc.gridx = x;
                        gc.gridy = y;
                        panel.add(new JPanel());
                        x++;
                    }
                    gc.weightx = 0.8;
                    gc.weighty = 0.8;
                    gc.gridx = x;
                    gc.gridy = y;
                    try{
                        JTile tile = new JTile(getImageTypeTile(tiles[i][j]), false, x, y, tiles[i][j].getTypeTile());
                        panel.add(tile);
                    } catch (Exception e) {
                        panel.add(new JPanel());
                    }
                    if(x == 15){
                        if (tiles[i][j].getE() != null) {
                            gc.weightx = 0.2;
                            gc.weighty = 0.8;
                            gc.gridx = x;
                            gc.gridy = y;
                            JRoad r = new JRoad(x, y, "vertical");
                            r.setBackground(getColorRoad(tiles[i][j].getE()));
                            panel.add(r);
                            x++;
                        } else {
                            gc.weightx = 0.2;
                            gc.weighty = 0.8;
                            gc.gridx = x;
                            gc.gridy = y;
                            panel.add(new JPanel());
                            x++;
                        }
                    }
                } else {
                    gc.weightx = 1;
                    gc.weighty = 1;
                    gc.gridx = x;
                    gc.gridy = y;
                    panel.add(new JPanel());
                }
            }
        }

        return gbl;
    }

    public static Color getColorStructure(Structure s) {
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

    public static Image getImageTypeTile(Tile tile) throws NoSuchFileException{
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
                    return ImageIO.read(new File("res/foret.jpeg"));
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
            default:
                try {
                    return ImageIO.read(new File("res/error.jpg"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        return null;
    }
}
