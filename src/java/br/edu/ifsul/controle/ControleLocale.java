/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 *
 * @author alexv
 */
@ManagedBean(name = "controleLocale")
public class ControleLocale implements Serializable{
    
    private Locale currentLocale = new Locale("pt", "BR");
    
    public ControleLocale(){
        
    }

    public void englishLocale(){
        UIViewRoot uiViewRoot = FacesContext.getCurrentInstance().getViewRoot();
        currentLocale = Locale.US;
        uiViewRoot.setLocale(currentLocale);
    }
    
    public void portugueseLocale(){
        UIViewRoot uiViewRoot = FacesContext.getCurrentInstance().getViewRoot();
        currentLocale = new Locale("pt","BR");
        uiViewRoot.setLocale(currentLocale);
    } 
    
    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }
}
