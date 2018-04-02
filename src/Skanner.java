import java.util.Scanner;

public class Skanner {
    private Scanner scanner;
    public Skanner(){
        this.scanner = new Scanner(System.in);
    }
    public String kysi(String kysimus){
        System.out.println(kysimus);

        return this.scanner.nextLine();

    }
    public void space(int a){
        for (int j = 0; j <  a ; j++) {
            System.out.println();
        }
    }
}