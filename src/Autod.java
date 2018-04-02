import java.io.*;
import java.util.*;
public class Autod {

    public static ArrayList<String> autoNimed(File fail) throws FileNotFoundException {
        ArrayList<String> Autonimekiri = new ArrayList<String>();
        Scanner sc = new Scanner(fail, "UTF-8");
        while (sc.hasNextLine()) {
            String rida = sc.nextLine();
            Autonimekiri.add(rida);
        }
        return Autonimekiri;

    }

}