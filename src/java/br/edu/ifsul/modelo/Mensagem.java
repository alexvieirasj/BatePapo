/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Mensagem implements Serializable {

    private String mensagem;

    private Usuarios usuario;

    private Calendar horaMensagem;

    public Mensagem() {

    }

    public Mensagem(String mensagem) {

        this.mensagem = mensagem;
       
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Calendar getHoraMensagem() {
        return horaMensagem;
    }

    public void setHoraMensagem(Calendar horaMensagem) {
        this.horaMensagem = horaMensagem;
    }

}
