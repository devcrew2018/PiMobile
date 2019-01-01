/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * in the LICENSE file that accompanied this code.
 *  
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * 
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Please contact Codename One through http://www.codenameone.com/ if you 
 * need additional information or have any questions.
 */
package com.mycompany.GUI;



import com.codename1.capture.Capture;
import com.codename1.components.MultiButton;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.SOUTH;
import static com.codename1.ui.CN.isTablet;
import static com.codename1.ui.CN.openGallery;
import static com.codename1.ui.CN1Constants.GALLERY_IMAGE;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.validation.Validator;
import com.mycompany.CoursServices.CoursServices;
import com.mycompany.Entities.Cours;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Random;

import com.mycompany.GUI.indexCours;



/**
 * Demonstrates basic usage of input facilities, device orientation behavior as
 * well as adapting the UI to tablets. This demo shows off a typical form with
 * user information, different keyboard types, ability to capture an avatar
 * image and style it etc.
 *
 * @author Shai Almog
 */
public class Input1 extends Demo {
    String devisnamee;
    Date k;
    public void setK(Date k)
    {
    this.k=k;
    }

    public String getDisplayName() {
        return "Cours";
    }

    public Image getDemoIcon() {
        return getResources().getImage("box.png");
    }
    
    private String createListEntry(String name) {
            
            return name;
        }

    @Override
    public String getDescription() {
        return "Demonstrates basic usage of input facilities, device orientation behavior as well as adapting the UI to tablets."
                + "This demo shows off a typical form with user information, different keyboard types, ability to capture an "
                + "avatar image and style it etc.";
    }

    @Override
    public String getSourceCodeURL() {
        return "https://github.com/codenameone/KitchenSink/blob/master/src/com/codename1/demos/kitchen/Input.java";
    }

    @Override
    public Container createDemo(Form parent) {
        TextComponent lib = new TextComponent().labelAndHint("Libelle");
        FontImage.setMaterialIcon(lib.getField().getHintLabel(), FontImage.MATERIAL_NOTE_ADD);

        
        TextComponent salle = new TextComponent().labelAndHint("Salle");
        FontImage.setMaterialIcon(salle.getField().getHintLabel(), FontImage.MATERIAL_HOME);
        
        TextComponent coach = new TextComponent().labelAndHint("Nom du coach");
        FontImage.setMaterialIcon(coach.getField().getHintLabel(), FontImage.MATERIAL_PERSON);
        
        
        ComboBox combo1 = new ComboBox<> (
          createListEntry("Musculation"),
          createListEntry("Fitness"),
          createListEntry("Boxe"),
          createListEntry("Lutte Libre"),
          createListEntry("Natation"),
          createListEntry("Aerobic sportive")
          );
  
        combo1.setRenderer(new GenericListCellRenderer<>(new MultiButton(""), new MultiButton("")));

        
        Picker date=new Picker();
        
        TextComponent nbPlace = new TextComponent().labelAndHint("Nombre de place").constraint(TextArea.EMAILADDR);
        FontImage.setMaterialIcon(nbPlace.getField().getHintLabel(), FontImage.MATERIAL_INFO);
     
        Validator val = new Validator();
        Validator val2 = new Validator();






        TextModeLayout tl = new TextModeLayout(6, 1);
        Container comps = new Container(tl);
        comps.add(tl.createConstraint().horizontalSpan(1), lib);
        //comps.add(tl.createConstraint().horizontalSpan(2), type);
        comps.add(combo1);
        comps.add(tl.createConstraint().horizontalSpan(1), salle);
        comps.add(tl.createConstraint().horizontalSpan(1), coach);
        comps.add(tl.createConstraint().horizontalSpan(1), date);
        comps.add(tl.createConstraint().horizontalSpan(1), nbPlace);
      
        

        comps.setScrollableY(true);
        comps.setUIID("PaddedContainer");

        Container content = BorderLayout.center(comps);


        Button save = new Button("Ajouter");
        save.setUIID("InputAvatarImage");
        content.add(SOUTH, save);
        
        
       
        
        save.addActionListener(e -> {
            CoursServices ser = new CoursServices();
            Date d=date.getDate();
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
            String datetf = DATE_FORMAT.format(d);
            Cours c = new Cours(lib.getField().getText(), combo1.getSelectedItem().toString(), Integer.parseInt(salle.getField().getText()), coach.getField().getText(), datetf, Integer.parseInt(nbPlace.getField().getText()));
            ser.ajoutCours(c);
        });

        content.setUIID("InputContainerForeground");
        
        

        Button avatar = new Button("");
        avatar.setUIID("InputAvatar");
        Image defaultAvatar = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, "InputAvatarImage", 8);
        Image circleMaskImage = getResources().getImage("circle.png");
        //defaultAvatar = defaultAvatar.scaled(circleMaskImage.getWidth(), circleMaskImage.getHeight());
        defaultAvatar = ((FontImage) defaultAvatar).toEncodedImage();
        //Object circleMask = circleMaskImage.createMask();
        //defaultAvatar = defaultAvatar.applyMask(circleMask);
        avatar.setIcon(defaultAvatar);
        
       
        
        
        
        
        
//        avatar.addActionListener(e -> {
//            if (Dialog.show("Camera or Gallery", "Would you like to use the camera or the gallery for the picture?", "Camera", "Gallery")) {
//                String pic = Capture.capturePhoto();
//                System.out.println(pic);
//                if (pic != null) {
//                    System.out.println(pic);
//
//                    try {
//                        //C:/wamp64/wamp/PIDEV-sant-et-bien-tre/web/devis/temp8406763231869110404..png
//                        //C:/wamp64/wamp/PIDEV-sant-et-bien-tre/web/devis/
////                        String test = FileSystemStorage.getInstance().getAppHomePath().substring(12)+System.currentTimeMillis()+".jpg";
////                        System.out.println(FileSystemStorage.getInstance().getAppHomePath().substring(11));
////                        System.out.println("home".substring(2));
//                        Image img = Image.createImage(pic).fill(circleMaskImage.getWidth(), circleMaskImage.getHeight());
//                        avatar.setIcon(img.applyMask(circleMask));
//                         Random randomGenerator = new Random();
//                        
//                        int randomInt = randomGenerator.nextInt(19999999);
//                         devisnamee = String.valueOf(randomInt);
//                        System.out.println(devisnamee);
//                        
//                        InputStream stream = FileSystemStorage.getInstance().openInputStream(pic);
//                        OutputStream out = Storage.getInstance().createOutputStream(devisnamee);
//                        Util.copy(stream, out);
//                        Util.cleanup(stream);
//                        Util.cleanup(out);
//
////                String pathToBeStored = test ;
////                Image img5 = Image.createImage(pic);
////                OutputStream os = FileSystemStorage.getInstance().openOutputStream(pathToBeStored );
////                ImageIO.getImageIO().save(img5, os, ImageIO.FORMAT_JPEG, 0.9f);
////                os.close();
////                InputStream stream = FileSystemStorage.getInstance().openInputStream(pic);
////OutputStream out = Storage.getInstance().createOutputStream("C:/wamp64/wamp/PIDEV-sant-et-bien-tre/web/devis/MyImage");
////Util.copy(stream, out);
////Util.cleanup(stream);
////Util.cleanup(out);
//                        System.out.println("done");
//
//                    } catch (IOException err) {
//                        ToastBar.showErrorMessage("An error occured while loading the image: " + err);
//                        Log.e(err);
//                    }
//                }else{devisnamee=null;}
//            } else {
//                openGallery(ee -> {
//                    if (ee.getSource() != null) {
//                        try {
//                            Image img = Image.createImage((String) ee.getSource()).fill(circleMaskImage.getWidth(), circleMaskImage.getHeight());
//                            avatar.setIcon(img.applyMask(circleMask));
//
//                        } catch (IOException err) {
//                            ToastBar.showErrorMessage("An error occured while loading the image: " + err);
//                            Log.e(err);
//                        }
//                    }
//                }, GALLERY_IMAGE);
//            }
//        });

        Container actualContent = LayeredLayout.encloseIn(content,
                FlowLayout.encloseCenter(avatar));

        Container input;
        if (!isTablet()) {
            Label placeholder = new Label(" ");

            Component.setSameHeight(actualContent, placeholder);
            Component.setSameWidth(actualContent, placeholder);

            input = BorderLayout.center(placeholder);

            parent.addShowListener(e -> {
                if (placeholder.getParent() != null) {
                    input.replace(placeholder, actualContent, CommonTransitions.createFade(1500));
                }
            });
        } else {
            input = BorderLayout.center(actualContent);
        }
        input.setUIID("InputContainerBackground");

        return input;
    }

}
