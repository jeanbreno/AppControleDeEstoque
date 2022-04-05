package erp.controle.estoque.model.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import erp.controle.estoque.exceptions.CnpjInvalidoException;
import erp.controle.estoque.exceptions.EmailInvalidoException;
//import erp.controle.estoque.exceptions.FileNotFoundException;
import erp.controle.estoque.exceptions.LojaNulaException;
import erp.controle.estoque.exceptions.NaoExisteRoupasException;
import erp.controle.estoque.exceptions.NomeInvalidoException;
import erp.controle.estoque.exceptions.QuantidadeInvalidaException;
import erp.controle.estoque.exceptions.TamanhoInvalidoException;
import erp.controle.estoque.exceptions.ValorInvalidoException;
import erp.controle.estoque.model.domain.Pedido;
import erp.controle.estoque.model.domain.Calca;
import erp.controle.estoque.model.domain.Camisa;
import erp.controle.estoque.model.domain.Casaco;
import erp.controle.estoque.model.domain.Loja;
import erp.controle.estoque.model.domain.Roupa;

public class ArquivoControleTeste {

	public static void main(String[] args) {
		
		try {
			
			List<String> inconsistencias = new ArrayList<String>();
			
			System.out.println("Processando pedidos...");
			try {
				
				String arquivo = "pedido.txt";
				
				FileReader fileR = new FileReader(arquivo);
				BufferedReader leitura = new BufferedReader(fileR);
				
				FileWriter fileW = new FileWriter("out_"+arquivo);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = leitura.readLine();
				
				String[] campos = null;
				
				List<Roupa> roupas = new ArrayList<Roupa>();
	
				Pedido pedido = null;
				
				while(linha != null) {
					campos = linha.split(";");
					
					String tipo = campos[0];
					
					switch (tipo.toUpperCase()) {
					case "Pedido":
						Loja loja = null;
						try {
							loja = new Loja(campos[2], campos[3], campos[4]);
						} catch (NomeInvalidoException | EmailInvalidoException | CnpjInvalidoException e) {
							System.out.println(e.getMessage());
						}
						
						try {
							pedido = new Pedido(loja);
							pedido.setNumeroPedido(campos[1]);
							pedido.setRoupas(roupas);
						} catch (LojaNulaException e) {
							System.out.println(e.getMessage());
						}
						
						break;
					case "Calca":				
						try {
							Calca skinny = new Calca(campos[1], campos[2], Float.valueOf(campos[3]), campos[4], campos[5], Integer.valueOf(campos[6]));
							skinny.setMarca(campos[6]);
							skinny.setEspecial(Boolean.valueOf(campos[7]));
							skinny.setComCinto(Boolean.valueOf(campos[8]));
							skinny.setSecao(campos[9]);
							skinny.setEstilo(campos[10]);
							roupas.add(skinny);
						} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
							System.out.println(e.getMessage());
						}
	
						break;
					case "Camisa":				
						try {
							Camisa esporte = new Camisa(campos[1], campos[2], Float.valueOf(campos[3]), campos[4], campos[5], Integer.valueOf(campos[6]));
							esporte.setMarca(campos[6]);
							esporte.setEspecial(Boolean.valueOf(campos[7]));
							esporte.setSecao(campos[8]);
							roupas.add(esporte);
						} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
							System.out.println(e.getMessage());
						}
	
						break;
					case "Casaco":				
						try {
							Casaco rajado = new Casaco(campos[1], campos[2], Float.valueOf(campos[3]), campos[4], campos[5], Integer.valueOf(campos[6]));
							rajado.setMarca(campos[6]);
							rajado.setEspecial(Boolean.valueOf(campos[7]));
							rajado.setTemCapuz(Boolean.valueOf(campos[8]));
							rajado.setSecao(campos[9]);
							rajado.setEstilo(campos[10]);
							roupas.add(rajado);
						} catch (ValorInvalidoException | TamanhoInvalidoException | QuantidadeInvalidaException e) {
							System.out.println(e.getMessage());
						}
	
						break;
	
					default:
						inconsistencias.add(linha);
						break;
					}
					
					linha = leitura.readLine();
				}
				
				try {
					
					pedido.relatorio();
					
					escrita.write(pedido.obterLinhaGravacaoArquivo());		
					
					System.out.println("# Quantidade de erros no processamento: " + inconsistencias.size());
					for(String erro : inconsistencias) {
						System.out.println("- " + erro);
					}
				} catch (NaoExisteRoupasException e) {
					System.out.println(e.getMessage());
				}
				
				leitura.close();
				escrita.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	} finally {
		System.out.println("Processamento finalizado!");
	}
	}
}
