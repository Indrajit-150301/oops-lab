import java.io.*;
import java.util.Scanner;

public class FileSearch                    {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the filename from the user
        System.out.print("Enter the filename: ");
        String fileName = scanner.nextLine();

        // Get the text to write to the file
        System.out.print("Enter the text to write to the file: ");
        String text = scanner.nextLine();

        // Write the text to the file
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
            return;
        }

        // Get the keyword to search for
        System.out.print("Enter the keyword to search for: ");
        String keyword = scanner.nextLine();

        // Search for the keyword in the file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int lineNumber = 1;
            int position = -1;
            while ((line = reader.readLine()) != null) {
                position = line.indexOf(keyword);
                if (position != -1) {
                    break;
                }
                lineNumber++;
            }
            reader.close();

            if (position == -1) {
                System.out.println("Keyword not found in file.");
            } else {
                System.out.println("Keyword found at line " + lineNumber + ", position " + position + ".");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
    }

}