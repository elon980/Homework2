public class ex3 {
    public static void main(String[] args) {
        int[] arrayNumbers = {1,2,3,4,1,2,8,4};
        int length = arrayNumbers.length;
        length = arrayDuplicateRemoval(arrayNumbers, length);
        for (int i = 0; i < length; i++) {
            System.out.print(arrayNumbers[i] + " ");
        }
    }
    public static int arrayDuplicateRemoval(int[] originalArray, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (originalArray[i] == originalArray[j]) {
                    int remove = j;
                    for (int k = j + 1; k < length; k++, remove++) {
                        originalArray[remove] = originalArray[k];
                    }
                    length--;
                    j--;
                }
            }
        }
        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = originalArray[i];
        }
        return length;
    }
}