package entidade.dominio;

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

    public Anuncio() {
        aprovado = false;
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
}
