/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author Amine
 */
public class CurrentUser {
     public static int id;
 //    private users cu;
     
     
    public static int getId() {
        return id;
    }

//    public static users getCu() {
//        ConnectionRequest connection = new ConnectionRequest();
//        connection.setUrl("http://localhost/piversionune/web/app_dev.php/Juse/"+id+"");
//        connection.addResponseListener(e->{
//        System.out.println(new String(connection.getResponseData()));
//            JSONParser json = new JSONParser();
//            String jsonresponse = new String(connection.getResponseData());
//            
//                    ArrayList<users> listusers = new ArrayList<>();
//
//            try {
//                Map <String, Object> user_info= json.parseJSON(new CharArrayReader(jsonresponse.toCharArray()));
//                List<Map<String, Object>> list = (List<Map<String, Object>>)user_info.get("root");
//             
//                 for (Map<String, Object> obj : list) {
//                  users u= new users();
//                 float id = Float.parseFloat(obj.get("id").toString());
//                System.out.println(id);
//                e.setId((int) id);
//                e.setEtat(obj.get("state").toString());
//                e.setNom(obj.get("name").toString());
//                System.out.println(e);
//                listTasks.add(e);
//            }
//
//        } catch (IOException ex) {
//        }
//                
////                for ( Map<String, Object> obj : list) {
////                        users user = new users()
////                        user.setNom(obj.get("fullname").toString());
////                        user.setMail(obj.get("email").toString());
////                        user.setNumero(Integer.parseInt(obj.get("phone").toString()));
////                        user.setMdp(obj.get("password").toString());
////                        user.setSexe(obj.get("sexe").toString());   
////            }
////              
////            } catch (IOException ex) {
////                System.out.println("lenna");
////            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(connection);
//        return user;
//    }

     
    public  void setId(int id) {
        CurrentUser.id = id;
    }

}
