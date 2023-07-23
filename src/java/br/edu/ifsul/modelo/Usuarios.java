package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Usuarios implements Serializable {

    
    private Integer id;
    @NotBlank(message = "{usuarios.nome.notblank}")
    @Length(max = 20, message = "{usuarios.nome.length}")
    private String nome;

    public Usuarios() {

    }

    public Usuarios(Integer id,String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuarios other = (Usuarios) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
