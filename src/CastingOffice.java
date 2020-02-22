/** This class handles upgrading the player and storing the various costs for upgrading */

public class CastingOffice {

    private static int[][] costs ={
            {2, 4, 5},
            {3, 10, 10},
            {4, 18, 15},
            {5, 28, 20},
            {6, 40, 25}
    };

    //Upgrades player object and subtracts appropriate credits/money
    public void upgrade(int[] newRank, Player player){
        if(newRank[0] == 0){
            int newCredit = player.getCredit() - newRank[2];
            player.setCredit(newCredit);
            player.setRank(newRank[1]);
        }else if(newRank[0] == 1){
            int newMoney = player.getMoney() - newRank[2];
            player.setMoney(newMoney);
            player.setRank(newRank[1]);
        }
    }

    public int[][] getCosts(){
        return this.costs;
    }
}
