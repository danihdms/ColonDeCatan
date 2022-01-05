package Game;

import java.util.ArrayList;
import java.util.Scanner;

import Display.ConsoleDisplay;
import Cards.*;

public class PlayConsole {
    public static void main(String[] args) {
        // argile, laine, blé, minerais, bois

        ResCard[] coutRoad = { new ResCard("argile"), new ResCard("bois") };
        ResCard[] coutUpgrade = { new ResCard("blé"), new ResCard("blé"), new ResCard("minerais"),
                new ResCard("minerais"), new ResCard("minerais") };
        ResCard[] coutStructure = { new ResCard("argile"), new ResCard("bois"), new ResCard("blé"),
                new ResCard("laine") };
        ResCard[] coutPioche = { new ResCard("blé"), new ResCard("minerais"), new ResCard("laine") };
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
                    System.out.println("Donnez la colonne de la colonie à placer.");
                    String y = sc.nextLine();
                    System.out.println("Dans quel coin de la tuile voulez-vous la placer ? [ne/no/se/so]");
                    String pos = sc.nextLine();
                    while (!game.getBoard().addStructure(Integer.parseInt(x), Integer.parseInt(y), new Structure(0, p),
                            pos)) {
                        System.out.println("Vous ne respecter pas la règle de placement. Recommencez.");
                        System.out.println("Donnez la ligne de la colonie à placer.");
                        x = sc.nextLine();
                        System.out.println("Donnez la colonne de la colonie à placer.");
                        y = sc.nextLine();
                        System.out.println("Dans quel coin voulez-vous la placer ? [ne/no/se/so]");
                        pos = sc.nextLine();
                    }
                    System.out.println("Vous gagnez 1 point de victoire");
                    game.giveVictoryP(p);

                    display.printBoard(game.getBoard());
                    System.out.println("Vous devez desormais placer une route, près de votre colonie.");
                    System.out.println("Donnez la ligne de la route à placer.");
                    x = sc.nextLine();
                    System.out.println("Donnez la colonne de la route à placer.");
                    y = sc.nextLine();
                    System.out.println("De quel côté voulez-vous la placer ? [n/o/e/s]");
                    pos = sc.nextLine();
                    while (!game.getBoard().addRoad(Integer.parseInt(x), Integer.parseInt(y), new Road(p), pos)) {
                        System.out.println("Vous ne respecter pas la règle de placement. Recommencez.");
                        System.out.println("Donnez la ligne de la route à placer.");
                        x = sc.nextLine();
                        System.out.println("Donnez la colonne de la route à placer.");
                        y = sc.nextLine();
                        System.out.println("De quel côté voulez-vous la placer ? [n/o/e/s]");
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
            Player player = game.getPlayers()[turnP];
            // lancé de dé
            int dice = game.throwDice();
            
            if (player.getHuman()) {

                if (dice != 7) {
                    System.out.println("Vous avez fait " + dice);
                    game.distribution(dice);
                } else {
                    System.out.println("Vous avez fait un 7, veuillez deplacer le voleur.");
                    System.out.println("Donnez la ligne où vous voulez placer le voleur.");
                    String x = sc.nextLine();
                    System.out.println("Donnez la colonne où vous voulez placer le voleur.");
                    String y = sc.nextLine();
                    while (!game.getBoard().setThief(Integer.parseInt(x), Integer.parseInt(y))) {
                        System.out.println("Vous ne respecter pas la règle de placement. Recommencez");
                        System.out.println("Donnez la ligne où vous voulez placer le voleur.");
                        x = sc.nextLine();
                        System.out.println("Donnez la colonne où vous voulez placer le voleur.");
                        y = sc.nextLine();
                    }

                    Structure[] tabAction = game.getBoard().getThiefColonies();
                    int res = game.getRandom(game.getResCards().size());
                    int playerChoose = game.getRandom(tabAction.length);
                    // vol d'une ressources apres le placement du voleur
                    if (tabAction != null) {
                        while (tabAction[playerChoose].getOwner() == player) {

                            playerChoose = game.getRandom(tabAction.length);

                        }
                        while (!game.hasRessources(1, game.getResCards().get(res),
                                tabAction[playerChoose].getOwner())) {
                            res = game.getRandom(game.getResCards().size());
                        }
                        game.enleveRessources(game.getResCards().get(res), tabAction[playerChoose].getOwner());
                        game.giveRessources(game.getResCards().get(res), player);
                        System.out.println("vous avez trouvé des ressources");
                    }
                    // le vol des ressources; si il faut enlever les ressources quand au dessus de
                    // 7;
                    for (int i = 0; i < game.getPlayers().length; i++) {
                        if (game.getPlayers()[i].getResC().size() > 7) {
                            int s = game.getPlayers()[i].getResC().size() / 2;
                            for (int j = 0; j < s; j++) {
                                game.getResCards().add(game.getPlayers()[i].getResC().get(i));
                                game.getPlayers()[i].getResC().remove(j);
                            }
                        }
                    }
                }
            } else {
                if (dice != 7) {
                    game.distribution(dice);
                } else {
                    game.setAIThief();

                }
            }
            // si humain
            if (player.getHuman()) {
                
                
                
                System.out.println(game.PlayerStat(player));
                // placer structure
                if (!game.structuresFull() && game.hasRessourcesToPlaceStructure(player)
                        && player.getNbSettlements() > 0) {
                    System.out.println("Voulez vous placer une colonie ? [y/n]");
                    String rep = sc.nextLine();

                    if (rep.equals("y")) {
                        System.out.println("Donnez la ligne où placer votre colonie.");
                        String x = sc.nextLine();
                        System.out.println("Donnez la colonne où placer votre colonie.");
                        String y = sc.nextLine();
                        System.out.println("Dans quel coin voulez-vous la placer ? [ne/no/se/so]");
                        String pos = sc.nextLine();
                        while (!game.getBoard().addStructure(Integer.parseInt(x), Integer.parseInt(y),
                                new Structure(0, player), pos)) {
                            System.out.println("Vous ne respecter pas la règle de placement. Recommencez.");
                            System.out.println("Donnez la ligne où placer votre colonie.");
                            x = sc.nextLine();
                            System.out.println("donnez la colonne où placer votre colonie.");
                            y = sc.nextLine();
                            System.out.println("Dans quel coin voulez- vous la placer ? [ne/no/se/so]");
                            pos = sc.nextLine();
                        }
                        player.nbSettelments--;
                        display.printBoard(game.getBoard());
                        game.PrendrePaiement(player, coutStructure);
                        System.out.println("Vous gagnez 1 point de victoire");
                        game.giveVictoryP(player);
                    }

                }
                // placer routes
                if (!game.roadsFull() && game.hasRessourcesForRoad(player) && player.getNbRoads() > 0) {
                    System.out.println("Voulez-vous placer une route ? [y/n]");
                    String rep = sc.nextLine();

                    if (rep.equals("y")) {
                        System.out.println("Donnez la ligne où placer votre route.");
                        String x = sc.nextLine();
                        System.out.println("Donnez la colonne où placer votre route.");
                        String y = sc.nextLine();
                        System.out.println("Dans quel coin voulez-vous la placer ? [n/o/e/s]");
                        String pos = sc.nextLine();
                        while (!game.getBoard().addRoad(Integer.parseInt(x), Integer.parseInt(y), new Road(player),
                                pos)) {
                            System.out.println("Vous ne respecter pas la règle de placement. Recommencez.");
                            System.out.println("Donnez la ligne où placer votre route.");
                            x = sc.nextLine();
                            System.out.println("Donnez la colonne où placer votre route.");
                            y = sc.nextLine();
                            System.out.println("Dans quel coin voulez-vous la placer ? [n/o/e/s]");
                            pos = sc.nextLine();
                        }
                        player.nbRoads--;
                        display.printBoard(game.getBoard());
                        game.PrendrePaiement(player, coutRoad);
                        // TODO la route la plus longue plus tout ce qu'il y a autour
                    }
                }
                // améliorer une colonies
                if (game.hasRessourcesToUpgrade(player) && player.getNbCities() > 0) {
                    System.out.println("Voulez-vous améliorer une colonie ? [y/n]");
                    String rep = sc.nextLine();

                    if (rep.equals("y")) {
                        System.out.println("Donnez la ligne de la colonie à améliorer.");
                        String x = sc.nextLine();
                        System.out.println("Donnezla colonne de la colonie à améliorer.");
                        String y = sc.nextLine();
                        System.out.println("Dans quel coin ?[ne/no/se/so]");
                        String pos = sc.nextLine();
                        while (game.getBoard().getTiles()[Integer.parseInt(x)][Integer.parseInt(y)].getStructure(pos)
                                .getOwner() != player) {
                            System.out.println("Cette colonie n'est pas à vous choisissez en une qui vous appartiens");
                            System.out.println("Donnez la ligne de la colonie à améliorer.");
                            x = sc.nextLine();
                            System.out.println("Donnez la colonne de la colonie à améliorer.");
                            y = sc.nextLine();
                            System.out.println("Dans quel coin ?[ne/no/se/so]");
                            pos = sc.nextLine();
                        }
                        game.getBoard().getTiles()[Integer.parseInt(x)][Integer.parseInt(y)].getStructure(pos)
                                .setType(1);
                        player.nbCities--;
                        player.nbSettelments++;
                        display.printBoard(game.getBoard());
                        game.PrendrePaiement(player, coutUpgrade);
                        System.out.println("Vous gagnez 1 point de victoire");
                        game.giveVictoryP(player);
                    }
                }

                // voulez vous jouez une carte ?,laquelle,jouez la carte si oui
                if (game.hassRessourcesPickCard(player)) {
                    System.out.println("Voulez-vous piochez une carte ? [y/n]");
                    String rep = sc.nextLine();

                    if (rep.equals("y")) {
                        game.throwCard(player);
                        game.PrendrePaiement(player, coutPioche);
                    }
                    if (!player.getDevC().isEmpty()) {
                        System.out.println("Voulez vous jouez l'une de vos cartes ?[y/n]");
                        rep = sc.nextLine();
                        if (rep.equals("y")) {
                            System.out.println("Vous avez le choix entre ces cartes Choisissez avec le numéro");
                            for (int i = 0; i < player.getDevC().size(); i++) {
                                System.out.println(i + "." + player.getDevC().get(i).getType());
                            }
                            rep = sc.nextLine();
                            // verifiez le numero

                            player.getDevC().get(Integer.parseInt(rep)).useCard();
                            // todo les différenetes cartes et effets
                            switch (player.getDevC().get(Integer.parseInt(rep)).getType()) {
                                case "victory":
                                    player.setV(player.getV() + 2);
                                    player.getDevC().remove(Integer.parseInt(rep));
                                    break;
                                case "knight":
                                    System.out.println("Veuillez deplacer le voleur.");
                                    System.out.println("Donnez la ligne où vous voulez placer le voleur.");
                                    String x = sc.nextLine();
                                    System.out.println("Donnez la colonne où vous voulez placer le voleur.");
                                    String y = sc.nextLine();
                                    while (!game.getBoard().setThief(Integer.parseInt(x), Integer.parseInt(y))) {
                                        System.out.println(
                                                "Vous ne respecter pas la règle de placement. Recommencez");
                                        System.out.println("Donnez la ligne où vous voulez placer le voleur.");
                                        x = sc.nextLine();
                                        System.out.println("Donnez la colonne où vous voulez placer le voleur.");
                                        y = sc.nextLine();
                                    }
                                    
                                    Structure[] tabAction = game.getBoard().getThiefColonies();
                                    int res = game.getRandom(game.getResCards().size());
                                    int playerChoose = game.getRandom(tabAction.length);
                                    // vol d'une ressources apres le placement du voleur
                                    if (tabAction != null) {
                                        while (tabAction[playerChoose].getOwner() == player) {

                                            playerChoose = game.getRandom(tabAction.length);

                                        }
                                        while (!game.hasRessources(1, game.getResCards().get(res),
                                                tabAction[playerChoose].getOwner())) {
                                            res = game.getRandom(game.getResCards().size());
                                        }
                                        game.enleveRessources(game.getResCards().get(res),
                                                tabAction[playerChoose].getOwner());
                                        game.giveRessources(game.getResCards().get(res), player);
                                        System.out.println("vous avez trouvé des ressources");
                                    }
                                    player.chevalierJ++;
                                    if (player.chevalierJ == 3 && !game.getFirtsTo3Knight()) {
                                        player.setV(player.getV() + 2);
                                        game.setfirstTo3Knigths();
                                    }
                                    player.getDevC().remove(Integer.parseInt(rep));
                                    break;
                                case "roadBuilding":
                                    int count = 0;
                                    while (count < 2) {
                                        System.out.println("Donnez la ligne où placer votre route.");
                                        x = sc.nextLine();
                                        System.out.println("Donnez la colonne où placer votre route.");
                                        y = sc.nextLine();
                                        System.out.println("Dans quel coin voulez-vous la placer ? [n/o/e/s]");
                                        String pos = sc.nextLine();
                                        while (!game.getBoard().addRoad(Integer.parseInt(x), Integer.parseInt(y),
                                                new Road(player),
                                                pos)) {
                                            System.out.println(
                                                    "Vous ne respecter pas la règle de placement. Recommencez.");
                                            System.out.println("Donnez la ligne où placer votre route.");
                                            x = sc.nextLine();
                                            System.out.println("Donnez la colonne où placer votre route.");
                                            y = sc.nextLine();
                                            System.out.println("Dans quel coin voulez-vous la placer ? [n/o/e/s]");
                                            pos = sc.nextLine();
                                        }
                                        
                                        player.nbRoads--;
                                        count++;
                                    }
                                    // verifier si route la plus longue;
                                    player.getDevC().remove(Integer.parseInt(rep));
                                case "monopoly":
                                    System.out.println(
                                            "choisissez une ressources à monopoliser entre :[argile, laine, blé, minerais, bois]");
                                    String repp = sc.nextLine();
                                    for (int i = 0; i < game.getPlayers().length; i++) {
                                        if (game.getPlayers()[i] != player) {
                                            while (game.hasRessources(1, new ResCard(repp), game.getPlayers()[i])) {
                                                game.enleveRessources(new ResCard(repp), game.getPlayers()[i]);
                                                game.giveRessources(new ResCard(repp), player);
                                            }
                                        }
                                    }
                                    player.getDevC().remove(Integer.parseInt(rep));
                                    break;
                                case "yearOfPlenty":
                                    System.out.println(
                                            "Vous avez le droit de choisir deux ressources parmi [argile, laine, blé, minerais, bois]");

                                    System.out.println("Ressource 1:");
                                    String ress = sc.nextLine();
                                    game.giveRessources(new ResCard(ress), player);
                                    System.out.println("Ressource 2:");
                                    ress = sc.nextLine();
                                    game.giveRessources(new ResCard(ress), player);
                                    player.getDevC().remove(Integer.parseInt(rep));

                                default:
                                    break;
                            }
                            display.printBoard(game.getBoard());

                            

                        }

                    }
                }

                if (game.AcotéDunPort(player)) {

                    System.out.println(
                            "Vous pouvez échanger des ressources avec un port,vous pouvez donnez deux  ressources  similaire au port contre une choisis");
                    System.out.println("vous voulez ?[y/n]");
                    String answer = sc.nextLine();
                    if (answer.equals("y")) {
                        ArrayList<String> port = game.ListPortPlayer(player);
                        System.out.println("Vous avez le choix entre :");
                        for (String s : port) {
                            System.out.print(s + " ");
                        }
                        System.out.println("");
                        answer = sc.nextLine();
                        if (game.hasRessources(2, new ResCard(answer), player)) {
                            System.out.println("choisissez votre ressources [laine,blé,bois,argile,minerais]");
                            String choix = sc.nextLine();
                            game.enleveRessources(new ResCard(answer), player);
                            game.enleveRessources(new ResCard(answer), player);
                            game.giveRessources(new ResCard(choix), player);
                        } else {
                            System.out.println("vous n'avez pas les ressources suffisantes");
                        }

                    }
                }
                // TODO echange
            } else {
                // si c'est une ia
                if (!game.structuresFull() && game.hasRessourcesToPlaceStructure(player)
                        && player.getNbSettlements() > 0) {
                    game.addAIStructure(player);
                    display.printBoard(game.getBoard());
                }

                if (!game.roadsFull() && game.hasRessourcesForRoad(player) && player.getNbRoads() > 0) {
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
                            pos = "no";
                            break;
                        case 3:
                            pos = "so";
                            break;
                    }
                    game.getBoard().getTiles()[coordinates[0]][coordinates[1]].getStructure(pos).setType(1);
                    player.nbCities--;
                    player.nbSettelments++;
                    display.printBoard(game.getBoard());
                    // TODO enlevez les ressources
                    // ajouter les point de victoires si besion
                }
                if (!player.getDevC().isEmpty()) {
                    // voulez vous jouez une carte ?,laquelle,jouez la carte si oui
                }
            }
            turnP++;
        }
        sc.close();

    }
}