package Game;

import java.util.Scanner;

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
        while(nbPlayers != 3 && nbPlayers != 4){
            System.out.println("Il faut choisir entre 3 ou 4 joueurs.\nVoulez-vous jouer à 3 ou 4 personnes ?");
            nbPlayers = sc.nextInt();
        }

        Player[] players = new Player[nbPlayers];
        String[] colors = {"red", "green","blue", "yellow"};
        for(int i = 0; i < nbPlayers; i++){
            boolean human = false;

            System.out.println("Le joueur " + (i+1) + " est-il un humain ou une IA ?");
            String ans = sc.nextLine();
            if(ans.equals("humain")){
                human = true;
            }
            System.out.println("Quel est le prénom de ce joueur ?");
            String name = sc.nextLine();
            players[i] = new Player(name, colors[i], human);
        }
        
        Game game = new Game(players);
        for(Player p : game.getPlayers()){
            System.out.println(p.getName() + p.getHuman());
        }


        sc.close();
    }
}
