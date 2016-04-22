package consultorio.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="atendimento")
public class Atendimento {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
 
	@Column(name="anotacao")	
	private String anotacao;
 
	@Column(name="data")
	private Date data;
 
	public Integer getId() {
		return id;
	}
 
	public void setId(Integer id) {
		this.id = id;
	}
 
	public String getAnotacao() {
		return anotacao;
	}
 
	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}
 
	public Date getData() {
		return data;
	}
 
	public void setData(Date data) {
		this.data = data;
	}
 
}