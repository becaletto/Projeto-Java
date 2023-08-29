import java.util.Scanner;

public abstract class Pessoa implements IPessoa {

    private String nome;
    private int idade;
    private long cep, tel, cpf;

    public Pessoa(String nome, int idade, long cep, long tel, long cpf) {

        Scanner scanner = new Scanner(System.in);

        this.nome=nome;

        if(cpf<= 0) {
            System.out.println("");
            System.out.println("CPF invalido! Digite novamente: ");
            cpf = Long.parseLong(scanner.nextLine());
            this.cpf = cpf;
        } else {
            this.cpf = cpf;
        }

            if (idade < 12 || idade > 120) {
                System.out.println("");
                System.out.println("Idade inválida! Digite novamente: ");
                idade = Integer.parseInt(scanner.nextLine());
                this.idade = idade;
        } else {
            this.idade = idade;
    }

        if(cep<= 0) {
            System.out.println("");
            System.out.println("CEP invalido! Digite novamente: ");
            cep = Long.parseLong(scanner.nextLine());
            this.cep = cep;
        } else {
            this.cep = cep;
        }


        if (tel <= 0){
            System.out.println("");
            System.out.println("Telefone invalido! Digite novamente: ");
            tel = Long.parseLong(scanner.nextLine());
            this.tel = tel;
        } else {
            this.tel = tel;
        }

    }

    @Override
    public void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: "+ cpf);
        System.out.println("Idade: " + idade);
        System.out.println( "Telefone: " + tel);
        System.out.println("CEP: " + cep);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }



}