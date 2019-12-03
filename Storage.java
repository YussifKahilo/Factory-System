
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class Storage {

    private int numberOfStoredGoods;
    private int numberOfSoldGoods;
    private int numberOfGoodsToBeSold;
    private double priceOfGood;
    private int numberOfGoodsThisMonth;

    public Storage() throws IOException {
        FileReader f = new FileReader("Storage.txt");
        BufferedReader bf = new BufferedReader(f);
        String line = bf.readLine();
        if (line != null) {
            String[] arr = line.split("#");
            this.numberOfStoredGoods = Integer.parseInt(arr[0]);
            this.numberOfSoldGoods = Integer.parseInt(arr[1]);
            this.numberOfGoodsToBeSold = Integer.parseInt(arr[2]);
            this.priceOfGood = Double.parseDouble(arr[3]);
            this.numberOfGoodsThisMonth = Integer.parseInt(arr[4]);
            bf.close();
        }
    }

    public void setNumberOfStoredGoods(int SoldGoods) throws IOException {
        this.numberOfStoredGoods = SoldGoods;
        FileWriter file = new FileWriter("Storage.txt");
        BufferedWriter buf = new BufferedWriter(file);
        buf.write(this.toString());
        buf.close();
    }

    public int getNumberOfStoredGoods() {
        return numberOfStoredGoods;
    }

    public void setNumberOfSoldGoods(int numberOfSoldGoods) throws IOException {
        this.numberOfSoldGoods = numberOfSoldGoods;
        FileWriter file = new FileWriter("Storage.txt");
        BufferedWriter buf = new BufferedWriter(file);
        buf.write(this.toString());
        buf.close();
    }

    public int getNumberOfSoldGood() {
        return numberOfSoldGoods;
    }

    public void setNumberOfGoodsTobeSold(int amount) throws IOException {
        this.numberOfGoodsToBeSold = amount;
        FileWriter file = new FileWriter("Storage.txt");
        BufferedWriter buf = new BufferedWriter(file);
        buf.write(this.toString());
        buf.close();
    }

    public int getNumberOfGoodsToBeSold() {
        return numberOfGoodsToBeSold;
    }

    public void setPriceOfGoods(double price) throws IOException {
        this.priceOfGood = price;
        FileWriter file = new FileWriter("Storage.txt");
        BufferedWriter buf = new BufferedWriter(file);
        buf.write(this.toString());
        buf.close();
    }

    public double getPriceofGoods() {
        return priceOfGood;
    }

    public void setnumberOfGoodsThisMonth(int amount) throws IOException {
        this.numberOfGoodsThisMonth = amount;
        FileWriter file = new FileWriter("Storage.txt");
        BufferedWriter buf = new BufferedWriter(file);
        buf.write(this.toString());
        buf.close();
    }

    public int getnumberOfGoodsThisMonth() {
        return numberOfGoodsThisMonth;
    }

    public String toString() {
        return numberOfStoredGoods + "#" + numberOfSoldGoods + "#" + numberOfGoodsToBeSold + "#" + priceOfGood + "#" + numberOfGoodsThisMonth;
    }
}
