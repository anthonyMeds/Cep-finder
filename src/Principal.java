import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        ConsultaCep consultaCep = new ConsultaCep();

//        Ler cep desejado
        System.out.println("Digite um número de cep: ");
        var cep = leitura.nextLine();

        try {
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            System.out.println(novoEndereco);
//            Gerar arquivo com endereço
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);

        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
        }


    }
}