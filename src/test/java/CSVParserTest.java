import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import model.HTMLParser;
import model.Person;
import utlis.ResourceLoader;

public class CSVParserTest {

  @Test
  public void test() {
    try {
      HTMLParser htmlParser = new HTMLParser(new ResourceLoader("test0.csv"));
      List<Person> list = htmlParser.parse();
      System.out.print("number of person " + list.size());
      assertEquals(3, list.size());
    } catch (IOException exception) {
      System.out.print("test 0 fail");
    }
  }

}
