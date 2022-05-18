package week2_5.submission;

import week1.Mean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        School mm = new MeanMedianModusScore();
        School mm2 = new FrequencyScore();
        int menu = -1;
        while(menu != 0) {
            System.out.println("--------------------------------------------------");
            System.out.println();
            System.out.println("Aplikasi Pengolahan Nilai Siswa");
            System.out.println("--------------------------------------------------");
            System.out.println("Letakan file csv dengan nama file data_sekolah di direktori berikut: src/week1_5/nilaiSemester5.txt");
            System.out.println();
            System.out.println("Pilih menu: ");
            System.out.println("1. Generate txt untuk menampilkan frekuensi nilai");
            System.out.println("2. Generate txt untuk menampilkan nilai rata-rata, median, dan modus");
            System.out.println("3. Generate kedua file");
            System.out.println("0. Exit");
            menu = kb.nextInt();
            List<Integer> list = new ArrayList<>();
            switch (menu) {
                case 1:
                    list = mm.readCsv();
                    mm.generate(list);
                    break;
                case 2:
                    list = mm2.readCsv();
                    mm2.generate(list);
                    break;
                case 3:
                    list = mm.readCsv();
                    mm.generate(list);
                    list = mm2.readCsv();
                    mm2.generate(list);
                    break;
            }
        }
    }
}
