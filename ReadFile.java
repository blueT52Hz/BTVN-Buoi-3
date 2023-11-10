import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static List<String> stringsFromPathOfFile(String pathOfFile) {
        File f = new File(pathOfFile);
        try {
            Scanner sc = new Scanner(f.toPath());
            List<String> lines = Files.readAllLines(f.toPath());
            return lines;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of(new String[0]);
    }

    public static void main(String[] args) {

    }
}
