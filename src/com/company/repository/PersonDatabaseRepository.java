package com.company.repository;

import com.company.model.Person;

import java.util.Scanner;


public class PersonDatabaseRepository {
	
	private static PersonDBCrud persCRUD = new PersonDBCrud();
	public PersonDatabaseRepository() {}
	public PersonDBCrud getPersonDBCRUD() {
		return persCRUD;
	}

	//@Override
	public Person add() {
		// TODO Auto-generated method stub
		Person pers = new Person();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("idPer: ");
		Long id = scanner.nextLong();
		pers.setIdPerson(id);
		System.out.println("Vorname: ");
		String vorname = scanner.nextLine();
		pers.setFirstName(vorname);
		String vor = scanner.nextLine();
		System.out.println("Nachname: ");
		String nachname = scanner.nextLine();
		pers.setLastName(nachname);

		return pers;
	}

	//@Override
	public void find() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vorname: ");
		String vorname = scanner.next();
		persCRUD.showAll().stream().filter(pers -> pers.getFirstName().equals(vorname)).findFirst().ifPresent(System.out::println);
	}

	//@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("ID: ");
		Scanner scanner = new Scanner(System.in);
		String nachname = scanner.next();
		persCRUD.showAll().stream().filter(pers -> pers.getLastName().equals(nachname)).findFirst().ifPresent(pers -> persCRUD.delete(pers.getIdPerson()));
	}

	//@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Vorname: ");
		Scanner scanner = new Scanner(System.in);
		String vorname = scanner.next();
		persCRUD.showAll().stream().filter(pers -> pers.getFirstName().equals(vorname)).findFirst().ifPresent(pers -> persCRUD.update(pers, add()));
	}

}
