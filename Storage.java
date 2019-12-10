import java.io.IOException;
import java.util.ArrayList;

public class Storage {

	private int numberOfStoredGoods;
	private int numberOfSoldGoods;
	private int numberOfGoodsToBeSold;
	private double priceOfGood;
	private int numberOfGoodsThisMonth;

	public Storage() throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		FileData.getData(lines, "Storage.txt");
		String line = lines.get(0);
		if (line != null) {
			String[] arr = line.split("#");
			this.numberOfStoredGoods = Integer.parseInt(arr[0]);
			this.numberOfSoldGoods = Integer.parseInt(arr[1]);
			this.numberOfGoodsToBeSold = Integer.parseInt(arr[2]);
			this.priceOfGood = Double.parseDouble(arr[3]);
			this.numberOfGoodsThisMonth = Integer.parseInt(arr[4]);

		}
	}

	public void setNumberOfStoredGoods(int SoldGoods) throws IOException {
		this.numberOfStoredGoods = SoldGoods;
		ArrayList<String> line = new ArrayList<String>();
		line.add(this.toString());
		FileData.setData(line, "Storage.txt");
	}

	public int getNumberOfStoredGoods() {
		return numberOfStoredGoods;
	}

	public void setNumberOfSoldGoods(int numberOfSoldGoods) throws IOException {
		this.numberOfSoldGoods = numberOfSoldGoods;
		ArrayList<String> line = new ArrayList<String>();
		line.add(this.toString());
		FileData.setData(line, "Storage.txt");

	}

	public int getNumberOfSoldGood() {
		return numberOfSoldGoods;
	}

	public void setNumberOfGoodsTobeSold(int amount) throws IOException {
		this.numberOfGoodsToBeSold = amount;
		ArrayList<String> line = new ArrayList<String>();
		line.add(this.toString());
		FileData.setData(line, "Storage.txt");
	}

	public int getNumberOfGoodsToBeSold() {
		return numberOfGoodsToBeSold;
	}

	public void setPriceOfGoods(double price) throws IOException {
		this.priceOfGood = price;
		ArrayList<String> line = new ArrayList<String>();
		line.add(this.toString());
		FileData.setData(line, "Storage.txt");
	}

	public double getPriceofGoods() {
		return priceOfGood;
	}

	public void setnumberOfGoodsThisMonth(int amount) throws IOException {
		this.numberOfGoodsThisMonth = amount;
		ArrayList<String> line = new ArrayList<String>();
		line.add(this.toString());
		FileData.setData(line, "Storage.txt");
	}

	public int getnumberOfGoodsThisMonth() {
		return numberOfGoodsThisMonth;
	}

	public String toString() {
		return numberOfStoredGoods + "#" + numberOfSoldGoods + "#" + numberOfGoodsToBeSold + "#" + priceOfGood + "#"
				+ numberOfGoodsThisMonth;
	}
}
