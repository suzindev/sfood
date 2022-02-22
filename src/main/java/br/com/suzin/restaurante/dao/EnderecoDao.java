package br.com.suzin.restaurante.dao;

import br.com.suzin.restaurante.entity.Endereco;
import br.com.suzin.restaurante.entity.Ordem;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDao {
    private EntityManager entityManager;

    public EnderecoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*
     * CRUD
     * C = CREATE
     * R = READ
     * U = UPDATE
     * D = DELETE
     */

    public void cadastrar(final Endereco endereco) {
        this.entityManager.persist(endereco);
    }

    public Endereco consultarPorId(final Integer id) {
        return this.entityManager.find(Endereco.class, id);
    }

    public List<Endereco> consultarTodos() {
        String jpql = "SELECT e FROM Endereco e";
        return this.entityManager.createQuery(jpql, Endereco.class).getResultList();
    }

    public void atualizar(final Endereco endereco) {
        this.entityManager.merge(endereco);
    }

    public void excluir(final Endereco endereco) {
        this.entityManager.remove(endereco);
    }
}
