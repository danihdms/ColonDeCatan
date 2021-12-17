public class ConsoleDisplay implements Display {
    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String blue = "\u001B[34m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String boldRoads = "\033[4m";
    public static final String boldTiles = "\033[1m";

    // print horizontal roads
    public void printHRoads(Board board, int indexOfLine) {
        for (Road road : board.getRoads()[indexOfLine]) {
            if (road != null) {
                switch (road.getPlayer().getColor()) {
                    case "red":
                        System.out.print(red + boldRoads + "  ━━━━━━━━━━━━━  " + reset); // 13 lignes
                        break;
                    case "green":
                        System.out.print(green + boldRoads + "  ━━━━━━━━━━━━━  " + reset);
                        break;
                    case "blue":
                        System.out.print(blue + boldRoads + "  ━━━━━━━━━━━━━  " + reset);
                        break;
                    case "yellow":
                        System.out.print(yellow + boldRoads + "  ━━━━━━━━━━━━━  " + reset);
                        break;
                }
            } else {
                System.out.print("                 ");
            }
        }
        System.out.println();
    }

    // print the top of the tiles
    public void printTopTile(Board board, int indexOfLine) {
        for (Tile tile : board.getTiles()[indexOfLine]) {
            if (tile != null) {
                System.out.print(boldTiles + " ┏━━━━━━━━━━━━━┓ ");

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
                System.out.print(boldTiles + " ┗━━━━━━━━━━━━━┛ ");
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
                System.out.print(boldTiles + " ┃             ┃ ");
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
                        System.out.print(boldTiles + " ┃    Desert   ┃ ");
                        break;
                    case "colline":
                        System.out.print(boldTiles + " ┃   Colline   ┃ ");
                        break;
                    case "plaine":
                        System.out.print(boldTiles + " ┃    Plaine   ┃ ");
                        break;
                    case "foret":
                        System.out.print(boldTiles + " ┃    Foret    ┃ ");
                        break;
                    case "champ":
                        System.out.print(boldTiles + " ┃    Champ    ┃ ");
                        break;
                    case "montagne":
                        System.out.print(boldTiles + " ┃   Montagne  ┃ ");
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
                    System.out.print(boldTiles + " ┃             ┃ ");
                } else {
                    if (tile.getNumber() > 9) {
                        System.out.print(boldTiles + " ┃      " + tile.getNumber() + "     ┃ ");
                    } else {
                        System.out.print(boldTiles + " ┃      " + tile.getNumber() + "      ┃ ");
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
        c.printBoard(board);
    }

}
