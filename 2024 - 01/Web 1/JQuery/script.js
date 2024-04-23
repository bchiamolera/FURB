// URL1: https://viacep.com.br/ws/89012190/json/
//                                 cep
//
// URL2: https://viacep.com.br/ws/SP/Sao%20Paulo/Avenida%20Paulista/json/
//                                uf localidade     logradouro
//
// Requisição: GET -> Serve para buscar informações em um servidor web através de uma URL específica.
//
// Resposta: Objeto JSON com as informações do CEP.
//
/* Retorno: {
  "cep": "",
  "logradouro": "",
  "complemento": "",
  "bairro": "",
  "localidade": "",
  "uf": "",
  "ibge": "",
  "gia": "",
  "ddd": "",
  "siafi": ""
}
*/

async function buscarInfo() {
    let cep = document.getElementById('cepInput').value;
    let apiUrl = 'https://viacep.com.br/ws/' + cep + '/json/';

    try {
        const response = await fetch(apiUrl);
        if (!response.ok) {
            throw new Error("Erro ao buscar o CEP");
        }
        const data = await response.json();
        console.log(data);
        document.getElementById('cep').innerText = data.cep;
        document.getElementById('logradouro').innerText = data.logradouro;
        document.getElementById('bairro').innerText = data.bairro;
        document.getElementById('localidade').innerText = data.localidade;
        document.getElementById('uf').innerText = data.uf;
        document.getElementById('ibge').innerText = data.ibge;
        document.getElementById('gia').innerText = data.gia;
        document.getElementById('ddd').innerText = data.ddd;
        document.getElementById('siafi').innerText = data.siafi;
    } catch (error) {
        alert('Erro ao buscar o CEP', error);
    }
}

async function buscarCep() {
    let uf = document.getElementById('ufInput').value;
    let localidade = document.getElementById('localidadeInput').value;
    let logradouro = document.getElementById('logradouroInput').value;

    let apiUrl = 'https://viacep.com.br/ws/' + uf + '/' + localidade + '/' + logradouro + '/json/';

    try {
        const response = await fetch(apiUrl);
        if (!response.ok) {
            throw new Error("Erro ao buscar o CEP");
        }
        const data = await response.json();
        console.log(data);
        document.getElementById('cep').innerText = data[0].cep;
        document.getElementById('logradouro').innerText = data[0].logradouro;
        document.getElementById('bairro').innerText = data[0].bairro;
        document.getElementById('localidade').innerText = data[0].localidade;
        document.getElementById('uf').innerText = data[0].uf;
        document.getElementById('ibge').innerText = data[0].ibge;
        document.getElementById('gia').innerText = data[0].gia;
        document.getElementById('ddd').innerText = data[0].ddd;
        document.getElementById('siafi').innerText = data[0].siafi;
    } catch (error) {
        alert('Erro ao buscar o CEP', error);
    }

}