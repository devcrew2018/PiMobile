/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.getCurrentForm;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.CoursServices.CoursServices;
import com.mycompany.Entities.Cours;
import com.mycompany.Entities.Reservation;
import com.mycompany.myapp.MyApplication;
import java.util.Date;

/**
 *
 * @author Firas
 */
public class AddReservation extends Form{
    private final Label l1,l2,l5;
    private final TextField idcours,libtf;
    private final Container mainContainer;
    private final Button addBtn;

    public AddReservation(String f,String idc) {
        this.setLayout(new BorderLayout(CENTER));
        mainContainer = new Container();
        mainContainer.setLayout(new GridLayout(8,1));
        l1 = new Label("Réserver");
        l1.setAlignment(CENTER);
        //l1.getUnselectedStyle().setAlignment(Component.CENTER);
        l1.getUnselectedStyle().setFgColor(-16777216);
        Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        l1.getUnselectedStyle().setFont(l1_font);
        
        
        
        idcours = new TextField(idc);
        idcours.setEditable(false);
        idcours.setVisible(false);
        
        
        l5 = new Label("Idcours:");
        l5.setVisible(false);
        
        l2 = new Label("Libelle:");
        l2.setVisible(false);
        libtf = new TextField(f);
        libtf.setVisible(false);
        libtf.setEditable(false);
        
        
        
        TextComponent username = new TextComponent().labelAndHint("Username");
        FontImage.setMaterialIcon(username.getField().getHintLabel(), FontImage.MATERIAL_PERSON);
        username.getField().setText("aminekhemiri");
        username.getField().setEditable(false);
        
        
        TextComponent email = new TextComponent().labelAndHint("Email");
        FontImage.setMaterialIcon(email.getField().getHintLabel(), FontImage.MATERIAL_EMAIL);
        email.getField().setText("aminekhemiri@esprit.tn");
        email.getField().setEditable(false);
        
        Form previous = getCurrentForm();
                            this.getToolbar().setBackCommand(" ", ee -> {
                                    previous.showBack();
                            });
        
        addBtn= new Button("Confirmer");
        addBtn.setUIID("InputAvatarImage");
        
        
        
        mainContainer.add(username);
        //mainContainer.add(l4);
        mainContainer.add(email);

        mainContainer.add(new Label());
        
        
        mainContainer.add(l5);
        mainContainer.add(idcours);
        
        mainContainer.add(l2);
        mainContainer.add(libtf);
        //mainContainer.add(l3);
        

        
        mainContainer.add(addBtn);
        
        
        addBtn.addActionListener((ActionListener) (ActionEvent evt) -> {
            
            
            Reservation r=new Reservation(libtf.getText(),username.getField().getText(), email.getField().getText());
            
            new  CoursServices().ajoutReservation(r,Integer.parseInt(idcours.getText()));
            
            });
        
        this.add(BorderLayout.NORTH, mainContainer);
        
            
    }

    
    
    
}
