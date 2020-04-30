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
			 em.close();
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
	 
	 public void buscar (Integer m1) {
		 try {
			 em.getTransaction().begin();
			 Mensaje m = em.find(Mensaje.class, m1);
			 em.getTransaction().commit();
			 System.out.println(m.getId());	
			  
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			 em.close();
			 }
		
		 
		 
	 }
}
