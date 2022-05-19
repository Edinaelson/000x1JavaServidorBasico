package ClienteBasico;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ClienteBasico {
	public static void main(String a[]) {
		System.out.println("[Conectando...]");
		
		try (Socket cliente = new Socket("localHost", 1234);){
			System.out.println("[Conexao aceita de: "
					+ cliente.getInetAddress().toString() + "]");
			System.out.println("[Recebendo Mensagens]..."); 
			ObjectInputStream entrada = new ObjectInputStream(
					cliente.getInputStream());
			
			String msg;
			do { //recepcao do servidor
				msg = (String) entrada.readObject();
				System.out.println(msg);
			} while (!msg.equals("EOT"));
			System.out.println("[Conexao encerrada]");
		} catch (Exception e) {
			System.out.println("Erro! \n" + e.getMessage());
		}//cliente.close() implicito
		
	}
}
