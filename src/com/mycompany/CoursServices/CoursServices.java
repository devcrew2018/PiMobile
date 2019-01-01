/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CoursServices;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.mycompany.Entities.Cours;
import com.mycompany.Entities.Reservation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Firas
 */
public class CoursServices {
    
    
    public ArrayList<Cours> getListCours(String json) {
        ArrayList<Cours> listCours = new ArrayList<>();

        try {
           // System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> cours = j.parseJSON(new CharArrayReader(json.toCharArray()));
          //  System.out.println(cabinets);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) cours.get("root");

            for (Map<String, Object> obj : list) {
                Cours e = new Cours();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                
                
                //System.out.println(id);
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setLib(obj.get("lib").toString());
                e.setType(obj.get("type").toString());
                float salle = Float.parseFloat(obj.get("salle").toString());
                //System.out.println(salle);
                e.setSalle((int) salle);
                //e.setSalle(Integer.parseInt(obj.get("salle").toString().trim()));
                e.setCoachName(obj.get("coachName").toString());
                e.setDate(obj.get("date").toString());
                float place = Float.parseFloat(obj.get("nbPlace").toString());
                e.setNbPlace((int) place);
                //e.setNbPlace(Integer.parseInt(obj.get("nbPlace").toString().trim()));

                //System.out.println(e);
                listCours.add(e);
                

            }

        } catch (IOException ex) {
        }
        //System.out.println(listEtudiants);
        return listCours;

    }
    
    
    ArrayList<Cours> listCours = new ArrayList<>();
    
    public ArrayList<Cours> getListCours2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIVersionuneFiras/web/app_dev.php/show_mobile");  
        con.setPost(true);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                CoursServices ser = new CoursServices();
                listCours = ser.getListCours(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCours;
    }
    
    public void ajoutCours(Cours c) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PIVersionuneFiras/web/app_dev.php/cours/add/" + c.getLib() + "/" + c.getType()+ "/" + c.getSalle()+ "/" + c.getCoachName()+ "/" + c.getDate()+ "/" + c.getNbPlace();
        con.setUrl(Url);
        con.setPost(true);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    public void removeCourse(Cours b,int id){   
        ConnectionRequest connectionRequest= new ConnectionRequest() {
        @Override
        protected void postResponse() {
            Dialog d = new Dialog("Supression de cours");
            TextArea popupBody = new TextArea("Cours supprimé");
            popupBody.setUIID("PopupBody");
            popupBody.setEditable(false);
            d.setLayout(new BorderLayout());
            d.add(BorderLayout.CENTER, popupBody);
            
            }           
        };
        connectionRequest.setUrl("http://localhost/PIVersionuneFiras/web/app_dev.php/cours/delete/" + id);
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }
    
    public void updateCourse(int id,String lib,String type,int salle,String coach,String date,int place){
        ConnectionRequest connectionRequest = new ConnectionRequest() {
            
            @Override
            protected void postResponse() { 
                Dialog d = new Dialog("Popup Title");
                TextArea popupBody = new TextArea("Cours updated");
                popupBody.setUIID("PopupBody");
                popupBody.setEditable(false);
                d.setLayout(new BorderLayout());
                d.add(BorderLayout.CENTER, popupBody);
                
            }
        };
        connectionRequest.setUrl("http://localhost/PIVersionuneFiras/web/app_dev.php/cours/update/" +id+ "/" +lib + "/" + type + "/" + salle + "/" + coach + "/" + date + "/" + place);
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }
    
    public void ajoutReservation(Reservation r,int id) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PIVersionuneFiras/web/app_dev.php/reservation/add/" + id+ "/"+r.getLib()+ "/" + r.getUsername()+ "/" + r.getEmail();
        con.setUrl(Url);
        con.setPost(true);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    
    public ArrayList<Reservation> getListReserv(String json) {
        ArrayList<Reservation> listRerva = new ArrayList<>();

        try {
           // System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> reservations = j.parseJSON(new CharArrayReader(json.toCharArray()));

           
            List<Map<String, Object>> list = (List<Map<String, Object>>) reservations.get("root");

            for (Map<String, Object> obj : list) {
                Reservation e = new Reservation();

                float id = Float.parseFloat(obj.get("id").toString());
                
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setLib(obj.get("lib").toString());
                e.setUsername(obj.get("username").toString());
                //e.setSalle(Integer.parseInt(obj.get("salle").toString().trim()));
                e.setEmail(obj.get("email").toString());
                listRerva.add(e);
                
            }

        } catch (IOException ex) {
        }
        //System.out.println(listEtudiants);
        return listRerva;

    }
    
    
    ArrayList<Reservation> listRes = new ArrayList<>();
    
    public ArrayList<Reservation> getListReserva2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIVersionuneFiras/web/app_dev.php/show_mobile_Reserv");  
        con.setPost(true);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                CoursServices ser = new CoursServices();
                listRes = ser.getListReserv(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listRes;
    }
    
    

    
    
}
