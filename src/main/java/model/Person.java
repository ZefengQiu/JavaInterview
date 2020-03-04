package model;

import java.util.ArrayList;
import java.util.Map;

public class Person implements Idable {

  private String id;

  private Map<String, String> info;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Map<String, String> getInfo() {
    return info;
  }

  public void setInfo(Map<String, String> info) {
    this.info = info;
  }

  public Person mergeInfo(Person p) {
    for(String key: new ArrayList<String>(p.getInfo().keySet())) {
      if(!this.info.keySet().contains(key)) {
        this.info.put(key, p.getInfo().get(key));
      }
    }

    return this;
  }
}
