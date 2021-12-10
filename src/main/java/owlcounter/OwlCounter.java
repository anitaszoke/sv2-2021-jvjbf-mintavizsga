package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OwlCounter {

    private List<String> owls = new ArrayList<>();

    public void readFromFile(Path path) {
        try {
            owls = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int getNumberOfOwls(String county) {
        exceptionThrow(county);
        int owlNumber = 0;
        for (String s : owls) {
            if (s.contains(county)) {
                int index = s.indexOf("=") + 1;
                owlNumber = Integer.parseInt(s.substring(index));
            }
        }
        return owlNumber;
    }


    public int getNumberOfAllOwls() {
        int owlNumber = 0;
        for (String s : owls) {
            int index = s.indexOf("=") + 1;
            owlNumber += Integer.parseInt(s.substring(index));
        }
        return owlNumber;
    }


    private void exceptionThrow(String county) {
        if (!owls.toString().contains(county)) {
            throw new IllegalArgumentException("No such county in Hungary!");
        }
    }
}



