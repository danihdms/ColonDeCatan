package Game;

import java.util.Scanner;

import Display.ConsoleDisplay;

public class PlayConsole {

    public static String verifNumber(String s){
        String [] number={"1","2","3","4","5","6"};
        Scanner ss=new Scanner(System.in);
        for(String n : number){
            if (n.equals(s)){
                return n;
                
            }
        }
        System.out.println("La coordonné est invalide redonné en une autre");
        s=ss.nextLine();
        ss.close();
        return verifNumber(s);
        
    }
    
    public static String verifCoin(String s){
        String [] number={"ne","nw","se","sw"};
        Scanner ss=new Scanner(System.in);
        for(String n : number){
            if (n.equals(s)){
                return n;
                
            }
        }
        System.out.println("Le coin  est invalide redonné en une autre[ne/nw/se/sw]");
        s=ss.nextLine();
        ss.close();
        return verifNumber(s);
    }
    public static String verifCote(String s){
        String [] number={"n","w","e","s"};
        Scanner ss=new Scanner(System.in);
        for(String n : number){
            if (n.equals(s)){
                return n;
                
            }
        }
        System.out.println("Le coin  est invalide redonné en une autre[n/w/e/s]");
        s=ss.nextLine();
        ss.close();
        return verifNumber(s);
    }
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
                    System.out.println("Vous devez placer une colonie.");
                    System.out.println("Donnez la ligne de la colonie à placer.");
                    String x = sc.nextLine();
                    x=verifNumber(x);
                    System.out.println("Donnez la colonne de la colonie à placer.");
                    String y = sc.nextLine();
                    y=verifNumber(y);
                    System.out.println("Dans quel coin de la tuile voulez-vous la placer ? [ne/nw/se/sw]");
                    String pos = sc.nextLine();
                    pos=verifCoin(pos);
                    while (!game.getBoard().addStructure(Integer.parseInt(x), Integer.parseInt(y), new Structure(0, p),
                            pos)) {
                        System.out.println("Vous ne respecter pas la règle de placement. Recommencez.");
                        System.out.println("Donnez la ligne de la colonie à placer.");
                        x = sc.nextLine();
                        x=verifNumber(x);
                        System.out.println("Donnez la colonne de la colonie à placer.");
                        y = sc.nextLine();
                        y=verifNumber(y);
                        System.out.println("Dans quel coin voulez-vous la placer ? [ne/nw/se/sw]");
                        pos = sc.nextLine();
                        pos=verifCoin(pos);
                    }
                    //ajoutez les points de victoires
                    display.printBoard(game.getBoard());
                    System.out.println("Vous devez desormais placer une route, près de votre colonie.");
                    System.out.println("Donnez la ligne de la route à placer.");
                    x = sc.nextLine();
                    x=verifNumber(x);
                    System.out.println("Donnez la colonne de la route à placer.");
                    y = sc.nextLine();
                    y=verifNumber(y);
                    System.out.println("De quel côté voulez-vous la placer ? [n/w/e/s]");
                    pos = sc.nextLine();
                    pos=verifCote(pos);
                    while (!game.getBoard().addRoad(Integer.parseInt(x), Integer.parseInt(y), new Road(p), pos)) {
                        System.out.println("Vous ne respecter pas la règle de placement. Recommencez.");
                        System.out.println("Donnez la ligne de la route à placer.");
                        x = sc.nextLine();
                        x=verifNumber(x);
                        System.out.println("Donnez la colonne de la route à placer.");
                        y = sc.nextLine();
                        y=verifNumber(y);
                        System.out.println("De quel côté voulez-vous la placer ? [n/w/e/s]");
                        pos = sc.nextLine();
                        pos=verifCote(pos);
                    }
                    display.printBoard(game.getBoard());
                    turn++;
                } else {
                    // a ecrie pour l'IA
                    turn++;
                }
                if (turn == 2 * game.getPlayers().length) { // permet de faire deux tour du tableau
                    debut = true;
                }
            }
        }
        int turnP = 0;
        while (!game.endGame()) {
            if (turnP >= game.getPlayers().length) {// pour recommencer au début de la file de joueur
                turnP = 0;
            }
            Player temp = game.getPlayers()[turnP];
            // lancé de dé
            int dice = game.throwDice();
            if (dice != 7) {
                System.out.println("Vous avez fait " + dice);
                game.getBoard().Distribution(dice);
            } else {
                System.out.println("Vous avez fait un 7, veuillez deplacer le voleur.");
                System.out.println("Donnez la ligne où vous voulez placer le voleur.");
                String x = sc.nextLine();
                x=verifNumber(x);
                System.out.println("Donnez la colonne où vous voulez placer le voleur.");
                String y = sc.nextLine();
                y=verifNumber(y);
                while (!game.getBoard().setThief(Integer.parseInt(x), Integer.parseInt(y))) {
                    System.out.println("Vous ne respecter pas la règle de placement. Recommencez");
                    System.out.println("Donnez la ligne où vous voulez placer le voleur.");
                    x = sc.nextLine();
                    x=verifNumber(x);
                    System.out.println("Donnez la colonne où vous voulez placer le voleur.");
                    y = sc.nextLine();
                    y=verifNumber(y);
                }
                // TODO le vol des ressources; si il faut enlever les ressources quand au dessus
                // de 7;
            }
            // si humain
            if (temp.getHuman()) {
                // placer structure
                if (game.hasRessourcesToPlaceStructure(temp)) {
                    System.out.println("Voulez vous placer une colonie ? [y/n]");
                    String rep = sc.nextLine();

                    if (rep.equals("y")) {
                        System.out.println("Donnez la ligne où placer votre colonie.");
                        String x = sc.nextLine();
                        x=verifNumber(x);
                        System.out.println("Donnez la colonne où placer votre colonie.");
                        String y = sc.nextLine();
                        y=verifNumber(y);
                        System.out.println("Dans quel coin voulez-vous la placer ? [ne/nw/se/sw]");
                        String pos = sc.nextLine();
                        pos=verifCoin(pos);
                        while (!game.getBoard().addStructure(Integer.parseInt(x), Integer.parseInt(y),
                                new Structure(0, temp), pos)) {
                            System.out.println("Vous ne respecter pas la règle de placement. Recommencez.");
                            System.out.println("Donnez la ligne où placer votre colonie.");
                            x = sc.nextLine();
                            x=verifNumber(x);
                            System.out.println("donnez la colonne où placer votre colonie.");
                            y = sc.nextLine();
                            y=verifNumber(y);
                            System.out.println("Dans quel coin voulez- vous la placer ? [ne/nw/se/sw]");
                            pos = sc.nextLine();
                            pos=verifCoin(pos);
                        }
                        temp.nbSettelments--;
                        display.printBoard(game.getBoard());
                        // TODO enlevez les ressources
                        // ajouter les point de victoires si besion
                    }

                }
                // placer routes
                if (game.hasRessourcesForRoad(temp)) {
                    System.out.println("Voulez-vous placer une route ? [y/n]");
                    String rep = sc.nextLine();

                    if (rep.equals("y")) {
                        System.out.println("Donnez la ligne où placer votre route.");
                        String x = sc.nextLine();
                        x=verifNumber(x);
                        System.out.println("Donnez la colonne où placer votre route.");
                        String y = sc.nextLine();
                        y=verifNumber(y);
                        System.out.println("Dans quel coin voulez-vous la placer ? [n/w/e/s]");
                        String pos = sc.nextLine();
                        pos=verifCote(pos);
                        while (!game.getBoard().addRoad(Integer.parseInt(x), Integer.parseInt(y), new Road(temp),
                                pos)) {
                            System.out.println("Vous ne respecter pas la règle de placement. Recommencez.");
                            System.out.println("Donnez la ligne où placer votre route.");
                            x = sc.nextLine();
                            x=verifNumber(x);
                            System.out.println("Donnez la colonne où placer votre route.");
                            y = sc.nextLine();
                            y=verifNumber(y);
                            System.out.println("Dans quel coin voulez-vous la placer ? [n/w/e/s]");
                            pos = sc.nextLine();
                            pos=verifCote(pos);
                        }
                        temp.nbRoads--;
                        display.printBoard(game.getBoard());
                        // TODO enlevez les ressources
                        // ajouter les point de victoires si besion
                    }

                }
                // améliorer une colonies
                if (game.hasRessourcesToUpgrade(temp)) {
                    System.out.println("Voulez-vous améliorer une colonie ? [y/n]");
                    String rep = sc.nextLine();

                    if (rep.equals("y")) {
                        System.out.println("Donnez la ligne de la colonie à améliorer.");
                        String x = sc.nextLine();
                        x=verifNumber(x);
                        System.out.println("Donnezla colonne de la colonie à améliorer.");
                        String y = sc.nextLine();
                        y=verifNumber(y);
                        System.out.println("Dans quel coin ?[ne/nw/se/sw]");
                        String pos = sc.nextLine();
                        pos=verifCoin(pos);
                        while (game.getBoard().getTiles()[Integer.parseInt(x)][Integer.parseInt(y)].getStructure(pos)
                                .getOwner() != temp) {
                            System.out.println("Cette colonie n'est pas à vous choisissez en une qui vous appartiens");
                            System.out.println("Donnez la ligne de la colonie à améliorer.");
                            x = sc.nextLine();
                            x=verifNumber(x);
                            System.out.println("Donnez la colonne de la colonie à améliorer.");
                            y = sc.nextLine();
                            y=verifNumber(y);
                            System.out.println("Dans quel coin ?[ne/nw/se/sw]");
                            pos = sc.nextLine();
                            pos=verifCoin(pos);
                        }
                        game.getBoard().getTiles()[Integer.parseInt(x)][Integer.parseInt(y)].getStructure(pos)
                                .setType(1);
                        temp.nbCities--;
                        temp.nbSettelments--;
                        display.printBoard(game.getBoard());
                        // TODO enlevez les ressources
                        // ajouter les point de victoires si besion
                    }
                }
                if (!temp.getDevC().isEmpty()) {
                    // voulez vous jouez une carte ?,laquelle,jouez la carte si oui
                }
                // TODO echange
            } else {
                // si c'est une ia
            }
            turnP++;
        }

        sc.close();
        
    }

    
    
    
}