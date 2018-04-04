import java.io.*;
import java.util.*;


public class Hooldus {

    private int summa; // summa isendituup
    private static List<String> Ostukorv;

    public static ArrayList<String> HoolduseNimetused(File fail) throws FileNotFoundException {
        ArrayList<String> Hooldusenimekiri = new ArrayList<>();
        Scanner sc = new Scanner(fail, "UTF-8");
        while (sc.hasNextLine()) {
            String rida = sc.nextLine();
            Hooldusenimekiri.add(rida);
        }

        return Hooldusenimekiri;
    }
    public static ArrayList<String> HooldusMootor(File fail) throws FileNotFoundException {
        ArrayList<String> mootorinimekiri = new ArrayList<>();
        Scanner sc = new Scanner(fail, "UTF-8");
        while (sc.hasNextLine()) {
            String rida = sc.nextLine();
            mootorinimekiri.add(rida);
        }

        return mootorinimekiri;
    }
    public static ArrayList<String>HooldusSalong(File fail) throws FileNotFoundException {
        ArrayList<String>salonginimekiri = new ArrayList<>();
        Scanner sc = new Scanner(fail, "UTF-8");
        while (sc.hasNextLine()) {
            String rida = sc.nextLine();
            salonginimekiri.add(rida);
        }

        return salonginimekiri;
    }
    public static ArrayList<String> HooldusKere(File fail) throws FileNotFoundException {
        ArrayList<String>kerenimekiri = new ArrayList<>();
        Scanner sc = new Scanner(fail, "UTF-8");
        while (sc.hasNextLine()) {
            String rida = sc.nextLine();
            kerenimekiri.add(rida);
        }

        return kerenimekiri;
    }



    public void vaataOstukorvi(ArrayList<String> OstuKorv){ // ostukorvi valjastamise meetod, mdea kas seda laheb vaja
        for (int k = 0; k < OstuKorv.size(); k++)
            System.out.println(OstuKorv.get(k));
    }
}