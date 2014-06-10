
package entidade.dominio;

public class Pagamento {

    private boolean pago;
    private final int id;
    private double valor;
    
    public Pagamento(int id, double valor) {
        pago = false;
        this.id = id;
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }
    
    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
