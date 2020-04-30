package Entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Dao.*;
import Util.Conexion;

public class Prueba {
	
	public static void main(String[] args) {
		
		Usuario u= new Usuario();
		
		u.setUsuario("Javier31");
		u.setClave("123456");
		Mensaje m = new Mensaje();
		m.setNombre("camilo");
		m.setMensaje("segundo mensaje");
		m.setEmail("@prueba");
		m.setWebsite(".com");
	    m.setUsuario(u);
		
		MensajeDao mD = new MensajeDao();
		mD.registrar(m);
		
				 }
		
	
	}
	
	


