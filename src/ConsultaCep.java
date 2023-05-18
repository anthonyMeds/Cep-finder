import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
//  consultar endereço e devolver um objeto

    public Endereco buscaEndereco(String cep){
        //    Concatenar url padrao com o cep desejado
        URI endereco = URI.create ("https://viacep.com.br/ws/" + cep + "/json");
//requisição do cep
//        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

//        Resposta
        // código omitido


        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //        Importar Gson
            return new Gson().fromJson(response.body(), Endereco.class);

        } catch (Exception e) {
            throw new RuntimeException ("Não consegui obter o endereço a partir desse CEP.");
        }

    }
}
