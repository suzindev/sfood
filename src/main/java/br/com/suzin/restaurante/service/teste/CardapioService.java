package br.com.suzin.restaurante.service.teste;

import br.com.suzin.restaurante.dao.CardapioDao;
import br.com.suzin.restaurante.entity.Cardapio;
import br.com.suzin.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmão ao molho de maracujá");
        salmao.setDescricao("Salmão grelhado ao molho de maracujá");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));

        EntityManager entityManager = JPAUtil.getEntityManagerSFood();
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();

        cardapioDao.cadastrar(risoto);
        entityManager.flush();

        cardapioDao.cadastrar(salmao);
        entityManager.flush();

        System.out.println("O prato consultado foi: " + cardapioDao.consultar(1));

        cardapioDao.excluir(salmao);

        System.out.println("O prato consultado foi: " + cardapioDao.consultar(2));

        entityManager.clear();

        risoto.setValor(BigDecimal.valueOf(75.50));
        cardapioDao.atualizar(risoto);
        System.out.println("O prato consultado foi: " + cardapioDao.consultar(1));
    }
}
