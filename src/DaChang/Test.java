package DaChang;

/**
 * @author dingxudong
 * @create 2021-09-29 20:26
 * @Description
 */
class Per{
    int i = 10;
    public Per(){
        System.out.println(1);
    }
    static {
        System.out.println(2);
    }
    protected Per show(){
        System.out.println(i);
        return new Per();
    }
    private void show1(int a, double b){
        System.out.println(1);
    }
    private void show1(double a, int b){
        System.out.println(1);
    }
}

class Stu extends Per {
    static int i = 20;
    public Stu(){
        System.out.println(3);
    }
    static {
        int i = 40;
        System.out.println(4);
    }
    @Override
    public Stu show(){//返回值是父类返回值或者父类返回值的派生类
        System.out.println(i);
        return new Stu();
    }

}

public class Test {
    private int id;
    public int age;
    public String name;
    public static void change(StringBuffer a, StringBuffer b){
        a.append(b);
        b = a;
    }
    public static void change(String s, char[]c){
        s = "test ok";
        c[0]='c';
    }
    public static void change(int a, int b){
        int c = a;
        a = b;
        b = c;
    }


    public static void main(String[] args) {
        StringBuffer A = new StringBuffer("A");
        StringBuffer B = new StringBuffer("B");
        String C = "hello";
        char[] d = new char[]{'a','b'};
        change(C,d);
        System.out.println(C);//hello
        System.out.println(d);//cb
        change(A,B);
        System.out.println(A);//AB
        System.out.println(B);//B
        int e = 1;
        int f = 2;
        change(e,f);
        System.out.println(e);
        System.out.println(f);

        //2 1 4 1 3
//        Per p1 = new Per();//2 1
//        Per p2 = new Stu();//2 4 1 3

//        Per p3 = new Stu();
//        Per p4 = new Per();//2 4 1 3 1

//        Per p5 = new Stu();
//        Per p6 = new Stu();//2 4 1 3 1 3

//        Per p7 = new Per();//2 1 4 1 3
//        System.out.println(p7);
//        Per p8 = new Stu();
//        System.out.println(p8.i);
//        System.out.println("        ");
//        System.out.println(p7.i);
//        System.out.println(p8.i);
//        p7.show();
//        p8.show();
    }
}
