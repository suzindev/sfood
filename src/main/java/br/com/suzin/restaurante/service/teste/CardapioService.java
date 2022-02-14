package br.com.suzin.restaurante.service.teste;

import br.com.suzin.restaurante.dao.CardapioDao;
import br.com.suzin.restaurante.util.CargaDeDadosUtil;
import br.com.suzin.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerSFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("O produto pesquisado foi: " + cardapioDao.consultarPorNome("moqueca"));
        entityManager.close();
    }
}
