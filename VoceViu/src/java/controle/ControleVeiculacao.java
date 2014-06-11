/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import entidade.dominio.Anuncio;
import entidade.dominio.Localidade;
import entidade.personagens.Cliente;
import java.util.ArrayList;

/**
 *
 * @author nicolas
 */
public class ControleVeiculacao {
   
    private ArrayList<Anuncio> listaDeAnuncios;
    private static ControleVeiculacao instance = null;
     
    public ControleVeiculacao(){
        this.listaDeAnuncios = new ArrayList<>();
        mock();
   
    }
   
    public static ControleVeiculacao getInstance(){
        if (instance == null) {
            instance = new ControleVeiculacao();
        }
        return instance;
    }
    
    //Por enquanto não esta usando o BD
    private void mock(){
                
        Anuncio a1 = new Anuncio();
        Localidade l1 = new Localidade("Shopping Iguatemi", 1);
        a1.setLocalidade(l1);
        a1.setId(1);
        a1.setDescricao("Esta é a descrição do anúncio 1");
        a1.setNumeroMeses(24);
        a1.setTitulo("Este é o título do anúncio 1");        
        a1.getCliente().setId(10);
        this.listaDeAnuncios.add(a1);
        
        Anuncio a2 = new Anuncio();
        Localidade l2 = new Localidade("Shopping Beira-Mar", 1);
        a2.setLocalidade(l2);
        a2.setId(1);
        a2.setDescricao("Esta é a descrição do anúncio 2");
        a2.setNumeroMeses(24);
        a2.setTitulo("Este é o título do anúncio 2");        
        a2.setId(2);
        a2.getCliente().setId(20);
        this.listaDeAnuncios.add(a2);
        
        Anuncio a3 = new Anuncio();  
        Localidade l3 = new Localidade("Shopping Itaguaçu", 1);
        a3.setLocalidade(l3);
        a3.setId(1);
        a3.setDescricao("Esta é a descrição do anúncio 3");
        a3.setNumeroMeses(24);
        a3.setTitulo("Este é o título do anúncio 3");        
        a3.setId(3);
        a3.getCliente().setId(30);    
        this.listaDeAnuncios.add(a3);   
        
    }
    
    public void atualizarVeiculacao(Anuncio veiculacao)
    {  int i = 0;     
       for (Anuncio a: this.listaDeAnuncios)
       {
           if(a.getId() == veiculacao.getId())
               this.listaDeAnuncios.set(i, veiculacao);
           i++;                 
       }
    }
   
    public void cadastrarVeiculacao(Anuncio veiculacao)
    {
        this.listaDeAnuncios.add(veiculacao);
    }
   
    public ArrayList<Anuncio> listarTodasVeiculacoes(){
        return listaDeAnuncios;
    }
       
    public ArrayList<Anuncio> listarVeiculacoesPorLocalidade(Localidade localidade){
        ArrayList<Anuncio> veiculacoesPorLocalidade = new ArrayList<>();
       
        for (Anuncio a: this.listaDeAnuncios){
            if (a.getLocalidade().equals(localidade))
                veiculacoesPorLocalidade.add(a);           
        }
       
        return veiculacoesPorLocalidade;
    }
   
    public Anuncio recuperarVeiculacao(int id){
               
       for (Anuncio a: this.listaDeAnuncios)
       {
           if(a.getId() == id)
               return a;
                   
       }
        return null;
    }
    

    
}