package practice.oop;

import java.util.Scanner;

public class Light implements SmartDevice{
    Scanner s = new Scanner(System.in);
    String status;
    int nowMode = 0;
    boolean power = false;
    private static final int maxMode = 100;
    private static final int minMode = 0;

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
        System.out.println("현재 밝기 : " + nowMode + "%");
        System.out.println("변경할 밝기 입력 : ");
        System.out.println("입력 > ");
        int mode = s.nextInt();
        if (nowMode == maxMode) {
            System.out.println("이미 최대 밝기입니다!");
        } else if (mode > maxMode) {
            System.out.println("최대 밝기는 100%입니다!");
        } else if (mode <= minMode) {
            System.out.println("최대 밝기는 1%입니다!");
        } else {
            nowMode = mode;
            System.out.println("밝기를 " + nowMode + "%로 조정하였습니다💡");
        }
    }

    public void run(){
        lightRun();
    }

    public void lightRun(){
        while(true){
            if (!this.isPower()) {
                status = "OFF";
            } else {
                status = "ON";
            }

            // 현재 상태 출력 (getter 사용)
            System.out.println("Light (" + status + ", Mode " + nowMode + " %)");
            System.out.println("[1] ON | [2] OFF | [3] Mode | [0] Back");
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
