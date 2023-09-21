package com.lgarcia.ejemploactividades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Parqueadero implements Serializable {

    int id;
    String placa;
    Date fechaHoraEntrada, fechaHoraSalida;

    public Parqueadero(int id, String placa) {
        this.id = id;
        this.placa = placa;
        fechaHoraEntrada = Calendar.getInstance().getTime();
        fechaHoraSalida = null;
    }

    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getFechaHoraEntrada() {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(fechaHoraEntrada);
    }

    public String getFechaHoraSalida() {
        if(fechaHoraSalida!= null){
            return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(fechaHoraSalida);
        }else{
            return "En curso";
        }

    }

    public boolean verificarSalida(){
        return fechaHoraSalida != null;
    }

    public void setFechaHoraSalida() {
        this.fechaHoraSalida = Calendar.getInstance().getTime();;
    }

    public String tiempoConsumido(){
       if(fechaHoraSalida != null){
           long diferenciaEnMinutos = (fechaHoraSalida.getTime() - fechaHoraEntrada.getTime()) / 60000;
           return Long.toString(diferenciaEnMinutos);
       }else{
           return "";
       }
    }
}
