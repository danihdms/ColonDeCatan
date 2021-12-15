public abstract class Structure {
    private Player owner =null;
    
    private int x;
    private int y;
    private int type;
        //0 pour colonies,1 pour villes

    public abstract void giveRessources(String resType);

    public void setOwner(Player p){
        if(owner==null){
            owner=p;
        }
    }
    public Player getOwner(){return owner;}
    public int getX(){return x;}
    public int getY(){return y;}
    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}
    public int getType(){return type;}
    public void setType(int t){type=t;}
}
