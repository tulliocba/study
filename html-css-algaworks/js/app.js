var alternador = document.querySelector('.js-botao-alternador');

alternador.onclick = function () {
   var menu = document.querySelector('.js-menu');
   menu.classList.toggle('js-menu--exibindo');
}