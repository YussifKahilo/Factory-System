
public class Target {

    private int targetOfGoodsToBeManufactured;
    private int targetOfGoodsToBeSold;
    private int targetOfGoodsToBeManufacturedForEachWorker;

    public Target(String line) {
        String[] data = line.split("#");
        this.targetOfGoodsToBeManufactured = Integer.parseInt(data[0]);
        this.targetOfGoodsToBeSold = Integer.parseInt(data[1]);
        this.targetOfGoodsToBeManufacturedForEachWorker = Integer.parseInt(data[2]);
    }

    public int getTargetOfGoodsToBeManufactured() {
        return targetOfGoodsToBeManufactured;
    }

    public void setTargetOfGoodsToBeManufactured(int targetOfGoodsToBeManufactured) {
        this.targetOfGoodsToBeManufactured = targetOfGoodsToBeManufactured;
    }

    public int getTargetOfGoodsToBeSold() {
        return targetOfGoodsToBeSold;
    }

    public void setTargetOfGoodsToBeSold(int targetOfGoodsToBeSold) {
        this.targetOfGoodsToBeSold = targetOfGoodsToBeSold;
    }

    public int getTargetOfGoodsToBeManufacturedForEachWorker() {
        return targetOfGoodsToBeManufacturedForEachWorker;
    }

    public void setTargetOfGoodsToBeManufacturedForEachWorker(int targetOfGoodsToBeManufacturedForEachWorker) {
        this.targetOfGoodsToBeManufacturedForEachWorker = targetOfGoodsToBeManufacturedForEachWorker;
    }

    public String toString() {
        return targetOfGoodsToBeManufactured + "#" + targetOfGoodsToBeManufacturedForEachWorker + "#" + targetOfGoodsToBeSold;
    }

}
