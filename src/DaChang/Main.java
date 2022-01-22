package DaChang;
import java.util.*;

/**
 * @author dingxudong
 * @create 2021-08-30 21:18
 * @Description
 */
public class Main {
    public static void main1(String[] args) {
//        System.out.println("0");          //0
//        System.out.println('0');           //0
//        System.out.println(2+'0');         //50
//        System.out.println(2+"0");         //20

//        System.out.println('0' + 0);//48
//        System.out.println('A' + 0);//65
//        System.out.println('a' + 0);//97
//        try{
//            System.out.println(1<<4);
//        }
//        catch (Exception e){
//            System.out.println(2);
//            System.out.println(e.getStackTrace());
//        }finally {
//            System.out.println(1);
//        }

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s == null || "".equals(s)) break;
            String[] split = s.split("\\s");
            String key = split[0].substring(split[0].lastIndexOf('\\') + 1) + " " + split[1];
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (int i = 0; i < 8; i ++) {
            String[] split = list.get(i).getKey().split("\\s");
            if(split[0].length() > 16) split[0] = split[0].substring(split[0].length() - 16);
            System.out.println(split[0] + " " + split[1] + " " + list.get(i).getValue());
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

        }
    }


}