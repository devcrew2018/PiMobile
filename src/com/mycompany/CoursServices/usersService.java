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
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entities.CurrentUser;
import com.mycompany.Entities.users;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import java.util.List;



/**
 *
 * @author Amine
 */
public class usersService {

    
   // ************************************UPDATE  PROFIL******************************************************************
    public boolean edit_user(users u) {
        ConnectionRequest connection = new ConnectionRequest();
        connection.setUrl("http://localhost/piversionune/web/app_dev.php/Jupd/"+CurrentUser.getId()+"?fullname="+u.getNom()+"&email="+u.getMail()+"&phone="+u.getNumero()+"&password="+u.getMdp()+"&sexe="+u.getSexe()+"&photo=profil.jpg");
        connection.addResponseListener(a->{
            Dialog.show(null, new String(connection.getResponseData()), "Ok", null);
        });
        NetworkManager.getInstance().addToQueueAndWait(connection);
        return true;
    }
    

     public ArrayList<users> getUser(String json) {

        ArrayList<users> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");           
           
           // System.out.println(list);
            for (Map<String, Object> obj : list) {
                
                          users user = new users();
                         float bbbb=Float.parseFloat(obj.get("id").toString());
                        user.setId((int)bbbb);
                        user.setNom(obj.get("fullname").toString());
                        user.setMail(obj.get("email").toString());
                        float f = Float.parseFloat(obj.get("phone").toString());
                        user.setNumero((int) f);
                         user.setMdp(obj.get("password").toString());
                        user.setSexe(obj.get("sexe").toString());   
                         user.setRole(obj.get("role").toString());   
                       // System.out.println(user);
                        listTasks.add(user);
            }

        } catch (IOException ex) {
        }
        return listTasks;

    }
     
     
     ArrayList<users> listuserss = new ArrayList<>();
    
    public ArrayList<users> getListuser(){       
        ConnectionRequest con = new ConnectionRequest();
            con.setUrl("http://localhost/PIVersionuneFiras/web/app_dev.php/Juserr");  
                con.setPost(false);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                usersService ser = new usersService();
                listuserss = ser.getUser(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
     //   System.out.println(listuserss);
        return listuserss;
    }
   
       // ************************************  L O G I N  ******************************************************************
   

    
    
}
