/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.SOUTH;
import static com.codename1.ui.CN.getCurrentForm;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
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
public class Aff extends Form{
    private Label l1,l2,l3,l4,l5,l6,l7,l0;
    private TextField idtf,libtf,typetf,salletf,coachtf,placetf;
    private Picker datetf;
    private Container mainContainer;
    private Button editBtn,removeBtn;
    private Cours currentCours;
    
    public Aff(String idk,String lib,String type,String salle,String coach_name,String date,String nb_place){
        
        this.setLayout(new BorderLayout());
        mainContainer = new Container();
        mainContainer.setLayout(new GridLayout(8,2));
        
        l1 = new Label("Cours");
        l1.getUnselectedStyle().setFgColor(-00000000);
        Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        l1.getUnselectedStyle().setFont(l1_font);
        
        l0 = new Label("id:");
        idtf = new TextField(idk);  
        idtf.setVisible(false);
        idtf.setEditable(false);
        
        
        l2 = new Label("Lib:");
        libtf = new TextField(lib);
        
        l3 = new Label("Type:");
        typetf = new TextField(type);
        
        l4 = new Label("Salle:");
        salletf = new TextField(salle);
        
        l5 = new Label("Nom du coach:");
        coachtf = new TextField(coach_name);
        
        l6 = new Label("Date:");
        datetf = new Picker();
        datetf.setText(date);
        
        l7 = new Label("Nombre de places:");
        placetf = new TextField(nb_place);
        
        editBtn= new Button("Modifier");
        editBtn.setUIID("InputAvatarImage");
        removeBtn= new Button("Suprrimer");
        removeBtn.setUIID("InputAvatarImage");


        
        
        mainContainer.add(l1);
        mainContainer.add(new Label());
        
        mainContainer.add(l0);
        mainContainer.add(idtf);
        l0.setVisible(false);
        

        mainContainer.add(l2);
        mainContainer.add(l3);
        mainContainer.add(libtf);
        mainContainer.add(typetf);
        mainContainer.add(l4);
        mainContainer.add(l5);
        mainContainer.add(salletf);
        mainContainer.add(coachtf);
        
        mainContainer.add(l6);
        mainContainer.add(l7);
        mainContainer.add(datetf);
        mainContainer.add(placetf);
        

        mainContainer.add(editBtn);
        mainContainer.add(removeBtn);
        
        
        
        
        removeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new CoursServices().removeCourse(currentCours,Integer.parseInt(idtf.getText()));
                if(Dialog.show("Supression", "ùvoulez-vous supprimer ce cours", "Yes", "No")){
                     MyApplication c = new MyApplication();
                c.start();
                }
            }
        });
        
        editBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                
            Date d=datetf.getDate();
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
            String date = DATE_FORMAT.format(d);
                new CoursServices().updateCourse(Integer.parseInt(idtf.getText()),libtf.getText(),typetf.getText(),Integer.parseInt(salletf.getText()),coachtf.getText(),date,Integer.parseInt(placetf.getText()));
            }
        });
                            Form previous = getCurrentForm();
                            this.getToolbar().setBackCommand(" ", ee -> {
                                    previous.showBack();
                            });
        
        
        
        
        this.add(BorderLayout.NORTH, mainContainer);
    }
    
}
