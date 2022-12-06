public class ex4 {
    public static void main(String[] args){
        int[] array = {8,9,3,2,1};
        int x = checkArrayUpDown(array);
        System.out.println(x);
    }
    public static int checkArrayUpDown(int[] array){
        int top=-1;
        for (int i=0;i<array.length-1;i++){
            if (array[i]<array[i+1]){
                top=i+1;
                continue;
            }
            else
                break;
        }
        if (top!=-1 && top!=array.length-1) {
            for (int j = top; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    continue;
                } else {
                    top = -1;
                }
            }
        }
        else
            top=-1;
        return top;
    }
}
