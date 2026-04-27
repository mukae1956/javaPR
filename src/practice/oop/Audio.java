package practice.oop;

import java.util.Scanner;

public class Audio extends MediaDevice {

    Scanner s = new Scanner(System.in);
    int nowTrack = 1;

    public void run(){
        audioRun();
    }
    public void audioRun() {

        while (true) {
            String status;

            // getter 사용
            if (!this.isPower()) {
                status = "OFF";
            } else {
                status = "ON";
            }

            System.out.println("Audio (" + status + ", Track " + nowTrack + ", Vol " + this.getVolume() + ")");
            System.out.println("[1] ON | [2] OFF | [3] Track | [4] Volume Up | [5] Volume Down | [0] Back");
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

                System.out.println("변경 트랙 번호 : ");
                System.out.println("입력 > ");
                int track = s.nextInt();

                if (nowTrack == track) {
                    System.out.println("현재 트랙과 같은 트랙입니다!!");
                } else {
                    nowTrack = track;
                    System.out.println("현재 트랙 : " + nowTrack);
                    System.out.println("트랙이 변경되었습니다!");
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