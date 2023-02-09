import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void swap(int[] array, int i, int j){
        int arrayPlaceHolder;
        arrayPlaceHolder = array[i];
        array[i] = array[j];
        array[j] = arrayPlaceHolder;
    }
    public static void add(int i, int j){
        i = i + j;
        j = 100;

    }
    public static void bubbleSort(int[] array){
        for (int j = array.length; j >= 1; j --){
                for (int i = 0; i<array.length-1; i++){
                if (array[i] > array[i+1]) {
                    swap(array, i ,i+1);
                }
            }
        }
    }
    
    public static boolean isSorted(int[] array) {
        /*int[] arraySorted = new int[array.length];
        for (int i = 0; i<array.length; i++){
            arraySorted[i]=array[i];
        }
        bubbleSort(arraySorted);
        for (int i = 0; i<array.length-1; i++){
            if(arraySorted[i]==array[i]){
            }else{
                return false;
            }
        }
        return true;*/
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i]>array[i+1]){return false;}
        }
        return true;
    }
    /*public static int[] readFileToArray(String filename){
        //try bufferedReader
        ArrayList<Integer> arrayList = new ArrayList<>();
        try{
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                arrayList.add(Integer.parseInt(s));

            }
            Integer[] arrayTemp=arrayList.toArray(new Integer[arrayList.size()]);
            int[] arrayOut= new int[arrayTemp.length];
            scanner.close();
            for (int i = 0; i < arrayList.size()-1; i++) {
                arrayOut[i]=arrayTemp[i].intValue();
            }
            return arrayOut;
            
        }
            catch(IOException e){}
        return null;

    }*/
    public static void insertionSort(int[] array){
        for (int i = 0; i < array.length-1;) {
            if((i==0) && array[0]>array[1]){
                swap(array,0,1);
                i++;
            }else if(array[i]>array[i+1]){
                swap(array,i,i+1);
                i--;
            }else{i++;}
            }
    }
    public static void writeArrayToFile(int[] array, String filename){
        try(FileWriter fileWriter = new FileWriter(filename)){
            fileWriter.write(Arrays.toString(array));
            fileWriter.close();
        }catch(IOException e){
            System.out.println("oh no!");
        }
    }
    public static int summation(int i){
        if (i == 1){
            return 1;
        }else {
            return i + summation(i-1);
        }
    }
    public static void randomizeArray(int[] array, int upperBounds){
        Random random = new Random();
        for (int i = 0; i < array.length - 1; i++){
            array[i] = random.nextInt(upperBounds);
        }
    }
    public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    System.out.println("Input Write filename");
    String RW_File = scan.next();
    int[] a = new int[10];
    randomizeArray(a,100);
    bubbleSort(a);
    writeArrayToFile(a,RW_File);
    }
    
}
