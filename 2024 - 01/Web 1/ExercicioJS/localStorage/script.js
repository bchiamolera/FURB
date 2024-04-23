var qtdLinhas = 0;

qtdLinhas = localStorage.getItem("qtdLinhas");

if (qtdLinhas > 0) {
  for (let i = 0; i < qtdLinhas; i++) {
    onLoad();
  }
}

function onLoad() {
  var table = document.getElementById("tabela");
  var row = document.createElement("tr");
  var data = document.createElement("td");
  data.style = "border: 1px solid black; width: 100px; height: 10px;";
  row.appendChild(data);
  table.appendChild(row);
}

function addLinha() {
  var table = document.getElementById("tabela");
  var row = document.createElement("tr");
  var data = document.createElement("td");
  data.style = "border: 1px solid black; width: 100px; height: 10px;";
  row.appendChild(data);
  table.appendChild(row);
  qtdLinhas++;
  console.log(qtdLinhas);
}

function salvaLinhas() {
  localStorage.setItem("qtdLinhas", document.getElementById("tabela").childElementCount);
}
