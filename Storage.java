
public class Storage {

    private int numberOfStoredGoods;
    private int numberOfSoldGoods;
    private int numberOfGoodsToBeSold;
    private double priceOfGood;
    private int numberOfGoodsThisMonth;

    public Storage() {
        String line = FileData.getData("Storage.txt");
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
        String line = this.toString();
        FileData.setData(line, "Storage.txt");
    }

    public int getNumberOfStoredGoods() {
        return numberOfStoredGoods;
    }

    public void setNumberOfSoldGoods(int numberOfSoldGoods) {
        this.numberOfSoldGoods = numberOfSoldGoods;
        String line = this.toString();
        FileData.setData(line, "Storage.txt");

    }

    public int getNumberOfSoldGood() {
        return numberOfSoldGoods;
    }

    public void setNumberOfGoodsTobeSold(int amount) {
        this.numberOfGoodsToBeSold = amount;
        String line = this.toString();
        FileData.setData(line, "Storage.txt");
    }

    public int getNumberOfGoodsToBeSold() {
        return numberOfGoodsToBeSold;
    }

    public void setPriceOfGoods(double price) {
        this.priceOfGood = price;
        String line = this.toString();
        FileData.setData(line, "Storage.txt");
    }

    public double getPriceofGoods() {
        return priceOfGood;
    }

    public void setnumberOfGoodsThisMonth(int amount) {
        this.numberOfGoodsThisMonth = amount;
        String line = this.toString();
        FileData.setData(line, "Storage.txt");
    }

    public int getnumberOfGoodsThisMonth() {
        return numberOfGoodsThisMonth;
    }

    public String toString() {
        return numberOfStoredGoods + "#" + numberOfSoldGoods + "#" + numberOfGoodsToBeSold + "#" + priceOfGood + "#" + numberOfGoodsThisMonth;
    }
}
