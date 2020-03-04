package utlis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Person;

public class ResourceMerger {

  private List<List<Person>> lists;

  public ResourceMerger(List<List<Person>> lists) {
    this.lists = lists;
  }

  public List<Person> merge() {
    Map<String, Person> pDict = new HashMap<String, Person>();
    List<Person> result = new ArrayList<Person>();
    for(List<Person> list: lists) {
      for(Person p: list) {
        if(pDict.keySet().contains(p.getId())) {
          Person pToMerge = pDict.get(p.getId());
          pToMerge.mergeInfo(p);
          pDict.put(p.getId(), pToMerge);
        } else {
          pDict.put(p.getId(), p);
        }
      }
    }

    return new ArrayList<Person>(pDict.values());
  }
}
