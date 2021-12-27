package Game;

import java.util.Scanner;

import Display.ConsoleDisplay;

public class PlayConsole {

    public static void main(String[] args) {
        System.out.println("┏━━━━━━━━━━━━━━━┓");
        System.out.println("┃     Début     ┃");
        System.out.println("┃     de la     ┃");
        System.out.println("┃    Partie !   ┃");
        System.out.println("┗━━━━━━━━━━━━━━━┛");

        Scanner sc = new Scanner(System.in);

        System.out.println("Voulez-vous jouer à 3 ou 4 personnes ?");
        int nbPlayers = sc.nextInt();
        sc.nextLine();
        while (nbPlayers != 3 && nbPlayers != 4) {
            System.out.println("Il faut choisir entre 3 ou 4 joueurs.\nVoulez-vous jouer à 3 ou 4 personnes ?");
            nbPlayers = sc.nextInt();
        }

        Player[] players = new Player[nbPlayers];
        String[] colors = { "red", "green", "blue", "yellow" };
        for (int i = 0; i < nbPlayers; i++) {
            boolean human = false;

            System.out.println("Le joueur " + (i + 1) + " est-il un humain ou une IA ?");
            String ans = sc.nextLine();
            if (ans.equals("humain")) {
                human = true;
            }
            System.out.println("Quel est le prénom de ce joueur ?");
            String name = sc.nextLine();
            players[i] = new Player(name, colors[i], human);
        }

        ConsoleDisplay display = new ConsoleDisplay();
        Game game = new Game(players);

        display.printBoard(game.getBoard());
        // Demander de poser les structures et les routes : une structure et un route
        // par joueur 2 fois (chacun leur tour)
        boolean debut = false;
        int turn = 0;
        while (debut != true) {
            for (Player p : game.getPlayers()) {
                if (p.getHuman()) {
                    System.out.println("donnez la ligne ou placer votre colonie");
                    String x = sc.nextLine();
                    // verifier x
                    System.out.println("donnez la colonne  ou placer votre colonie");
                    String y = sc.nextLine();
                    // verifier y
                    System.out.println("Dans quel coin ?[ne/nw/se/sw]");
                    String pos = sc.nextLine();
                    // verifier pos
                    while (!game.getBoard().addStructure(Integer.parseInt(x),Integer.parseInt(y), new Structure(0, p), pos)) {
                        System.out.println("donnez la ligne ou placer votre colonie");
                        x = sc.nextLine();
                        // verifier x
                        System.out.println("donnez la colonne  ou placer votre colonie");
                        y = sc.nextLine();
                        // verifier y
                        System.out.println("Dans quel coin ?[ne/nw/se/sw]");
                        pos = sc.nextLine();
                        // verifier pos
                    }
                    display.printBoard(game.getBoard());
                    System.out.println("donnez la ligne ou placer votre route");
                    x = sc.nextLine();
                    // verifier x
                    System.out.println("donnez la colonne  ou placer votre route");
                    y = sc.nextLine();
                    // verifier y
                    System.out.println("Dans quel coin ?[n/w/e/s]");
                    pos = sc.nextLine();
                    // verifier pos
                    while (!game.getBoard().addRoad(Integer.parseInt(x), Integer.parseInt(y), new Road(p), pos)) {
                        System.out.println("donnez la ligne ou placer votre route");
                        x = sc.nextLine();
                        // verifier x
                        System.out.println("donnez la colonne  ou placer votre route");
                        y = sc.nextLine();
                        // verifier y
                        System.out.println("Dans quel coin ?[n/w/e/s]");
                        pos = sc.nextLine();
                        // verifier pos
                    }
                    display.printBoard(game.getBoard());
                    turn++;
                } else {
                    //a ecrie pour l'IA
                    turn++;
                }
                if(turn==2*game.getPlayers().length){ //permet de faire deux tour du tableau
                    debut=true;
                }
            }
        }
        

        // Lancer le dé
        // recevoir les resources ou appeler le voleur
        // choisir quoi faire :
        // tirer une carte en depensant ses resources
        // la jouer si il peut ou la garder
        // placer une colonie
        // placer une route
        // ameliorer une colonie

        sc.close();
    }
}
