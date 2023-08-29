import java.util.Scanner;

public class Produto {
    private String descricao;
    private double preco;
    private String plataforma;
    private String nome;
    private String desenvolvedora;
    private int codigo;

    public void exibirProduto() {
        System.out.println("Nome: " + nome);
        System.out.println("Codigo: " + codigo);
        System.out.println("Preço: "+ preco);
        System.out.println("Descrição: " + descricao);
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Desenvolvedora: " + desenvolvedora);
    }

    public Produto(int codigo, String descricao, double preco, String plataforma, String nome, String desenvolvedora) {

        Scanner scanner = new Scanner(System.in);

        if (codigo <= 0) {
            System.out.println("");
            System.out.println("Codigo invalido! Digite novamente: ");
            codigo = scanner.nextInt();
            this.codigo = codigo;
        } else {
            this.codigo = codigo;
        }


        this.descricao = descricao;


        if (preco <= 0) {
            System.out.println("");
            System.out.println("Preço invalido! Digite novamente: ");
            preco = scanner.nextDouble();
            this.preco = preco;
        } else {
            this.preco = preco;
        }


        this.plataforma = plataforma;
        this.nome = nome;
        this.desenvolvedora = desenvolvedora;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descrição) {
        this.descricao = descrição;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preço) {
        this.preco = preço;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }


}