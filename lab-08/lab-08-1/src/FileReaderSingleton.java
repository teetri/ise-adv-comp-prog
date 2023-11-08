import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileReaderSingleton {
  private static FileReaderSingleton instance = null;
  private BufferedReader reader;

  private FileReaderSingleton() {
    openFile();
  }

  public static FileReaderSingleton getInstance() {
    if (instance == null) {
      instance = new FileReaderSingleton();
    }
    return instance;
  }

  private void openFile() {
    String filePath = "src/data.txt";
    try {
      reader = new BufferedReader(new FileReader(filePath));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public String readLineFromFile() {
    // System.out.println(reader);
    try {
      return reader.readLine();
    } catch (IOException e) {
      openFile();
      try {
        return reader.readLine();
      } catch (IOException x) {
        e.printStackTrace();
        return null;
      }
    }

  }

  public void closeFile() {
    try {
      if (reader != null) {
        reader.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
