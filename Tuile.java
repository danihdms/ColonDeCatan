public class Tuile {
    private int number =0;
    private Location location;
    private boolean Avoleur = false;
    private final String type;
        /*
         *Values:
         * DESERT,BRICK,BOIS,PIERRE,BLE,MOUTON
         */
    public Tuile(int x,int y,int n,String str){
        location=new Location(x, y);
        type=str;
        number=n;
    }    

    public Tuile(String str){
        type=str;
    }

    public Tuile(String str,boolean b){
        type=str;
        Avoleur=b;

    }
    
    public void setCoords(int x,int y){
        location=new Location(x, y);

    }
    public boolean Avoleur(){return Avoleur;}
    public void setVoleur(boolean n){Avoleur=n;}
    public Location getLocation(){return location;}
    public void setNumber(int n){number=n;}
    public int getNumber(){return number;}
    public String getType(){return type;}
}
