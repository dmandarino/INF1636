package service;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import modelos.Casa;
import modelos.Peca;
import modelos.PecaEnum;

public class Arquivo { 
	
	private Image	bispo_branco, 
	cavalo_branco,
	dama_branco,
	peao_branco,
	rei_branco,
	torre_branco,
	bispo_preto,
	cavalo_preto,
	dama_preto,
	peao_preto,
	rei_preto,
	torre_preto;
	
	public void salvaJogo(List<Peca> pecasPretas, List<Peca> pecasBrancas){
		try{		
		FileWriter arq = new FileWriter("jogo.txt"); 
		PrintWriter gravarArq = new PrintWriter(arq); 
		
		for (Peca peca : pecasBrancas) {
			printNoArquivo(gravarArq, peca);
		}
		
		for (Peca peca : pecasPretas) {
			printNoArquivo(gravarArq, peca);
		}
		
		arq.close(); 
		}catch (IOException e) { 
			System.err.printf("Erro ao escrever o arquivo: %s.\n", e.getMessage()); 
		}
	}

	private void printNoArquivo(PrintWriter gravarArq, Peca peca) {
		gravarArq.printf("%d-%d-%s-%s-%s%n", peca.getCasa().getNumCasa(), peca.getId(), peca.getTipo().toString(), peca.isBranco(), peca.isPrimeiroMovimento());
	} 
	
	public void recuperaJogo(HashMap<Integer, Casa> casas, List<Peca> pecasBrancas, List<Peca> pecasPretas){
		try { 
			Peca peca = new Peca();
			carregaImagem();
			
			FileReader arq = new FileReader("jogo.txt");
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha = lerArq.readLine(); 
			
			while (linha != null) { 
				String[] dados = linha.split("-");
				
				peca.setCasa(casas.get(Integer.valueOf(dados[0])+1));
				peca.setId(Long.valueOf(dados[1]));
				peca.setIsBranco(Boolean.valueOf(dados[3]));
				peca.setPrimeiroMovimento(Boolean.valueOf(dados[4]));
				peca.setFigura(setFigura(dados[2], peca.isBranco()));
				peca.setTipo(setTipo(dados[2]));
				
				if(peca.isBranco())
					pecasBrancas.add(peca);
				else
					pecasPretas.add(peca);
				casas.get(peca.getCasa().getNumCasa()+1).setPeca(peca);
				
				linha = lerArq.readLine(); 
			}
			arq.close(); 
		} catch (IOException e) { 
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); 
		}
	}

	
	private PecaEnum setTipo(String dados) {
		switch (dados) {
		case "PEAO":
			return PecaEnum.PEAO;
		case "TORRE":
			return PecaEnum.TORRE;
		case "CAVALO":
			return PecaEnum.CAVALO;
		case "BISPO":
			return PecaEnum.BISPO;
		case "RAINHA":
			return PecaEnum.RAINHA;
		default:
			return PecaEnum.REI;
		}
	}

	private Image setFigura(String dados, Boolean branco) {
		switch (dados) {
		case "PEAO":
			if(branco)
				return peao_branco;
			return peao_preto;
		case "TORRE":
			if(branco)
				return torre_branco;
			return torre_preto;
		case "CAVALO":
			if(branco)
				return cavalo_branco;
			return cavalo_preto;
		case "BISPO":
			if(branco)
				return bispo_branco;
			return bispo_preto;
		case "RAINHA":
			if(branco)
				return dama_branco;
			return dama_preto;
		default:
			if(branco)
				return rei_branco;
		}
		return rei_preto;
	}

	private void carregaImagem(){
		try
		{
			bispo_branco	= ImageIO.read(new File("Pecas/b_bispo.png"));
			cavalo_branco	= ImageIO.read(new File("Pecas/b_cavalo.png"));
			dama_branco		= ImageIO.read(new File("Pecas/b_dama.png"));
			peao_branco		= ImageIO.read(new File("Pecas/b_peao.png"));
			rei_branco		= ImageIO.read(new File("Pecas/b_rei.png"));
			torre_branco	= ImageIO.read(new File("Pecas/b_torre.png"));
			bispo_preto		= ImageIO.read(new File("Pecas/p_bispo.png"));
			cavalo_preto	= ImageIO.read(new File("Pecas/p_cavalo.png"));
			dama_preto		= ImageIO.read(new File("Pecas/p_dama.png"));
			peao_preto		= ImageIO.read(new File("Pecas/p_peao.png"));
			rei_preto		= ImageIO.read(new File("Pecas/p_rei.png"));
			torre_preto		= ImageIO.read(new File("Pecas/p_torre.png"));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}