import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private Tile[][] tiles;
    private Structure[][] structures;
    private Road[][] roads;
    // voleurLocation to do
    private Road endpoint = null;

    public Board() {
        tiles = new Tile[7][7];
        structures = new Structure[7][7];
        roads = new Road[7][7];
        Tile desert = new Tile("desert", true);

        // création d'une listes pour mettre les tiles de façon aléatoire sur le
        // plateau

        ArrayList<Tile> tileList = new ArrayList<Tile>();
        tileList.add(new Tile("bois"));
        tileList.add(new Tile("bois"));
        tileList.add(new Tile("bois"));
        tileList.add(new Tile("bois"));
        tileList.add(new Tile("argile"));
        tileList.add(new Tile("argile"));
        tileList.add(new Tile("argile"));
        tileList.add(new Tile("ble"));
        tileList.add(new Tile("ble"));
        tileList.add(new Tile("ble"));
        tileList.add(new Tile("ble"));
        tileList.add(new Tile("pierre"));
        tileList.add(new Tile("pierre"));
        tileList.add(new Tile("pierre"));
        tileList.add(new Tile("mouton"));
        tileList.add(new Tile("mouton"));
        tileList.add(new Tile("mouton"));
        tileList.add(new Tile("mouton"));

        // Melange de la liste
        Collections.shuffle(tileList);

        // Placement des tuiles et de leur numero
        placeTiles(tileList);
        placeNumbers();

        // voleurLocation = desert.getLocation();
    }

    public void placeTiles(ArrayList<Tile> tileList) {
        // Nous avons decide de ne pas faire un plateau carre mais ressemblant plus a une ile
        int count = 0;
        for (int row = 1; row < 6; row++) {
            switch (row) {
                case 1:
                    for (int col = 1; col < 4; col++) {
                        tiles[col][row] = tileList.get(count);

                        count++;
                    }
                    break;
                case 2:
                    for (int col = 1; col < 5; col++) {
                        tiles[col][row] = tileList.get(count);

                        count++;
                    }
                    break;
                case 3:
                    for (int col = 1; col < 6; col++) {
                        tiles[col][row] = tileList.get(count);

                        count++;
                    }
                    break;
                case 4:
                    for (int col = 2; col < 6; col++) {
                        tiles[col][row] = tileList.get(count);

                        count++;
                    }
                    break;
                case 5:
                    for (int col = 3; col < 6; col++) {
                        tiles[col][row] = tileList.get(count);

                        count++;
                    }
                    break;
            }
        }
    }

    public void placeNumbers(){
        // Ces deux tableaux permettent de placer les numeros sur les tuiles en spirale.
        // Ces numeros ne changent pas, tandis que la place des tuiles change a chaque partie (placées au hasard)
        int[] numberOrder = { 5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 8, 10, 9, 4, 5, 6, 3, 11 }; // ordre des nombres
        int numberTile = 0;
        int[] tileOrder = { 3, 5, 2, 4, 1, 3, 1, 2, 1, 1, 2, 1, 3, 1, 4, 2, 5, 3, 5, 4, 5, 5, 4, 5, 3, 4, 2, 3, 2, 2, 3,
                2, 4, 3, 4, 4, 3, 3 }; // coordonées x et y assignées aux tuiles
        // on assigne les numero à leurs tiles
        for (int s = 0; s < tileOrder.length - 1; s += 2) {
            if (numberTile == 18) {
                break;
            }
            if (tiles[tileOrder[s]][tileOrder[s + 1]].getType().equals("DESERT")) {

            } else {
                tiles[tileOrder[s]][tileOrder[s + 1]].setNumber(numberOrder[numberTile]);
            }
        }
    }
        
    // placer les structures
    // placer les routes
    // distribuer les ressources
    // rechercher sur le plateau les tiles avec le numéro fournie
    // getter setter structure ,routes,voleur
    // placer une colonies meme sans route avec vérification des espaces entre 2
    // colonies d'une même équipe
    // checker et assigner si bon la colonie au joueur
    // checker et assigner si bon la route au joueur
    // regarder si la localisation est corretcte puis upgrade en city
    // verifier la localisation puis deplacer le voleur
    // donner la liste de structure autour du voleur
    // getter pour une tile precise
    // avoir les structures adjacentes autour d'une certain point
    // trouver la plus longue route(optionnel)
    // trouver les routes adjacentes et connecter à une route donné(optionnel)
    // verifier si une localisation est un port

}
