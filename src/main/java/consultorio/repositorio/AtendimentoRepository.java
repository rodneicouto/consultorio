package consultorio.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import consultorio.dominio.Atendimento;

public class AtendimentoRepository {
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public AtendimentoRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
 
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void Salvar(Atendimento atendimento){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(atendimento);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void Alterar(Atendimento atendimento){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(atendimento);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * RETORNA TODAS AS PESSOAS CADASTRADAS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<Atendimento> TodosAtendimentos(){
 
		return this.entityManager.createQuery("SELECT p FROM Atendimento p ORDER BY p.data").getResultList();
	}
 
	/**
	 * CONSULTA UMA PESSOA CADASTRA PELO CÓDIGO
	 * */
	public Atendimento GetPessoa(Integer id){
 
		return this.entityManager.find(Atendimento.class, id);
	}
 
	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void Excluir(Integer id){
 
		Atendimento atendimento = this.GetPessoa(id);
 
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(atendimento);
		this.entityManager.getTransaction().commit();
 
	}
}
