package model;

import java.io.IOException;
import java.util.List;

public interface Parser<T extends Idable> {
  List<T> parse() throws IOException;
}
