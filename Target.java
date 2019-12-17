
public class Target {

<<<<<<< HEAD
	private int targetOfGoodsToBeManufactured;
	private int targetOfGoodsToBeSold;
	private int targetOfGoodsToBeManufacturedForEachWorker;

	/**
	 * target constructor.
	 * 
	 * @param line of the total target & the target for each worker.
	 */
	public Target(String line) {
		String[] data = line.split("#");
		this.targetOfGoodsToBeManufactured = Integer.parseInt(data[0]);// target of goods that will be manufactured.
		this.targetOfGoodsToBeSold = Integer.parseInt(data[1]);// target of goods that will be sold.
		// target of goods that will be manufactured from each worker.
		this.targetOfGoodsToBeManufacturedForEachWorker = Integer.parseInt(data[2]);
	}

	/**
	 * gets the target of goods that will be manufactured.
	 * 
	 * @return number of the target.
	 */
	public int getTargetOfGoodsToBeManufactured() {
		return targetOfGoodsToBeManufactured;
	}

	/**
	 * sets the number of goods that will be manufactured.
	 * 
	 * @param targetOfGoodsToBeManufactured
	 */
	public void setTargetOfGoodsToBeManufactured(int targetOfGoodsToBeManufactured) {
		this.targetOfGoodsToBeManufactured = targetOfGoodsToBeManufactured;
	}

	/**
	 * gets the target of goods that will be sold.
	 * 
	 * @return number of the target.
	 */
	public int getTargetOfGoodsToBeSold() {
		return targetOfGoodsToBeSold;
	}

	/**
	 * sets the number of goods that will be sold.
	 * 
	 * @param targetOfGoodsToBeManufactured
	 */
	public void setTargetOfGoodsToBeSold(int targetOfGoodsToBeSold) {
		this.targetOfGoodsToBeSold = targetOfGoodsToBeSold;
	}

	/**
	 * gets the target of goods that will be manufactured from each worker.
	 * 
	 * @return number of the target.
	 */
	public int getTargetOfGoodsToBeManufacturedForEachWorker() {
		return targetOfGoodsToBeManufacturedForEachWorker;
	}

	/**
	 * sets the number of goods that will be manufactured from each worker.
	 * 
	 * @param targetOfGoodsToBeManufactured
	 */
	public void setTargetOfGoodsToBeManufacturedForEachWorker(int targetOfGoodsToBeManufacturedForEachWorker) {
		this.targetOfGoodsToBeManufacturedForEachWorker = targetOfGoodsToBeManufacturedForEachWorker;
	}

	/**
	 * the way of saving in the file.
	 */
	public String toString() {
		return targetOfGoodsToBeManufactured + "#" + targetOfGoodsToBeManufacturedForEachWorker + "#"
				+ targetOfGoodsToBeSold;
	}
=======
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
        return targetOfGoodsToBeManufactured + "#" + targetOfGoodsToBeManufacturedForEachWorker + "#"
                + targetOfGoodsToBeSold;
    }
>>>>>>> 09ba9a9766efc9c8a8df1d1a8b46568c0b987ebd

}
