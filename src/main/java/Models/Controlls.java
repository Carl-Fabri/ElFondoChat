/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author Carlos Fabricio
 */
public class Controlls implements Serializable {
    private String ipcontrol;
    private String nombrecontrol;
    private int puerto;

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getIpcontrol() {
        return ipcontrol;
    }

    public void setIpcontrol(String ipcontrol) {
        this.ipcontrol = ipcontrol;
    }

    public String getNombrecontrol() {
        return nombrecontrol;
    }

    public void setNombrecontrol(String nombrecontrol) {
        this.nombrecontrol = nombrecontrol;
    }
}
