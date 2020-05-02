package model;

import java.util.Scanner;

public class Libro {
	Scanner sc=new Scanner(System.in);
	
	private String titulo;
	private String autor;
	private String resumen;
	private String genero;
	private String codigo;
	private boolean prestado;
	
	public Libro(String titulo, String autor, String genero, String codigo, boolean prestado) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.codigo = codigo;
		this.prestado = prestado;
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

}
