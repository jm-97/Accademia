package it.bit.accademia;

import java.sql.*;
import java.util.Collection;

import com.mysql.jdbc.ConnectionImpl;

import it.bit.accademia.model.Area;

public class Main {
	
	public static void main(String[] args) {
		try (
				Connection con =DriverManager.getConnection('jdbc:mysql://localhost:3307/scuolaCorsi', 'root','passwrd');
				Statement st = con.createStatement();
				Result rs= st.executeQuery("select * from studente");
				){
			System.out.print("connessione effettuata");
			System.out.println(con.getClass().getName());
			ConnectionImpl =DriverManager.getConnection('jdbc:mysql://localhost:3307/scuolaCorsi', 'root','passwrd');
			//errore perche ci vuole cast forzato. polimorfismo . devo forzzare cioe aggiungiere (ConnectionImpl) ma è coe smell
			
			System.out.println(st.getClass().getName());
			
			
			while (rs.next()) {
				//guarda se ce prossima riga, se ce allora true , altrimenti false. fa sia hashNext() sia next() ovvero si sposta di riga.
				//anche per solo un risultato faccio un next, perche risultato potrebbe essere vuoto.
				String id= rs.getString("id");
				String nome= rs.getString("nome");
				String cf= rs.getString("codiceFiscale");
				
				System.out.printf("id: % s nome: % s descrizione: %s ", id, nome, descrizione);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		findAreaLike("GRA").forEach(System.out::println);
		betterFindAreaLike("GRA").forEach(System.out::println);
		
		
	}
	
	public static Collection<Area> findAreaLike(String partialName) {
		Collection<E> <Area> colArea = ArrayList<Area>();
 		//funzione invece che essere void ritorni Collection di Aree
		try (
				Connection con =DriverManager.getConnection('jdbc:mysql://localhost:3307/scuolaCorsi', 'root','passwrd');
				Statement st = con.createStatement();
				Result rs= st.executeQuery("select * from studente where nome = '%" + partialName + "%'");
				){
			System.out.print("connessione effettuata");
			System.out.println(con.getClass().getName());
			ConnectionImpl =DriverManager.getConnection('jdbc:mysql://localhost:3307/scuolaCorsi', 'root','passwrd');
			//errore perche ci vuole cast forzato. polimorfismo . devo forzzare cioe aggiungiere (ConnectionImpl) ma è coe smell
			
			System.out.println(st.getClass().getName());
			
			
			while (rs.next()) {
				//guarda se ce prossima riga, se ce allora true , altrimenti false. fa sia hashNext() sia next() ovvero si sposta di riga.
				//anche per solo un risultato faccio un next, perche risultato potrebbe essere vuoto.
				int id= rs.getInt("id");
				String nome= rs.getString("nome");
				String cf= rs.getString("codiceFiscale");
				
				System.out.printf("id: % s nome: % s descrizione: %s ", id, nome, descrizione);
				Area a = new Area(id, nome, cf);
				colArea.add(a);
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return colArea;
	}

public static Collection<Area> betterFindAreaLike(String partialName, String partialDescription) {
	Collection<E> <Area> colArea = ArrayList<Area>();
		//funzione invece che essere void ritorni Collection di Aree
	try (
			Connection con =DriverManager.getConnection('jdbc:mysql://localhost:3307/scuolaCorsi', 'root','passwrd');
			PreparedStatement pst = con.PreparedStatement("select * from studente where nome like ? and descrizione = ?");
			//Result rs= st.executeQuery("select * from studente where nome = '%" + partialName + "%'");
			
			){
		
		pst.setString(1, "%"+partialName+"%"); //non è risorsa autoclosable percio non in try()
		pst.setString(2, "%"+partialDescription+"%");// il prio ? ha valore %partialname%
		
		//nel from non va bene  ? perche non è collage di stringhe, lui vuole query sql sensata in cui mancano determiati dati, nome tabella è necessario
		try(ResultSet rs= pst.executeQuery()){
			while (rs.next()) {
				//guarda se ce prossima riga, se ce allora true , altrimenti false. fa sia hashNext() sia next() ovvero si sposta di riga.
				//anche per solo un risultato faccio un next, perche risultato potrebbe essere vuoto.
				int id= rs.getInt("id");
				String nome= rs.getString("nome");
				String cf= rs.getString("codiceFiscale");
			
				System.out.printf("id: % s nome: % s descrizione: %s ", id, nome, descrizione);
				Area a = new Area(id, nome, cf);
				colArea.add(a);
			}
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return colArea;
}
}
