///**
//* this class contains the target which all the employees aim to achieve it.
//* there is target for every worker and supervisor
//* 
//* @author Mohamed Ahmed El-Sayed Hammad.
//* @ID 220180220
//*/
public class Target {
	//
	private long targetOfGoodsToBeManufactured;
	private long targetOfGoodsToBeSold;
	private long targetOfGoodsToBeManufacturedForEachWorker;
	private long targetOfGoodsToBeSoldByEachSalesMan;

	/// **
	// * target constructor.
	// *
	// * @param line of the total target & the target for each worker.
	// */
	public Target(String line) {
		String[] data = line.split("#");
		this.targetOfGoodsToBeManufactured = Long.parseLong(data[0]);// target of goods that will be manufactured.
		this.targetOfGoodsToBeSold = Long.parseLong(data[1]);// target of goods that will be sold.
		// target of goods that will be manufactured from each worker.
		this.targetOfGoodsToBeManufacturedForEachWorker = Long.parseLong(data[2]);
		this.targetOfGoodsToBeSoldByEachSalesMan = Long.parseLong(data[3]);
	}

	/// **
	// * gets the target of goods that will be manufactured.
	// *
	// * @return number of the target.
	// */
	public long getTargetOfGoodsToBeManufactured() {
		return targetOfGoodsToBeManufactured;
	}

	/// **
	// * sets the number of goods that will be manufactured.
	// *
	// * @param targetOfGoodsToBeManufactured
	// */
	public void setTargetOfGoodsToBeManufactured(long targetOfGoodsToBeManufactured) {
		this.targetOfGoodsToBeManufactured = targetOfGoodsToBeManufactured;
	}

	/// **
	// * gets the target of goods that will be sold.
	// *
	// * @return number of the target.
	// */
	public long getTargetOfGoodsToBeSold() {
		return targetOfGoodsToBeSold;
	}

	/// **
	// * sets the number of goods that will be sold.
	// *
	// * @param targetOfGoodsToBeSold
	// */
	public void setTargetOfGoodsToBeSold(long targetOfGoodsToBeSold) {
		this.targetOfGoodsToBeSold = targetOfGoodsToBeSold;
	}

	/// **
	// * gets the target of goods that will be manufactured from each worker.
	// *
	// * @return number of the target.
	// */
	public long getTargetOfGoodsToBeManufacturedForEachWorker() {
		return targetOfGoodsToBeManufacturedForEachWorker;
	}

	/// **
	// * sets the number of goods that will be manufactured from each worker.
	// *
	// * @param targetOfGoodsToBeManufacturedForEachWorker
	// */
	public void setTargetOfGoodsToBeManufacturedForEachWorker(long targetOfGoodsToBeManufacturedForEachWorker) {
		this.targetOfGoodsToBeManufacturedForEachWorker = targetOfGoodsToBeManufacturedForEachWorker;
	}

	/// **
	// *
	// * @return target Of Goods To Be Sold By Each SalesMan
	// */
	public long getTargetOfGoodsToBeSoldByEachSalesMan() {
		return targetOfGoodsToBeSoldByEachSalesMan;
	}

	/// **
	// * @targetOfGoodsToBeSoldByEachSalesMen
	// */
	public void setTargetOfGoodsToBeSoldByEachSalesMan(long targetOfGoodsToBeSoldByEachSalesMan) {
		this.targetOfGoodsToBeSoldByEachSalesMan = targetOfGoodsToBeSoldByEachSalesMan;
	}

	/// **
	// * the way of saving in the file.
	// */
	public String toString() {
		return targetOfGoodsToBeManufactured + "#" + targetOfGoodsToBeSold + "#"
				+ targetOfGoodsToBeManufacturedForEachWorker + "#" + targetOfGoodsToBeSoldByEachSalesMan;
	}
}
