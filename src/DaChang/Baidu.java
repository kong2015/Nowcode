package DaChang;

/**
 * @author dxd
 * @create 2021-08-29 18:31
 */
public class Baidu {
    /**
     * 完美数字
     * @param args
     */
    public static void main(String[] args) {
        String s = "1303"; //变成1293；向前借一位
        System.out.println(getPerfect(s));
    }
    private static long getPerfect(String str){
        char[] arr = str.toCharArray();
        int j = 0;
        while (j < arr.length) {
            if (arr[j] > '3') {
                break;
            }else if (arr[j] == '0') {
                if (j == 0) {
                    j++;
                    break;
                }
                arr[j] = '9';
                j--;
                arr[j]--;
            } else {
                j++;
            }
        }
        for (; j < arr.length; j++) {
            arr[j] = '3';
        }
        return Long.parseLong(new String(arr));
    }
}