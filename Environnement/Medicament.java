package Environnement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import hugo.Interface;
	/**
	 * Classe médicament, finalement non usitée.
	 * @author hugo
	 * Rang correspond à un identifiant dans la base de données.
	 */
public class Medicament {
	public String nom;
	public int rang;
	public static List<Medicament> MEDICAMENTS = new ArrayList<>();




	/**
	 * Récupère un médicament dans la base de donnée.
	 * @param rang : indice du médicament dans la base de donnée
	 */
	public Medicament (int rang){
        this.rang = rang;
        
        try {
			JSONParser parser = new JSONParser();
			JSONObject json;
			try {
				
				json = (JSONObject) parser.parse(Interface.recoit("getMedicine/"+rang));
				// nom reçoit une string d'où le transtypage premier. Notre fonction originelle return un format de type {"list":[{"medicine":1,"name":"Doliprane"}]}
				// Par consequent on penetre la liste à sa première (et unique) adresse pour réouvrir un json et enfin mettre la clef demandée
				if (((JSONObject)((List)json.get("list")).get(0))!=null)
					{
					if (((JSONObject)((List)json.get("list")).get(0)).get("name")!=null)
						{
						this.nom=(String) ((JSONObject)((List)json.get("list")).get(0)).get("name");
						Medicament.MEDICAMENTS.add(this);
						}
					}
					
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	
	
	public static List<Medicament> getList(){
		return Medicament.MEDICAMENTS;
				
	}
	
	
	
	public String getNom() {
		return this.nom;
	}
	public String getId() {
		return this.nom;
	}

	public int mortalité () {
		return 0;
	}
}
