package DaChang;

/**
 * @author dxd
 * @create 2021-10-15 15:01
 */
// 一个遥控器可以控制电视、空调。遥控器有个2按钮，分别为：

// 1. 控制目标切换按钮：按照顺序切换遥控的控制目标，依次按下，会切换电视、空调。

// 2. 开关机按钮：根据按钮1切换的结果，控制目标的开关机，并打印出文字“电视/空调 开/关机”。

// 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法
public class ShowMeBug {
    public static void main(String[] args) {
        System.out.println("dajiangzy");
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Controller c = new Controller();
        c.turnButtonA();
        c.turnButtonB();
        c.turnButtonB();

        c.turnButtonA();
        c.turnButtonB();
        c.turnButtonB();
        System.out.println("Hello World!");
    }
}

class A{
    protected boolean isOn = false;
    public void turnOn(){
        isOn = true;
    }
    public void turnOff(){
        isOn = false;
    }
}

class DianShi extends A{
    @Override
    public void turnOn(){
        isOn = true;
        System.out.println("电视 开机");
    }
    @Override
    public void turnOff(){
        isOn = false;
        System.out.println("电视 关机");
    }
}

class KongTiao extends A{
    @Override
    public void turnOn(){
        isOn = true;
        System.out.println("空调 开机");
    }
    @Override
    public void turnOff(){
        isOn = false;
        System.out.println("空调 关机");
    }
}

class Controller{
    private KongTiao k = new KongTiao();
    private DianShi d = new DianShi();
    private boolean flag1;
    private boolean flag2;
    private A a;
    public void turnButtonA(){
        if(flag1 == true){
            this.a = k;
            flag1 = !flag1;
        }else{
            this.a = d;
            flag1 = !flag1;
        }
    }
    public void turnButtonB(){
        if(flag2 == false){
            this.a.turnOn();
            flag2 = !flag2;
        }else{
            a.turnOff();
            flag2 = !flag2;
        }
    }
}