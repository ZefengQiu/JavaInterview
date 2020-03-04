package utlis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class ResourceLoader {

  private final String file_path;

  public ResourceLoader(String path) {
    this.file_path = path;
  }

  public Reader read() throws IOException {
    try {
      File file = this.getFileFromResources();
      FileReader reader = new FileReader(file);
      return new BufferedReader(reader);
    } catch (IOException exception) {
      System.out.print("file path got issue");
      throw exception;
    }
  }

  public File getFileFromResources() {
    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource(this.file_path);
    if (resource == null) {
      throw new IllegalArgumentException("OOps, file is not found!");
    } else {
      return new File(resource.getFile());
    }
  }

}
