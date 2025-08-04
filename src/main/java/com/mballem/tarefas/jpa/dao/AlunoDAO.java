package com.mballem.tarefas.jpa.dao;

import com.mballem.tarefas.jpa.domain.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlunoDAO {

    @PersistenceContext // Classe para injeção de um EntityManager
    private EntityManager manager;

    /**
     * TESTE 1 - Complete o metodo com a operação JPA solicitada
     */
    public Aluno findByNomeCompleto(String nomePesquisa) {
        String query = "select a from Aluno a "
                + "where a.nome like :nomePesquisa";

        return this.manager.createQuery(query, Aluno.class)
                .setParameter("nomePesquisa", nomePesquisa)
                .getSingleResult();
    }

    /**
     * TESTE 2 - Complete o metodo com a operação JPA solicitada
     */
    public Aluno findByMatricula(String matriculaPesquisa) {

        String query = "select a from Aluno a "
                + "where a.matricula like :matriculaPesquisa";

        return this.manager.createQuery(query, Aluno.class)
                .setParameter("matriculaPesquisa", matriculaPesquisa)
                .getSingleResult();
    }

    /**
     * TESTE 3 - Complete o metodo com a operação JPA solicitada
     */
    public Long findByAnoLetivo(int inicio, int fim) {

        String query = "select count(a) from Aluno a "
                + "where a.anoLetivo between :inicio AND :fim";

        String queryJava21 = """
            select count(1) from Aluno a where a.anoLetivo between :inicio and :fim
        """;

        return this.manager.createQuery(query, Long.class)
                .setParameter("inicio", inicio)
                .setParameter("fim", fim)
                .getSingleResult();

    }

    /**
     * TESTE 4 - Complete o metodo com a operação JPA solicitada
     */
    public List<Aluno> findByNomeParcial(String nomeParcial) {

        String query = "select a from Aluno a "
                + "where a.nome like :nomeParcial";

        return this.manager.createQuery(query, Aluno.class)
                .setParameter("nomeParcial", "%" + nomeParcial + "%")
                .getResultList();
    }

    /**
     * TESTE 5 - Complete o metodo com a operação JPA solicitada
     */
    public Aluno findByNumeroArmario(Integer numero) {

        String query = "select a from Aluno a "
                + "where a.armario.numero = :numero";

        return this.manager.createQuery(query, Aluno.class)
                .setParameter("numero", numero)
                .getSingleResult();
    }

    /**
     * TESTE 6 - Complete o metodo com a operação JPA solicitada
     */
    public List<Long> findByNumerosDeArmarios(List<Integer> numeros) {

        String query = """
                select a.id from Aluno a
                where a.armario.numero in (:numeros)
                """;

        return this.manager.createQuery(query, Long.class)
                .setParameter("numeros", numeros)
                .getResultList();
    }

    /**
     * TESTE 7 - Complete o metodo com a operação JPA solicitada
     */
    public Aluno updateNomeById(String matricula, String nome) {

        String query = """
                select a from Aluno a 
                where a.matricula like :matricula
                """;

        Aluno alunoPersistent = this.manager.createQuery(query, Aluno.class)
                .setParameter("matricula", matricula)
                .getSingleResult();

        alunoPersistent.setNome(nome);

        return alunoPersistent;
    }

    /**
     * TESTE 8 - Complete o metodo com a operação JPA solicitada
     */
    public List findAlunosAndArmariosByNomeAndAnoLetivo(String nome, int anoLetivo) {

        return null;
    }

}
