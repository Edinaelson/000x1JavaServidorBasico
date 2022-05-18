package ClienteBasico;

import java.net.Socket;

public class ClienteBasico {
	public static void main(String[] args) {
		System.out.println("[Conectando...]");
		
		try (Socket cliente = new Socket(a[0], 1234);){
			System.out.println("[Conexao aceita de: "
					+ cliente.getInetAddress().toString() + "]");
			System.out.println("[Recebendo Mensagens]...");
		}
		
	}
}
