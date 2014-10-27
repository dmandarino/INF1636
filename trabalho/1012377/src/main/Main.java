package main;

import java.awt.Graphics;

import visualizacao.XadrezFrame;
import modelos.Casa;
import modelos.Peao;
import modelos.Peca;
import modelos.PecaEnum;

public class Main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Peca peca = new Peca();
		peca.setNome(PecaEnum.PEAO);
		Casa casa = new Casa();
		Casa casaDestino = new Casa();
		
		XadrezFrame f	= new XadrezFrame();
		f.setVisible(true);
		
		casa.setX(1);
		casa.setY(1);
		peca.setCasa(casa);
		casaDestino.setX(1);
		casaDestino.setY(2);
		
		casa=peca.andarPeca(casaDestino);
		System.out.println(casa.getY().toString() + ", " + casa.getX().toString());
	}

}
