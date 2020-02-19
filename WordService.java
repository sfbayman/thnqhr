import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WordService {
  public static String getRandomWord(List<String> words) {
    if (words == null || words.size() < 1) {
      return null;
    }
    return words.get(ThreadLocalRandom.current().nextInt(words.size()));
  }

  private static List<String> loadWords(String fileName) throws IOException {
    if (fileName == null || fileName.length() < 1) {
      return null;
    }
    return Files.readAllLines(Path.of(fileName));
  }

  public static void main(String[] args) throws IOException {
    List<String> wordsList = loadWords("words_alpha.txt");
    System.out.println(getRandomWord(wordsList));
    System.out.println(getRandomWord(null));
    wordsList = new ArrayList<>();
    System.out.println(getRandomWord(wordsList));
  }
}
