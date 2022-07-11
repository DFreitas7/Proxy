
package tsi.proxy;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class ServicoLogin {
    private HashMap<String, Usuario> usuarios;
    
    public ServicoLogin()
    {
        usuarios = new HashMap();
    }
    
    public Usuario cadastrar(String nome, String senha, String confirmacaoSenha)  throws Exception {
        if (usuarios.containsKey(nome))
            throw new Exception("Nome de usuário já está sendo utilizado.");
        
        if (!senha.equals(confirmacaoSenha))
            throw new Exception("Confirmação de senha não bate com a senha informada.");
                            
        
        Usuario novoUsuario = new Usuario(nome, senha);
        
        usuarios.put(nome, novoUsuario);
        System.out.println("Usuário " + nome + " cadastrado com sucesso!");
        
        return novoUsuario;
    }
    
    public Usuario logar(String nome, String senha) throws Exception {
        Usuario usuarioPorNome = usuarios.get(nome);
        
        if (usuarioPorNome == null)
            throw new Exception("Usuário não encontrado no sistema.");
        
        if (!usuarioPorNome.getSenha().equals(senha))
            throw new Exception("Senha incorreta.");
        
        System.out.println("Usuário " + nome + " logado com sucesso!");
        return usuarioPorNome;
    }
    
    public void remover(String nome, String senha) throws Exception {
        Usuario usuarioPorNome = usuarios.get(nome);
        
        if (usuarioPorNome == null)
            throw new Exception("Usuário não encontrado no sistema.");
        
        if (!usuarioPorNome.getSenha().equals(senha))
            throw new Exception("Senha incorreta.");
        
        usuarios.remove(nome);
        System.out.println("Usuário " + nome + " removido com sucesso!");
    }
    
}
