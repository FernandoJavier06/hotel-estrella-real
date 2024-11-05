/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.cunori.hotel.estrella.real;

import com.cunori.views.Gui;
import com.cunori.views.GuiLogin;
import com.cunori.views.PanelPerfil;

/**
 *
 * @author ferna
 */
public class HotelEstrellaReal {

    public static void main(String[] args) {
        GuiLogin guiLogin = new GuiLogin();
        Gui gui = new Gui();
        guiLogin.setGui(gui);
        gui.setGuiLogin(guiLogin);
        
        guiLogin.setVisible(true);
        //gui.setVisible(true);
    }
}
