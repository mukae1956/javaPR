package practice.oop;

import java.util.Scanner;

public class SmartHomeApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("\n 스마트홈 제어 시스템 시작..");

		// 기기 등록
		TV tv = new TV();
		AirConditioner ac = new AirConditioner();
		Light light = new Light();
		Audio audio = new Audio();

		// 기기 배열로 관리
		SmartDevice[] devices = {tv, ac, light, audio};
		String[] deviceNames = {"TV", "Air Conditioner", "Light", "Audio"};

		while (true) {
			showDevices(devices, deviceNames);

			if (!selectDevice(devices, deviceNames)) {
				System.out.println("\n 스마트홈 제어 시스템 종료..");
				return;
			}
		}
	}

	// 등록된 모든 기기 및 상태 보기
	static void showDevices(SmartDevice[] devices, String[] deviceNames) {
		String status;
		System.out.println("\n------------------------------");
		System.out.println("        스마트홈 기기 목록       ");
		System.out.println("------------------------------");

		for (int i = 0; i < devices.length; i++) {
			if (!devices[i].isPower()) {
				status = "OFF";
			}
			else {
				status = "ON";
			}
			System.out.println("[" + (i + 1) + "] [" + deviceNames[i] + "] (" + status + ")");
		}

		System.out.println("------------------------------");
	}

	// 선택된 기기 제어하기
	static boolean selectDevice(SmartDevice[] devices, String[] deviceNames) {
		int idx = readInt("\n  제어할 기기 번호 (0: 종료) > ");

		if (idx == 0) return false;

		if (idx < 1 || idx > devices.length) {
			System.out.println("없는 기기입니다! 다시 선택해 주세요!");
			return true;
		}

		// 선택한 기기의 run() 실행

		// 배열은 0부터 시작이므로 idx - 1
		// devices 안에 있는 객체들을 selected로
		SmartDevice selected = devices[idx - 1];

		// selected가 각 객체인지 instanceof로 확인 후 run 시행
		if (selected instanceof TV) {
			((TV) selected).run();
		} else if (selected instanceof AirConditioner) {
			((AirConditioner) selected).run();
		} else if (selected instanceof Light) {
			((Light) selected).run();
		} else if (selected instanceof Audio) {
			((Audio) selected).run();
		}

		return true;
	}

	// 숫자 입력 유틸
	static int readInt(String prompt) {
		System.out.print(prompt);
		while (!sc.hasNextInt()) {
			System.out.print("  숫자를 입력하세요 > ");
			sc.next();
		}
		return sc.nextInt();
	}
}