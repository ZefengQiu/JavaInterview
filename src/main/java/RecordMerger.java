import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.CSVParser;
import model.HTMLParser;
import model.Person;
import utlis.ResourceLoader;
import utlis.ResourceMerger;
import utlis.ResourceWriter;

public class RecordMerger {

  public static final String FILENAME_COMBINED = "combined.csv";

  /**
   * Entry point of this test.
   *
   * @param args command line arguments: first.html and second.csv.
   * @throws Exception bad things had happened.
   *
   */
    public static void main(String[] args) {
      System.out.println("Hello world ...");

      HTMLParser htmlParser = new HTMLParser(new ResourceLoader("first.html"));
      CSVParser csvParser = new CSVParser(new ResourceLoader("second.csv"));
      List<List<Person>> lists = new ArrayList<List<Person>>();
      try {
        lists.add(htmlParser.parse());
        lists.add(csvParser.parse());

        ResourceMerger merger = new ResourceMerger(lists);
        List<Person> allP = merger.merge();

        ResourceWriter writer = new ResourceWriter(allP);
        writer.writeToCSV(FILENAME_COMBINED);
      } catch (IOException exception) {
        System.out.print("exception  " + exception.getMessage());
      }
    }
}
