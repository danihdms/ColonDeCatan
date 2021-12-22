public class Structure {
    private Player owner = null;
    private int type; // 0 pour colonies,1 pour villes

    public Structure(int type, Player owner){
        this.type = type;
        this.owner = owner;
    }

    public void giveRessources(String resType){
        if(type == 1) {
        //getOwner().setNumberResourcesType(resType,getOwner().getNumberResourecesType(resType)+2);
        } else if (type == 0){
        //getOwner().setNumberResourcesType(resType,getOwner().getNumberResourecesType(resType)+1);
        }
    }
    
    public void setOwner(Player p) {
        if (owner == null) {
            owner = p;
        }
    }

    public Player getOwner() {
        return owner;
    }

    public int getType() {
        return type;
    }

    public void setType(int t) {
        type = t;
    }
}
