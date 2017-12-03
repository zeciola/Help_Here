var volun = document.querySelector("#campvolunparti");
var doar = document.querySelector("#campvaldoar");

function Mostra1() {
    console.log("função mostra 1");
    doar.classList.add("paraExibicao");
    volun.classList.remove("paraExibicao");
}


function Mostra2() {
    console.log("função mostra 2");
    volun.classList.add("paraExibicao");
    doar.classList.remove("paraExibicao");
}

