public class ConsoleDisplay implements Display {
    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String blue = "\u001B[34m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String bold = "\033[1m";

    // print horizontal roads
    public void printHRoads(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                if (tile.getRoad("n") != null) {
                    switch (tile.getRoad("n").getOwner().getColor()) {
                        case "red":
                            System.out.print(red + bold + "═══════════════ " + reset); // 13 lignes
                            break;
                        case "green":
                            System.out.print(green + bold + "═══════════════ " + reset);
                            break;
                        case "blue":
                            System.out.print(blue + bold + "═══════════════ " + reset);
                            break;
                        case "yellow":
                            System.out.print(yellow + bold + "═══════════════ " + reset);
                            break;
                    }
                } else {
                    System.out.print("                ");
                }
            } else {
                System.out.print("                ");
            }
        }
        System.out.println();
    }

    // print the top of the tiles
    public void printTopTile(Board board, int indexOfLine) {
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
                System.out.print(bold + westColor + "┏━━━━━━━━━━━━━┓");

            } else {
                System.out.print("27272727272727");
            }
        }
        System.out.println();
    }

    // print other tile lines
    public void printOtherPartTile(Board board, int indexOfLine) {
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
                System.out.print(bold + westColor + "┃             ┃");
            } else {
                System.out.print("27272727272727");
            }
        }
        System.out.println();
    }

    // print the middle of the tiles, with the name of the land
    // desert, colline, plaine, foret, champ, montagne
    public void printTypeOnTile(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile == null) {
                System.out.print("27272727272727");
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
                        System.out.print(bold + westColor + "┃    Desert   ┃");
                        break;
                    case "colline":
                        System.out.print(bold + westColor + "┃   Colline   ┃");
                        break;
                    case "plaine":
                        System.out.print(bold + westColor + "┃    Plaine   ┃");
                        break;
                    case "foret":
                        System.out.print(bold + westColor + "┃    Foret    ┃");
                        break;
                    case "champ":
                        System.out.print(bold + westColor + "┃    Champ    ┃");
                        break;
                    case "montagne":
                        System.out.print(bold + westColor + "┃   Montagne  ┃");
                        break;
                }
            }
        }
        System.out.println();
    }

    // print the line with the number of the tile
    public void printNumberOnTile(Board board, int indexOfLine) {
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
                    System.out.print(bold + westColor + "┃             ┃");
                } else {
                    if (tile.getNumber() > 9) {
                        System.out.print(bold + westColor + "┃      " + tile.getNumber() + "     ┃");
                    } else {
                        System.out.print(bold + westColor + "┃      " + tile.getNumber() + "      ┃");
                    }
                }
            } else {
                System.out.print("              ");

            }

        }
        System.out.println();
    }

    // print the bottom of the tiles
    public void printBottomTile(Board board, int indexOfLine) {
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
                System.out.print(bold + westColor + "┗━━━━━━━━━━━━━┛");
            } else {
                System.out.print("              ");
            }
        }
        System.out.println();
    }

    // print the last row of roads
    public void printLastRowRoads(Board board) {
        for (Tile tile : board.getTiles()[5]) {
            if (tile != null) {
                if (tile.getRoad("s") != null) {
                    switch (tile.getRoad("s").getOwner().getColor()) {
                        case "red":
                            System.out.print(red + bold + "═══════════════ " + reset); // 13 lignes
                            break;
                        case "green":
                            System.out.print(green + bold + "═══════════════ " + reset);
                            break;
                        case "blue":
                            System.out.print(blue + bold + "═══════════════ " + reset);
                            break;
                        case "yellow":
                            System.out.print(yellow + bold + "═══════════════ " + reset);
                            break;
                    }
                }
            } else {
                System.out.print("                ");
            }
        }
        System.out.println();
    }

    // print last column of roads
    public void printLastColRoads(Board board, int indexOfLine) {
        for (int i = 0; i < board.getTiles()[indexOfLine].length; i++) {
            if((indexOfLine == 1 && i == 3) || (indexOfLine == 2 && i == 4) ||(indexOfLine == 3 && i == 5) || (indexOfLine == 4 && i == 5) ||(indexOfLine == 5 && i == 5)){
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

    @Override
    public void printBoard(Board board) {
        for (int i = 0; i < board.getTiles().length; i++) {
            printHRoads(board, i);

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
        System.out.println(board.addRoad(1, 1, new Road(new Player("blue")), "n"));
        board.addRoad(1, 2, new Road(new Player("blue")), "n");
        board.addRoad(1, 2, new Road(new Player("blue")), "w");
        board.addRoad(1, 2, new Road(new Player("blue")), "e");
        board.addRoad(1, 3, new Road(new Player("blue")), "n");
        board.addRoad(2, 1, new Road(new Player("yellow")), "n");
        board.addRoad(2, 2, new Road(new Player("green")), "n");
        board.addRoad(2, 3, new Road(new Player("blue")), "n");
        board.addRoad(2, 4, new Road(new Player("blue")), "n");
        board.addRoad(3, 1, new Road(new Player("blue")), "n");
        board.addRoad(3, 2, new Road(new Player("blue")), "n");
        board.addRoad(3, 3, new Road(new Player("yellow")), "n");
        board.addRoad(3, 4, new Road(new Player("blue")), "n");
        board.addRoad(3, 5, new Road(new Player("blue")), "n");
        board.addRoad(4, 2, new Road(new Player("blue")), "n");
        board.addRoad(4, 3, new Road(new Player("red")), "n");
        board.addRoad(4, 4, new Road(new Player("blue")), "n");
        board.addRoad(4, 5, new Road(new Player("blue")), "n");
        board.addRoad(5, 3, new Road(new Player("blue")), "n");
        board.addRoad(5, 3, new Road(new Player("green")), "s");
        board.addRoad(5, 4, new Road(new Player("blue")), "n");
        board.addRoad(5, 4, new Road(new Player("blue")), "s");
        board.addRoad(5, 5, new Road(new Player("red")), "n");
        board.addRoad(5, 5, new Road(new Player("blue")), "s");
        c.printBoard(board);
    }

}