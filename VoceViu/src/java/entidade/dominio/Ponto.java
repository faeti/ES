
package entidade.dominio;

public class Ponto {

    private String id;
    private String IP;
    private String MAC;
    
    public Ponto(String id, String IP, String MAC) {
        this.id = id;
        this.IP = IP;
        this.MAC = MAC;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }    
}
