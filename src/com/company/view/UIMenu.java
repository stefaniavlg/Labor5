package com.company.view;

import com.company.controller.MenuController;

import java.util.Scanner;


public class UIMenu {
	public void options() {
		System.out.println(" 1. Database");
	}
	public void menuUI() {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Choose one: ");
			options();
			Integer option = scanner.nextInt();
			switch (option) {
			case 1: {
				MenuController crt = new MenuController();
				crt.menu();
				break;
			}
			default: break;	
			}
			System.out.println("Continue? (y/n)");
			String next = scanner.next();
			if(!next.equals("y")) {
				break;
			}
		}
	}
}
