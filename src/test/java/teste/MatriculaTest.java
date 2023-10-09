package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatriculaTest {

	
    @ParameterizedTest
	@CsvSource({
			"4.0, 4.0, 4.0, 75, APRD",
			"2.0, 8.0, 8.0, 75, REPO",
			"7.1, 3.9, 7.0, 75, REPO",
			"9.0, 9.0, 0.0, 75, REPO",
			"4.0, 7.0, 7.0, 74, REPF",
			"3.0, 7.0, 7.0, 74, REMF",
			"7.0, 3.0, 7.0, 74, REMF",
			"7.0, 7.0, 3.0, 74, REMF",
			"3.0, 3.0, 3.0, 75, REPO",
			"0.0, 0.0, 9.0, 75, REPO",
			"3.0, 3.0, 2.9, 75, REPR",
			"2.9, 3.0, 3.0, 75, REPO",
			"2.9, 3.0, 3.0, 74, REMF",
			"10.0, 10.0, 10.0, -1, REPF",
			"10.0, 10.0, -1.0, 75, REPO",
			"-1.0, -1.0, -1.0, 75, REPR",
			"13.0, 9.0, 8.0, 75, APRD",
			"10.0, 10.0, 10.0, 101, APRD",
			"13.0, 13.0, 13.0, 75, APRD"
			})
    
	void testarConsolidacaoParcial(String numeroCenario, BigDecimal nota1, BigDecimal nota2, 
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
