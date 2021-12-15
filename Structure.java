public abstract class Structure {
    private Player owner =null;
    
    private CoinLocation location;
    private int type;
        //0 pour colonies,1 pour villes

    public abstract void giveRessources(String resType);

    public void setOwner(Player p){
        if(owner==null){
            owner=p;
        }
    }
    public Player getOwner(){return owner;}
    public void setLocation(CoinLocation location){this.location=location;}
    public int getType(){return type;}
    public void setType(int t){type=t;}
}
