import java.util.Scanner;

public class ex1 {
    public static void main(String [] args){
        biggerThanAvg();
    }
    public static void biggerThanAvg (){
        int sum=0,avg;
        int[] num = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i=0;i<10;i++){
            System.out.println("Enter number");
            num[i]= scanner.nextInt();
            sum=num[i]+sum;
        }
        avg=sum/10;
        for (int i=0;i<10;i++){
            if (num[i]>avg)
                System.out.print(num[i]+",");

        }
    }
}
