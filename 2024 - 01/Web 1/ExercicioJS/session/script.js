let input = document.getElementById('inNome');

if (sessionStorage.getItem('nome') != null) {
    loadNome();
}

function saveNome() {
    let nome = input.value;
    sessionStorage.setItem('nome', nome);
    document.getElementById('nome').innerText = nome;
}

function loadNome() {
    let nome = sessionStorage.getItem('nome');
    document.getElementById('nome').innerText = nome;
}