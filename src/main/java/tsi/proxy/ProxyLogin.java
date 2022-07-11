package tsi.proxy;

import java.util.Random;
import java.util.Scanner;

public class ProxyLogin {
    ServicoLogin servicoLogin;
    public ProxyLogin() {
        servicoLogin = new ServicoLogin();
    }
    
    ServicoLogin acessar() throws Exception {
        verificarBot();
        return servicoLogin;
    }
    
    private void verificarBot() throws Exception
    {
        int menor = 48; // numero '0'
        int maior = 122; // letra 'z'
        int targetStringLength = 6;
        Random random = new Random();

        String codigoAleatorio = random.ints(menor, maior + 1)
            .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
        
        System.out.println("Digite o codigo abaixo para verificação:");
        System.out.println(codigoAleatorio);
        
        Scanner scanner = new Scanner(System.in);
        
        String codigoDigitado = scanner.nextLine();
        
        if (!codigoDigitado.equals(codigoAleatorio))
            throw new Exception("Código de verificação inválido.");
    }
}
