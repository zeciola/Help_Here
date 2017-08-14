var tipo = document.querySelector('#tipo');
var tipotext = tipo.textContent;
var contadorVolun = document.querySelector('#volun');
var contadorDoac = document.querySelector('#doar');

var re = new RegExp("A-Za-z");

console.log('antes do if');
if(tipotext == "Voluntario"){
    console.log('entrou if');
    contadorVolun.classList.remove('paraExibicao');
}

console.log('antes do if 2');
if(tipotext == "Doacao"){
    console.log('entrou if');
    contadorDoac.classList.remove('paraExibicao');
}