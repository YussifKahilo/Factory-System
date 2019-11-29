package FactorySystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Financial {

    private double totalMoney;
    private double matrialsPrice;
    private double profit;

    public Financial() throws IOException {
        FileReader fr = new FileReader("Financial.txt");
        BufferedReader bf = new BufferedReader(fr);
        String line = bf.readLine();
        if (line != null) {
            String[] arr = line.split("#");
            this.setTotalMoney(Double.parseDouble(arr[0]));
            this.setprofit(Double.parseDouble(arr[1]));
        }
        bf.close();
    }

    public void setTotalMoney(double amount) throws IOException {
        this.totalMoney = amount;
        FileWriter file = new FileWriter("Financial.txt");
        BufferedWriter buf = new BufferedWriter(file);
        buf.write(this.toString());
        buf.close();
    }

    public double getMatrialsPrice() {
        return matrialsPrice;
    }

    public void setMatrialsPrice(double matrialsPrice) throws IOException {
        this.matrialsPrice = matrialsPrice;
        FileWriter file = new FileWriter("Financial.txt");
        BufferedWriter buf = new BufferedWriter(file);
        buf.write(this.toString());
        buf.close();
    }

    public double getTotalMoney() throws IOException {
        return totalMoney;
    }

    public double getprofit() throws IOException {
        return profit;
    }

    public void setprofit(double provit) throws IOException {
        this.profit = provit;
        FileWriter file = new FileWriter("Financial.txt");
        BufferedWriter buf = new BufferedWriter(file);
        buf.write(this.toString());
        buf.close();
    }

    public String toString() {
        return totalMoney + "#" + profit + "#" + matrialsPrice;
    }
}
