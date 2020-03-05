import static org.junit.Assert.*;
import org.junit.Test;
import model.CSVParser;
import java.io.IOException;
import java.util.List;
import model.Person;
import utlis.ResourceLoader;

public class CSVParserTest {

  @Test
  public void testLanguage() {
    try {
      CSVParser csvParser = new CSVParser(new ResourceLoader("test0.csv"));
      List<Person> list = csvParser.parse();
      for(Person p: list) {
        System.out.print("Person's info: " + p.getInfo() + "\n");
      }
      assertEquals(3, list.size());
    } catch (IOException exception) {
      System.out.print("test 0 fail");
    }
  }

  @Test
  public void testEmptyInfo() {
    try {
      CSVParser csvParser = new CSVParser(new ResourceLoader("test1.csv"));
      List<Person> list = csvParser.parse();
      for(Person p: list) {
        System.out.print("Person's info: " + p.getInfo() + "\n");
      }
      assertEquals(0, list.size());
    } catch (IOException exception) {
      System.out.print("test 1 fail");
    }
  }

}
