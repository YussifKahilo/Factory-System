import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Financial {

    private double totalMoney;
    private double matrialsPrice;
    private double profit;

    public Financial() throws IOException {
    	ArrayList<String> lines = FileData.getData("Financial.txt");
        String line = lines.get(0);
        if (line != null) {
            String[] arr = line.split("#");
            this.setTotalMoney(Double.parseDouble(arr[0]));
            this.setprofit(Double.parseDouble(arr[1]));
            this.setMatrialsPrice(Double.parseDouble(arr[2]));
        }
        
    }

    public void setTotalMoney(double amount) throws IOException {
        this.totalMoney = amount;
        ArrayList<String> line=new ArrayList<String>();
		line.add(this.toString());
		FileData.setData(line, "Financial.txt");
    }

    public double getMatrialsPrice() {
        return matrialsPrice;
    }

    public void setMatrialsPrice(double matrialsPrice) throws IOException {
        this.matrialsPrice = matrialsPrice;
        ArrayList<String> line=new ArrayList<String>();
		line.add(this.toString());
		FileData.setData(line, "Financial.txt");
    }

    public double getTotalMoney() throws IOException {
        return totalMoney;
    }

    public double getprofit() throws IOException {
        return profit;
    }

    public void setprofit(double provit) throws IOException {
        this.profit = provit;
        ArrayList<String> line=new ArrayList<String>();
		line.add(this.toString());
		FileData.setData(line, "Financial.txt");
    }

    public String toString() {
        return totalMoney + "#" + profit + "#" + matrialsPrice;
    }
}
