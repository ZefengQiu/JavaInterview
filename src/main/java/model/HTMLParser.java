package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import utlis.ResourceLoader;

public class HTMLParser implements Parser {

  private ResourceLoader loader;

  public HTMLParser(ResourceLoader loader) {
    this.loader = loader;
  }

  public List<Person> parse() throws IOException {
    File file = loader.getFileFromResources();
    Boolean firstLine = true;
    List<String> keys = new ArrayList<String>();
    List<Person> result = new ArrayList<Person>();
    try {
      Document doc = Jsoup.parse(file,"UTF-8");
      for(Element element: doc.select("tr")) {
        List<Element> links = element.children();
        if(firstLine) {
          for(Element link: links) {
            keys.add(link.text());
          }

          firstLine = false;
        } else {
          Person p = new Person();
          Map<String, String> info = new HashMap<String, String>();
          for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).toUpperCase().compareTo("ID") == 0) {
              p.setId(links.get(i).text());
            }

            info.put(keys.get(i), links.get(i).text());
          }

          p.setInfo(info);

          result.add(p);
        }
      }

      return result;
    } catch (IOException exception) {
      System.out.print("html parse have problem");
      throw exception;
    }
  }

}
