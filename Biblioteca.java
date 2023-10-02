import javax.swing.plaf.synth.SynthToolBarUI;

public class Biblioteca{
    
        private Livro[] acervo;
        private int capacidadeMaxima;
        private int qtdLivros;
        
        public Biblioteca(int capacidadeMaxima) {
            this.acervo = new Livro[capacidadeMaxima];
            this.capacidadeMaxima = capacidadeMaxima;
            this.qtdLivros = 0;
        }

        public boolean insereLivro(Livro livro){
            if(qtdLivros < capacidadeMaxima){
                acervo[qtdLivros] = livro;
                qtdLivros++;
                return true;
            }
            return false;
        }


        public Livro consultaLivroISBN(String isbn){
            for (int i = 0; i < qtdLivros; i++) {
                if(acervo[i].equals(isbn)){
                    return acervo[i];
                }
                
            }
            System.out.println("O livro que você deseja consultar não possui no acervo");
            return null;
        }

        public void atualizaLivroAutor(String isbn, String novoAutor){
            for (int i = 0; i < qtdLivros; i++) {
                if(acervo[i].equals(isbn)){
                    acervo[i].setAutor(novoAutor);
                    System.out.println("Autor atualizado com sucesso");
                }
                
            }
            System.out.println("O o livro não foi encontrado");
        }

        public boolean removeLivro(String isbn){
            for (int i = 0; i < qtdLivros; i++) {
                if(acervo[i].equals(isbn)){
                    for (int j = 0; j < qtdLivros - 1; j++) {
                        acervo[j]=acervo[j+1];

                    } 
                    acervo[qtdLivros-1] = null;
                        qtdLivros--;
                        System.out.println("Livro removido com sucesso");
                        return true;
                }
                
            }
            return false;
        }

        public void listarLivros(){
             if(qtdLivros == 0){
                System.out.println("Não há livros para listar");
             }else{
                for (int i = 0; i < acervo.length; i++) {
                    Livro livro = acervo[i];
                    System.out.println(livro);
                }
             }
        }
}

        

