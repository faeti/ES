/* ............................................................... */
/* funções genéricas:*/

function numeroMaxCaracteres(componente, componenteAviso, tamanho) {
    var valor = componente.value;
    if ((valor !== null) && (valor.length > tamanho)) {
        componente.value = valor.substring(0, tamanho);

        var aviso = document.getElementById(componenteAviso);

        if (aviso !== null) {
            aviso.innerHTML = "máximo de caractéres é " + tamanho;
        }

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

    if (idPonto.value === "" || ipPonto.value === "" || macPonto.value === "") {
        var campos = "";
        var erros = 0;

        if (idPonto.value === "") {
            campos += "identicação do ponto\n";
            erros++;
        }

        if (ipPonto.value === "") {
            campos += "IP\n";
            erros++;
        }

        if (macPonto.value === "") {
            campos += "MAC\n";
            erros++;
        }

        var msg;

        if (erros !== 0) {
            msg = "Os seguintes campos são obrigatórios:";
        } else {
            msg = "O seguinte campo é obrigatório:";
        }

        alert(msg + "\n\n" + campos);

        return false;
    }

    if (ipPonto.value !== "" && !validaEnderecoIP(ipPonto)) {
        return false;
    }

    if (macPonto.value !== "" && !validaEnderecoMAC(macPonto)) {
        return false;
    }

    return true;
}

function validaEnderecoIP(endereco) {
    var ipFormat = /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;

    var valido;

    if (endereco.value.match(ipFormat)) {
        valido = true;
    } else {
        var sug = "aaa.bbb.ccc.ddd";
        alert("O campo IP não está preenchido corretamente!\n\n" + sug);
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
        var sug = "aa:bb:cc:dd:ee:ff";
        alert("O campo MAC não está preenchido corretamente!\n\n" + sug);
        valido = false;
    }

    return valido;
}

function cancelaCamposCadastroPonto() {
    return confirm("As alterações serão perdidas, deseja continuar?");
}

function confirmaExcluirPonto() {
    var idPonto = document.getElementById("idPonto");
    var ipPonto = document.getElementById("ipPonto");
    var macPonto = document.getElementById("macPonto");
    
    var ponto = idPonto.value + " - " + ipPonto.value + " - " + macPonto.value;
    
    return confirm("Deseja excluir este registro?\n\n" + ponto);
}

/* ............................................................... */