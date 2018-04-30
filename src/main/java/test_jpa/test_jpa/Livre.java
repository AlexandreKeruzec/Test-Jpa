package test_jpa.test_jpa;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre {
	@Id
	private Integer id;
	@Column(name="titre", length=255, nullable=false)
	private String titre;
	@Column(name="auteur", length=50, nullable=false)
	private String auteur;
	@ManyToMany(mappedBy="livres")
	private Set<Emprunt> emprunts;

	public Livre() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	

}
