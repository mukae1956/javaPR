package practice.oop;

import java.util.Scanner;

public class TV extends MediaDevice {

    Scanner s = new Scanner(System.in);
    int nowChannel = 1;
    String status;
    public void run(){
        tvRun();
    }
    public void tvRun() {

        while (true) {
            // 전원 상태 (getter 사용)
            if (!this.isPower()) {
                status = "OFF";
            } else {
                status = "ON";
            }

            // 현재 상태 출력 (getter 사용)
            System.out.println("TV (" + status + ", Ch " + nowChannel + ", Vol " + this.getVolume() + ")");
            System.out.println("[1] ON | [2] OFF | [3] Channel | [4] Volume Up | [5] Volume down | [0] Back");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("선택 > ");

            int num = s.nextInt();

            if (num == 1) {
                this.turnOn();
            }
            else if (num == 2) {
                this.turnOff();
            }
            else if (num == 3) {
                if (!this.isPower()) {
                    System.out.println("전원이 꺼져 있습니다!");
                    System.out.println("----------------------------------------------------------------------------");
                    continue;
                }

                System.out.println("변경 채널 번호 : ");
                System.out.println("입력 > ");
                int channel = s.nextInt();

                if (nowChannel == channel) {
                    System.out.println("현재 채널과 같은 채널입니다!!");
                } else {
                    nowChannel = channel;
                    System.out.println("현재 채널 : " + nowChannel);
                    System.out.println("채널이 변경되었습니다!");
                }
                System.out.println("----------------------------------------------------------------------------");
            }
            else if (num == 4) {
                if (!this.isPower()) {
                    System.out.println("전원이 꺼져 있습니다!");
                    System.out.println("----------------------------------------------------------------------------");
                    continue;
                }
                this.volumeUp();
            }
            else if (num == 5) {
                if (!this.isPower()) {
                    System.out.println("전원이 꺼져 있습니다!");
                    System.out.println("----------------------------------------------------------------------------");
                    continue;
                }
                this.volumeDown();
            }
            else if (num == 0) {
                System.out.println("기기 선택으로 돌아갑니다!");
                break;
            }
            else {
                System.out.println("없는 기능입니다! 다시 선택해 주세요!!");
            }
        }
    }
}