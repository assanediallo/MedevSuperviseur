package Environnement;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import hugo.Interface;

public class Chambre{
	public int numero;
	public Patient occupant;
	public static List<Chambre> CHAMBRES = new ArrayList<>();

	
	public Chambre (int numero){
		String nss;
		String medoc;
		try {
			JSONParser parser = new JSONParser();
			JSONObject json;
			
			try {
				json = (JSONObject) parser.parse(Interface.recoit("getRoom/"+numero));
				System.out.println("test1");
				System.out.println(json.toString());
				System.out.println("test2");
				
				
				
				//this.nom=(String) ((JSONObject)((List)json.get("list")).get(0)).get("name");
				if (((JSONObject)(json.get("rooms"))).get("patientID")!=null)
					{
						nss= ((JSONObject)(json.get("rooms"))).get("patientID").toString();
					}
				else {nss= null;}
				if (((JSONObject)(json.get("rooms"))).get("medicine")!=null)
					{
						medoc= ((JSONObject)(json.get("rooms"))).get("medicine").toString();
						System.out.println(medoc);
					}
				else {medoc=null;}
				
						
				if (medoc==null&&nss==null)
				{
					occupant = new Patient (Medicament.getList().get(Integer.parseInt(medoc)));
				}
				else if (medoc == null)
				{
					occupant = new Patient (Integer.parseInt(nss));
				}
				else {
					occupant = new Patient (Integer.parseInt(nss),Medicament.getList().get(Integer.parseInt(medoc)));
				}
				
				
				Chambre.CHAMBRES.add(this);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Patient getOccupant ()
	{
		return this.occupant;
	}
}
