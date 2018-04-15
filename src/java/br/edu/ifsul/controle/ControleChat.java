/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.ejb.BeanChat;
import br.edu.ifsul.modelo.Mensagem;
import br.edu.ifsul.modelo.Usuarios;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Renato
 */
@Named(value = "controleChat")
@SessionScoped
public class ControleChat implements Serializable {

    @EJB
    private BeanChat beanChat;

    private Mensagem mensagem;

    private Usuarios usuario;

    public ControleChat() {
        this.mensagem = new Mensagem();
        this.usuario = new Usuarios();
    }

    public void adicionaMsg() {
        this.getMensagem().setHoraMensagem(Calendar.getInstance());
        this.getMensagem().setUsuario(getUsuario());
        this.beanChat.adicionarMensagem(getMensagem());
        this.setMensagem(new Mensagem());

    }

    public void logarChat() {
        if (this.beanChat.testeUsuario(usuario)) {
            usuario.setNome(null);
            Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            sessionMap.clear();
        } else {
            this.beanChat.adicionaUsuario(usuario);
            this.beanChat.adicionarMensagem(new Mensagem(usuario.getNome() + " entrou no bate papo"));
        }
    }

    public void logoutChat() { 
        this.beanChat.adicionarMensagem(new Mensagem(usuario.getNome() + " saiu do bate papo"));
        this.beanChat.removerUsuario(usuario);
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.clear();
    }

    public String verChat() {
        return "index?faces-redirect=true";
    }

    public BeanChat getBeanChat() {
        return beanChat;
    }

    public void setBeanChat(BeanChat beanChat) {
        this.beanChat = beanChat;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public List<Mensagem> atualizarMsg() {
        return beanChat.getMensagens();
    }

}
