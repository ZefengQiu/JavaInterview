import model.HTMLParser;
import model.Person;
import org.junit.Test;
import utlis.ResourceLoader;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HTMLParserTest {
    @Test
    public void testLanguage() {
        try {
            HTMLParser htmlParser = new HTMLParser(new ResourceLoader("test0.html"));
            List<Person> list = htmlParser.parse();
            for(Person p: list) {
                System.out.print("Person's info: " + p.getInfo() + "\n");
            }
            assertEquals(2, list.size());
        } catch (IOException exception) {
            System.out.print("test 0 fail");
        }
    }

    @Test
    public void testEmptyInfo() {
        try {
            HTMLParser htmlParser = new HTMLParser(new ResourceLoader("test1.html"));
            List<Person> list = htmlParser.parse();
            for(Person p: list) {
                System.out.print("Person's info: " + p.getInfo() + "\n");
            }
            assertEquals(0, list.size());
        } catch (IOException exception) {
            System.out.print("test 1 fail");
        }
    }
}
