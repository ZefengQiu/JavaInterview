import model.CSVParser;
import model.HTMLParser;
import model.Person;
import org.junit.Test;
import utlis.ResourceLoader;
import utlis.ResourceMerger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResourceMergerTest {

    @Test
    public void test0() {
        try {
            HTMLParser htmlParser = new HTMLParser(new ResourceLoader("test0.html"));
            CSVParser csvParser = new CSVParser(new ResourceLoader("test0.csv"));
            List<List<Person>> lists = new ArrayList<List<Person>>();

            lists.add(htmlParser.parse());
            lists.add(csvParser.parse());

            ResourceMerger merger = new ResourceMerger(lists);
            List<Person> allP = merger.merge();

            for(Person p: allP) {
                System.out.print("Person's info: " + p.getInfo() + "\n");
            }

            assertEquals(4, allP.size());
        } catch (IOException exception) {
            System.out.print("test 0 fail");
        }
    }

    @Test
    public void test1() {
        try {
            HTMLParser htmlParser = new HTMLParser(new ResourceLoader("test0.html"));
            CSVParser csvParser = new CSVParser(new ResourceLoader("test1.csv"));
            List<List<Person>> lists = new ArrayList<List<Person>>();

            lists.add(htmlParser.parse());
            lists.add(csvParser.parse());

            ResourceMerger merger = new ResourceMerger(lists);
            List<Person> allP = merger.merge();

            for(Person p: allP) {
                System.out.print("Person's info: " + p.getInfo() + "\n");
            }

            assertEquals(2, allP.size());
        } catch (IOException exception) {
            System.out.print("test 0 fail");
        }
    }

    @Test
    public void test2() {
        try {
            HTMLParser htmlParser = new HTMLParser(new ResourceLoader("test1.html"));
            CSVParser csvParser = new CSVParser(new ResourceLoader("test0.csv"));
            List<List<Person>> lists = new ArrayList<List<Person>>();

            lists.add(htmlParser.parse());
            lists.add(csvParser.parse());

            ResourceMerger merger = new ResourceMerger(lists);
            List<Person> allP = merger.merge();

            for(Person p: allP) {
                System.out.print("Person's info: " + p.getInfo() + "\n");
            }

            assertEquals(3, allP.size());
        } catch (IOException exception) {
            System.out.print("test 0 fail");
        }
    }
}
