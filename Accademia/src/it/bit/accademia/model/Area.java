package it.bit.accademia.model;

public class Area {
	private int id;
	private String nome;
	private String cognome;
	public Area(int id, String nome, String cognome) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	

	

}
