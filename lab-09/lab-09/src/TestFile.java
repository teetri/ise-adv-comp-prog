import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TestFile {
  private HashMap<String, int[]> scoreMap = new HashMap<>();
  private HashSet<String> editedStudentID = new HashSet<>();

  public HashMap<String, int[]> read_scores(String filePath) {

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains("Quiz")) {
          continue;
        }
        String[] x = line.split(",");
        String[] y = Arrays.copyOfRange(x, 1, x.length);
        this.scoreMap.put(x[0], Arrays.stream(y).mapToInt(Integer::parseInt).toArray());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return this.scoreMap;
  }

  public int getTotalScore(HashMap<String, int[]> allScores, String id) {
    return Arrays.stream(allScores.get(id)).sum();
  }

  public HashSet<String> getEditedStudentID(String filePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains("Quiz")) {
          continue;
        }
        this.editedStudentID.add(line.split(",")[0]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return this.editedStudentID;
  }

  public void createNewEditedScore(String ss, String es, String ns) {
    HashMap<String, int[]> newScores = read_scores(ss);

    try (BufferedReader reader = new BufferedReader(new FileReader(es))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains("Quiz")) {
          continue;
        }
        String x = line.split(",")[0];
        int y = Integer.parseInt(line.split(",")[1]);
        int z = Integer.parseInt(line.split(",")[2]);

        int[] s = newScores.get(x);
        s[y - 1] = z;
        newScores.replace(x, s);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(ns))) {
      writer.write("ID,Quiz1,Quiz2,Quiz3,Quiz4,Quiz5\n");
      for (Map.Entry<String, int[]> x : newScores.entrySet()) {
        int[] q = x.getValue();
        writer.write(String.format("%s,%d,%d,%d,%d,%d\n", x.getKey(), q[0], q[1], q[2], q[3], q[4]));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    // Test the methods

    TestFile testFile = new TestFile();

    // Task 1: Test the 'read_scores' method
    HashMap<String, int[]> allScores = testFile.read_scores("student_scores.csv");
    System.out.println("All Scores:");
    for (String studentID : allScores.keySet()) {
      System.out.println(studentID + " - " + Arrays.toString(allScores.get(studentID)));
    }

    // Task 2: Test the 'getTotalScore' method
    String studentIDToLookup = "6632462421";
    int totalScore = testFile.getTotalScore(allScores, studentIDToLookup);
    if (totalScore != -1) {
      System.out.println("Total Score for " + studentIDToLookup + ": " +
          totalScore);
    } else {
      System.out.println("Student not found.");
    }

    // Task 3: Test the 'getEditedStudentID' method
    HashSet<String> editedStudentIDs = testFile.getEditedStudentID("edited_scores.csv");
    System.out.println("Edited Student IDs: " + editedStudentIDs);

    // Task 4: Test the 'createNewEditedScore' method
    testFile.createNewEditedScore("student_scores.csv", "edited_scores.csv",
        "new_scores.csv");
    System.out.println("New scores have been written to 'new_scores.csv'.");
  }
}
