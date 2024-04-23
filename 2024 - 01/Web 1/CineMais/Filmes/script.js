// Feito Por Bernardo Chiamolera, Grégori Pintarelli e Ricardo Sasse
const lista = document.getElementById("listaFilmes")
const titulo = document.getElementById("titulo")
const ano = document.getElementById("ano")
const genero = document.getElementById("genero")
const diretor = document.getElementById("diretor")
const sinopse = document.getElementById("sinopse")
const imagem = document.getElementById("imagem")
var filmes = new Map();
var editarID
var vazio = true

function onLoad() { // Função rodada quando a página carrega. Puxa todos filmes salvados no localStorage, se algum existe
    if (localStorage.getItem("filmes") != null) {
        filmes = new Map(JSON.parse(localStorage.getItem("filmes")));
        for (let filme of filmes) {
            adicionarFilmeHTML(filme[0], filme[1].titulo, filme[1].ano, filme[1].genero, filme[1].diretor, filme[1].sinopse, filme[1].imagem);
        }
        if (filmes.size < 1) setListaVazio();
    }
    else setListaVazio();
}
onLoad();

function randomId() { // Gera um Id aleatório entre 0 e 1000000
    return Math.floor(Math.random() * 1000000)
}

function salvarFilmes() { // Salva o Map de filmes no localStorage
    localStorage.setItem("filmes", JSON.stringify(Array.from(filmes)))
}

function erroDeImagem(img) { // Troca uma imagem que não conseguiu ser carregada por uma imagem padrão de erro
    img.src = '../img/imageError.png'
    img.title = 'O poster não conseguiu ser carregado.'
}

function setListaVazio() { // Mostra a mensagem de "Nenhum filme cadastrado" na lista
    vazio = true
    lista.innerHTML =  `<div class="vazio">
                            <h3>Nenhum filme cadastrado</h3>
                        </div>`
    
}

function divFilmeHTML(filmeId, bordado) { // Retorna o HTML exterior do filme
    if (bordado) return `<div class="filme bordado" data-id="${filmeId}"></div>`
    else return `<div class="filme" data-id="${filmeId}"></div>`
}

function filmeHTML(filmeId, titulo, ano, genero, diretor, sinopse, imagem) { // Retorna o HTML interior do filme
    return `<div class="infoFilmeDiv">
                <img src="${imagem}" alt="Poster" class="imagem" onerror="erroDeImagem(this)">
                <div class="infoFilme">
                    <div class="info1">
                        <h3>${titulo}</h3>
                        <p class="ano">${ano}</p>
                    </div>
                    <div class="info2">
                        <p>${genero}</p>
                        <p>${diretor}</p>
                    </div>
                    <p class="sinopse">${sinopse}</p>
                </div>
            </div>
            <div class="botoes">
                <button class="material-symbols-outlined" onclick="editarFilme(${filmeId})">edit</button>
                <button class="material-symbols-outlined" onclick="deletarFilme(${filmeId})">delete</button>
            </div>`
}

class Filme { // Cria o objeto que guarda as informações do filme
    constructor(titulo, ano, genero, diretor, sinopse, imagem) {
        this.titulo = titulo
        this.ano = ano
        this.genero = genero
        this.diretor = diretor
        this.sinopse = sinopse
        this.imagem = imagem
    }
}

function verificarCampos() { // Verifica todos campos e adiciona ou edita um filme com eles se eles estiverem certos
    let message = "Campos inválidos: "
    if (titulo.value == "") message += "Título, "
    if (ano.value == "" || isNaN(ano.value) || ano.value < 1895) message += "Ano, "
    if (genero.value == "") message += "Gênero, " 
    if (diretor.value == "") message += "Diretor, "
    if (sinopse.value == "") message += "Sinopse, "
    if (imagem.value == "") message += "Imagem, "
    if (message != "Campos inválidos: ") {
        alert(message.slice(0, -2) + ".")
    } else
    {
        let cadastro = document.getElementById("cadastro")
        if (editarID != undefined) { // Editar Cadastro
            let filmeId = editarID
            filmes.set(Number(filmeId), new Filme(titulo.value, ano.value, genero.value, diretor.value, sinopse.value, imagem.value))
            document.querySelector(`[data-id="${filmeId}"]`).innerHTML = filmeHTML(filmeId, titulo.value, ano.value, genero.value, diretor.value, sinopse.value, imagem.value)
            salvarFilmes()
            cadastro.value = "Cadastrar"
            editarID = undefined
        } 
        else { // Adicionar Filme
            cadastrarFilme(titulo.value, ano.value, genero.value, diretor.value, sinopse.value, imagem.value)
        }
        document.getElementById("formCadastro").reset()
    }
}

function cadastrarFilme(titulo, ano, genero, diretor, sinopse, imagem) { // Cadastra um filme novo, adicionando ele no Map e no HTML
    let filmeId = randomId()
    while (filmes.has(filmeId)) {
        filmeId = randomId()
    }
    adicionarFilmeHTML(filmeId, titulo, ano, genero, diretor, sinopse, imagem)
    filmes.set(filmeId, new Filme(titulo, ano, genero, diretor, sinopse, imagem))
    
    localStorage.setItem("filmes", JSON.stringify(Array.from(filmes)))
}

function adicionarFilmeHTML(filmeId, titulo, ano, genero, diretor, sinopse, imagem) { // Adiciona o HTML de um filme
    if (vazio === true) {
        vazio = false
        lista.innerHTML = ""
    }
    lista.insertAdjacentHTML("beforeend", divFilmeHTML(filmeId, lista.childElementCount > 0))
    document.querySelector(`[data-id="${filmeId}"]`).innerHTML = filmeHTML(filmeId, titulo, ano, genero, diretor, sinopse, imagem)
}

function scrollCadastro() { // Rola a página até o menu de cadastro
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    })
}

function scrollLista() { // Rola a página até a lista de filmes
    const rect = document.getElementById("filmes").getBoundingClientRect()
    window.scrollTo({
        top: rect.top + window.scrollY - document.getElementById("header").offsetHeight,
        behavior: 'smooth'
    })
}

function scrollSobre() { // Rola a página até a seção de sobre
    window.scrollTo({
        top: document.body.offsetHeight,
        behavior: 'smooth'
    })
}

function editarFilme(filmeId) { // Botão editar filme
    let filme = filmes.get(filmeId)
    imagem.value = filme.imagem
    titulo.value = filme.titulo
    ano.value = filme.ano
    genero.value = filme.genero
    diretor.value = filme.diretor
    sinopse.value = filme.sinopse

    let cadastro = document.getElementById("cadastro")
    cadastro.value = "Editar: " + filme.titulo
    editarID = filmeId
    scrollCadastro()
}

function deletarFilme(filmeId) { // Botão deletar filme
    if (editarID == filmeId) return
    filmes.delete(filmeId)
    document.querySelector(`[data-id="${filmeId}"]`).remove()
    if (filmes.size > 0) lista.children[0].setAttribute("class", "filme")
    else setListaVazio()
    salvarFilmes()
}