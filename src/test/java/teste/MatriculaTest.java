package teste;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatriculaTest {

	
    @ParameterizedTest
	@CsvSource({
//		CT-001
			"4.0, 7.0, 7.0, 75, APRD",
			
//		CT-002
			"2.0, 8.0, 8.0, 75, REPO",
			
//		CT-003			
			"7.1, 3.9, 7.0, 75, REPO",
			
//		CT-004
			"9.0, 9.0, 0.0, 75, REPO",
			
//		CT-005
			"4.0, 7.0, 7.0, 74, REPF",
			
//		CT-006			
			"3.0, 3.0, 2.9, 74, REMF",
			
//		CT-007				
			"3.0, 3.0, 3.0, 74, REPF",
			
			
//		CT-008			
			"7.0, 7.0, 3.0, 75, REPO",
		
//		CT-009
			"3.0, 3.0, 3.0, 75, REPO",
			
//		CT-010
			"0.0, 0.0, 9.0, 75, REPO",
			
//		CT-011
			"3.0, 3.0, 2.9, 75, REPR",
		
//		CT-012
			"2.9, 3.0, 3.0, 75, REPO",
		
//		CT-013
			"2.0, 3.0, 3.0, 74, REMF",
			
//		CT-014		
			"10.0, 10.0, 10.0, -1, REPF",
			
//		CT-015
			"10.0, 10.0, -1.0, 75, REPO",
			
//		CT-016
			"-1.0, -1.0, -1.0, 75, REPR",
			
//		CT-017
			"13.0, 9.0, 8.0, 75, APRD",
			
//		CT-018
			"10.0, 10.0, 10.0, 101, APRD",

//		CT-019
			"13.0, 13.0, 13.0, 75, APRD"
			})
    
	void testarConsolidacaoParcial(BigDecimal nota1, BigDecimal nota2, 
			BigDecimal nota3, Integer frequencia, StatusAprovacao statusEsperado) {
		Matricula m = new Matricula();

		
		m.registrarNota1(nota1);
		m.registrarNota2(nota2);
		m.registrarNota3(nota3);
		m.registrarFrequencia(frequencia);
		

		m.consolidarParcialmente();

        StatusAprovacao statusRetornado = m.status();

		Assertions.assertEquals(statusEsperado, statusRetornado);
	}
}
