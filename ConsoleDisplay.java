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
                            System.out.print(red + bold + "  ═════════════  " + reset); // 13 lignes
                            break;
                        case "green":
                            System.out.print(green + bold + "  ═════════════  " + reset);
                            break;
                        case "blue":
                            System.out.print(blue + bold + "  ═════════════  " + reset);
                            break;
                        case "yellow":
                            System.out.print(yellow + bold + "  ═════════════  " + reset);
                            break;
                    }
                } else {
                    System.out.print("                 ");
                }
                if(indexOfLine == 5){
                    if (tile != null) {
                        if (tile.getRoad("s") != null) {
                            switch (tile.getRoad("s").getOwner().getColor()) {
                                case "red":
                                    System.out.print(red + bold + "  ═════════════  " + reset); // 13 lignes
                                    break;
                                case "green":
                                    System.out.print(green + bold + "  ═════════════  " + reset);
                                    break;
                                case "blue":
                                    System.out.print(blue + bold + "  ═════════════  " + reset);
                                    break;
                                case "yellow":
                                    System.out.print(yellow + bold + "  ═════════════  " + reset);
                                    break;
                            }
                        } 
                    }
                }
            }
            else {
                System.out.print("                 ");
            }
        }
        System.out.println();
    }

    // print the top of the tiles
    public void printTopTile(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                System.out.print(bold + " ┏━━━━━━━━━━━━━┓ ");

            } else {
                System.out.print("                 ");
            }
        }
        System.out.println();
    }

    // print the bottom of the tiles
    public void printBottomTile(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                System.out.print(bold + " ┗━━━━━━━━━━━━━┛ ");
            } else {
                System.out.print("                 ");
            }
        }
        System.out.println();
    }

    // print other tile lines
    public void printOtherPartTile(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                System.out.print(bold + " ┃             ┃ ");
            } else {
                System.out.print("                 ");
            }
        }
        System.out.println();
    }

    // print the middle of the tiles, with the name of the land and the tile number
    // desert, colline, plaine, foret, champ, montagne
    public void printTypeOnTile(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile == null) {
                System.out.print("                 ");
            } else {
                switch (tile.getType()) {
                    case "desert":
                        System.out.print(bold + " ┃    Desert   ┃ ");
                        break;
                    case "colline":
                        System.out.print(bold + " ┃   Colline   ┃ ");
                        break;
                    case "plaine":
                        System.out.print(bold + " ┃    Plaine   ┃ ");
                        break;
                    case "foret":
                        System.out.print(bold + " ┃    Foret    ┃ ");
                        break;
                    case "champ":
                        System.out.print(bold + " ┃    Champ    ┃ ");
                        break;
                    case "montagne":
                        System.out.print(bold + " ┃   Montagne  ┃ ");
                        break;
                }
            }
        }
        System.out.println();
    }

    public void printNumberOnTile(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                if (tile.getType().equals("desert")) {
                    System.out.print(bold + " ┃             ┃ ");
                } else {
                    if (tile.getNumber() > 9) {
                        System.out.print(bold + " ┃      " + tile.getNumber() + "     ┃ ");
                    } else {
                        System.out.print(bold + " ┃      " + tile.getNumber() + "      ┃ ");
                    }
                }
            } else {
                System.out.print("                 ");

            }

        }
        System.out.println();
    }

    @Override
    public void printBoard(Board board) {
        for (int i = 0; i < board.getTiles().length; i++) {
            printHRoads(board, i);
            printTopTile(board, i);
            printOtherPartTile(board, i);
            printTypeOnTile(board, i);
            printNumberOnTile(board, i);
            printOtherPartTile(board, i);
            printBottomTile(board, i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Board board = new Board();
        ConsoleDisplay c = new ConsoleDisplay();
        System.out.println(board.addRoad(1, 1, new Road(new Player("blue")), "n"));
        c.printBoard(board);
    }

}
