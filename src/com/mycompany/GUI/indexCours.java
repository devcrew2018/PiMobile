/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.Accordion;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.getCurrentForm;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.CoursServices.CoursServices;
import com.mycompany.Entities.Cours;
import java.util.ArrayList;

/**
 *
 * @author Firas
 */
public class indexCours {
    private Form f;

    public indexCours() {
       
      f=new Form(new BorderLayout());
      Accordion acc=new Accordion();
      
        CoursServices ss=new CoursServices();
      ArrayList<Cours> listcours = ss.getListCours2();
       
     
      for(Cours s : listcours) {
        SpanLabel sl=new SpanLabel();
          sl.setText("Libelle : "+s.getLib()+"\n Type :"+s.getType()+"\n Salle :"+s.getSalle()+"\n Nom du coach :"+s.getCoachName()+"\n Date :"+s.getDate()+"\n Nombre de place :"+s.getNbPlace());
          Button b = new Button("Réserver");
          b.setUIID("InputAvatarImage");
          b.setUIID(String.valueOf(s.getId()));
          //acc.add(); 
          
          createStarRankSlider().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CoursServices ser=new CoursServices();
                for(Cours c:ser.getListCours2()){
                    if(c.getId()==Integer.parseInt(b.getUIID())){
                        c.setRating(createStarRankSlider().getText());
                    }
                    
                }
            }
        });
          
            
            

            
          b.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              
                          AddReservation c=new AddReservation(s.getLib(),String.valueOf(s.getId()));
                          c.show();
                      
 
   
          }
      });
           
         acc.addContent(s.getLib(), BoxLayout.encloseY(sl,b,FlowLayout.encloseCenter(createStarRankSlider())));
        
          
      }
f.add(BorderLayout.CENTER, acc);

            Form previous = getCurrentForm();
                            f.getToolbar().setBackCommand(" ", ee -> {
                                    previous.showBack();
                            });
    
      
      
  }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}

private Slider createStarRankSlider() {
    Slider starRank = new Slider();
    starRank.setEditable(true);
    starRank.setMinValue(0);
    starRank.setMaxValue(10);
    Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
            derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
    Style s = new Style(0xffff33, 0, fnt, (byte)0);
    Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    s.setOpacity(100);
    s.setFgColor(0);
    Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
    initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
    starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
    System.out.println(starRank);
    
    return starRank;
}
    
    
}

    
    
    
    

