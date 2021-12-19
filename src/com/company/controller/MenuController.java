package com.company.controller;


import com.company.model.Person;
import com.company.repository.PersonDatabaseRepository;

import java.util.Scanner;


public class MenuController {
	private PersonDatabaseRepository persRepo = new PersonDatabaseRepository();
	public void options() {
		System.out.println("DATABASE:");
		System.out.println("        1. Create");
		System.out.println("        2. Read");
		System.out.println("        3. Update");
		System.out.println("        4. Delete");
		System.out.println("        5. Find");
	}
	public void menu() {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Choose one: ");
			options();
			Integer option = scanner.nextInt();
			switch (option) {
			case 1: {
				persRepo.getPersonDBCRUD().add(persRepo.add());
				break;
			}
			case 2: {
				persRepo.getPersonDBCRUD().showAll();
				break;
			}
			case 3: {
				Person oldPers = new Person();
				Person newPers = new Person();

				System.out.println("Old idPer: ");
				Long id = scanner.nextLong();
				oldPers.setIdPerson(id);
				System.out.println("Old Vorname: ");
				String vorname = scanner.nextLine();
				oldPers.setFirstName(vorname);
				String vor = scanner.nextLine();
				System.out.println("Old Nachname: ");
				String nachname = scanner.nextLine();
				oldPers.setLastName(nachname);

				System.out.println("New idPer: ");
				Long newId = scanner.nextLong();
				newPers.setIdPerson(id);
				System.out.println("New Vorname: ");
				String newVorname = scanner.nextLine();
				newPers.setFirstName(vorname);
				String newVor = scanner.nextLine();
				System.out.println("New Nachname: ");
				String newNachname = scanner.nextLine();
				newPers.setLastName(nachname);

				persRepo.getPersonDBCRUD().update(oldPers, newPers);
				break;
			}
			case 4: {
				System.out.println("idPer: ");
				Integer id = scanner.nextInt();
				persRepo.getPersonDBCRUD().delete(id);
				break;
			}
			case 5: {
				System.out.println("idPer: ");
				Integer id = scanner.nextInt();
				persRepo.getPersonDBCRUD().find(id);
				break;
			}
			default:
				break;
			}
			System.out.println("Database, continue? (y/n)");
			String next = scanner.next();
			if(!next.equals("y")) {
				break;
			}
		}
	}

}
