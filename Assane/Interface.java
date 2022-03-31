package Assane;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Environnement.Chambre;



public class Interface {	
	static public void main(String[] argv) throws ParseException
	    {
			Parametres.init();
			serveurOk();
			
			
			/*creerMedicaments("Curare");
			Medicament onretest=new Medicament(1);
			System.out.println("c'estla bonne");
			System.out.println(onretest.nom);
			System.out.println(onretest.LIST);*/
			apparaitreChambres();
			
			
			
	    }
	
	
	
	
	
	
	
	public static Boolean serveurOk() 
	{
		Parametres.url ="http://10.3.2.121:8000/";///Accueil_TextField_IP.getText();
		String str =Parametres.url+ "getMedicine"	;
		System.out.println(str);
		
		int responseCode=0;
		try {
			URL obj = new URL (str);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
			con.setRequestMethod("POST");
		
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			responseCode = con.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (responseCode == 200) { // success
			return true;
		} else {
			return false;
		}
		
		
	}
	
	//Connect("");
	public static String recoit(String urlend) throws IOException {
		String str =Parametres.url+ urlend	;
		System.out.println(str);
		URL obj = new URL (str);
				
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		} else {
			System.out.println("ici");
			return null;
		}
	}
	public static String envoi(String urlend) throws IOException {
		String str =Parametres.url+ urlend	;
		System.out.println(str);
		URL obj = new URL (str);
				
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		} else {
			return null;
		}
	}
	/*															
	 * 															*
	 * 								Get							*
	 * 															*	
	*/	
	public static int nombreMedicaments() throws ParseException {
		int k=-1;
		JSONParser parser = new JSONParser();
		JSONObject json=null;
		try {
			json = (JSONObject) parser.parse(Interface.recoit("getMedicinesAmount/"));
			System.out.println(Math.toIntExact((long) json.get("amount")));
			k= (Math.toIntExact((long) json.get("amount")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}
	
	/*															
	 * 															*
	 * 								Make						*
	 * 															*	
	*/	
	public static void creerMedicaments(String nom) throws ParseException {
		int value=nombreMedicaments()+1;//Nombre de medocs en place demandes un URI
		
		try {
			Interface.envoi("addMedicine/"+value+","+nom);
			Interface.envoi("addMedicine/"+(value+1)+","+nom+"_placebo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//réinitialiser l'acquisition
	}
	
	/*															
	 * 															*
	 * 						Apparition							*
	 * 															*	
	*/	
	public static void apparaitreChambres() {
		for (int i=1;i<5;i++) {
			System.out.println(i);
			Chambre chambre=new Chambre (i);
			
		}
	}
	
	public static void apparaitreMedicaments() {
		JSONParser parser = new JSONParser();
		JSONObject json;
		int max=0;
		try {
			json = (JSONObject) parser.parse(Interface.recoit("getMedicinesAmount/"));
			String nb= (String) json.get("amount");
			max = Integer.parseInt(nb);
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i=1;i<max;i++) {
			new Chambre (i);
		}
			
			
	}
}
