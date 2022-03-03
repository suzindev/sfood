package br.com.suzin.restaurante.dao;

import br.com.suzin.restaurante.entity.Categoria;
import br.com.suzin.restaurante.entity.Cliente;
import br.com.suzin.restaurante.entity.ClienteId;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {
    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*
     * CRUD
     * C = CREATE
     * R = READ
     * U = UPDATE
     * D = DELETE
     */

    public void cadastrar(final Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    public Cliente consultarPorId(final ClienteId id) {
        return this.entityManager.find(Cliente.class, id);
    }

    public List<Cliente> consultarTodos() {
        String jpql = "SELECT c FROM Cliente c";
        return this.entityManager.createQuery(jpql, Cliente.class).getResultList();
    }

    public List<Cliente> consultarPorNome(final String nome) {
        String jpql = "SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(:nome)";
        return this.entityManager.createQuery(jpql, Cliente.class).setParameter("nome", "%" +
                nome + "%").getResultList();
    }

    public void atualizar(final Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    public void excluir(final Cliente cliente) {
        this.entityManager.remove(cliente);
    }
}
