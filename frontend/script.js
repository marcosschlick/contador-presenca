// Função para aplicar a máscara de CPF ou documento uruguaio
function mascaraDocumento(campo) {
    var valor = campo.value.replace(/\D/g, ''); // Remove tudo que não é número

    // Limita o número de caracteres a 11
    if (valor.length > 11) {
        valor = valor.substring(0, 11);
    }

    // Verifica se o número é de CPF ou do documento uruguaio
    if (valor.length === 11) {
        // Máscara de CPF (XXX.XXX.XXX-XX)
        valor = valor.replace(/(\d{3})(\d)/, '$1.$2');
        valor = valor.replace(/(\d{3})(\d)/, '$1.$2');
        valor = valor.replace(/(\d{3})(\d{1,2})$/, '$1-$2');
    } else if (valor.length === 8) {
        // Máscara para documento uruguaio (X.XXX.XXX.X)
        valor = valor.replace(/(\d{1})(\d{3})(\d{3})(\d{1})$/, '$1.$2.$3.$4');
    }

    campo.value = valor;
}

// Função chamada quando o botão "Registrar" é clicado
function registrar() {
    var documento = document.getElementById('documento').value;
    
    // Verifica se o documento tem o comprimento correto (8 ou 11 caracteres)
    var numero = documento.replace(/\D/g, ''); // Remove tudo que não é número
    if (numero.length !== 8 && numero.length !== 11) {
        alert('Documento inválido. O número deve ter 8 ou 11 caracteres.');
        return;
    }

    // Se o documento for válido, mostra o alerta de registro
    alert('Documento registrado: ' + documento);
}


// URL base do backend
const BASE_URL = "http://localhost:8080/presenca";

// Função para registrar entrada
function registrar() {
    const documentoInput = document.getElementById("documento");
    const documento = documentoInput.value.trim().replace(/\D/g, ''); // Remove tudo que não é número
  
    if (!documento) {
      alert("Por favor, insira um documento válido.");
      return;
    }
  
    // Tenta registrar saída primeiro
    fetch(`${BASE_URL}/registrar_saida/${documento}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then(response => response.text())
      .then(message => {
        if (message.includes("Saída registrada com sucesso")) {
          alert(message);
          documentoInput.value = ""; // Limpa o campo após sucesso
        } else {
          // Se não foi possível registrar a saída, tenta registrar entrada
          throw new Error(message);
        }
      })
      .catch(error => {
        console.warn("Tentando registrar entrada:", error.message);
  
        // Tenta registrar entrada
        fetch(`${BASE_URL}/registrar/${documento}`, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
        })
          .then(response => response.text())
          .then(message => {
            alert(message);
            documentoInput.value = ""; // Limpa o campo após sucesso
          })
          .catch(err => {
            console.error("Erro ao registrar entrada:", err);
            alert("Houve um problema ao registrar a presença. Tente novamente.");
          });
      });
  }
  
  
  
  