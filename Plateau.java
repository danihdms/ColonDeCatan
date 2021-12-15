import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Plateau {
    private Tuile[][] tuiles;
    private Structure[][] structures;
    private Route[][] routes;
    //voleurLocation to do
    private Route endpoint = null;

    public Plateau() {
        tuiles = new Tuile[7][7];
        structures = new Structure[7][7];
        routes = new Route[7][7];
        Tuile desert = new Tuile("DESERT", true);

        // création d'une listes pour mettre les tuiles de façon aléatoire sur le
        // plateau

        ArrayList<Tuile> tuileList = new ArrayList<Tuile>();
        tuileList.add(new Tuile("BOIS"));
        tuileList.add(new Tuile("BOIS"));
        tuileList.add(new Tuile("BOIS"));
        tuileList.add(new Tuile("BOIS"));
        tuileList.add(new Tuile("BRICK"));
        tuileList.add(new Tuile("BRICK"));
        tuileList.add(new Tuile("BRICK"));
        tuileList.add(new Tuile("BLE"));
        tuileList.add(new Tuile("BLE"));
        tuileList.add(new Tuile("BLE"));
        tuileList.add(new Tuile("BLE"));
        tuileList.add(new Tuile("Pierre"));
        tuileList.add(new Tuile("Pierre"));
        tuileList.add(new Tuile("Pierre"));
        tuileList.add(new Tuile("Mouton"));
        tuileList.add(new Tuile("Mouton"));
        tuileList.add(new Tuile("Mouton"));
        tuileList.add(new Tuile("Mouton"));

        // mélanger la list

        Collections.shuffle(tuileList);

        // on place les tuiles

        int count = 0;

        for (int row = 1; row < 6; row++) {
            switch (row) {
                case 1:
                    for (int col = 1; col < 4; col++) {
                        tuiles[col][row] = tuileList.get(count);
                        
                        count++;
                    }
                    break;
                case 2:
                    for (int col = 1; col < 5; col++) {
                        tuiles[col][row] = tuileList.get(count);
                        
                        count++;
                    }
                    break;
                case 3:
                    for (int col = 1; col < 6; col++) {
                        tuiles[col][row] = tuileList.get(count);
                       
                        count++;
                    }
                    break;
                case 4:
                    for (int col = 2; col < 6; col++) {
                        tuiles[col][row] = tuileList.get(count);
                        
                        count++;
                    }
                    break;
                case 5:
                    for (int col = 3; col < 6; col++) {
                        tuiles[col][row] = tuileList.get(count);
                        
                        count++;
                    }
                    break;
            }

            //voleurLocation = desert.getLocation();
        }
        //ordre des nombres

        int [] numberOrder = {5,2,6,3,8,10,9,12,11,4,8,10,9,4,5,6,3,11};
        int numberTile =0;

        //les coordonées x y assigné au tuiles
        int [] tileOrder = {3,5, 2,4, 1,3, 1,2, 1,1, 2,1, 3,1, 4,2, 5,3, 5,4, 5,5, 4,5, 3,4, 2,3, 2,2, 3,2, 4,3, 4,4, 3,3};
        //on assigne les numero à leurs tuiles
        for(int s=0;s<tileOrder.length-1;s+=2){
            if(numberTile==18){
                break;
            }
            if (tuiles[tileOrder[s]][tileOrder[s+1]].getType().equals("DESERT")){

            } else {
                tuiles[tileOrder[s]][tileOrder[s+1]].setNumber(numberOrder[numberTile]);
            }

            
        }
        //mettre toutes les tuiles vides qui représente l'eau
        for (int i =0;i<tuiles.length;i++){
            for (int j=0;j<tuiles[0].length;j++){
                if (tuiles[i][j] == null){
                    tuiles[i][j] = new Tuile(i,j,0,null);
                }
            }
        }
        //placer les structures
        
        //placer les routes
        
    }
    //distribuer les ressources
    //rechercher sur le plateau les tuiles avec le numéro fournie
    //getter setter structure ,routes,voleur
    //placer une colonies meme sans route avec vérification des espaces entre 2 colonies d'une même équipe
    //checker et assigner si bon la colonie au joueur
    //checker et assigner si bon la route au joueur
    //regarder si la localisation est corretcte puis upgrade en city
    //verifier la localisation puis deplacer le voleur
    //donner la liste de structure autour du voleur
    //getter pour une tuile precise
    //avoir les structures adjacentes autour d'une certain point
    //trouver la plus longue route(optionnel)
    //trouver les routes adjacentes et connecter à une route donné(optionnel)
    //verifier si une localisation est un port

}
