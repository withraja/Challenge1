package week2_5.submission;

import java.io.IOException;
import java.util.List;

public interface School {
    List<Integer> readCsv() throws IOException;
    void generate(List<Integer> list) throws IOException;
}
