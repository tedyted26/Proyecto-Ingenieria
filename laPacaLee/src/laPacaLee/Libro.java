package laPacaLee;

public class Libro {
	private String titulo;
	private String autor;
	private String resumen;
	private String genero;
	private String codigo;
	
	public Libro(String titulo, String autor, String genero, String codigo) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.codigo = codigo;
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
	public void crear() {
	}
	public void eliminar() {
		
	}
	public void consultar() {
		
	}
	public void devolver() {
		
	}
	public void prestar() {
		
	}
	public void buscar() {
		
	}
	
}
