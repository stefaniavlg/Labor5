package com.company.repository;


import com.company.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDBCrud {
	private ConnectToDB conDB = new ConnectToDB();
	public PersonDBCrud() {
		conDB = new ConnectToDB();
	}

	/**
	 * CREATE person
	 * @param pers
	 */
	public void add(Person pers) {
		String query = "INSERT INTO `person`(`idPerson`, `Vorname`, `Nachname`) values(?, ?, ?)";
		try {
			conDB.connectDB();
			PreparedStatement stmt = conDB.getConnection().prepareStatement(query);

			stmt.setLong(1, pers.getIdPerson());
			stmt.setString(2, pers.getFirstName());
			stmt.setString(3, pers.getLastName());

			stmt.execute();
		}catch(Exception ex) {
			System.out.println("Not Created");
		}
	}

	/**
	 * Read
	 * @return
	 */
	public List<Person> showAll() {
		List<Person> persList = new ArrayList<>();
		try {
			conDB.connectDB();
			PreparedStatement stmt = conDB.getConnection().prepareStatement("SELECT * FROM person");
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				long id = result.getLong("idPerson");
				String vorname = result.getString("firstName");
				String nachname = result.getString("lastName");

				Person pers = new Person(id, vorname, nachname);
				persList.add(pers);
				//System.out.println(pers);
				System.out.println("Id: " + pers.getIdPerson() + ", firstname: " + pers.getFirstName() + ", lastName: " + pers.getLastName());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("No Person found");
		}
		return persList;
	}

	/**
	 * UPDATE Person
	 * @param oldPers
	 * @param newPers
	 */
	public void update(Person oldPers, Person newPers) {
		try {
			conDB.connectDB();
			String query = "UPDATE `person` SET `firstName`=?, `lastName`=? WHERE `idPerson`=" + oldPers.getIdPerson();
			PreparedStatement stmt = conDB.getConnection().prepareStatement(query);
			stmt.setString(1, newPers.getFirstName());
			stmt.setString(2, newPers.getLastName());

			stmt.executeUpdate();
			System.out.println("Updated");
		}catch(Exception ex) {
			System.out.println("No Update");
		}
	}

	/**
	 * DELETE Person
	 * @param id
	 */
	public void delete(long id) {
		try {
			conDB.connectDB();
			String query = "DELETE FROM `person` WHERE `idPerson`="+ id;
			PreparedStatement stmt = conDB.getConnection().prepareStatement(query);
			stmt.execute();
			System.out.println("Deleted");
		}catch(Exception ex) {
			System.out.println("No Delete");
		}
	}
	public void find(long id) {
		List<Person> persList= new ArrayList();
		try {
			conDB.connectDB();
			PreparedStatement stmt = conDB.getConnection().prepareStatement("SELECT * FROM `person` WHERE `idPerson`=" + id);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				long idP = result.getLong("idPerson");
				String vorname = result.getString("firstName");
				String nachname = result.getString("lastName");

				Person pers = new Person(idP, vorname, nachname);
				persList.add(pers);
				//System.out.println(pers);
				System.out.println("Id: " + pers.getIdPerson() + ", firstname: " + pers.getFirstName() + ", lastName: " + pers.getLastName());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("No Person found");
		}
	}

}
