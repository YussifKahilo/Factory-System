
public class Financial {

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
}
