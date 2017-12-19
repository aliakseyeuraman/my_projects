package reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * class for reading information from file
 */
public class FileReader {
    private static final String FILE_PATH = "A:\\Java\\Text_number\\src\\main\\resources\\Example";
    private ArrayList<String> text = new ArrayList<>();

    public ArrayList<String> read() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(FILE_PATH), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.add(line);
            }
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return text;
    }
}
