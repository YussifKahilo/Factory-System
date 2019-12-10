
public class Financial {

    private double totalMoney;
    private double matrialsPrice;
    private double profit;

    public Financial() {
        String line = FileData.getData("Financial.txt");
        if (line != null) {
            String[] arr = line.split("#");
            this.setTotalMoney(Double.parseDouble(arr[0]));
            this.setprofit(Double.parseDouble(arr[1]));
            this.setMatrialsPrice(Double.parseDouble(arr[2]));
        }

    }

    public void setTotalMoney(double amount) {
        this.totalMoney = amount;
        String line = this.toString();
        FileData.setData(line, "Financial.txt");
    }

    public double getMatrialsPrice() {
        return matrialsPrice;
    }

    public void setMatrialsPrice(double matrialsPrice) {
        this.matrialsPrice = matrialsPrice;
        String line = this.toString();
        FileData.setData(line, "Financial.txt");
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
        String line = this.toString();
        FileData.setData(line, "Financial.txt");
    }

    public String toString() {
        return totalMoney + "#" + profit + "#" + matrialsPrice;
    }
}
