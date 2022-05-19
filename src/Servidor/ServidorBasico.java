package Servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorBasico {
	
	public static void main(String a[]) {
		System.out.println("Iniciando Servidor...");
		
		try (ServerSocket servidor = new ServerSocket(1234);){
			System.out.println("[Servidor operando na porta 1234]");
			
			while(true) {
				System.out.println("[Aguardando conexao...]");
				Socket cliente = servidor.accept(); //aceita conexão.
				System.out.println("[conexao aberta de: "
						+ cliente.getInetAddress().toString() + "]");
				System.out.println("[Enviando dados...]");
				
				ObjectOutputStream saida = new ObjectOutputStream(
						cliente.getOutputStream());
				
				saida.flush(); //envia cabeçalho de preparo do outro endpoint
				saida.writeObject("Servidor basico conectado");
				saida.writeObject("Dados conexao: " + cliente.toString());
				saida.writeObject("Tchau!");
				System.out.println("[Dados enviados]");
				saida.writeObject("EOT");
				System.out.println("[Conexao encerrada]");
				
			}
		} catch(IOException e) {
			System.out.println("Erro! \n" + e.getMessage());
		}
		
	}

}
