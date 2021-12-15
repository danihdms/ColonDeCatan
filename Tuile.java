public class Tuile {
    private int number =0;
    private int x,y;
    private boolean Avoleur = false;
    private Route n,s,e,o;
    private Structure no,ne,se,so; 
    private final String type;
        /*
         *Values:
         * DESERT,BRICK,BOIS,PIERRE,BLE,MOUTON
         */
    public Tuile(int x,int y,int n,String str){
        this.x=x;
        this.y=y;
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
    
    public int getX(){return x;}
    public int getY(){return y;}
    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}
    public boolean Avoleur(){return Avoleur;}
    public void setVoleur(boolean n){Avoleur=n;}
    
    public void setNumber(int n){number=n;}
    public int getNumber(){return number;}
    public String getType(){return type;}
}
