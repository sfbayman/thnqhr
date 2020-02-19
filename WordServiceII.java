import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WordServiceII {
  private List<String> words;

  WordServiceII() {
    words = loadWords("words_alpha.txt");
  }

  public String getRandomWord() {
    if (words == null || words.size() < 1) {
      return null;
    }
    return words.get(ThreadLocalRandom.current().nextInt(words.size()));
  }

  private List<String> loadWords(String fileName) {
    if (fileName == null || fileName.length() < 1) {
      return null;
    }
    try {
      return Files.readAllLines(Path.of(fileName));
    } catch (IOException e) {
      System.out.println("Words file not found");
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    WordServiceII wordService = new WordServiceII();
    System.out.println(wordService.getRandomWord());
  }
}
