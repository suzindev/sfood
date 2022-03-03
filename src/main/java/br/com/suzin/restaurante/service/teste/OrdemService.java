package br.com.suzin.restaurante.service.teste;

import br.com.suzin.restaurante.dao.CardapioDao;
import br.com.suzin.restaurante.dao.ClienteDao;
import br.com.suzin.restaurante.dao.EnderecoDao;
import br.com.suzin.restaurante.dao.OrdemDao;
import br.com.suzin.restaurante.entity.*;
import br.com.suzin.restaurante.util.CargaDeDadosUtil;
import br.com.suzin.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerSFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Endereco endereco = new Endereco("000000000", "rua", "apt 0", "São Paulo", "PR");
        Cliente suzin = new Cliente("11111111111", "email@email.com", "Suzin");
        suzin.addEndereco(endereco);
        Ordem ordem = new Ordem(suzin);
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(1), 2));
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(2), 3));
        clienteDao.cadastrar(suzin);
        ordemDao.cadastrar(ordem);

        EnderecoDao enderecoDao = new EnderecoDao(entityManager);

        System.out.println(enderecoDao.consultarClientes("PR", "São Paulo", null));
        System.out.println(enderecoDao.consultarClientesUsandoCriteria("PR", "São Paulo", null));
        System.out.println(clienteDao.consultarPorId(new ClienteId("email@email.com", "11111111111")));

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
