import java.io.*;
import java.text.BreakIterator;
import java.util.*;

public class Muudatused_K extends Autod {

    public static ArrayList<String> Ostukorv = new ArrayList<String>();

    public static Integer Summeeri() {
        int summa = 0;
        for (int i = 0; i < Ostukorv.size(); i++) {
            String[] tükid = Ostukorv.get(i).split(" ");
            summa += Integer.parseInt(tükid[tükid.length - 1].substring(0, tükid[tükid.length - 1].length() - 1));

        }
        return summa;
    }


    public static void main(String[] args) throws Exception {

        File fail = new File("Autod.txt");
        File failHooldusTuup = new File("Hooldus.txt");
        File failmootorihooldus = new File("MootoriHooldus.txt");
        File failsalongihooldus = new File("SalongiHooldus.txt");
        File failkerehooldus = new File("KereHooldus.txt");


        boolean running = true;
        Skanner s = new Skanner();
        String name = s.kysi("Sisestage oma eesnimi");
        String surname = s.kysi("Sisestage oma perenimi");
        Klient Kasutaja = new Klient(name, surname);
        while (running) {
            boolean tõeväärtus = true;

            String soov = s.kysi("Ost või hooldus");
            System.out.println(Kasutaja);

            if (soov.toLowerCase().equals("ost")) {// KUI VASTUS ON OST SIIS ANNAB ETTE MÜÜGILOLEVATEAUTODE NIMEKIRJA
                System.out.println("Siin näete kõiki müügilolevate autode nimekirja: ");
                s.space(3);
                for (int i = 0; i < Autod.autoNimed((fail)).size(); i++) {// VÄLJASTAB NIMEKIRJA
                    System.out.println(Autod.autoNimed((fail)).get(i));
                }

                s.space(3);

                String misauto = s.kysi("Valige palun mudel, mida soovite osta(väljumise puhul, sisestage ei)").toLowerCase(); //SKÄNNIB VALITUD AUTOT

                for (int i = 0; i < Autod.autoNimed((fail)).size(); i++) {

                    if (Autod.autoNimed((fail)).get(i).toLowerCase().contains(misauto)) { // KONTROLLIB ÜLE, MILLINE AUTO MATCHIB VASTUSEGA
                        s.space(1);
                        Ostukorv.add((Autod.autoNimed((fail)).get(i)));// LISAB SELLE VALIKU OSTUKORVI
                        System.out.println("Auto lisati ostukorvi");
                        String misedasi = s.kysi("Kas soovid kviitungit?");
                        s.space(3);

                        if (misedasi.toLowerCase().equals("jah")) {
                            System.out.println("Klient: " + Kasutaja.getNimi() + " " + Kasutaja.getPerekonnanimi());
                            System.out.println("Teie ostunimekiri:");

                            for (int j = 0; j < Ostukorv.size(); j++) {

                                System.out.println(Ostukorv.get(j));//valjastame ilusti tabelina ostukorvi
                            }
                            s.space(2);
                            System.out.println("Kokku tasuda tuleb: " + Summeeri() + "€");

                            running = false;

                            break;


                        } else {
                            System.out.println("Oled saadetud algusesse tagasi. ");
                            s.space(3);
                        }
                    } else if (misauto.toLowerCase().equals("ei")) {
                        if (Ostukorv.size() != 0 && tõeväärtus) {
                            for (int j = 0; j < Ostukorv.size(); j++) {

                                System.out.println(Ostukorv.get(j));//valjastame ilusti tabelina ostukorvi
                            }
                            s.space(2);
                            System.out.println("Kokku läheb teil maksma: " + Summeeri() + "€");
                            tõeväärtus = false;
                            running = false;
                        } else if (tõeväärtus) {
                            tõeväärtus = false;
                            System.out.println("Teie ostukorv on tühi valige 'välju' või 'tagasi poodi'.");
                        }
                    }
                }
            } else if (soov.toLowerCase().equals("hooldus")) {

                System.out.println("Siin näete, milliseid hooldusteenusi me pakume: ");
                s.space(1);
                for (int i = 0; i < Hooldus.HoolduseNimetused((failHooldusTuup)).size(); i++) {// VÄLJASTAB NIMEKIRJA
                    System.out.println(Hooldus.HoolduseNimetused((failHooldusTuup)).get(i));
                }

                System.out.println();//TÜHI RIDA
                String soovHooldus = s.kysi("Millist hooldust soovite?").toLowerCase();  // MUUDATUS Skanner  -------------------------------------------------------------------------------------


                for (int i = 0; i < Hooldus.HoolduseNimetused((failHooldusTuup)).size(); i++) {
                    if (Hooldus.HoolduseNimetused(failHooldusTuup).get(i).toLowerCase().contains(soovHooldus)) { // KONTROLLIB ÜLE, MILLINE AUTO MATCHIB VASTUSEGA
                        s.space(1);
                        System.out.println("Valisite selle hoolduse: " + Hooldus.HoolduseNimetused((failHooldusTuup)).get(i));
                        s.space(1);
                    }
                    if (soovHooldus.toLowerCase().contains("mootor")) {

                        for (int k = 0; k < Hooldus.HooldusMootor(failmootorihooldus).size(); k++) {// VÄLJASTAB NIMEKIRJA
                            System.out.println(Hooldus.HooldusMootor(failmootorihooldus).get(k));
                        }
                        String mishooldus = s.kysi("Valige palun teenus, mida soovite kasutada (väljumise puhul, sisestage ei)").toLowerCase(); //SKÄNNIB VALITUD AUTOT

                        if (Hooldus.HoolduseNimetused((failmootorihooldus)).get(i).toLowerCase().contains(mishooldus)) { // KONTROLLIB ÜLE, MIS MATCHIB VASTUSEGA
                            System.out.println();
                            Ostukorv.add((Hooldus.HoolduseNimetused((failmootorihooldus)).get(i)));// LISAB SELLE VALIKU OSTUKORVI
                            System.out.println("Teenus lisati ostukorvi");
                            String misedasi = s.kysi("Kas soovid kviitungit?");
                            s.space(3);

                            if (misedasi.toLowerCase().equals("jah")) {
                                System.out.println("Klient: " + Kasutaja.getNimi() + " " + Kasutaja.getPerekonnanimi());
                                System.out.println("Teie ostunimekiri:");
                                for (int l = 0; l < Ostukorv.size(); l++) {

                                    System.out.println(Ostukorv.get(l));//valjastame ilusti tabelina ostukorvi
                                }
                                s.space(2);
                                System.out.println("Kokku tasuda tuleb: " + Summeeri() + "€");

                                running = false;
                                break;


                            } else {
                                System.out.println("Oled saadetud algusesse tagasi. ");
                                s.space(3);
                            }

                        } else if (mishooldus.toLowerCase().equals("ei")) {

                            if (Ostukorv.size() != 0 && tõeväärtus) {
                                for (int j = 0; j < Ostukorv.size(); j++) {

                                    System.out.println(Ostukorv.get(j));//valjastame ilusti tabelina ostukorvi
                                }
                                s.space(2);
                                System.out.println("Kokku läheb teil maksma: " + Summeeri() + "€");
                                tõeväärtus = false;
                                running = false;
                                // VAATA SEDA RIDA RSK
                            } else if (tõeväärtus) {
                                System.out.println("Teie ostukorv on tühi valige 'välju' või 'tagasi poodi'.");
                                tõeväärtus = false;
                            }

                        }

                    } else if (soovHooldus.toLowerCase().contains("kere")) {

                        for (int j = 0; j < Hooldus.HoolduseNimetused((failkerehooldus)).size(); j++) {// VÄLJASTAB NIMEKIRJA
                            System.out.println(Hooldus.HoolduseNimetused((failkerehooldus)).get(j));
                        }

                        String mishooldus = s.kysi("Valige palun teenus, mida soovite kasutada (väljumise puhul, sisestage ei)").toLowerCase();

                        for (int k = 0; k < Hooldus.HoolduseNimetused((failkerehooldus)).size(); k++) {

                            if (Hooldus.HoolduseNimetused((failkerehooldus)).get(k).toLowerCase().contains(mishooldus)) { // KONTROLLIB ÜLE, MIS MATCHIB VASTUSEGA
                                System.out.println();
                                Ostukorv.add((Hooldus.HoolduseNimetused((failkerehooldus)).get(k)));// LISAB SELLE VALIKU OSTUKORVI
                                System.out.println("Teenus lisati ostukorvi");
                                String misedasi = s.kysi("Kas soovid kviitungit?");
                                s.space(3);

                                if (misedasi.toLowerCase().equals("jah")) {
                                    System.out.println("Klient: " + Kasutaja.getNimi() + " " + Kasutaja.getPerekonnanimi());
                                    System.out.println("Teie ostunimekiri:");

                                    for (int l = 0; l < Ostukorv.size(); l++) {

                                        System.out.println(Ostukorv.get(l));//valjastame ilusti tabelina ostukorvi
                                    }
                                    s.space(2);
                                    System.out.println("Kokku tasuda tuleb: " + Summeeri() + "€");

                                    running = false;
                                    break;


                                } else {
                                    System.out.println("Oled saadetud algusesse tagasi. ");
                                    s.space(3);
                                }

                            } else if (mishooldus.toLowerCase().equals("ei")) {

                                if (Ostukorv.size() != 0 && tõeväärtus) {
                                    for (int j = 0; j < Ostukorv.size(); j++) {

                                        System.out.println(Ostukorv.get(j));//valjastame ilusti tabelina ostukorvi
                                    }
                                    s.space(2);
                                    System.out.println("Kokku läheb teil maksma: " + Summeeri() + "€");
                                    tõeväärtus = false;
                                    running = false;
                                    break;

                                } else if (tõeväärtus) {
                                    System.out.println("Teie ostukorv on tühi valige 'välju' või 'tagasi poodi'.");
                                    tõeväärtus = false;
                                }

                            }

                        }
                    } else if (soovHooldus.toLowerCase().contains("salong")) {

                        for (int j = 0; j < Hooldus.HooldusSalong((failsalongihooldus)).size(); j++) {// VÄLJASTAB NIMEKIRJA
                            System.out.println(Hooldus.HooldusSalong((failsalongihooldus)).get(j));
                        }

                        String mishooldus = s.kysi("Valige palun teenus, mida soovite kasutada (väljumise puhul, sisestage ei)").toLowerCase(); //SKÄNNIB VALITUD AUTOT

                        for (int k = 0; k < Hooldus.HooldusSalong((failsalongihooldus)).size(); k++) {

                            if (Hooldus.HooldusSalong((failsalongihooldus)).get(k).toLowerCase().contains(mishooldus)) { // KONTROLLIB ÜLE, MIS MATCHIB VASTUSEGA
                                System.out.println();
                                Ostukorv.add((Hooldus.HooldusSalong((failsalongihooldus)).get(k)));// LISAB SELLE VALIKU OSTUKORVI
                                System.out.println("Teenus lisati ostukorvi");
                                String misedasi = s.kysi("Kas soovid kviitungit?");
                                s.space(3);

                                if (misedasi.toLowerCase().equals("jah")) {
                                    System.out.println("Klient: " + Kasutaja.getNimi() + " " + Kasutaja.getPerekonnanimi());
                                    System.out.println("Teie ostunimekiri:");

                                    for (int l = 0; l < Ostukorv.size(); l++) {

                                        System.out.println(Ostukorv.get(l));//valjastame ilusti tabelina ostukorvi
                                    }
                                    s.space(2);
                                    System.out.println("Kokku tasuda tuleb: " + Summeeri() + "€");

                                    running = false;
                                    break;



                                } else {
                                    System.out.println("Oled saadetud algusesse tagasi. ");
                                    s.space(3);
                                }

                            } else if (mishooldus.toLowerCase().equals("ei")) {

                                if (Ostukorv.size() != 0 && tõeväärtus) {
                                    for (int j = 0; j < Ostukorv.size(); j++) {

                                        System.out.println(Ostukorv.get(j));//valjastame ilusti tabelina ostukorvi
                                    }
                                    s.space(2);
                                    System.out.println("Kokku läheb teil maksma: " + Summeeri() + "€");
                                    tõeväärtus = false;
                                    running = false;
                                    // VAATA SEDA RIDA RSK
                                } else if (tõeväärtus) {
                                    tõeväärtus = false;
                                    System.out.println("Teie ostukorv on tühi valige 'välju' või 'tagasi poodi'.");
                                }

                            }

                        }
                    }
                }
            }
        }
    }
}

