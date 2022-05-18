package week2_5.submission;

import java.io.*;
import java.util.*;

public class FrequencyScore implements School {
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
        Map<String, Integer> map = new HashMap<>();
        map.put("kurang dari 6", 0);
        map.put("6", 0);
        map.put("7", 0);
        map.put("8", 0);
        map.put("9", 0);
        map.put("10", 0);

        for (int el : list) {
            if (el < 6) {
                map.put("kurang dari 6", map.get("kurang dari 6") + 1);
            } else if (el == 6) {
                map.put("6", map.get("6") + 1);
            } else if (el == 7) {
                map.put("7", map.get("7") + 1);
            } else if (el == 8) {
                map.put("8", map.get("8") + 1);
            } else if (el == 9) {
                map.put("9", map.get("9") + 1);
            } else if (el == 10) {
                map.put("10", map.get("10") + 1);
            }
        }

        PrintWriter pw = new PrintWriter(new FileWriter("src/week2_5/submission/data_sekolah_modus.txt"));
        pw.println("Berikut Hasil Pengolahan Nilai:");
        pw.println("\nNilai\t\t\t|\tFrekuensi");
        pw.println("kurang dari 6\t|\t" + map.get("kurang dari 6"));
        pw.println("6\t\t\t\t|\t" + map.get("6"));
        pw.println("7\t\t\t\t|\t" + map.get("7"));
        pw.println("8\t\t\t\t|\t" + map.get("8"));
        pw.println("9\t\t\t\t|\t" + map.get("9"));
        pw.print("10\t\t\t\t|\t" + map.get("10"));
        pw.close();

    }
}
