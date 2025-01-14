import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a subtra��o de dois n�meros")
	@Test
	public void testSubtraiDoisNumeros() {
		int subtracao = calc.subtracao(8, 5);		
		Assertions.assertEquals(3, subtracao);		
	}
	
	@DisplayName("Testa a multiplica��o de dois n�meros")
	@Test
	public void testMultiplicaDoisNumeros() {
		int multiplicacao = calc.multiplicacao(2, 5);		
		Assertions.assertEquals(10, multiplicacao);		
	}
	
	@DisplayName("Testa a divis�o de dois n�meros")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@DisplayName("Testa a divis�o por zero")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@DisplayName("Testa a deivis�o por zero com assert throws")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testa somatoria")
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(5);		
		Assertions.assertEquals(15, somatoria);		
	}
	
	@DisplayName("Testa positivo com numero negativo")
	@Test
	public void testEhPositivoFalso() {
		int ehPositivo = calc.ehPositivo(5);		
		Assertions.assertEquals(False, ehPositivo);		
	}
	
	@DisplayName("Testa positivo com numero positivo")
	@Test
	public void testEhPositivoVerdadeiro() {
		int ehPositivo = calc.ehPositivo(4);		
		Assertions.assertEquals(True, ehPositivo);		
	}
	
	@DisplayName("Testa compara��o com dois n�meros iguais")
	@Test
	public void testComparaIguais() {
		int compara = calc.compara(4, 4);		
		Assertions.assertEquals(0, compara);		
	}
	
	@DisplayName("Testa compara��o com o primeiro numero maior")
	@Test
	public void testComparaMaior() {
		int compara = calc.compara(4, 3);		
		Assertions.assertEquals(1, compara);		
	}
	
	@DisplayName("Testa compara��o com o primeiro numero menor")
	@Test
	public void testComparaMenor() {
		int compara = calc.compara(4, 5);		
		Assertions.assertEquals(-1, compara);		
	}

}