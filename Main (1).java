import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        Scanner scannerPessoas = new Scanner(System.in);

        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Scanner scannerProdutos = new Scanner(System.in);

        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        int decisao = 0;

        while (!sair) {
            System.out.println("");
            System.out.println("----------------------------------------");
            System.out.println("[1] - Adicionar cliente");
            System.out.println("[2] - Excluir cliente");
            System.out.println("[3] - Buscar clinte");
            System.out.println("[4] - Adicionar produto");
            System.out.println("[5] - Excluir produto");
            System.out.println("[6] - Buscar produto");
            System.out.println("[7] - Estatísticas de clientes");
            System.out.println("[8] - Estatísticas de produtos");
            System.out.println("[0] - Sair");
            System.out.println("----------------------------------------");
            System.out.println("");

            try {
                decisao = scanner.nextInt();
                scanner.nextLine();
                System.out.println("");
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("");
                System.out.println("Opção inválida! Digite um número válido.");
                decisao = scanner.nextInt();
            }

            switch (decisao) {

                case 1: {
                    //ADICIONAR CLIENTE

                    System.out.print("Digite o nome: ");
                    String nome = scannerPessoas.nextLine();
                    while (!nome.matches("[a-zA-ZÀ-ú ]+")) {
                        System.out.println("");
                        System.out.print("Nome inválido! Digite novamente: ");
                        System.out.println("");
                        nome = scannerPessoas.nextLine();
                    }

                    long cpf = 0, cep = 0, tel = 0;
                    int idade = 0;
                    boolean cpfExistente;

                    do {
                        System.out.print("Digite o CPF: ");
                        try {
                            cpf = Long.parseLong(scannerPessoas.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("");
                            System.out.println("Formato inválido! Digite novamente.");
                            cpf = Long.parseLong(scannerPessoas.nextLine());
                        }

                        cpfExistente = false;

                        for (Pessoa e : pessoas) {
                            if (((Cliente) e).getCpf() == cpf) {
                                cpfExistente = true;
                                break;
                            }
                        }

                        if (cpfExistente) {
                            System.out.println("");
                            System.out.println("CPF inválido. Digite novamente.");
                        }
                    } while (cpfExistente);

                    System.out.print("Digite a idade: ");
                    {
                        try {
                            idade = Integer.parseInt(scannerPessoas.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("");
                            System.out.println("Formato inválido! Digite novamente.");
                            idade = Integer.parseInt(scannerPessoas.nextLine());
                        }
                    }

                    System.out.print("Digite o CEP: ");
                    try {
                        cep = Long.parseLong(scannerPessoas.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("");
                        System.out.println("Formato inválido! Digite novamente.");
                        cep = Long.parseLong(scannerPessoas.nextLine());
                    }

                    System.out.print("Digite o telefone: ");
                    try {
                        tel = Long.parseLong(scannerPessoas.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("");
                        System.out.println("Formato inválido! Digite novamente.");
                        tel = Long.parseLong(scannerPessoas.nextLine());
                    }

                    Cliente c = new Cliente(nome, idade, cep, tel, cpf);
                    pessoas.add(c);
                }break;

                case 2: {
                    // EXCLUIR CLIENTE
                    System.out.println("Digite o CPF do cliente que você deseja excluir: ");
                    long clienteExc = Long.parseLong(scannerPessoas.nextLine());
                    System.out.println("");

                    boolean clienteEncontrado = false;

                    for (Pessoa e : pessoas) {
                        if (e.getCpf() == clienteExc) {
                            clienteEncontrado = true;
                            System.out.println("Esse é o cliente que deseja excluir?: ");
                            System.out.println(e.getNome());
                            System.out.println(e.getCpf());
                            System.out.println("");
                            System.out.println("Se sim - Tecle [s]");
                            System.out.println("Se não - Tecle [qualquer tecla]");
                            char confirmacao = scannerPessoas.next().charAt(0);
                            if (confirmacao == 's') {
                                try {
                                    pessoas.remove(e);
                                    System.out.println("Cliente removido com sucesso!");
                                } catch (NumberFormatException nfe) {
                                    System.out.println("");
                                    System.out.println("Erro");
                                }
                            } else
                                System.out.println("Esse cliente não sera excluido");
                            break;
                        }
                    }
                }break;

                case 3: {
                    //BUSCAR CLIENTE

                    int modoDeBusca;

                    System.out.println("Como vc deseja buscar clientes?");
                    System.out.println("[1] CPF");
                    System.out.println("[2] Nome");

                    try {
                        modoDeBusca = Integer.parseInt(scannerPessoas.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("");
                        System.out.println("Formato inválido! Digite novamente.");
                        modoDeBusca = Integer.parseInt(scannerPessoas.nextLine());
                    }

                    switch (modoDeBusca) {

                        case 1: {
                            //BUSCA POR CPF

                            long clientePesqCpf = 0;

                            System.out.println("Digite o CPF do cliente que você deseja buscar: ");
                            try {
                                clientePesqCpf = Long.parseLong(scannerPessoas.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("");
                                System.out.println("Formato inválido! Digite novamente.");
                                clientePesqCpf = Long.parseLong(scannerPessoas.nextLine());
                            }

                            boolean clienteEncontrado = false;

                            for (Pessoa e : pessoas) {
                                if (e.getCpf() == clientePesqCpf) {
                                    clienteEncontrado = true;
                                    e.exibir();
                                    break;
                                }
                            }

                            if (!clienteEncontrado) {
                                System.out.println("");
                                System.out.println("Cliente não foi encontrado");
                            }

                            System.out.println("");

                        }break;

                        case 2: {
                            //BUSCA POR NOME

                            String clientePesqNome;

                            System.out.println("Digite o nome do cliente que você deseja buscar: ");
                            clientePesqNome = scannerPessoas.nextLine();
                            System.out.println("");

                            boolean clienteEncontrado = false;

                            for (Pessoa e : pessoas) {
                                if (e.getNome().toLowerCase().contains(clientePesqNome.toLowerCase())) {
                                    clienteEncontrado = true;
                                    e.exibir();
                                    System.out.println("");
                                    break;
                                }
                            }
                            if (!clienteEncontrado) {
                                System.out.println("");
                                System.out.println("Cliente não encontrado");
                                System.out.println("");
                            }
                        }
                        break;
                    }
                }break;

                case 4: {
                    // ADICIONAR PRODUTO

                    System.out.print("Digite o nome: ");
                    String nome = scannerProdutos.nextLine();
                    while (!nome.matches("[a-zA-ZÀ-ú0-9 ]+")) {
                        System.out.println("");
                        System.out.print("Nome inválido! Digite novamente: ");
                        System.out.println("");
                        nome = scannerProdutos.nextLine();
                        System.out.println("");
                    }

                    int codigo;
                    boolean codigoExistente;

                    do {
                        System.out.print("Digite o código: ");
                        try {
                            codigo = Integer.parseInt(scannerProdutos.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("");
                            System.out.println("Codigo inválido! Digite novamente:");
                            codigo = Integer.parseInt(scannerProdutos.nextLine());
                            System.out.println("");
                        }

                        codigoExistente = false;

                        for (Produto produto : produtos) {
                            if (produto.getCodigo() == codigo) {
                                codigoExistente = true;
                                break;
                            }
                        }

                        if (codigoExistente) {
                            System.out.println("");
                            System.out.println("Código inválido. Digite novamente.");
                        }
                    } while (codigoExistente);

                    System.out.print("Digite a descrição: ");
                    String descricao = scannerProdutos.nextLine();
                    while (!descricao.matches("[a-zA-ZÀ-ú1-9 ]+")) {
                        System.out.println("");
                        System.out.print("Descrição inválida! Digite novamente: ");
                        System.out.println("");
                        descricao = scanner.nextLine();
                        System.out.println("");
                    }

                    double preco = 0;

                    do {
                        System.out.print("Digite o preço: ");
                        try {
                            preco = Double.parseDouble(scannerProdutos.nextLine());
                        } catch (NumberFormatException | InputMismatchException e) {
                            if (preco <= 0) {
                                System.out.println("");
                                System.out.println("Preço inválido! Digite novamente:");
                                preco = Double.parseDouble(scannerProdutos.nextLine());
                                System.out.println("");
                            }
                        }
                    } while (preco <= 0);

                    System.out.print("Digite a plataforma: ");
                    String plataforma = scannerProdutos.nextLine();
                    while (!plataforma.matches("[a-zA-ZÀ-ú1-9 ]+")) {
                        System.out.println("");
                        System.out.print("Plataforma inválida! Digite novamente: ");
                        System.out.println("");
                        plataforma = scanner.nextLine();
                        System.out.println("");
                    }

                    System.out.print("Digite a desenvolvedora: ");
                    String desenvolvedora = scannerProdutos.nextLine();
                    while (!desenvolvedora.matches("[a-zA-ZÀ-ú1-9 ]+")) {
                        System.out.println("");
                        System.out.print("Desenvolvedora inválida! Digite novamente: ");
                        System.out.println("");
                        desenvolvedora = scanner.nextLine();
                        System.out.println("");
                    }

                    Produto p = new Produto(codigo, descricao, preco, plataforma, nome, desenvolvedora);
                    produtos.add(p);

                }
                break;

                case 5: {
                    //EXCLUIR PRODUTO

                    long produtoPesq = 0;

                    System.out.println("Digite o código do produto que você deseja excluir: ");

                    try {
                        produtoPesq = Long.parseLong(scannerProdutos.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("");
                        System.out.println("Formato inválido! Digite novamente.");
                        produtoPesq = Long.parseLong(scannerProdutos.nextLine());
                    }

                    for (Produto e : produtos) {
                        if (e.getCodigo() == produtoPesq) {
                            e.exibirProduto();
                        }
                        System.out.println("Esse é o produto que deseja excluir?: ");
                        System.out.println(e.getNome());
                        System.out.println(e.getCodigo());
                        System.out.println("Se sim - Tecle [S] / Se não - Tecle qualquer tecla");
                        char confirmacao = scanner.next().charAt(0);
                        if (confirmacao == 's') {
                            try {
                                produtos.remove(e);
                                System.out.println("Produto removido com sucesso!");
                            } catch (NumberFormatException nfe) {
                                System.out.println("Erro");
                            }
                        } else {
                            System.out.println("");
                            System.out.println("Produto não foi encontrado");
                        }
                    }
                    System.out.println("");
                    System.out.println("");

                    break;
                }

                case 6: {
                    // PESQUISAR PRODUTO

                    int modoDeBusca = 0;
                    int produtoPesqCod = 0;
                    String produtoPesqDesc;

                    System.out.println("Como deseja buscar o produto?");
                    System.out.println("[1] Código");
                    System.out.println("[2] Descrição");

                    try {
                        modoDeBusca = scanner.nextInt();
                    } catch (NumberFormatException e){
                        System.out.println("");
                        System.out.println("Formato inválido! Digite novamente.");
                        modoDeBusca = Integer.parseInt(scannerPessoas.nextLine());
                    }

                    switch (modoDeBusca) {
                        case 1: {
                            // BUSCA POR CÓDIGO

                            System.out.println("Digite o código do produto que você deseja buscar: ");
                            try {
                                produtoPesqCod = Integer.parseInt(scannerPessoas.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("");
                                System.out.println("Formato inválido! Digite novamente.");
                                produtoPesqCod = Integer.parseInt(scannerPessoas.nextLine());
                            }

                            boolean produtoEncontrado = false;

                            for (Produto e : produtos) {
                                if (e.getCodigo() == produtoPesqCod) {
                                    produtoEncontrado = true;
                                    e.exibirProduto();
                                    System.out.println("");
                                }
                            }

                            if (!produtoEncontrado) {
                                System.out.println("");
                                System.out.println("Produto não foi encontrado");
                                System.out.println("");
                            }
                        } break;

                        case 2: {
                            // BUSCA POR DESCRIÇÃO
                            System.out.println("Digite a descrição que você deseja buscar: ");
                            String produtoPesq = scanner.nextLine();

                            boolean produtoEncontrado = false;

                            for (Produto e : produtos) {
                                if (e.getDescricao().toLowerCase().contains(produtoPesq.toLowerCase())) {
                                    produtoEncontrado = true;
                                    e.exibirProduto();
                                    System.out.println("");
                                }
                            }

                            if (!produtoEncontrado) {
                                System.out.println("");
                                System.out.println("Nenhum produto encontrado com essa descrição");
                                System.out.println("");
                            }
                        }break;
                    }
                }break;

                case 7: {
                    //ESTATISTICAS DE CLIENTES

                    int decisaoMetodo1;

                    if (pessoas.size() == 0) {
                        System.out.println("Sem clientes registrados");
                        break;
                    }

                    System.out.println("[1] Cliente de maior idade");
                    System.out.println("[2] Quantidade de clientes menores de idade");
                    System.out.println("[3] Idade média dos clientes");

                    try {
                        decisaoMetodo1 = scanner.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.println("Formato inválido! Digite novamente.");
                        decisaoMetodo1 = scanner.nextInt();
                    }

                    switch (decisaoMetodo1) {
                        case 1: {
                            //Cliente de maior idade
                            int maiorIdade = 0;
                            for (Pessoa e : pessoas) {
                                if (e.getIdade() >= maiorIdade) {
                                    maiorIdade = e.getIdade();
                                }
                            }
                            for (Pessoa e : pessoas) {
                                if (maiorIdade == e.getIdade()) {
                                    e.exibir();
                                    System.out.println("");
                                }

                            }
                        }
                        break;


                        case 2: {
                            //Quantidade de clientes menores de idade
                            int quantidaMenoresDeIdade = 0;
                            for (Pessoa e : pessoas) {
                                if (e.getIdade() < 18) {
                                    quantidaMenoresDeIdade++;
                                }
                            }
                            System.out.println("Quantidade de clientes menores de idade: " + quantidaMenoresDeIdade);
                            System.out.println("");
                        }
                        break;

                        case 3: {
                            // Idade média dos clientes

                            int soma = 0;

                            for (Pessoa e : pessoas) {
                                soma += e.getIdade();
                            }
                            int media = soma / pessoas.size();
                            System.out.println("Média de idades: " + media);
                            System.out.println("");
                        }
                        break;
                    }
                    break;
                }

                case 8: {
                    //ESTATISTICAS DE PRODUTOS

                    int decisaoMetodo2;

                    if(produtos.size()==0){
                        System.out.println("Sem produtos registrados");
                        break;
                    }

                    System.out.println("[1] Produto/Serviço mais barato");
                    System.out.println("[2] Média de preços");
                    System.out.println("[3] Produtos acima da média");

                    try {
                        decisaoMetodo2 = scanner.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.print("Digite novamente: ");
                        decisaoMetodo2 = scanner.nextInt();
                    }

                    switch (decisaoMetodo2) {
                        case 1: {
                            //Produto/Serviço mais barato
                            double produtoMaisBarato = produtos.get(0).getPreco();
                            for (Produto e : produtos) {
                                if (e.getPreco() <= produtoMaisBarato) {
                                    produtoMaisBarato = e.getPreco();
                                }
                            }
                            for (Produto e : produtos) {
                                if (produtoMaisBarato == e.getPreco()) {
                                    e.exibirProduto();
                                    System.out.println("");
                                }

                            }

                        } break;

                        case 2: {
                            //Média de preços
                            int media = 0, soma = 0;
                            for (Produto e : produtos) {
                                soma += e.getPreco();
                            }
                            media = soma / produtos.size();
                            System.out.println("Média de preço: " + media);
                            System.out.println("");
                        }break;

                        case 3: {
                            //Produtos acima da média
                            int somaAcima = 0;
                            int media = 0, soma = 0;
                            for (Produto e : produtos) {
                                soma += e.getPreco();
                                media = soma / produtos.size();
                            }
                            for (Produto e : produtos) {
                                if (e.getPreco() > media) {
                                    somaAcima++;
                                }

                            }
                            System.out.println("Quatidade de produtos com o preço acima da média: " + somaAcima);
                            System.out.println("");
                        }break;
                    }
                }break;

                case 0: {
                    sair = true;
                    System.out.println("Programa encerrado.");
                }break;

                default: {
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    System.out.println("");
                    break;
                }
            }

        }
    }
}