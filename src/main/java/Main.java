import java.util.Random;

public class Main {

    public static void main(String[] arg){

        //Размер массива
        final int sizearr = 1000000;

        //Создадим массив
        MyArr arr = new MyArr(sizearr);
        Random random = new Random();

        //Заполним массив случайными числами
        for(int i = 0; i<sizearr; i++){
            arr.insert(random.nextInt(sizearr));
        }

        //Найдем случайно выбранное число
        int temp = random.nextInt(sizearr);
        int mfind = arr.getElement(temp);

        //Сначала найдем линейным способом
        System.out.println("Найдем число: " + Integer.toString(mfind) + ", которое находится в " + Integer.toString(temp) + " элементе массива.");
        arr.findLin(mfind);
        arr.findBinary(mfind);
    }

}
