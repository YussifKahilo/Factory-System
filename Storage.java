///**
// * this class contains the storage which have the goods that are made in the
//* factory and the number of sold goods.
//* 
//* @author Kirolos Wesam
//* @ID 220180259
//*
//*/
public class Storage {
	// attributes of the storage number of stored goods,number of sold goods,price
	// of each good and number of the goods that have been manufactured
	private int numberOfStoredGoods;
	private int numberOfSoldGoods;
	private double priceOfGood;
	private int numberOfGoodsManufacturedThisMonth;

	/// **
	// * Storage constructor.
	// *
	// * @param line the of stored goods,number of sold goods,price of each good and
	// * number of manufactured goods.
	// */
	public Storage(String line) {
		if (line != null) {
			String[] arr = line.split("#");
			this.numberOfStoredGoods = Integer.parseInt(arr[0]);
			this.numberOfSoldGoods = Integer.parseInt(arr[1]);
			this.priceOfGood = Double.parseDouble(arr[2]);
			this.numberOfGoodsManufacturedThisMonth = Integer.parseInt(arr[3]);
		}
	}

	/// **
	// * sets the number of stored goods to the storage.
	// *
	// * @param SoldGoods to be set.
	// */
	public void setNumberOfStoredGoods(int SoldGoods) {
		this.numberOfStoredGoods = SoldGoods;
	}

	/// **
	// * gets the number of stored goods in the storage.
	// *
	// * @return number of stored goods.
	// */
	public int getNumberOfStoredGoods() {
		return numberOfStoredGoods;
	}

	/// **
	// * sets the number of stored goods to the attribute number of sold goods.
	// *
	// * @param SoldGoods to be set.
	// */
	public void setNumberOfSoldGoods(int numberOfSoldGoods) {
		this.numberOfSoldGoods = numberOfSoldGoods;
	}

	/// **
	// * gets the number of sold goods from the storage.
	// *
	// * @return number of sold goods.
	// */
	public int getNumberOfSoldGood() {
		return numberOfSoldGoods;
	}

	/// **
	// * sets prices of goods to the storage.
	// *
	// * @param prices to be set.
	// */
	public void setPriceOfGoods(double price) {
		this.priceOfGood = price;
	}

	/// **
	// * gets the price of the goods in the storage.
	// *
	// * @return price of goods.
	// */
	public double getPriceofGoods() {
		return priceOfGood;
	}

	/// **
	// * sets the Number Of Goods Manufactured This Month to the storage
	// *
	// * @param number of manufactured goods.
	// */
	public void setNumberOfGoodsManufacturedThisMonth(int amount) {
		this.numberOfGoodsManufacturedThisMonth = amount;
	}

	/// **
	// * gets the Number Of Goods Manufactured This Month.
	// *
	// * @return number of manufactured goods.
	// */
	public int getNumberOfGoodsManufacturedThisMonth() {
		return numberOfGoodsManufacturedThisMonth;
	}

	/// **
	// * the way of saving the data in the file.
	// */
	public String toString() {
		return numberOfStoredGoods + "#" + numberOfSoldGoods + "#" + priceOfGood + "#"
				+ numberOfGoodsManufacturedThisMonth;
	}
}
