package it.bit.accademia.model.data.jdbc;

import java.util.Collection;

import it.bit.accademia.model.Student;
import it.bit.accademia.model.data.StudentRepository;

public class StudentRepositoryJdbc implements StudentRepository {

	@Override
	public Student add(Student studente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Student> findByNameLike(String partialName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Student> findByLastNameLike(String partialLastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iscriviStudente(int studentId, int idCorso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Student> studentsByCourse(int corso) {
		// TODO Auto-generated method stub
		return null;
	}

}
