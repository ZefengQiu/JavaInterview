package utlis;

import com.google.common.io.Files;
import model.CSVParser;
import model.HTMLParser;
import model.Parser;
import model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceParser {

    private final String[] args;

    public ResourceParser(String[] args) {
        this.args = args;
    }

    public List<List<Person>> parse() throws IOException {
        List<List<Person>> lists = new ArrayList<List<Person>>();
        List<Parser> parsers = new ArrayList<Parser>();
        for(String arg: this.args) {
            if(this.getExtensionByGuava(arg).compareTo("html") == 0) {
                Parser htmlParser = new HTMLParser(new ResourceLoader(arg));
                parsers.add(htmlParser);
            }

            if(this.getExtensionByGuava(arg).compareTo("csv") == 0) {
                Parser csvParser = new CSVParser(new ResourceLoader(arg));
                parsers.add(csvParser);
            }
        }

        for(Parser p: parsers) {
            lists.add(p.parse());
        }

        return lists;
    }

    private String getExtensionByGuava(String filename) {
        return Files.getFileExtension(filename);
    }

}
