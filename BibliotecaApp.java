import java.util.Scanner;

public class BibliotecaApp{
   
  private Biblioteca biblioteca;  
  private Scanner teclado;
    
  public BibliotecaApp (int valorBiblioteca ){
    this.biblioteca = new Biblioteca(valorBiblioteca);
    this.teclado = new Scanner(System.in);

  }

  private void preCadastrarLivro() {
    System.out.println("------ Pré-Cadastro de Livro ------");
    
    System.out.println("Informe o título do livro:");
    String titulo = teclado.nextLine();
    
    System.out.println("Informe o autor do livro:");
    String autor = teclado.nextLine();
    
    System.out.println("Informe a categoria do livro:");
    String categoria = teclado.nextLine();
    
    System.out.println("Informe o ISBN do livro:");
    String ISBN = teclado.nextLine();
    
    System.out.println("Informe o ano de publicação do livro:");
    int anoPublicacao = teclado.nextInt();
    teclado.nextLine();  // Consumir o restante da linha

    cadastrarLivro(titulo, autor, categoria, ISBN, anoPublicacao);
}


    private void cadastrarLivro(String titulo, String autor, String categoria, String ISBN, int anoPublicacao) {
     
        Livro nv = new Livro(titulo, autor, categoria, ISBN, anoPublicacao);
        if (biblioteca.insereLivro(nv)) {
            System.out.println("Cadastro concluido com sucesso");
        }else{
            System.out.println("O estoque de livros já está cheio");
        }
    }
  
    public void consultarLivro(){
        System.out.println("Informe o ISBN do livro que deseja consultar:");
        String isbn = teclado.nextLine();
       Livro livroEncontrado = biblioteca.consultaLivroISBN(isbn); // verifica se o livro existe
       if (livroEncontrado != null) { // caso seja encontrado pega todas informações dele
        // Imprimir informações do livro
        System.out.println("Livro Encontrado:");
        System.out.println("Título: " + livroEncontrado.getTitulo());
        System.out.println("Autor: " + livroEncontrado.getAutor());
        System.out.println("Categoria: " + livroEncontrado.getCategoria());
        System.out.println("ISBN: " + livroEncontrado.getIsbn());
        System.out.println("Ano de Publicação: " + livroEncontrado.getAnoPublicacao());
    } else { 
        System.out.println("Livro não encontrado com o ISBN fornecido.");
    }
        
    }
    public void removeLivro(){
        System.out.println("Digite o isbn do livro que deseja remover");
        String isbn = teclado.nextLine();
        Boolean resultadBoolean = biblioteca.removeLivro(isbn);
        if(resultadBoolean != true){
            System.out.println("O livro que digitou não foi encontrado para ser removido");
        }else{
            System.out.println("Livro foi removido com sucesso");
        }
    }


    public void atualizaLivroAutor(){
        System.out.println("Digite o isbn que deseja atualizar");
        String isbString= teclado.nextLine();
        System.out.println("Digite o autor que deseja atualizar");
        String autor = teclado.nextLine();
        biblioteca.atualizaLivroAutor(isbString, autor);
    }

    public void listarLivros (){
        biblioteca.listarLivros();
    }


  public void menu(){
    
        System.out.println("------ Menu de Opções ------");
        System.out.println("1 - Cadastrar Livro");
        System.out.println("2 - Consultar Livro");
        System.out.println("3 - Atualizar Autor do Livro");
        System.out.println("4 - Remover Livro");
        System.out.println("5 - Listar Livros");
        System.out.println("0 - Sair");
    
    }

    public void executa(){
        int opcao = -1;
        while(opcao != 0){
         menu();
         System.out.println("Digite a opção desejada para executar");
         opcao = teclado.nextInt();

         switch(opcao){
            case 1:
        preCadastrarLivro();
            case 2:
         consultarLivro();
         case 3:
         atualizaLivroAutor();
         case 4:
         removeLivro();
         case 5:
         listarLivros();
         case 0:
         break;
         }
         

        }
    }






  }
  
  
  
