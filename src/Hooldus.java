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


    public void vaataOstukorvi(ArrayList<String> OstuKorv){ // ostukorvi valjastamise meetod, mdea kas seda laheb vaja
        for (int k = 0; k < OstuKorv.size(); k++)
            System.out.println(OstuKorv.get(k));
    }
}