public class DisplayTest {
    
    

    public static void main(String[] args) {
        // using ANSI to make colors in the console
        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String blue = "\u001B[34m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String boldRoads = "\033[4m";
        String boldTiles = "\033[1m";

        String hLine = "━";
        String nEdge = "┏┓";
        String sEdge = "┗┛";


        System.out.println(green + boldTiles + "┏━━━━━━━━━━━━━┓" + reset);
        System.out.println(green + boldTiles + "┃             ┃" + reset);
        System.out.println(green + boldTiles + "┃   Plaine    ┃" + reset);
        System.out.println(red + boldTiles + "┃      6      ┃" + reset);
        System.out.println(red + boldTiles + "┃             ┃" + reset);
        System.out.println(red + boldTiles + "┗━━━━━━━━━━━━━┛" + reset);
        System.out.println(green + boldRoads + "________" + reset);
        System.out.println(yellow + boldTiles + "________" + reset);



        


    }
}
