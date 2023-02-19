import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class homework {
    public static void main(String[] args) throws FileNotFoundException{
        int[] array = readFile();
        int a = array[0];
        int b = array[1];
        System.out.println("a= "+a);
        System.out.println("b= "+b);
        String str = "";        
        if(a == 0 && b == 0) writeFile("не определено");
        else if(b < 0) writeFile(str = a + "^" + b + " = " + negativPow(a, b));
        else writeFile(str = a + "^" + b + " = " + positivPow(a, b));
    }
    
    // Метод считывания файла:
    public static int[] readFile() throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        int[] intArray = new int[2];
        String[] stringArray = line.split(" ");
        String x = "a";
        if(stringArray[0].codePointAt(0) == x.codePointAt(0)){
            intArray[0] = Integer.parseInt(stringArray[1]);
            stringArray = scanner.nextLine().split(" ");
            intArray[1] = Integer.parseInt(stringArray[1]);
        }
        else {
            intArray[1] = Integer.parseInt(stringArray[1]);
            stringArray = scanner.nextLine().split(" ");
            intArray[0] = Integer.parseInt(stringArray[1]);
        }
        scanner.close();
        return intArray;
    }

    // ВЫчисление положительной степени
    public static String positivPow(int a, int b) {
        int temp = 1;
        String result = "";
        for(int i = 0; i < b; i++){
            temp *= a;
        }
        result = String.valueOf(temp);
        return result;
    }

    // Вычисление отрицательной степени
    public static String negativPow(int a, int b) {
        double temp = 1;
        String result = "";
        for(int i = 0; i < b * -1; i++){
            temp *= a; 
        }
        result = String.valueOf(1/temp);
        return result;
    }

    
    public static void writeFile(String string) throws FileNotFoundException {
        File file = new File("output.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.println(string);
        pw.close(); 
    }
}