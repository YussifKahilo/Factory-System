
///**
//* 
//* this class contains buffered reader and buffered writer to read from the file and to set the data to the file.
//* there is an overloaded methods one to save a line in the file and one save an array list in the file.
//* @author Eslam Amin Ahmed
//* @ID 220180011
//*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileData {
	// /**
	// * gets the data from the file to the array list.
	// *
	// * @param lines to set the data in.
	// * @param fileName to get the data from.
	// */
	public static void getData(ArrayList<String> lines, String fileName) {
		try {
			lines.clear();
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("The file \"" + fileName + "\" is not at the right location..");
		}
	}

	/// **
	// * gets the data from the file.
	// *
	// * @param fileName to get the data from.
	// */
	public static String getData(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			reader.close();
			return line;
		} catch (IOException e) {
			System.out.println("The file \"" + fileName + "\" is not at the right location..");
		}
		return null;
	}

	/// **
	// * set the data from the array list to the file.
	// *
	// * @param lines the array list to be set in the file.
	// * @param fileName the file to be set the data in.
	// */
	public static void setData(ArrayList<String> lines, String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			for (int i = 0; i < lines.size(); i++) {
				writer.write(lines.get(i));
				writer.write("\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("The file \"" + fileName + "\" is not at the right location..");
		}
	}

	/// **
	// * set the data from the line to the file.
	// *
	// * @param line line to be set in the file.
	// * @param fileName the file to be set the data in.
	// */
	public static void setData(String line, String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(line);
			writer.close();
		} catch (IOException e) {
			System.out.println("The file \"" + fileName + "\" is not at the right location..");
		}
	}

}
