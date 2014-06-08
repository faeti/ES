/* ............................................................... */
/* validação campos de cadastro de ponto: */

function validaCamposCadastroPonto() {
    if (document.getElementById("idPonto").value === "" ||
            document.getElementById("ipPonto").value === "" ||
            document.getElementById("macPonto").value === "") {
        alert("Todos os campos devem ser preenchidos");
        
        return false;
    }

    return true;
}

/* ............................................................... */