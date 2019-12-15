
public class Storage {

	private int numberOfStoredGoods;
	private int numberOfSoldGoods;
	private double priceOfGood;
	private int numberOfGoodsManufacturedThisMonth;

	public Storage(String line) {
		if (line != null) {
			String[] arr = line.split("#");
			this.numberOfStoredGoods = Integer.parseInt(arr[0]);
			this.numberOfSoldGoods = Integer.parseInt(arr[1]);
			this.priceOfGood = Double.parseDouble(arr[2]);
			this.numberOfGoodsManufacturedThisMonth = Integer.parseInt(arr[3]);
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

	public void setPriceOfGoods(double price) {
		this.priceOfGood = price;
	}

	public double getPriceofGoods() {
		return priceOfGood;
	}

	public void setNumberOfGoodsManufacturedThisMonth(int amount) {
		this.numberOfGoodsManufacturedThisMonth = amount;
	}

	public int getNumberOfGoodsManufacturedThisMonth() {
		return numberOfGoodsManufacturedThisMonth;
	}

	public String toString() {
		return numberOfStoredGoods + "#" + numberOfSoldGoods + "#" + priceOfGood + "#"
				+ numberOfGoodsManufacturedThisMonth;
	}
}
