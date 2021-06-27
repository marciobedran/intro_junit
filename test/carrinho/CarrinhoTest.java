import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

	Carrinho carrinho;
	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}
	
	@DisplayName("Testa carrinho vazio")
	@Test
	public void testCarrinhoVazio() {
		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0, carrinho.getValorTotal());
	}

	@DisplayName("Testa adição de item ao carrinho")
	@Test
	public void testAdicionaItemCarrinho() {
		float preco1 = (float) 10.00;
		float preco2 = (float) 25.00;
		float precoTotal = (float) 35.00;

		Produto p1 = new Produto("Produto 1", preco1);
		Produto p2 = new Produto("Produto 2", preco2);
		Produto p3 = new Produto("Produto 3", 30.0);
		
		carrinho.addItem(p1);
		carrinho.addItem(p2);
		
		assertEquals(2, carrinho.getQtdeItems());
		assertEquals(precoTotal, carrinho.getValorTotal());
	}

	@DisplayName("Testa remoção de item no carrinho")
	@Test
	public void testRemocaoDeProdutoValido() {
		Produto p1 = new Produto("Produto 1", 10.0);
		carrinho.addItem(p1);
		
		try {
			carrinho.removeItem(p1);
		} catch (Exception e) {
			System.out.println("Produto não encontrado");
		} finally {
			assertEquals(0, carrinho.getQtdeItems());
		}
	}

	@DisplayName("Testa remoção de um item que não está no carrinho")
	@Test
	public void testRemocaoDeProdutoInvalido() {
		Produto p1 = new Produto("Teste", 10.0);
		
		assertThrows(ProdutoNaoEncontradoException.class,
				() -> carrinho.removeItem(p1));
	}

	@DisplayName("Testa esvaizar carrinho")
	@Test
	public void testEsvazia() {
		Produto p1 = new Produto("Produto 1", 10.00);
		Produto p2 = new Produto("Produto 2", 25.00);
		
		carrinho.addItem(p1);
		carrinho.addItem(p2);

		assertEquals(2, carrinho.getQtdeItems());
		
		carrinho.esvazia();
		
		assertEquals(0, carrinho.getQtdeItems());
	}	
}