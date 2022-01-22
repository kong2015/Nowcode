package DaChang;

public class SumArray {
    private static int sum(int[] array, int l){
        if (array.length == l){
            return 0;
        }
        return array[l] + sum(array, l+1);
    }
    public static int sum(int[] array){
        return sum(array, 0);
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,6};
        System.out.println(sum(array));
    }
}
