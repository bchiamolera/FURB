// Feito Por Bernardo Chiamolera, Grégori Pintarelli e Ricardo Sasse
function entrar() { // Checa se o email está vazio antes de deixar o usuário entrar
    if (document.getElementById("email").value == "") {
        alert("O email não pode ser vazio!")
        return
    }
    document.location.href = "./Filmes"
}