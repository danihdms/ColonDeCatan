package Game;

import java.util.Random;
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
        int twoRounds = 0;
        int turn = 0;
        while (twoRounds < 2) {
            for (Player p : game.getPlayers()) {
                if (p.getHuman()) {
                    System.out.println("Joueur n°" + (turn + 1)
                            + "\nVous devez placer une colonie.\nDonnez la ligne de la colonie à placer.");
                    String x = sc.nextLine();
                    System.out.println("Donnez la colonne de la colonie à placer.");
                    String y = sc.nextLine();
                    System.out.println("Dans quel coin de la tuile voulez-vous la placer ? [ne/nw/se/sw]");
                    String pos = sc.nextLine();
                    while (!game.getBoard().addStructure(Integer.parseInt(x), Integer.parseInt(y), new Structure(0, p),
                            pos)) {
                        System.out.println(
                                "Vous ne respecter pas la règle de placement. Recommencez.\nDonnez la ligne de la colonie à placer.");
                        x = sc.nextLine();
                        System.out.println("Donnez la colonne de la colonie à placer.");
                        y = sc.nextLine();
                        pos = sc.nextLine();
                    }
                    // ajoutez les points de victoires
                    display.printBoard(game.getBoard());
                    System.out.println(
                            "Vous devez desormais placer une route, près de votre colonie.\nDonnez la ligne de la route à placer.");
                    x = sc.nextLine();
                    System.out.println("Donnez la colonne de la route à placer.");
                    y = sc.nextLine();
                    System.out.println("De quel côté voulez-vous la placer ? [n/w/e/s]");
                    pos = sc.nextLine();
                    while (!game.getBoard().addRoad(Integer.parseInt(x), Integer.parseInt(y), new Road(p), pos)) {
                        System.out.println(
                                "Vous ne respecter pas la règle de placement. Recommencez.\nDonnez la ligne de la route à placer.");
                        x = sc.nextLine();
                        System.out.println("Donnez la colonne de la route à placer.");
                        y = sc.nextLine();
                        System.out.println("De quel côté voulez-vous la placer ? [n/w/e/s]");
                        pos = sc.nextLine();
                    }
                    display.printBoard(game.getBoard());
                    turn++;
                } else {
                    // a ecrie pour l'IA
                    game.addAIStructure(p);
                    game.addAIRoad(p);
                    display.printBoard(game.getBoard());
                    turn++;
                }
            }
            turn = 0;
            twoRounds++;
        }

        int turnP = 0;
        while (!game.endGame()) {
            // pour recommencer au début de la file de joueur
            if (turnP >= game.getPlayers().length) {
                turnP = 0;
            }
            Player player = game.getPlayers()[turnP];

            // lancé de dé
            int dice = game.throwDice();
            if (player.getHuman()) {
                if (dice != 7) {
                    System.out.println("Les dés ont été lancés. Vous avez fait " + dice);
                    game.getBoard().Distribution(dice);
                } else {
                    System.out.println(
                            "Vous avez fait un 7, veuillez deplacer le voleur.\nDonnez la ligne où vous voulez placer le voleur.");
                    String x = sc.nextLine();
                    System.out.println("Donnez la colonne où vous voulez placer le voleur.");
                    String y = sc.nextLine();
                    while (!game.getBoard().setThief(Integer.parseInt(x), Integer.parseInt(y))) {
                        System.out.println(
                                "Vous ne respecter pas la règle de placement. Recommencez.\nDonnez la ligne où vous voulez placer le voleur.");
                        x = sc.nextLine();
                        System.out.println("Donnez la colonne où vous voulez placer le voleur.");
                        y = sc.nextLine();
                    }
                    // TODO le vol des ressources; si il faut enlever les ressources quand au dessus
                    // TODO de 7;
                }
            } else {
                if (dice != 7) {
                    game.getBoard().Distribution(dice);
                } else {
                    game.setAIThief();
                }
            }
            // si humain
            if (player.getHuman()) {
                // placer structure
                if (game.hasRessourcesToPlaceStructure(player) && player.getNbSettlements() > 0) {
                    System.out.println("Voulez vous placer une colonie ? [y/n]");
                    String rep = sc.nextLine();

                    if (rep.equals("y")) {
                        System.out.println("Donnez la ligne où placer votre colonie.");
                        String x = sc.nextLine();
                        System.out.println("Donnez la colonne où placer votre colonie.");
                        String y = sc.nextLine();
                        System.out.println("Dans quel coin voulez-vous la placer ? [ne/nw/se/sw]");
                        String pos = sc.nextLine();
                        while (!game.getBoard().addStructure(Integer.parseInt(x), Integer.parseInt(y),
                                new Structure(0, player), pos)) {
                            System.out.println("Vous ne respecter pas la règle de placement. Recommencez.");
                            System.out.println("Donnez la ligne où placer votre colonie.");
                            x = sc.nextLine();
                            System.out.println("donnez la colonne où placer votre colonie.");
                            y = sc.nextLine();
                            System.out.println("Dans quel coin voulez- vous la placer ? [ne/nw/se/sw]");
                            pos = sc.nextLine();
                        }
                        player.nbSettelments--;
                        display.printBoard(game.getBoard());
                        // TODO enlevez les ressources
                        // ajouter les point de victoires si besion
                    }

                }

                // placer routes
                if (game.hasRessourcesForRoad(player) && player.getNbRoads() > 0) {
                    System.out.println("Voulez-vous placer une route ? [y/n]");
                    String rep = sc.nextLine();

                    if (rep.equals("y")) {
                        System.out.println("Donnez la ligne où placer votre route.");
                        String x = sc.nextLine();
                        System.out.println("Donnez la colonne où placer votre route.");
                        String y = sc.nextLine();
                        System.out.println("Dans quel coin voulez-vous la placer ? [n/w/e/s]");
                        String pos = sc.nextLine();
                        while (!game.getBoard().addRoad(Integer.parseInt(x), Integer.parseInt(y), new Road(player),
                                pos)) {
                            System.out.println("Vous ne respecter pas la règle de placement. Recommencez.");
                            System.out.println("Donnez la ligne où placer votre route.");
                            x = sc.nextLine();
                            System.out.println("Donnez la colonne où placer votre route.");
                            y = sc.nextLine();
                            System.out.println("Dans quel coin voulez-vous la placer ? [n/w/e/s]");
                            pos = sc.nextLine();
                        }
                        player.nbRoads--;
                        display.printBoard(game.getBoard());
                        // TODO enlevez les ressources
                        // ajouter les point de victoires si besion
                    }

                }
                // améliorer une colonies
                if (game.hasRessourcesToUpgrade(player) && player.getNbCities() > 0) {
                    System.out.println("Voulez-vous améliorer une colonie ? [y/n]");
                    String rep = sc.nextLine();

                    if (rep.equals("y")) {
                        System.out.println("Donnez la ligne de la colonie à améliorer.");
                        String x = sc.nextLine();
                        System.out.println("Donnez la colonne de la colonie à améliorer.");
                        String y = sc.nextLine();
                        System.out.println("Dans quel coin ?[ne/nw/se/sw]");
                        String pos = sc.nextLine();
                        while (game.getBoard().getTiles()[Integer.parseInt(x)][Integer.parseInt(y)].getStructure(pos)
                                .getOwner() != player) {
                            System.out.println("Cette colonie n'est pas à vous choisissez en une qui vous appartiens");
                            System.out.println("Donnez la ligne de la colonie à améliorer.");
                            x = sc.nextLine();
                            System.out.println("Donnez la colonne de la colonie à améliorer.");
                            y = sc.nextLine();
                            System.out.println("Dans quel coin ?[ne/nw/se/sw]");
                            pos = sc.nextLine();
                        }
                        game.getBoard().getTiles()[Integer.parseInt(x)][Integer.parseInt(y)].getStructure(pos)
                                .setType(1);
                        player.nbCities--;
                        player.nbSettelments++;
                        display.printBoard(game.getBoard());
                        // TODO enlevez les ressources
                        // ajouter les point de victoires si besion
                    }
                }
                if (!player.getDevC().isEmpty()) {
                    // voulez vous jouez une carte ?,laquelle,jouez la carte si oui
                }
                // TODO echange
            } else {
                // si c'est une ia
                if (game.hasRessourcesToPlaceStructure(player) && player.getNbSettlements() > 0) {
                    game.addAIStructure(player);
                    display.printBoard(game.getBoard());
                }

                if (game.hasRessourcesForRoad(player) && player.getNbRoads() > 0) {
                    game.addAIRoad(player);
                    display.printBoard(game.getBoard());
                }

                if (game.hasRessourcesToUpgrade(player) && player.getNbCities() > 0) {
                    Integer[] coordinates = game.getCoordinatesOfStructure(player);
                    String pos = "";
                    switch (coordinates[2]) {
                        case 0:
                            pos = "ne";
                            break;
                        case 1:
                            pos = "se";
                            break;
                        case 2:
                            pos = "nw";
                            break;
                        case 3:
                            pos = "sw";
                            break;
                    }
                    game.getBoard().getTiles()[coordinates[0]][coordinates[1]].getStructure(pos).setType(1);
                    player.nbCities--;
                    player.nbSettelments++;
                    // TODO enlevez les ressources
                    // ajouter les point de victoires si besion
                }
                if (!player.getDevC().isEmpty()) {
                    // voulez vous jouez une carte ?,laquelle,jouez la carte si oui
                }
                // TODO echange
            }
            turnP++;
        }

        sc.close();

    }

}