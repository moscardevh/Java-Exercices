// calculator.js

let visorValue = '0';
let firstOperand = null;
let waitingForSecondOperand = false;
let operator = null;

const visor = document.getElementById('visor');

function updateVisor() {
    visor.textContent = visorValue;
}

// Evento para botões Numéricos
document.querySelectorAll('.js-num').forEach(button => {
    button.addEventListener('click', () => {
        const num = button.value;

        if (num === '.') {
            if (visorValue.includes('.')) return;
        }

        if (waitingForSecondOperand) {
            visorValue = num;
            waitingForSecondOperand = false;
        } else {
            visorValue = visorValue === '0' ? num : visorValue + num;
        }
        updateVisor();
    });
});

// Evento para botões de Operação
document.querySelectorAll('.js-op').forEach(button => {
    button.addEventListener('click', () => {
        const op = button.value;
        const inputValue = parseFloat(visorValue);

        firstOperand = inputValue;
        operator = op;
        waitingForSecondOperand = true;
    });
});

// Botão de Limpar (C)
document.getElementById('btn-clear').addEventListener('click', () => {
    visorValue = '0';
    firstOperand = null;
    waitingForSecondOperand = false;
    operator = null;
    updateVisor();
});

// O "Pulo do Gato": Botão de Igual (=) chamando o Java
document.getElementById('btn-equals').addEventListener('click', async () => {
    if (firstOperand === null || operator === null || waitingForSecondOperand) return;

    const secondOperand = parseFloat(visorValue);
    
    // Preparar os dados para o formato que o Spring @RequestParam entende
    const params = new URLSearchParams();
    params.append('numero1', firstOperand.toString());
    params.append('operacao', operator);
    params.append('numero2', secondOperand.toString());

    try {
        const response = await fetch('/exercise2/calcular', {
            method: 'POST',
            headers: {
                // ESSENCIAL para o Spring ler os @RequestParam no corpo da requisição
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: params.toString()
        });

        if (!response.ok) throw new Error('Erro na resposta do servidor');

        const resultado = await response.text();

        // Atualiza a tela com o valor que veio do Java
        visorValue = resultado;
        updateVisor();

        firstOperand = parseFloat(resultado); // Permite continuar a conta com o resultado anterior
        operator = null;
        waitingForSecondOperand = true; // Próximo número digitado limpa o visor
    } catch (error) {
        visor.textContent = 'Erro';
        console.error('Erro de conexão com o Java:', error);
    }
});