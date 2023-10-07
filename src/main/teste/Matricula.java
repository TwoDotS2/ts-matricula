package teste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.PublicKey;

public class Matricula {
	private Turma turma;

	private Aluno aluno;

	private BigDecimal nota1;

	private BigDecimal nota2;

	private BigDecimal nota3;

	private Integer frequencia;

	private StatusAprovacao status;

	public BigDecimal nota1() {
		return this.nota1;
	}

	public BigDecimal nota2() {
		return this.nota2;
	}

	public BigDecimal nota3() {
		return this.nota3;
	}

	public StatusAprovacao status() {
		return this.status;
	}

	public void registrarNota1(BigDecimal nota1) {
		this.nota1 = nota1;
	}

	public void registrarNota2(BigDecimal nota2) {
		this.nota2 = nota2;
	}

	public void registrarNota3(BigDecimal nota3) {
		this.nota3 = nota3;
	}


	public void consolidarParcialmente(){
		BigDecimal media = (nota1.add(nota2).add(nota3));
		media = media.divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);

		if(!nota1.equals(null) && !nota2.equals(null) && !nota2.equals(null) && frequencia != null){
			if(frequencia < 75){
				if(media.compareTo(BigDecimal.valueOf(5.00)) == -1)
					status = StatusAprovacao.REMF;
				else
					status = StatusAprovacao.REPF;
			} else {
				if(media.compareTo(BigDecimal.valueOf(3)) == -1){
					status = StatusAprovacao.REP;
				}
				else if(media.compareTo(BigDecimal.valueOf(3)) != -1 && media.compareTo(BigDecimal.valueOf(5)) == -1){
					status = StatusAprovacao.REC;
				} else if(media.compareTo(BigDecimal.valueOf(5)) != -1 && media.compareTo(BigDecimal.valueOf(7)) == -1){
					status = StatusAprovacao.APRN;
				} else {
					status = StatusAprovacao.APR;
				}
			}
		}

	}

	public Integer frequencia() {
		return frequencia;
	}

	public void registrarFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}
}
