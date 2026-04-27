package practice.oop;

public abstract class MediaDevice implements SmartDevice {

    // 🔥 전원 상태는 여기서 관리
    private boolean power = false;

    // 🔥 볼륨
    private int volume = 0;
    private static final int maxVolume = 100;
    private static final int minVolume = 0;

    public int getVolume() {
        return volume;
    }

    @Override
    public boolean isPower() {
        return power;
    }

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
    public abstract void run();

    public void volumeUp() {
        if (volume >= maxVolume) {
            System.out.println("지금은 최대 볼륨입니다!");
        } else {
            volume = Math.min(volume + 10, maxVolume);
            System.out.println("현재 볼륨 : " + volume);
        }
        System.out.println("----------------------------------------------------------------------------");
    }

    public void volumeDown() {
        if (volume <= minVolume) {
            System.out.println("지금은 최소 볼륨입니다!");
        } else {
            volume = Math.max(volume - 10, minVolume);
            System.out.println("현재 볼륨 : " + volume);
        }
        System.out.println("----------------------------------------------------------------------------");
    }
}