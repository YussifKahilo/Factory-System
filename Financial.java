
public class Financial {

<<<<<<< HEAD
	private double totalMoney;
	private double matrialsPrice;
	private double profit;

	/**
	 * financial constructor.
	 * 
	 * @param line that contains total money,profit and materials price.
	 */
	public Financial(String line) {
		if (line != null) {
			String[] arr = line.split("#");
			this.setTotalMoney(Double.parseDouble(arr[0]));
			this.setProfit(Double.parseDouble(arr[1]));
			this.setMaterialsPrice(Double.parseDouble(arr[2]));
		}

	}

	/**
	 * sets total money to the financial.
	 * 
	 * @param amount to be set to the financial.
	 */
	public void setTotalMoney(double amount) {
		this.totalMoney = amount;
	}

	/**
	 * 
	 * @return Materials price.
	 */
	public double getMaterialsPrice() {
		return matrialsPrice;
	}

	/**
	 * sets Materials price to the financial.
	 * 
	 * @param amount of Materials price to be set to the financial.
	 */
	public void setMaterialsPrice(double matrialsPrice) {
		this.matrialsPrice = matrialsPrice;
	}

	/**
	 * 
	 * @return total money.
	 */
	public double getTotalMoney() {
		return totalMoney;
	}

	/**
	 * 
	 * @return profit of the month.
	 */
	public double getProfit() {
		return profit;
	}

	/**
	 * sets profit of this month to the financial.
	 * 
	 * @param amount of the profit to be set to the financial.
	 */
	public void setProfit(double profit) {
		this.profit = profit;
	}

	/**
	 * the way of saving data to the file.
	 */
	public String toString() {
		return totalMoney + "#" + profit + "#" + matrialsPrice;
	}
=======
    private double totalMoney;
    private double matrialsPrice;
    private double profit;

    public Financial(String line) {
        if (line != null) {
            String[] arr = line.split("#");
            this.setTotalMoney(Double.parseDouble(arr[0]));
            this.setProfit(Double.parseDouble(arr[1]));
            this.setMatrialsPrice(Double.parseDouble(arr[2]));
        }

    }

    public void setTotalMoney(double amount) {
        this.totalMoney = amount;
    }

    public double getMatrialsPrice() {
        return matrialsPrice;
    }

    public void setMatrialsPrice(double matrialsPrice) {
        this.matrialsPrice = matrialsPrice;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String toString() {
        return totalMoney + "#" + profit + "#" + matrialsPrice;
    }
>>>>>>> 09ba9a9766efc9c8a8df1d1a8b46568c0b987ebd
}
