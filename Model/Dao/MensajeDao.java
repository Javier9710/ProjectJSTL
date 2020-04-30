package Dao;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.Mensaje;
import Util.Conexion;



public class MensajeDao {
	
	EntityManager em = null;

	public MensajeDao() {
		em = Conexion.getEm();
	}
	
	public List<Mensaje> listar(){
		return (List<Mensaje>) em.createQuery("select x from Mensaje x").getResultList();	
		
	}
	
	public void registrar (Mensaje mensaje) {
		 try {
			 em.getTransaction().begin();
			 em.persist(mensaje);
			 em.getTransaction().commit();
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			// em.close();
			 }
		
		 
		 
	 }
	 
	 public void actualizar (Mensaje mensaje) {
		 try {
			 em.getTransaction().begin();
			 em.merge(mensaje);
			 em.getTransaction().commit();
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			 //em.close();
			 }
		
		 
		 
	 }
	 
	 public void eliminar (int id){
		 try {

			 Mensaje m = em.find(Mensaje.class, id);
			 em.getTransaction().begin();
			 em.remove(m);
			 em.getTransaction().commit();
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			// em.close();
			 }
		
		 
		 
	 }
	 
	 public Mensaje buscar (Integer m1) {
		 Mensaje m=null;
		 try {
			 em.getTransaction().begin();
			 m = em.find(Mensaje.class, m1);
			 em.getTransaction().commit();
			 return m;
			  
			 } catch (Exception e) {
			 e.printStackTrace();
			 return m;
			 }finally {
			 //em.close();
			 }
		
		 
		 
	 }
}
