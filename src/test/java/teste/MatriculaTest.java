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
			"0,2.9,0,0,REMF",
			"2.1,2,2,75,REP",
			"4.9,3.1,4,0,REPF",
			"4.9,4.9,4.9,75,REC",
			"5.1,6.9,6.9,100,APRN",
			"7,10,8,100,APR",
			"0,3,3,100,REP",
			"3,0,3,100,REP",
			"3,3,0,100,REC",
			"2,10,6,100,REC",
			"10,2,6,100,REC",
			"10,6,2,100,REC",
			})
	void testarConsolidacaoParcial(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3, Integer frequencia, StatusAprovacao statusEsperado) {
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
