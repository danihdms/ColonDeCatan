package Display;

import Game.Board;
import Game.Player;
import Game.Road;
import Game.Structure;
import Game.Tile;

public class ConsoleDisplay {
    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String blue = "\u001B[34m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String bold = "\033[1m";
    public static final String colony = "•";
    public static final String city = "◯";

    // print horizontal roads

    private void printHRoads(Board board, int indexOfLine) {
        Tile lastTile = null;
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                lastTile = tile;
                int nwStructType;
                String nwStructure = " ";
                String nwColor = " ";
                if (tile.getStructure("nw") != null) {
                    nwColor = tile.getStructure("nw").getOwner().getColor();
                    nwStructType = tile.getStructure("nw").getType();
                    if (nwStructType == 0) {
                        nwStructure = colony;
                    } else if (nwStructType == 1) {
                        nwStructure = city;
                    }
                    switch (nwColor) {
                        case "red":
                            nwColor = red + nwStructure + reset;
                            break;
                        case "green":
                            nwColor = green + nwStructure + reset;
                            break;
                        case "yellow":
                            nwColor = yellow + nwStructure + reset;
                            break;
                        case "blue":
                            nwColor = blue + nwStructure + reset;
                            break;
                    }
                }
                if (tile.getRoad("n") != null) {
                    switch (tile.getRoad("n").getOwner().getColor()) {
                        case "red":
                            System.out.print(nwColor + red + bold + " ═══════════════ " + reset); // 13 lignes
                            break;
                        case "green":
                            System.out.print(nwColor + green + bold + " ═══════════════ " + reset);
                            break;
                        case "blue":
                            System.out.print(nwColor + blue + bold + " ═══════════════ " + reset);
                            break;
                        case "yellow":
                            System.out.print(nwColor + yellow + bold + " ═══════════════ " + reset);
                            break;
                    }
                } else {
                    System.out.print(nwColor + "                 ");
                }
            } else {
                if (lastTile != null) {
                    int neStructType;
                    String neColor = " ";
                    String neStructure = " ";
                    if (lastTile.getStructure("ne") != null) {
                        neColor = lastTile.getStructure("ne").getOwner().getColor();
                        neStructType = lastTile.getStructure("ne").getType();
                        if (neStructType == 0) {
                            neStructure = colony;
                        } else if (neStructType == 1) {
                            neStructure = city;
                        }
                        switch (neColor) {
                            case "red":
                                System.out.print(red + neStructure + reset);
                                break;
                            case "green":
                                System.out.print(green + neStructure + reset);
                                break;
                            case "yellow":
                                System.out.print(yellow + neStructure + reset);
                                break;
                            case "blue":
                                System.out.print(blue + neStructure + reset);
                                break;
                        }
                    }
                    lastTile = null;
                }
                System.out.print("                  ");
            }
        }
        System.out.println();
    }

    // print the top of the tiles

    private void printTopTile(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                String westColor = " ";
                if (tile.getRoad("w") != null) {
                    westColor = tile.getRoad("w").getOwner().getColor();
                    switch (westColor) {
                        case "red":
                            westColor = red + "║" + reset;
                            break;
                        case "green":
                            westColor = green + "║" + reset;
                            break;
                        case "yellow":
                            westColor = yellow + "║" + reset;
                            break;
                        case "blue":
                            westColor = blue + "║" + reset;
                            break;
                    }
                }
                System.out.print(bold + westColor + " ┏━━━━━━━━━━━━━┓ ");

            } else {
                System.out.print("                  ");
            }
        }
        System.out.println();
    }

    // print other tile lines
    private void printOtherPartTile(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                String westColor = " ";
                if (tile.getRoad("w") != null) {
                    westColor = tile.getRoad("w").getOwner().getColor();
                    switch (westColor) {
                        case "red":
                            westColor = red + "║" + reset;
                            break;
                        case "green":
                            westColor = green + "║" + reset;
                            break;
                        case "yellow":
                            westColor = yellow + "║" + reset;
                            break;
                        case "blue":
                            westColor = blue + "║" + reset;
                            break;
                    }
                }
                System.out.print(bold + westColor + " ┃             ┃ ");
            } else {
                System.out.print("                  ");
            }
        }
        System.out.println();
    }

    // print the middle of the tiles, with the name of the land
    // desert, colline, plaine, foret, champ, montagne
    private void printTypeOnTile(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile == null) {
                System.out.print("                  ");
            } else {
                String westColor = " ";
                if (tile.getRoad("w") != null) {
                    westColor = tile.getRoad("w").getOwner().getColor();
                    switch (westColor) {
                        case "red":
                            westColor = red + "║" + reset;
                            break;
                        case "green":
                            westColor = green + "║" + reset;
                            break;
                        case "yellow":
                            westColor = yellow + "║" + reset;
                            break;
                        case "blue":
                            westColor = blue + "║" + reset;
                            break;
                    }
                }
                switch (tile.getType()) {
                    case "desert":
                        System.out.print(bold + westColor + " ┃    Desert   ┃ ");
                        break;
                    case "colline":
                        System.out.print(bold + westColor + " ┃   Colline   ┃ ");
                        break;
                    case "plaine":
                        System.out.print(bold + westColor + " ┃    Plaine   ┃ ");
                        break;
                    case "foret":
                        System.out.print(bold + westColor + " ┃    Foret    ┃ ");
                        break;
                    case "champ":
                        System.out.print(bold + westColor + " ┃    Champ    ┃ ");
                        break;
                    case "montagne":
                        System.out.print(bold + westColor + " ┃   Montagne  ┃ ");
                        break;
                }
            }
        }
        System.out.println();
    }

    // print the line with the number of the tile
    private void printNumberOnTile(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                String westColor = " ";
                if (tile.getRoad("w") != null) {
                    westColor = tile.getRoad("w").getOwner().getColor();
                    switch (westColor) {
                        case "red":
                            westColor = red + "║" + reset;
                            break;
                        case "green":
                            westColor = green + "║" + reset;
                            break;
                        case "yellow":
                            westColor = yellow + "║" + reset;
                            break;
                        case "blue":
                            westColor = blue + "║" + reset;
                            break;
                    }
                }
                if (tile.getType().equals("desert")) {
                    if (tile.hasThief()) {
                        System.out.print(bold + westColor + " ┃      T      ┃ ");
                    } else
                        System.out.print(bold + westColor + " ┃             ┃ ");
                } else {
                    if (tile.getNumber() > 9) {
                        if (tile.hasThief()) {
                            System.out.print(bold + westColor + " ┃     " + tile.getNumber() + " T    ┃ ");
                        } else {
                            System.out.print(bold + westColor + " ┃      " + tile.getNumber() + "     ┃ ");
                        }
                    } else {
                        if (tile.hasThief()) {
                            System.out.print(bold + westColor + " ┃     " + tile.getNumber() + " T     ┃ ");
                        } else
                            System.out.print(bold + westColor + " ┃      " + tile.getNumber() + "      ┃ ");
                    }
                }
            } else {
                System.out.print("                  ");

            }

        }
        System.out.println();
    }

    // print the bottom of the tiles
    private void printBottomTile(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                String westColor = " ";
                if (tile.getRoad("w") != null) {
                    westColor = tile.getRoad("w").getOwner().getColor();
                    switch (westColor) {
                        case "red":
                            westColor = red + "║" + reset;
                            break;
                        case "green":
                            westColor = green + "║" + reset;
                            break;
                        case "yellow":
                            westColor = yellow + "║" + reset;
                            break;
                        case "blue":
                            westColor = blue + "║" + reset;
                            break;
                    }
                }
                System.out.print(bold + westColor + " ┗━━━━━━━━━━━━━┛ ");
            } else {
                System.out.print("                  ");
            }
        }
        System.out.println();
    }

    // print the last row of roads
    private void printLastRowRoads(Board board) {
        Tile lastTile = null;
        boolean firstNotNullTile = true;
        for (Tile tile : board.getTiles()[5]) {
            if (tile != null) {
                lastTile = tile;
                if (firstNotNullTile) {
                    System.out.print(" ");
                    firstNotNullTile = false;
                }
                int swStructType;
                String swStructure = " ";
                String swColor = " ";
                if (tile.getStructure("sw") != null) {
                    swColor = tile.getStructure("sw").getOwner().getColor();
                    if (tile.getStructure("sw") != null) {
                        swStructType = tile.getStructure("sw").getType();
                        if (swStructType == 0) {
                            swStructure = colony; // this is not recognized, might need to add a swith for each the
                                                  // colonies and the cities instead of a string variable ... relou
                        } else if (swStructType == 1) {
                            swStructure = city; // same as above
                        }
                        switch (swColor) {
                            case "red":
                                swColor = red + swStructure + reset;
                                break;
                            case "green":
                                swColor = green + swStructure + reset;
                                break;
                            case "yellow":
                                swColor = yellow + swStructure + reset;
                                break;
                            case "blue":
                                swColor = blue + swStructure + reset;
                                break;
                        }
                    }
                }
                if (tile.getRoad("s") != null) {
                    switch (tile.getRoad("s").getOwner().getColor()) {
                        case "red":
                            System.out.print(swColor + red + bold + " ═══════════════ " + reset); // 13 lignes
                            break;
                        case "green":
                            System.out.print(swColor + green + bold + " ═══════════════ " + reset);
                            break;
                        case "blue":
                            System.out.print(swColor + blue + bold + " ═══════════════ " + reset);
                            break;
                        case "yellow":
                            System.out.print(swColor + yellow + bold + " ═══════════════ " + reset);
                            break;
                    }
                } else {
                    System.out.print(swColor + "                 ");
                }
            } else {
                if (lastTile != null) {
                    int seStructType;
                    String seColor = " ";
                    String seStructure = " ";
                    if (lastTile.getStructure("se") != null) {
                        seColor = lastTile.getStructure("se").getOwner().getColor();
                        seStructType = lastTile.getStructure("se").getType();
                        if (seStructType == 0) {
                            seStructure = colony;
                        } else if (seStructType == 1) {
                            seStructure = city;
                        }
                        switch (seColor) {
                            case "red":
                                System.out.print(red + seStructure + reset);
                                break;
                            case "green":
                                System.out.print(green + seStructure + reset);
                                break;
                            case "yellow":
                                System.out.print(yellow + seStructure + reset);
                                break;
                            case "blue":
                                System.out.print(blue + seStructure + reset);
                                break;
                        }
                    }
                    lastTile = null;
                }
                System.out.print("                  ");
            }
        }
        System.out.println();
    }

    // print last column of roads
    private void printLastColRoads(Board board, int indexOfLine) {
        for (int i = 0; i < board.getTiles()[indexOfLine].length; i++) {
            if ((indexOfLine == 1 && i == 3) || (indexOfLine == 2 && i == 4) || (indexOfLine == 3 && i == 5)
                    || (indexOfLine == 4 && i == 5) || (indexOfLine == 5 && i == 5)) {
                if (board.getTiles()[indexOfLine][i] != null) {
                    String eastColor = " ";
                    if (board.getTiles()[indexOfLine][i].getRoad("e") != null) {
                        eastColor = board.getTiles()[indexOfLine][i].getRoad("e").getOwner().getColor();
                        switch (eastColor) {
                            case "red":
                                eastColor = red + "║" + reset;
                                break;
                            case "green":
                                eastColor = green + "║" + reset;
                                break;
                            case "yellow":
                                eastColor = yellow + "║" + reset;
                                break;
                            case "blue":
                                eastColor = blue + "║" + reset;
                                break;
                        }
                    }
                    System.out.print(eastColor);
                }
            }
        }
    }

    public void printBoard(Board board) {
        for (int i = 0; i < board.getTiles().length; i++) {
            printLastColRoads(board, i);
            printHRoads(board, i);

            printLastColRoads(board, i);
            printTopTile(board, i);

            printLastColRoads(board, i);
            printOtherPartTile(board, i);

            printLastColRoads(board, i);
            printTypeOnTile(board, i);

            printLastColRoads(board, i);
            printNumberOnTile(board, i);

            printLastColRoads(board, i);
            printOtherPartTile(board, i);

            printLastColRoads(board, i);
            printBottomTile(board, i);
            if (i == 5) {
                printLastRowRoads(board);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Board board = new Board();
        ConsoleDisplay c = new ConsoleDisplay();
        System.out.println(board.addRoad(1, 1, new Road(new Player("Stanley", "blue", true)), "n"));

        Player p = new Player("Stanley", "red", true);

        board.addStructure(1, 2, new Structure(0, p), "nw");
        board.addStructure(1, 2, new Structure(1, p), "ne");
        board.addStructure(2, 3, new Structure(1, p), "nw");
        board.addStructure(3, 4, new Structure(0, p), "nw");
        board.addStructure(4, 5, new Structure(1, p), "nw");
        board.addStructure(5, 5, new Structure(1, p), "nw");
        board.addStructure(5, 5, new Structure(1, p), "se");
        board.addStructure(5, 3, new Structure(1, p), "sw");
        board.addRoad(1, 2, new Road(p), "n");
        board.addRoad(1, 2, new Road(p), "w");
        board.addRoad(1, 2, new Road(p), "e");
        board.addRoad(1, 3, new Road(p), "n");
        board.addRoad(2, 1, new Road(p), "n");
        board.addRoad(2, 2, new Road(p), "n");
        board.addRoad(2, 3, new Road(p), "n");
        board.addRoad(2, 4, new Road(p), "n");
        board.addRoad(3, 1, new Road(p), "n");
        board.addRoad(3, 2, new Road(p), "n");
        board.addRoad(3, 3, new Road(p), "n");
        board.addRoad(3, 4, new Road(p), "n");
        board.addRoad(3, 5, new Road(p), "n");
        board.addRoad(4, 2, new Road(p), "n");
        board.addRoad(4, 3, new Road(p), "n");
        board.addRoad(4, 4, new Road(p), "n");
        board.addRoad(4, 5, new Road(p), "n");
        board.addRoad(5, 3, new Road(p), "n");
        board.addRoad(5, 3, new Road(p), "s");
        board.addRoad(5, 4, new Road(p), "n");
        board.addRoad(5, 4, new Road(p), "s");
        board.addRoad(5, 5, new Road(p), "n");
        board.addRoad(5, 5, new Road(p), "s");

        // board.addStructure(4, 5, new Structure(1, new Player("Stanley", "red",
        // true)), "se");

        c.printBoard(board);
    }

}