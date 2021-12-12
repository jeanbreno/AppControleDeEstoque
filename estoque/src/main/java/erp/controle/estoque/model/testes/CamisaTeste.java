package erp.controle.estoque.model.testes;

import erp.controle.estoque.exceptions.QuantidadeInvalidaException;
import erp.controle.estoque.exceptions.TamanhoInvalidoException;
import erp.controle.estoque.exceptions.ValorInvalidoException;
import erp.controle.estoque.model.domain.Camisa;

public class CamisaTeste { 
	
	public static void main(String[] args) {
		
		try {
			Camisa esporte = new Camisa("Blusa esporte", 19, "Imediata", "G", 5);
			esporte.setEspecial(false);
			System.out.println("Valor total do item Esporte: " + esporte.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | QuantidadeInvalidaException | TamanhoInvalidoException e)	{
			System.out.println(e.getMessage());
		}
		
		try {
			Camisa estampada = new Camisa("Blusa estampa Leão", 0, "Imediata", "P", 15);
			estampada.setEspecial(true);
			System.out.println("Valor total do item Estampada: " + estampada.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | QuantidadeInvalidaException | TamanhoInvalidoException e)	{
			System.out.println(e.getMessage());
		}
		
		try {
			Camisa estampada = new Camisa("Blusa estampa Leão", 0, "Imediata", "P", 0);
			estampada.setEspecial(true);
			System.out.println("Valor total do item Estampada: " + estampada.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | QuantidadeInvalidaException | TamanhoInvalidoException e)	{
			System.out.println(e.getMessage());
		}
		
		try {
			Camisa estampada = new Camisa("Blusa estampa Leão", -1, "Imediata", "P", -5);
			estampada.setEspecial(true);
			System.out.println("Valor total do item Estampada: " + estampada.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | QuantidadeInvalidaException | TamanhoInvalidoException e)	{
			System.out.println(e.getMessage());
		}
		
		try {
			Camisa estampada = new Camisa("Blusa estampa Leão", 5, "Imediata", null, 2);
			estampada.setEspecial(true);
			System.out.println("Valor total do item Estampada: " + estampada.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | QuantidadeInvalidaException | TamanhoInvalidoException e)	{
			System.out.println(e.getMessage());
		}
		
		try {
			Camisa estampada = new Camisa("Blusa estampa Leão", 5, "Imediata", "L", 0);
			estampada.setEspecial(true);
			System.out.println("Valor total do item Estampada: " + estampada.calcularValorTotalDoItem());
		} catch (ValorInvalidoException | QuantidadeInvalidaException | TamanhoInvalidoException e)	{
			System.out.println(e.getMessage());
		}
	}
}
