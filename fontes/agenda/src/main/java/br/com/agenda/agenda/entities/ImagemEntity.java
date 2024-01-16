package br.com.agenda.agenda.entities;

import java.io.Serializable;

import javax.swing.ImageIcon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "imagem")
@Data
@Table(name = "TB_IMAGEM")
public class ImagemEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    private ImageIcon imagem;
    
    public ImagemEntity(int id, ImageIcon imagem) {
        this.id = id;
        this.imagem = imagem;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImagemEntity other = (ImagemEntity) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    

}
