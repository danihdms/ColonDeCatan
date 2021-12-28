package Display;

import Game.Board;
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
                            nwColor = bold + red + nwStructure + reset;
                            break;
                        case "green":
                            nwColor =  bold + green + nwStructure + reset;
                            break;
                        case "yellow":
                            nwColor =  bold + yellow + nwStructure + reset;
                            break;
                        case "blue":
                            nwColor =  bold + blue + nwStructure + reset;
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
                            westColor = bold + red + "║" + reset;
                            break;
                        case "green":
                            westColor = bold + green + "║" + reset;
                            break;
                        case "yellow":
                            westColor = bold + yellow + "║" + reset;
                            break;
                        case "blue":
                            westColor = bold + blue + "║" + reset;
                            break;
                    }
                }
                System.out.print(westColor + bold + " ┏━━━━━━━━━━━━━┓ ");

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
                            westColor = bold + red + "║" + reset;
                            break;
                        case "green":
                            westColor = bold + green + "║" + reset;
                            break;
                        case "yellow":
                            westColor = bold + yellow + "║" + reset;
                            break;
                        case "blue":
                            westColor = bold + blue + "║" + reset;
                            break;
                    }
                }
                System.out.print(westColor + bold + " ┃             ┃ ");
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
                            westColor = bold + red + "║" + reset;
                            break;
                        case "green":
                            westColor = bold + green + "║" + reset;
                            break;
                        case "yellow":
                            westColor = bold + yellow + "║" + reset;
                            break;
                        case "blue":
                            westColor = bold + blue + "║" + reset;
                            break;
                    }
                }
                switch (tile.getType()) {
                    case "desert":
                        System.out.print(westColor + bold + " ┃    Desert   ┃ ");
                        break;
                    case "colline":
                        System.out.print(westColor + bold + " ┃   Colline   ┃ ");
                        break;
                    case "plaine":
                        System.out.print(westColor + bold + " ┃    Plaine   ┃ ");
                        break;
                    case "foret":
                        System.out.print(westColor + bold + " ┃    Foret    ┃ ");
                        break;
                    case "champ":
                        System.out.print(westColor + bold + " ┃    Champ    ┃ ");
                        break;
                    case "montagne":
                        System.out.print(westColor + bold + " ┃   Montagne  ┃ ");
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
                            westColor = bold + red + "║" + reset;
                            break;
                        case "green":
                            westColor = bold + green + "║" + reset;
                            break;
                        case "yellow":
                            westColor = bold + yellow + "║" + reset;
                            break;
                        case "blue":
                            westColor = bold + blue + "║" + reset;
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
                            westColor = bold + red + "║" + reset;
                            break;
                        case "green":
                            westColor = bold + green + "║" + reset;
                            break;
                        case "yellow":
                            westColor = bold + yellow + "║" + reset;
                            break;
                        case "blue":
                            westColor = bold + blue + "║" + reset;
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
                                swColor = bold + red + swStructure + reset;
                                break;
                            case "green":
                                swColor = bold + green + swStructure + reset;
                                break;
                            case "yellow":
                                swColor = bold + yellow + swStructure + reset;
                                break;
                            case "blue":
                                swColor = bold + blue + swStructure + reset;
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
                                System.out.print(bold + red + seStructure + reset);
                                break;
                            case "green":
                                System.out.print(bold + green + seStructure + reset);
                                break;
                            case "yellow":
                                System.out.print(bold + yellow + seStructure + reset);
                                break;
                            case "blue":
                                System.out.print(bold + blue + seStructure + reset);
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
                                eastColor = bold + red + "║" + reset;
                                break;
                            case "green":
                                eastColor = bold + green + "║" + reset;
                                break;
                            case "yellow":
                                eastColor = bold + yellow + "║" + reset;
                                break;
                            case "blue":
                                eastColor = bold + blue + "║" + reset;
                                break;
                        }
                    }
                    System.out.print(eastColor);
                }
            }
        }
    }

    public void printBoard(Board board) {
        System.out.print("                  ");
        System.out.print("          1        ");
        System.out.print("          2        ");
        System.out.print("          3        ");
        System.out.print("          4        ");
        System.out.print("          5        ");
        for (int i = 0; i < board.getTiles().length; i++) {
            printLastColRoads(board, i);
            printHRoads(board, i);

            System.out.print(" ");
            printLastColRoads(board, i);
            printTopTile(board, i);

            System.out.print(" ");
            printLastColRoads(board, i);
            printOtherPartTile(board, i);

            if(i > 0 && i < 6) System.out.print(i);
            printLastColRoads(board, i);
            printTypeOnTile(board, i);

            System.out.print(" ");
            printLastColRoads(board, i);
            printNumberOnTile(board, i);

            System.out.print(" ");
            printLastColRoads(board, i);
            printOtherPartTile(board, i);

            System.out.print(" ");
            printLastColRoads(board, i);
            printBottomTile(board, i);
            System.out.print(" ");
            if (i == 5) {
                printLastRowRoads(board);
            }
        }
        System.out.println();
    }
}