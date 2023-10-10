package teste;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Matricula2
{
	private static final BigDecimal TRES = BigDecimal.valueOf(3l);

	private static final BigDecimal QUATRO = BigDecimal.valueOf(4l);

	private static final BigDecimal SEIS = BigDecimal.valueOf(6l);

	private Turma turma;

	private Aluno aluno;

	private BigDecimal nota1;

	private BigDecimal nota2;

	private BigDecimal nota3;

	private Integer frequencia;

	private StatusAprovacao2 status;

	public BigDecimal nota1()
	{
		return this.nota1;
	}

	public BigDecimal nota2()
	{
		return this.nota2;
	}

	public BigDecimal nota3()
	{
		return this.nota3;
	}

	public StatusAprovacao2 status()
	{
		return this.status;
	}

	public void registrarNota1(BigDecimal nota1)
	{
		this.nota1 = nota1;
	}

	public void registrarNota2(BigDecimal nota2)
	{
		this.nota2 = nota2;
	}

	public void registrarNota3(BigDecimal nota3)
	{
		this.nota3 = nota3;
	}


	public void consolidarParcialmente()
	{

		BigDecimal mediaParcial = nota1.add(nota2).add(nota3).divide(TRES, RoundingMode.HALF_EVEN);

		if (frequencia < 75) 
		{

			if (mediaParcial.compareTo(TRES) < 0)
			{
				this.status = StatusAprovacao2.REMF;
			}
			else
			{
				this.status = StatusAprovacao2.REPF;
			}

		}
		else
		{
			if(mediaParcial.compareTo(TRES) < 0)
			{
				this.status = StatusAprovacao2.REPR;
			}
			else if(mediaParcial.compareTo(SEIS) < 0)
			{
				if(nota1.compareTo(QUATRO) < 0 || 
				   nota2.compareTo(QUATRO) < 0 || 
				   nota3.compareTo(QUATRO) < 0)
				{
					this.status = StatusAprovacao2.REPO;
				}
			}
			else
			{
				this.status = StatusAprovacao2.APRD;
			}
		}
	}

	public Integer frequencia()
	{
		return frequencia;
	}

	public void registrarFrequencia(Integer frequencia)
	{
		this.frequencia = frequencia;
	}
}