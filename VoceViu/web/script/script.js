/* ............................................................... */
/* funções genéricas:*/

function numeroMaxCaracteres(componente, componenteAviso, tamanho) {
    var valor = componente.value;
    if ((valor !== null) && (valor.length > tamanho)) {
        componente.value = valor.substring(0, tamanho);
        document.getElementById(componenteAviso).innerHTML = "máximo de caractéres é " + tamanho;
        return false;
    } else {
        document.getElementById(componenteAviso).innerHTML = "";
        return true;
    }
}

/* ............................................................... */
/* validação campos de cadastro de ponto: */

function validaCamposCadastroPonto() {
    var idPonto = document.getElementById("idPonto");
    var ipPonto = document.getElementById("ipPonto");
    var macPonto = document.getElementById("macPonto");
    
    var valido = true;
    
    if (idPonto.value === "" || ipPonto.value === "" || macPonto.value === "") {
        alert("Todos os campos devem ser preenchidos!");
        valido = false;
    }

    if (ipPonto.value !=="" && !validaEnderecoIP(ipPonto)) {
        valido = false;
    }

    if (macPonto.value !=="" && !validaEnderecoMAC(macPonto)) {
        valido = false;
    }

    return valido;
}

function validaEnderecoIP(endereco) {
    var ipFormat = /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
    
    var valido;
    
    if (endereco.value.match(ipFormat)) {
        valido = true;
    } else {
        alert("Endereço de IP inválido!");
        valido = false;
    }
    
    return valido;
}

function validaEnderecoMAC(endereco) {
    var macFormat = /^([0-9a-f]{1,2}[\.:-]){5}([0-9a-f]{1,2})$/;
    
    var valido;
    
    if (endereco.value.match(macFormat)) {
        valido = true;
    } else {
        alert("Endereço de MAC inválido!");
        valido = false;
    }
    
    return valido;
}

/* ............................................................... */