package xml.clasessax;

import java.awt.Font;

public class Libro {
	   private String isbn;  
	   private String titulo;  
	   private String autor;  
	   private String anyo;  
	   private String editorial;  
	     
	   // Constructor por defecto  
	   public Libro() {  
	        
	   }  
	     
	   public String getIsbn() {  
	      return isbn;  
	   }  
	     
	   public void setIsbn(String isbn) {  
	      this.isbn = isbn;  
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
	     
	   public String getAnyo() {  
	      return anyo;  
	   }  
	     
	   public void setAnyo(String anyo) {  
	      this.anyo = anyo;  
	   }  
	     
	   public String getEditorial() {  
	      return editorial;  
	   }  
	     
	   public void setEditorial(String editorial) {  
	      this.editorial = editorial;  
	   }  
	  
	   @Override  
	   public String toString() { 
	      StringBuilder sb = new StringBuilder(); //tipo de String m�s r�pido en a�adir! 
	      sb.append("\n + ISBN: " +isbn);  
	      sb.append("\n  - T�tulo: " +titulo);  
	      sb.append("\n  - Autor: " +autor);  
	      sb.append("\n  - A�o: " +anyo);  
	      sb.append("\n  - Editorial: " +editorial); 
	      sb.append("\n*********************************************");
	      sb.append("\n*********************************************");
	      
	      //System.out.println(sb);
	      
	      return sb.toString();  
	   }  
	     
	     
	  
	}  
