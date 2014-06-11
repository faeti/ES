package entidade.dominio;

import entidade.personagens.Cliente;
import java.io.File;
import java.util.Date;

public class Anuncio {

    private boolean aprovado;
    private File arquivoMedia;
    private Date dataInicio;
    private int numeroMeses;
    private String titulo;
    private String descricao;
    private int id;
    private Localidade localidade;
    private Cliente cliente;
    
    public Anuncio() {
        aprovado = false;
        this.localidade = new Localidade();
        this.cliente = new Cliente();
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public File getArquivoMedia() {
        return arquivoMedia;
    }

    public void setArquivoMedia(File arquivoMedia) {
        this.arquivoMedia = arquivoMedia;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getNumeroMeses() {
        return numeroMeses;
    }

    public void setNumeroMeses(int numeroMeses) {
        this.numeroMeses = numeroMeses;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString(){
       
        return "Anúncio:" +
                "\nTitulo: " + this.getTitulo() + 
                "\nId:" + this.getId() + 
                "\nDescricao: " + this.getDescricao() + 
                "\nData de início: " + this.getDataInicio() +
                "\nNúmero de meses: " + this.getNumeroMeses() + 
                "\n\nLocalidade: \n" + this.getLocalidade().toString() + 
                "\n\nCliente: " + this.getCliente().toString();
    }
    
}
