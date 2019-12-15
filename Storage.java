
public class Storage {

    private int numberOfStoredGoods;
    private int numberOfSoldGoods;
    private int numberOfGoodsToBeSold;
    private double priceOfGood;
    private int numberOfGoodsThisMonth;

    public Storage(String line) {
        if (line != null) {
            String[] arr = line.split("#");
            this.numberOfStoredGoods = Integer.parseInt(arr[0]);
            this.numberOfSoldGoods = Integer.parseInt(arr[1]);
            this.numberOfGoodsToBeSold = Integer.parseInt(arr[2]);
            this.priceOfGood = Double.parseDouble(arr[3]);
            this.numberOfGoodsThisMonth = Integer.parseInt(arr[4]);
        }
    }

    public void setNumberOfStoredGoods(int SoldGoods) {
        this.numberOfStoredGoods = SoldGoods;
    }

    public int getNumberOfStoredGoods() {
        return numberOfStoredGoods;
    }

    public void setNumberOfSoldGoods(int numberOfSoldGoods) {
        this.numberOfSoldGoods = numberOfSoldGoods;
    }

    public int getNumberOfSoldGood() {
        return numberOfSoldGoods;
    }

    public void setNumberOfGoodsTobeSold(int amount) {
        this.numberOfGoodsToBeSold = amount;
    }

    public int getNumberOfGoodsToBeSold() {
        return numberOfGoodsToBeSold;
    }

    public void setPriceOfGoods(double price) {
        this.priceOfGood = price;
    }

    public double getPriceofGoods() {
        return priceOfGood;
    }

    public void setnumberOfGoodsThisMonth(int amount) {
        this.numberOfGoodsThisMonth = amount;
    }

    public int getnumberOfGoodsThisMonth() {
        return numberOfGoodsThisMonth;
    }

    public String toString() {
        return numberOfStoredGoods + "#" + numberOfSoldGoods + "#" + numberOfGoodsToBeSold + "#" + priceOfGood + "#" + numberOfGoodsThisMonth;
    }
}
