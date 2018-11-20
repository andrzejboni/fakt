package Faktury;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



//      Faktura st = new Faktura(null, "Janusz Kowal Pchlaczna 12", "Zbigniew Ryneczek Turkosowa 21", 12, "2018-12-12","karma dla psa",
//              8,"23");

        // Swoidwad22
        FakturaDao fakturaDao = new FakturaDao();
        // FakturaDao.saveStudentIntoDataBase(st);
        // System.out.println(fakturaDao.getAllStudentsFromDataBase());

        Scanner scanner = new Scanner(System.in);

        System.out.println("wpisz  co chcesz zrobić: \n  dodaj \n  listuj \n  exit");
        String odczyt;

        do {
            odczyt = scanner.nextLine();
            if (odczyt.equals("listuj")) {
                fakturaDao.getAllStudentsFromDataBase().stream().forEach(System.out::println);
            } else if (odczyt.equals("dodaj")) {

                System.out.println("Dane nabywcy");
                String daneNabywcy = scanner.nextLine();
                System.out.println("Dane sprzedawcy");
                String daneSprzedawcy = scanner.nextLine();
                System.out.println("Podaj kwote na jaką opiewa faktura");
                int kwota = scanner.nextInt();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

                String date = "16/08/2016";
                System.out.println("Data Wystawienia to: " +  date);

                System.out.println("Podaj produkt ktrórego dotyczy faktura ");
                String produkt = scanner.nextLine();
                System.out.println("Podaj ile produktów na fakturze");
                int ilosc = scanner.nextInt();
                System.out.println("Podaj stawke podatku na produkt");
                double stawkaPodatku = scanner.nextDouble();

                fakturaDao.saveStudentIntoDataBase(new Faktura(null, daneNabywcy, daneSprzedawcy,kwota, date,produkt,ilosc,stawkaPodatku));
            } else {
                break;
            }
        } while (!odczyt.equals("exit"));
    }

}

//        private String daneNabywcy;
//        private String daneSprzedawcy;
//        private int kwota;
//        private String dataWystawienia;
//        private String produkt;
//        private int ilosc;
//        private double stawkaPodatku;