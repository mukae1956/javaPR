package practice.oop;

public interface SmartDevice {
    void turnOn();
    void turnOff();
    boolean isPower(); // 🔥 상태 확인용
    void run();        // 🔥 실행용
}