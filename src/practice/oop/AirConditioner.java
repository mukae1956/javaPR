package practice.oop;


import java.util.Scanner;

public class AirConditioner implements SmartDevice{
    boolean power = false;
    Scanner s = new Scanner(System.in);
    int nowMode = 1;
    int nowTemperature = 18;
    String status;
    private final static int maxTemperature = 30;
    private final static int minTemperature = 15;

    @Override
    public void turnOn() {
        power = true;
        System.out.println("==================");
        System.out.println(" 전원이 켜졌습니다!!");
        System.out.println("==================");
    }

    @Override
    public void turnOff() {
        power = false;
        System.out.println("==================");
        System.out.println(" 전원이 꺼졌습니다!!");
        System.out.println("==================");
    }
    @Override
    public boolean isPower(){
        return power;
    }

    public void modeSelect() {
        System.out.println("[1] 냉방 | [2] 난방 | [3] 제습");
        System.out.println("변경할 모드 입력 : ");
        System.out.println("입력 > ");
        int mode = s.nextInt();
        if (nowMode == mode) {
            System.out.println("현재 모드와 같은 모드입니다!");
        }
        else{
            if (mode == 1) {
                nowMode = mode;
                System.out.println("모드를 냉방으로 변경하였습니다 ❄");
            } else if (mode == 2) {
                nowMode = mode;
                System.out.println("모드를 난방으로 변경하였습니다 🔥");
            } else if (mode == 3) {
                nowMode = mode;
                System.out.println("모드를 냉방으로 변경하였습니다 🌀");
            } else {
                System.out.println("없는 모드입니다! 다시 선택해 주세요!");
            }
        }
    }

    public void temperatureChange(){
        System.out.println("현재 온도 : " + nowTemperature + "도");
        System.out.println("변경 온도 입력 : ");
        System.out.println("---------------------------------------");
        System.out.println("입력 > ");
        int temperature = s.nextInt();
        if (nowTemperature == temperature) {
            System.out.println("현재 온도와 같은 온도입니다!");
        }
        else{
            if(temperature > maxTemperature){
                System.out.println("온도는 " + maxTemperature + "까지만 변경이 가능합니다");
            }
            else if(temperature < minTemperature){
                System.out.println("온도는 " + maxTemperature + "까지만 변경이 가능합니다");
            }
            else {
                nowTemperature = temperature;
                System.out.println("온도가 변경되었습니다!");
                System.out.println("현재 온도는 " + nowTemperature + "도 입니다!");
            }
        }
    }
    //작동 자체를 묶어서 실행
    public void run(){
        airRun();
    }
    public void airRun(){
        while(true){
            if (!this.isPower()) {
                status = "OFF";
            } else {
                status = "ON";
            }

            if (nowMode ==1){
                System.out.println("Air Conditioner (" + status + ", Mode : 냉방 )");
            }
            else if (nowMode == 2) {
                System.out.println("Air Conditioner (" + status + ", Mode : 난방 )");
            }
            else if (nowMode == 3){
                System.out.println("Air Conditioner (" + status + ", Mode : 제습 )");
            }
            else{
                continue;
            }

            System.out.println("[1] ON | [2] OFF | [3] Mode | [4] Temperature | [0] Back");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("선택 > ");
            int num = s.nextInt();
            if (num == 1){
                this.turnOn();
            }
            else if (num ==2){
                this.turnOff();
            }
            else if (num ==3){
                if (!this.isPower()){
                    System.out.println("전원이 꺼져 있습니다!");
                    continue;
                } else {
                    this.modeSelect();
                }
            }
            else if (num == 4){
                if(!this.isPower()){
                    System.out.println("전원이 꺼져 있습니다!");
                    continue;
                } else {
                    this.temperatureChange();
                }
            }
            else if (num == 0){
                System.out.println("기기 선택으로 돌아갑니다!");
                break;
            }
            else {
                System.out.println("없는 기능입니다! 다시 선택해 주세요!");
            }
        }
    }
}
