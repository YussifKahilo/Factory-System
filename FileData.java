
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileData {

    public static ArrayList<String> getData(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            ArrayList<String> LINE = new ArrayList<String>();
            String line = reader.readLine();
            while (line != null) {
                LINE.add(line);
                line = reader.readLine();
            }
            reader.close();
            return LINE;
        } catch (IOException e) {
            System.out.println("The file \"" + fileName + "\" is not at the right location..");
        }
        return null;
    }

    public static void setData(ArrayList<String> LINES, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < LINES.size(); i++) {
                writer.write(LINES.get(i));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("The file \"" + fileName + "\" is not at the right location..");
        }
    }

}