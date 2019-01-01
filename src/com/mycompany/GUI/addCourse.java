/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.CoursServices.CoursServices;
import com.mycompany.Entities.Cours;
import com.mycompany.myapp.MyApplication;
import java.util.Date;

/**
 *
 * @author Firas
 */
public class addCourse extends Form{
    
    private Label l1,l2,l3,l4,l5,l6,l7;
    private TextField lib,type,salle,coach,place;
    private Picker date;
    private Container mainContainer;
    private Button addBtn,backBtn;
    
    
    
    
    public addCourse(){
        
        this.setLayout(new BorderLayout());
        mainContainer = new Container();
        mainContainer.setLayout(new GridLayout(8,2));
        l1 = new Label("Ajouter Un Cours");
        l1.setAlignment(CENTER);
        //l1.getUnselectedStyle().setAlignment(Component.CENTER);
        l1.getUnselectedStyle().setFgColor(-16777216);
        Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        l1.getUnselectedStyle().setFont(l1_font);
        
        l2 = new Label("Libelle:");
        lib = new TextField("");
        
        l3 = new Label("Type:");
        type = new TextField("");
        
        l4 = new Label("Salle:");
        salle = new TextField("");
        
        l5 = new Label("Nom du coach:");
        coach = new TextField("");
        
        l6 = new Label("Date:");
        date = new Picker();
        
        l7 = new Label("Nombre de place:");
        place = new TextField("");
        
        
        addBtn= new Button("Ajouter");
        backBtn= new Button("Retour");
        addBtn.getUnselectedStyle().setFgColor(5542241);
        backBtn.getUnselectedStyle().setFgColor(5542241);
        
        mainContainer.add(l1);
        mainContainer.add(new Label());

        mainContainer.add(l2);
        mainContainer.add(l3);
        mainContainer.add(lib);
        mainContainer.add(type);
        mainContainer.add(l4);
        mainContainer.add(l5);
        mainContainer.add(salle);
        mainContainer.add(coach);
        
        mainContainer.add(l6);
        mainContainer.add(l7);
        mainContainer.add(date);
        mainContainer.add(place);
        
        mainContainer.add(addBtn);
        mainContainer.add(backBtn);
        
        addBtn.addActionListener((ActionListener) (ActionEvent evt) -> {
            Date d=date.getDate();
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
            String date = DATE_FORMAT.format(d);
            
            Cours c = new Cours(lib.getText(),type.getText(),Integer.parseInt(salle.getText()),coach.getText(),date,Integer.parseInt(place.getText()));
            new  CoursServices().ajoutCours(c);
            
            lib.setText("");
            type.setText("");
            salle.setText("");
            coach.setText("");
            
            place.setText("");
            
            });
        
        this.add(BorderLayout.NORTH, mainContainer);
        
            backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MyApplication c = new MyApplication();
                c.start();
            }
        });
            
        
        
    }
    
}
