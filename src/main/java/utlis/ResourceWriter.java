package utlis;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import model.Person;

public class ResourceWriter {

  private List<Person> list;

  public ResourceWriter(List<Person> list) {
    this.list = list;
  }

  public void writeToCSV(String fileName) throws IOException {
    try {
      FileWriter csvWriter = new FileWriter(fileName);
      Set<String> keys = new HashSet<String>();
      List<List<String>> info = new ArrayList<List<String>>();

      //get all column names for Person
      for(Person p: list) {
        for(String key: p.getInfo().keySet()) {
          if(!keys.contains(key)) {
            keys.add(key);
          }
        }
      }

      //setup columns in csv file
      Object[] columns = keys.toArray();
      for(int i = 0; i < columns.length; i++) {
        csvWriter.append(columns[i].toString());

        if(i == columns.length - 1) {
          csvWriter.append("\n");
        } else {
          csvWriter.append(",");
        }
      }

      //fill in person's info under column
      for(Person p: list) {
        Map<String, String> personInfo = p.getInfo();
        for(int i = 0; i < columns.length; i++) {
          String columnName = columns[i].toString();
          if(personInfo.keySet().contains(columnName)) {
            csvWriter.append(personInfo.get(columnName));
          } else {
            csvWriter.append("   ");
          }

          if(i == columns.length - 1) {
            csvWriter.append("\n");
          } else {
            csvWriter.append(",");
          }
        }
      }

      csvWriter.flush();
      csvWriter.close();
    } catch (IOException exception) {
      System.out.print("write file got a problem");
      throw exception;
    }
  }

}
