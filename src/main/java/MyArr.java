public class MyArr {
    private int[] arr;
    private int size = 0;

    public MyArr(int arg){
        this.arr = new int[arg];
    }

    public int getElement(int index){
        return this.arr[index];
    }

    public void setElemend(int index, int elem){
        this.arr[index] = elem;
    }

    public void deleteElemenet(int elem){
        int n = -1;
        for(int i = 0; i < this.size; i++){
            if (this.arr[i] == elem) {
                n = i;
                break;
            }
        }
        if(n > -1) {
            for (int j = n; j < this.size - 1; j++) {
                this.arr[j] = this.arr[j + 1];
            }
            this.size--;
        }
    }

    public int getSize(){
        return this.size;
    }

    public void displey() {
        System.out.println();
        for(int i = 0; i < this.size; i++){
            System.out.print(this.arr[i] + " ");
        }
    }

    public void insert(int value) {
        this.arr[this.size] = value;
        //Если элементов больше 1
        if(this.size > 0)
            //Не будем при добавлении нового элемента каждый раз сравнивать его со всем массивом
            //просто ставним его с последним, ведь массив отсортирован.
            //Если новый элемент меньше последнего, то поставим его на свое место
            if(this.arr[this.size] < this.arr[this.size - 1]){
                for(int i = 0; i < this.size; i++){
                    //Поменяем местами элементы
                    int pred = this.size - i - 1;
                    int cur = this.size - i;
                    if(this.arr[cur] < this.arr[pred]) {
                        int temp = this.arr[pred];
                        this.arr[pred] = value;
                        this.arr[cur] = temp;
                    }else
                        break;
                }
            }

        this.size++;
    }

    public void findLin(int arg){
        double curtime = System.currentTimeMillis();

        for (int i = 0; i < this.size; i++) {
            if(this.arr[i] == arg){
                System.out.println("Время линейного поиска: " + Double.toString(System.currentTimeMillis() - curtime));
                break;
            }
        }
    }

    public void findBinary(int arg) {

        double curtime = System.currentTimeMillis();

        int end = this.size - 1;
        int start = 0;
        while (start != end) {
            int mid = (start + end) / 2;
            if (this.arr[mid] == arg) {
                System.out.println("Время бинарного поиска: " + Double.toString(System.currentTimeMillis() - curtime));
                break;
            }else if (this.arr[mid] > arg) {
                end = mid;
            } else {
                start = (start == (mid - 1))?(mid):(mid - 1);//Чтобы не зациклилось
            }
        }
    }
}
