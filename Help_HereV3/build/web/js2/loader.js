var porcent = document.querySelector('#porcentagem');
console.log(porcent);
var conteudotxt = porcent.textContent;
console.log(conteudotxt);
var n = Number(conteudotxt);
console.log(n);

$('.loader2').ClassyLoader({
    percentage: n,
    speed: 8,
    diameter: 70,
    showText: true,
    fontSize: '20px',
    roundedLine: true,
    fontColor: 'rgba(73, 125, 164, 0.3)',
    lineColor: 'rgba(73, 125, 164, 1)',
    remainingLineColor: 'rgba(73, 125, 164, 0.1)',
    lineWidth: 25
});