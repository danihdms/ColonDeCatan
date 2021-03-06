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
    public static final String magenta = "\u001b[35m";
    public static final String colony = "•";
    public static final String city = "◯";

    // print horizontal roads

    private void printHRoads(Board board, int indexOfLine) {
        Tile lastTile = null;
        int i = 0;
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                lastTile = tile;
                int noStructType;
                String noStructure = " ";
                String noColor = " ";
                if (tile.getStructure("no") != null) {
                    noColor = tile.getStructure("no").getOwner().getColor();
                    noStructType = tile.getStructure("no").getType();
                    if (noStructType == 0) {
                        noStructure = colony;
                    } else if (noStructType == 1) {
                        noStructure = city;
                    }
                    switch (noColor) {
                        case "red":
                            noColor = bold + red + noStructure + reset;
                            break;
                        case "green":
                            noColor = bold + green + noStructure + reset;
                            break;
                        case "yellow":
                            noColor = bold + yellow + noStructure + reset;
                            break;
                        case "blue":
                            noColor = bold + blue + noStructure + reset;
                            break;
                    }
                }
                if (tile.getRoad("n") != null) {
                    switch (tile.getRoad("n").getOwner().getColor()) {
                        case "red":
                            System.out.print(noColor + red + bold + " ═══════════════ " + reset); // 13 lignes
                            break;
                        case "green":
                            System.out.print(noColor + green + bold + " ═══════════════ " + reset);
                            break;
                        case "blue":
                            System.out.print(noColor + blue + bold + " ═══════════════ " + reset);
                            break;
                        case "yellow":
                            System.out.print(noColor + yellow + bold + " ═══════════════ " + reset);
                            break;
                    }
                    if ((indexOfLine == 1 && i == 3) || (indexOfLine == 2 && i == 4) || (indexOfLine == 3 && i == 5)
                            || (indexOfLine == 4 && i == 5) || (indexOfLine == 5 && i == 5)) {
                        printLastColRoads(board, indexOfLine);
                    }
                } else {
                    System.out.print(noColor + "                 ");
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
            i++;
        }
        System.out.println();
    }

    // print the top of the tiles

    private void printTopTile(Board board, int indexOfLine) {
        int i = 0;
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                String westColor = " ";
                if (tile.getRoad("o") != null) {
                    westColor = tile.getRoad("o").getOwner().getColor();
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
                if ((indexOfLine == 1 && i == 3) || (indexOfLine == 2 && i == 4) || (indexOfLine == 3 && i == 5)
                        || (indexOfLine == 4 && i == 5) || (indexOfLine == 5 && i == 5)) {
                    printLastColRoads(board, indexOfLine);
                }
            } else {
                System.out.print("                  ");
            }
            i++;
        }
        System.out.println();
    }

    // print the middle of the tiles, with the name of the land
    // desert, colline, plaine, foret, champ, montagne
    private void printTypeOnTile(Board board, int indexOfLine) {
        int i = 0;
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile == null) {
                System.out.print("                  ");
            } else {
                String westColor = " ";
                if (tile.getRoad("o") != null) {
                    westColor = tile.getRoad("o").getOwner().getColor();
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
                String port = "";
                if (tile.getIsAPort())
                    port = blue;
                switch (tile.getTypeTile()) {
                    case "desert":
                        System.out.print(westColor + bold + " ┃   " + port + " Desert " + reset + "  ┃ ");
                        break;
                    case "colline":
                        System.out.print(westColor + bold + " ┃  " + port + " Colline " + reset + "  ┃ ");
                        break;
                    case "plaine":
                        System.out.print(westColor + bold + " ┃   " + port + " Plaine " + reset + "  ┃ ");
                        break;
                    case "foret":
                        System.out.print(westColor + bold + " ┃   " + port + " Foret " + reset + "   ┃ ");
                        break;
                    case "champ":
                        System.out.print(westColor + bold + " ┃   " + port + " Champ " + reset + "   ┃ ");
                        break;
                    case "montagne":
                        System.out.print(westColor + bold + " ┃  " + port + " Montagne " + reset + " ┃ ");
                        break;
                }
                if ((indexOfLine == 1 && i == 3) || (indexOfLine == 2 && i == 4) || (indexOfLine == 3 && i == 5)
                        || (indexOfLine == 4 && i == 5) || (indexOfLine == 5 && i == 5)) {
                    printLastColRoads(board, indexOfLine);
                }
            }
            i++;
        }
        System.out.println();
    }

    // print the line with the number of the tile
    private void printNumberOnTile(Board board, int indexOfLine) {
        int i = 0;
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                String westColor = " ";
                if (tile.getRoad("o") != null) {
                    westColor = tile.getRoad("o").getOwner().getColor();
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
                        System.out.print(bold + westColor + " ┃      " + magenta + "V" + reset + "      ┃ ");
                    } else
                        System.out.print(bold + westColor + " ┃             ┃ ");
                } else {
                    if (tile.getNumber() == 0 && !tile.getType().equals("desert")) {
                        System.out.print(bold + westColor + " ┃      " + blue + "P" + reset + "      ┃ ");
                    } else if (tile.getNumber() > 9) {
                        if (tile.hasThief()) {
                            System.out.print(bold + westColor + " ┃     " + tile.getNumber() + " " + magenta + "V" + reset
                                    + "    ┃ ");
                        } else {
                            System.out.print(bold + westColor + " ┃      " + tile.getNumber() + "     ┃ ");
                        }
                    } else {
                        if (tile.hasThief()) {
                            System.out.print(bold + westColor + " ┃     " + tile.getNumber() + " " + magenta + "V" + reset
                                    + "     ┃ ");
                        } else
                            System.out.print(bold + westColor + " ┃      " + tile.getNumber() + "      ┃ ");
                    }
                }
                if ((indexOfLine == 1 && i == 3) || (indexOfLine == 2 && i == 4) || (indexOfLine == 3 && i == 5)
                        || (indexOfLine == 4 && i == 5) || (indexOfLine == 5 && i == 5)) {
                    printLastColRoads(board, indexOfLine);
                }
            } else {
                System.out.print("                  ");

            }
            i++;
        }
        System.out.println();
    }

    // print the bottom of the tiles
    private void printBottomTile(Board board, int indexOfLine) {
        int i = 0;
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                String westColor = " ";
                if (tile.getRoad("o") != null) {
                    westColor = tile.getRoad("o").getOwner().getColor();
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
                if ((indexOfLine == 1 && i == 3) || (indexOfLine == 2 && i == 4) || (indexOfLine == 3 && i == 5)
                        || (indexOfLine == 4 && i == 5) || (indexOfLine == 5 && i == 5)) {
                    printLastColRoads(board, indexOfLine);
                }
            } else {
                System.out.print("                  ");
            }
            i++;
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
                if (tile.getStructure("so") != null) {
                    swColor = tile.getStructure("so").getOwner().getColor();
                    if (tile.getStructure("so") != null) {
                        swStructType = tile.getStructure("so").getType();
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
        for(int i = 0; i < 150; i++){
            System.out.print("_");
        }
        System.out.println();
        System.out.println();
        System.out.print("                  ");
        System.out.print("          1        ");
        System.out.print("          2        ");
        System.out.print("        3        ");
        System.out.print("         4        ");
        System.out.print("         5        ");
        for (int i = 0; i < board.getTiles().length; i++) {
            if (i < 6)
                printHRoads(board, i);
            System.out.print(" ");
            printTopTile(board, i);
            if (i == 0 || i == 6)
                System.out.print(" ");
            if (i > 0 && i < 6)
                System.out.print(bold + i);
            printTypeOnTile(board, i);
            System.out.print(" ");
            printNumberOnTile(board, i);
            System.out.print(" ");
            printBottomTile(board, i);
            System.out.print(" ");
            if (i == 5) {
                printLastRowRoads(board);
            }
        }
        System.out.println();
    }
}