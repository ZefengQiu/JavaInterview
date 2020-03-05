package model;

import com.opencsv.CSVReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import utlis.ResourceLoader;

public class CSVParser implements Parser {

  private ResourceLoader loader;

  public CSVParser(ResourceLoader loader) {
    this.loader = loader;
  }

  public List<Person> parse() throws IOException {
    try {
      Reader reader = this.loader.read();
      CSVReader csvReader = new CSVReader(reader);
      String[] nextRecords;
      Boolean firstLine = true;
      List<String> keys = new ArrayList<String>();
      List<Person> result = new ArrayList<Person>();
      while ((nextRecords = csvReader.readNext()) != null) {
        if(firstLine) {
          for(String record: nextRecords) {
            keys.add(record);
          }

          firstLine = false;
        } else {
          Person p = new Person();
          Map<String, String> info = new HashMap<String, String>();
          for(int i = 0; i < keys.size(); i++) {
            info.put(keys.get(i), nextRecords[i]);
            if(keys.get(i).toUpperCase().compareTo("ID") == 0) {
              p.setId(nextRecords[i]);
            }
          }

          p.setInfo(info);

          result.add(p);
        }
      }

      return result;
    } catch (IOException exception) {
      System.out.print("loader have problem");
      throw exception;
    }
  }

}
