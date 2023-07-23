package br.edu.ifsul.ejb;

import br.edu.ifsul.modelo.Mensagem;
import br.edu.ifsul.modelo.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Singleton
public class BeanChat implements Serializable {

    private List<Mensagem> mensagens = new ArrayList<>();
    private List<Usuarios> usuarios = new ArrayList<>();

    public BeanChat() {
    }

    public void adicionaUsuario(Usuarios obj) {
        if (usuarios.contains(obj)) {
            FacesMessage msg = new FacesMessage("Usuário já existe com esse nome no chat!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            obj.setId(this.usuarios.size() + 1);
            usuarios.add(obj);
            System.out.println("nome: " + obj.getNome());
            FacesMessage msg = new FacesMessage("Usuário adicionado ao chat!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }        
    }
    
    public boolean testeUsuario(Usuarios obj){
        return usuarios.contains(obj);
    }

    public void removerUsuario(Usuarios obj) {
        usuarios.remove(obj);        
    }

    public void adicionarMensagem(Mensagem obj) {
        mensagens.add(obj);

    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
}
