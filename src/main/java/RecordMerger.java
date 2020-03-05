import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import model.CSVParser;
import model.HTMLParser;
import model.Person;
import model.Parser;
import utlis.ResourceLoader;
import utlis.ResourceMerger;
import utlis.ResourceParser;
import utlis.ResourceWriter;
import java.nio.file.Files.*;

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

      ResourceParser rp = new ResourceParser(args);

      try {
        List<List<Person>> lists = rp.parse();;

        ResourceMerger merger = new ResourceMerger(lists);
        List<Person> allP = merger.merge();

        ResourceWriter writer = new ResourceWriter(allP);
        writer.writeToCSV(FILENAME_COMBINED);
      } catch (IOException exception) {
        System.out.print("exception  " + exception.getMessage());
      }
    }
}
