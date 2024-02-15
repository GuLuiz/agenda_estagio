package br.com.agenda.agenda.entities;

import java.io.Serializable;

import javax.swing.ImageIcon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "IMAGEM")
public class ImagemEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imagemId;
    private ImageIcon imagem;
}
