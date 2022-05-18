package week2_5.submission;

import java.io.*;
import java.util.*;

public class MeanMedianModusScore implements School{

    @Override
    public List<Integer> readCsv() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/week2_5/submission/data_sekolah.csv"));
        String line = "";
        List<Integer> list = new ArrayList<>();
        while (br.ready()) {
            line = br.readLine();
            String[] data = line.split(";");
            for (int i = 1; i < data.length; i++) {
                list.add(Integer.parseInt(data[i]));
            }
        }
        br.close();
        return Collections.unmodifiableList(list);
    }

    @Override
    public void generate(List<Integer> list) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("src/week2_5/submission/data_sekolah_modus_median.txt"));
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        double mean = (double) sum / list.size();
        double median = 0;
        if (list.size() % 2 == 0) {
            median = (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.;
        } else {
            median = list.get(list.size() / 2);
        }
        int modus = 0;
        int max = 0;
        for (int i : list) {
            int count = 0;
            for (int j : list) {
                if (i == j) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                modus = i;
            }
        }
        pw.println("Berikut Hasil Pengolahan Nilai:");
        pw.println("\nBerikut hasil sebaran data nilai");
        pw.println("Mean: " + mean);
        pw.println("Median: " + median);
        pw.print("Modus: " + modus);
        pw.close();
    }
}
