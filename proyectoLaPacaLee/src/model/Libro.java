package model;

public class Libro {
	
	private String titulo;
	private String autor;
	private String resumen;
	private String genero;
	private String codigo;
	private boolean prestado;
	private String dniPrestatario;
	
	public Libro(String titulo, String autor, String resumen, String genero, String codigo, boolean prestado, String dniPrestatario) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.resumen = resumen;
		this.genero = genero;
		this.codigo = codigo;
		this.prestado = prestado;
		this.dniPrestatario = dniPrestatario;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isPrestado() {
		return prestado;
	}
	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	public String getDniPrestatario() {
		return dniPrestatario;
	}
	public void setDniPrestatario(String dniPrestatario) {
		this.dniPrestatario = dniPrestatario;
	}

}
