let input = document.getElementById('inNome');

var nomeLoad = document.cookie;

if (nomeLoad != "") {
    document.getElementById('nome').innerText = nomeLoad.split('=')[1];
}

function saveNome() {
    var nome = input.value;
    document.cookie = "nome=" + nome + "; expires=Thu, 18 Dec 2025 12:00:00 UTC";
    document.getElementById('nome').innerText = nome;
}