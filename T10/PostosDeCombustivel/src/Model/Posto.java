package Model;

/**
 *
 * @author LucasLima
 */
public class Posto {
    private int id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String bandeira;
    private String endereco;
    private String bairro;
    private String cep;
    private String imagem;
    
    public Posto(){
        this.id = 0;
        this.cnpj = "";
        this.razaoSocial = "";
        this.nomeFantasia = "";
        this.bandeira = "";
        this.endereco = "";
        this.bairro = "";
        this.cep = "";
        this.imagem = "";
    }

    public Posto(int id, String cnpj, String razaoSocial, String nomeFantasia, String bandeira, String endereco, String bairro, String cep, String imagem) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.bandeira = bandeira;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.imagem = imagem;
    }

    public Posto(int id, String cnpj, String razaoSocial, String nomeFantasia, String bandeira, String endereco, String bairro, String cep) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.bandeira = bandeira;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.imagem = "";
    }
    
    
    // Métodos Getter e Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
