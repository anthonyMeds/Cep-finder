import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    public void salvaJson( Endereco endereco) throws IOException {
//        Transformar o endereço em JSON = tojson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

//        A cada novo cep , um novo arquivo , FileWriter gera exceções = Throws IOexception
        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        escrita.write(gson.toJson(endereco));
        escrita.close();


    }
}
