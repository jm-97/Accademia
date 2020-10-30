package it.bit.accademia.model.data;

import java.util.Collection;

import it.bit.accademia.model.Student;

//usato per crud: create remove update delete
public interface StudentRepository {
	
	Student add(Student studente) throws DataException;
	Student delete(int id) throws DataException;
	Collection<Student> findAll() throws DataException;
	Collection<Student> findByNameLike(String partialName) throws DataException;
	Collection<Student> findByLastNameLike(String partialLastName) throws DataException;
	Student findById(int id) throws DataException;
	void update (Student student) throws DataException;
	void iscriviStudente(int studentId,int idCorso) throws DataException; // se gia iscritto a corso il metodo se ne deve accorgere
	//non boolean perche dovremmo lanciare eccezione controllando il boolean, (if ...) ,ma noi abbiamo la nostra classe di gestione errori che e meglio
	
	Collection<Student> studentsByCourse(int corso) throws DataException;
	
}
