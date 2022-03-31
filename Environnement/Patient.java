package Environnement;


import java.util.ArrayList;
/**
 * Classe patient.
 * Finalement non usitée
 */
import java.util.List;

public class Patient {
	public int nss;
	public int id;
	//public Medicament soin;
	public String soin
	public int week;
	public String Condition;
	
/**
 * Stocke tous les objets patients créés
 */
	public static List<Patient> PATIENTS = new ArrayList<>();
	
	
	/**
	 * Différents créateurs de patients
	 * @param nss
	 * @param nomdemedoc
	 */
	public Patient (int id,int nss, String nomdemedoc,int semaine, String condition) {
		this.nss=nss;
		this.soin=nomdemedoc;
		this.Condition=condition;
		this.id= id;
		this.week=semaine;
		Patient.PATIENTS.add(this);
		
		
				
		}
	public Patient (Medicament nomdemedoc) {
		this.soin=nomdemedoc;
		}
	public Patient (int nss) {
		this.nss=nss;
		}
	}	

