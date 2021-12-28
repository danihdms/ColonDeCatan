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
                        System.out.println("Vous ne respecter pas la règle de placement recommencé");
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
                        System.out.println("Vous ne respecter pas la règle de placement recommencé");
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
        int turnP=0;
        while(!game.endGame()){
            if(turnP>=game.getPlayers().length){//pour recommencer au début de la file de joueur
                turnP=0;
            }
            Player temp=game.getPlayers()[turnP];
            //lancer le dé
            int dice=game.throwDice();
            if (dice != 7){
                System.out.println("vous avez fait "+ dice);
                game.getBoard().Distribution(dice);
            } else {
                System.out.println("vous avez fait un 7 veuillez deplacer le voleur");
                System.out.println("donnez la ligne ");
                String x=sc.nextLine();
                //verifier x
                System.out.println("donnez la colonne");
                String y=sc.nextLine();
                //verifier y
                while(game.getBoard().setThief(Integer.parseInt(x), Integer.parseInt(y))){
                    System.out.println("Vous ne respecter pas la règle de placement recommencé");
                    System.out.println("donnez la ligne ");
                    x=sc.nextLine();
                    //verifier x
                    System.out.println("donnez la colonne");
                    y=sc.nextLine();
                    //verifier y
                }
                //todo le vole des ressources plus si il faut enlever les ressources quand au dessus de 7;
            }
            //si humain
            if(temp.getHuman()){
                //placer structure
                if (game.hasRessourcesForPlaceStructure(temp)){
                    System.out.println("voulez vous [y/n]");
                    String rep=sc.nextLine();
                    
                    if(rep.equals("y")){
                        System.out.println("donnez la ligne ou placer votre colonie");
                        String x = sc.nextLine();
                        // verifier x
                        System.out.println("donnez la colonne  ou placer votre colonie");
                        String y = sc.nextLine();
                        // verifier y
                        System.out.println("Dans quel coin ?[ne/nw/se/sw]");
                        String pos = sc.nextLine();
                        // verifier pos
                        while (!game.getBoard().addStructure(Integer.parseInt(x),Integer.parseInt(y), new Structure(0, temp), pos)) {
                            System.out.println("Vous ne respecter pas la règle de placement recommencé");
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
                        //Todo enlevez les ressources
                        //ajouter les point de victoires si besion
                    }
                    
                }
                //placer routes
                if (game.hasRessourcesForRoad(temp)){
                    System.out.println("voulez vous [y/n]");
                    String rep=sc.nextLine();
                    
                    if(rep.equals("y")){
                        System.out.println("donnez la ligne ou placer votre route");
                        String x = sc.nextLine();
                        // verifier x
                        System.out.println("donnez la colonne  ou placer votre route");
                        String y = sc.nextLine();
                        // verifier y
                        System.out.println("Dans quel coin ?[n/w/e/s]");
                        String pos = sc.nextLine();
                        // verifier pos
                        while (!game.getBoard().addRoad(Integer.parseInt(x), Integer.parseInt(y), new Road(temp),pos)) {
                            System.out.println("Vous ne respecter pas la règle de placement recommencé");
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
                    //Todo enlevez les ressources
                    //ajouter les point de victoires si besion
                    }
                    
                }
                //améliorer une colonies
                if (game.hasRessourcesForUpgrade(temp)){
                    System.out.println("voulez vous [y/n]");
                    String rep=sc.nextLine();
                    
                    if(rep.equals("y")){
                        System.out.println("donnez la ligne ou ameliorer votre colonie");
                        String x = sc.nextLine();
                        // verifier x
                        System.out.println("donnez la colonne  ou ameliorer votre colonie");
                        String y = sc.nextLine();
                        // verifier y
                        System.out.println("Dans quel coin ?[ne/nw/se/sw]");
                        String pos = sc.nextLine();
                        // verifier pos
                        while (game.getBoard().getTiles()[Integer.parseInt(x)][Integer.parseInt(y)].getStructure(pos).getOwner()!=temp) {
                            System.out.println("Cette colonie n'est pas à vous choisissez en une qui vous appartiens");
                            System.out.println("donnez la ligne ou ameliorer votre colonie");
                            x = sc.nextLine();
                            // verifier x
                            System.out.println("donnez la colonne  ou ameliorer votre colonie");
                            y = sc.nextLine();
                            // verifier y
                            System.out.println("Dans quel coin ?[ne/nw/se/sw]");
                            pos = sc.nextLine();
                            // verifier pos
                        }
                        game.getBoard().getTiles()[Integer.parseInt(x)][Integer.parseInt(y)].getStructure(pos).setType(1);
                        display.printBoard(game.getBoard());
                        //Todo enlevez les ressources
                        //ajouter les point de victoires si besion
                    }
                }
                if(!temp.getDevC().isEmpty()){
                    //voulez vous jouez une carte ?,laquelle,jouez la carte si oui
                }
                //Todo echange
            } else {
                //si c'est une ia
            }
            turnP++;
        }

        
        
        

        sc.close();
    }
}
