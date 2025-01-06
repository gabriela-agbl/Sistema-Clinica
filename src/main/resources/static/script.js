// Função para validar o CPF usando regex
function validarCPF(cpf) {
    const regex = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;
    return regex.test(cpf) && !/[a-zA-Z]/.test(cpf);
}

// Função para validar a idade (deve ser maior que 0)
function validarIdade(idade) {
    return idade > 0;
}

// Função para validar o telefone
function validarTelefone(telefone) {
    const regex = /^\(\d{2}\)\s\d{4,5}-\d{4}$/;
    return regex.test(telefone) && !/[a-zA-Z]/.test(telefone);
}

// Função para validar a data (no formato yyyy-mm-dd)
function validarData(data) {
    const regex = /^\d{4}-\d{2}-\d{2}$/;
    return regex.test(data);
}

// Função para validar o formulário antes de enviar para a API
async function validarFormularioConsulta(formulario) {
    const id_p = document.querySelector("input[th\\:field='*{paciente}']").value;
    const id_pr = document.querySelector("input[th\\:field='*{profissional}']").value;
    const data = document.querySelector("input[th\\:field='*{data}']").value;
    const receita = document.querySelector("input[th\\:field='*{receita}']").value;
    const feita = document.querySelector("select[th\\:field='*{feita}']").value;

    let erros = [];

    // Validar ID do Paciente e do Profissional
    if (!id_p || isNaN(id_p) || id_p <= 0) erros.push("ID do paciente inválido!");
    if (!id_pr || isNaN(id_pr) || id_pr <= 0) erros.push("ID do profissional inválido!");

    // Validar data
    if (!validarData(data)) erros.push("Data inválida! Por favor, use o formato yyyy-mm-dd.");

    // Validar campos vazios
    if (!receita) erros.push("O campo Receita não pode estar vazio.");
    if (!feita) erros.push("Selecione se a consulta foi realizada.");

    // Exibir erros ou enviar dados à API
    if (erros.length > 0) {
        alert(erros.join("\n"));
        return false;
    }

    // Dados válidos — enviar para a API
    try {
        const resposta = await fetch("https://localhost:8080/api/consultas/cadastrar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                paciente: id_p,
                profissional: id_pr,
                data,
                receita,
                feita
            })
        });

        if (!resposta.ok) {
            const erro = await resposta.json();
            alert(`Erro ao cadastrar: ${erro.mensagem}`);
        } else {
            alert("Consulta agendada com sucesso!");
            window.location.href = "Lista.html"; // Redirecionar após o sucesso
        }
    } catch (erro) {
        alert(`Erro ao se comunicar com a API: ${erro.message}`);
    }

    return false; // Previne o envio padrão do formulário
}

// Associar a validação ao evento de submissão do formulário
document.querySelector("form").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevenir o envio padrão do formulário
    validarFormularioConsulta(this);
});

// Função para validar o formulário de paciente
async function validarFormularioPaciente(formulario) {
    const nome_p = document.querySelector("input[th\\:field='*{nome_p}']").value;
    const cpf_p = document.querySelector("input[th\\:field='*{cpf_p}']").value;
    const ende_p = document.querySelector("input[th\\:field='*{ende_p}']").value;
    const idade_p = document.querySelector("input[th\\:field='*{idade_p}']").value;
    const telefone_p = document.querySelector("input[th\\:field='*{telefone_p}']").value;
    const convenio_p = document.querySelector("input[th\\:field='*{convenio_p}']").value;

    let erros = [];

    // Validar cpf
    if (!validarCpf(cpf_p)) erros.push("CPF inválido! Por favor, use o formato xxx.xxx.xxx-xx e digite apenas números.");
    
    //Validar idade
    if (!validarIdade(idade_p)) erros.push("Idade inválida! Por favor, digite números positivos.");
    
    //Validar telefone
    if (!validarTelefone(telefone_p)) erros.push("Telefone inválido! Por favor, use o formato (xx)xxxxx-xxxx e digite apenas números.");

    // Validar campos vazios
    if (!nome_p) erros.push("O campo Nome do Paciente não pode estar vazio.");
    if (!cpf_p) erros.push("O campo CPF do Paciente não pode estar vazio");
    if (!ende_p) erros.push("O campo Endereço do Paciente não pode estar vazio");
    if (!idade_p) erros.push("O campo Idade do Paciente não pode estar vazio");
    if (!telefone_p) erros.push("O campo Telefone do Paciente não pode estar vazio");
    
    // Exibir erros ou enviar dados à API
    if (erros.length > 0) {
        alert(erros.join("\n"));
        return false;
    }

    // Dados válidos — enviar para a API
    try {
        const resposta = await fetch("https://localhost:8080/api/pacientes/cadastrar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                nome_p,
                cpf_p,
                ende_p,
                idade_p,
                telefone_p,
                convenio_p
            })
        });

        if (!resposta.ok) {
            const erro = await resposta.json();
            alert(`Erro ao cadastrar: ${erro.mensagem}`);
        } else {
            alert("Paciente cadastrado com sucesso!");
            window.location.href = "Menu.html"; // Redirecionar após o sucesso
        }
    } catch (erro) {
        alert(`Erro ao se comunicar com a API: ${erro.message}`);
    }

    return false; // Previne o envio padrão do formulário
}

// Associar a validação ao evento de submissão do formulário
document.querySelector("form").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevenir o envio padrão do formulário
    validarFormularioPaciente(this);
});

// Função para validar o formulário de profissional
async function validarFormularioProfissional(formulario) {
    const nome_pr = document.querySelector("input[th\\:field='*{nome_pr}']").value;
    const cpf_pr = document.querySelector("input[th\\:field='*{cpf_pr}']").value;
    const ende_pr = document.querySelector("input[th\\:field='*{ende_pr}']").value;
    const idade_pr = document.querySelector("input[th\\:field='*{idade_pr}']").value;
    const telefone_pr = document.querySelector("input[th\\:field='*{telefone_pr}']").value;
    const especialidade_pr = document.querySelector("input[th\\:field='*{especialidade_pr}']").value;

    let erros = [];

    // Validar cpf
    if (!validarCpf(cpf_pr)) erros.push("CPF inválido! Por favor, use o formato xxx.xxx.xxx-xx e digite apenas números.");
    
    //Validar idade
    if (!validarIdade(idade_pr)) erros.push("Idade inválida! Por favor, digite números positivos.");
    
    //Validar telefone
    if (!validarTelefone(telefone_pr)) erros.push("Telefone inválido! Por favor, use o formato (xx)xxxxx-xxxx e digite apenas números.");

    // Validar campos vazios
    if (!nome_pr) erros.push("O campo Nome do Profissional não pode estar vazio.");
    if (!cpf_pr) erros.push("O campo CPF do Profissional não pode estar vazio");
    if (!ende_pr) erros.push("O campo Endereço do Profissional não pode estar vazio");
    if (!idade_pr) erros.push("O campo Idade do Profissional não pode estar vazio");
    if (!telefone_pr) erros.push("O campo Telefone do Profissional não pode estar vazio");
    if (!especialidade_pr) erros.push("O campo Especialide do Profissional não pode estar vazio");
    
    // Exibir erros ou enviar dados à API
    if (erros.length > 0) {
        alert(erros.join("\n"));
        return false;
    }

    // Dados válidos — enviar para a API
    try {
        const resposta = await fetch("https://localhost:8080/api/profissionais/cadastrar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                nome_pr,
                cpf_pr,
                ende_pr,
                idade_pr,
                telefone_pr,
                especialidade_pr
            })
        });

        if (!resposta.ok) {
            const erro = await resposta.json();
            alert(`Erro ao cadastrar: ${erro.mensagem}`);
        } else {
            alert("Profissional cadastrado com sucesso!");
            window.location.href = "Menu.html"; // Redirecionar após o sucesso
        }
    } catch (erro) {
        alert(`Erro ao se comunicar com a API: ${erro.message}`);
    }

    return false; // Previne o envio padrão do formulário
}

// Associar a validação ao evento de submissão do formulário
document.querySelector("form").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevenir o envio padrão do formulário
    validarFormularioProfissional(this);
});

$(document).ready(function() {
    // Listar Consultas
    function listarConsultas() {
        $.get("https://localhost:8080/api/consultas/", function(data) {
            $("#listarConsultas").empty(); // Limpa a lista antes de renderizar
            data.forEach(function(consulta) {
                $("#listarConsultas").append(`<ul>
                        <li><strong>Id do Paciente:</strong> ${consulta.paciente}</li>
                        <li><strong>Id Profissional:</strong> ${consulta.profissional}</li>
                        <li><strong>Data:</strong> ${consulta.data}</li>
                        <li><strong>Receita:</strong> ${consulta.receita}</li>
                        <li><strong>Feita:</strong> ${consulta.feita}</li>
                    </ul>`);
            });
        }).fail(function(jqXHR, textStatus, errorThrown) {
            alert("Erro ao carregar a lista de consultas.");
        });
    }

    listarConsultas(); // Chama a função ao carregar a página
    
    // Cadastrar Consulta
    $("#btn-adicionar").click(function() {
        const id_p = $("#paciente").val();
        const id_pr = $("#profissional").val();
        const data = $("#data").val();
        const receita = $("#receita").val();
        const feita = $("#feita").val();

        const novaConsulta = { id_p, id_pr, data, receita, feita };

        $.post("https://localhost:8080/api/consultas/", novaConsulta, function() {
            alert("Consulta cadastrada com sucesso!");
            listarConsultas(); // Atualiza a lista de consultas
            $("#paciente").val("");
            $("#profissional").val("");
            $("#data").val("");
            $("#receita").val("");
            $("#feita").val("");// Limpa os campos
        }).fail(function() {
            alert("Erro ao cadastrar a consulta. Tente novamente.");
        });
    });
    
    // Excluir Consulta
    $("#btn-excluir").click(function() {
        const numero_c = $("#numero_c").val();

        if (!numero_c) {
            alert("Informe o ID da consulta a ser excluída.");
            return;
        }

        if (confirm("Tem certeza de que deseja excluir esta consulta?")) {
            $.ajax({
                url: `https://localhost:8080/api/consultas/excluir/${numero_c}`,
                method: "DELETE",
                success: function() {
                    alert("Consulta excluída com sucesso!");
                    listarConsultas();
                },
                error: function() {
                    alert("Erro ao excluir a consulta. Verifique o ID e tente novamente.");
                }
            });
        }
    });
    
    // Cadastrar Paciente
    $("#btn-adicionar").click(function() {
        const id_p = $("#id_p").val();
        const nome_p = $("#nome_p").val();
        const cpf_p = $("#cpf_p").val();
        const ende_p= $("#ende_p").val();
        const idade_p = $("#idade_p").val();
        const telefone_p = $("#telefone_p").val();
        const convenio_p = $("#convenio_p").val();

        const novoPaciente = { id_p, nome_p, cpf_p, ende_p, idade_p, telefone_p, convenio_p };

        $.post("https://localhost:8080/api/pacientes/cadastrar", novoPaciente, function() {
            alert("Paciente cadastrado com sucesso!");
            $("#id_p").val("");
            $("#nome_p").val("");
            $("#cpf_p").val("");
            $("#ende_p").val("");
            $("#idade_p").val("");
            $("#telefone_p").val("");
            $("#convenio_p").val("");// Limpa os campos
        }).fail(function() {
            alert("Erro ao cadastrar o paciente. Tente novamente.");
        });
    });
    
    // Cadastrar Profissional
    $("#btn-adicionar").click(function() {
        const id_pr = $("#id_pr").val();
        const nome_pr = $("#nome_pr").val();
        const cpf_pr = $("#cpf_pr").val();
        const ende_pr= $("#ende_pr").val();
        const idade_pr = $("#idade_pr").val();
        const telefone_pr = $("#telefone_pr").val();
        const especialidade_pr = $("#especialidade_pr").val();

        const novoProfissional = { id_pr, nome_pr, cpf_pr, ende_pr, idade_pr, telefone_pr, especialidade_pr };

        $.post("https://localhost:8080/api/profissionais/cadastrar", novoProfissional, function() {
            alert("Profissional cadastrado com sucesso!");
            $("#id_pr").val("");
            $("#nome_pr").val("");
            $("#cpf_pr").val("");
            $("#ende_pr").val("");
            $("#idade_pr").val("");
            $("#telefone_pr").val("");
            $("#especialidade_pr").val("");// Limpa os campos
        }).fail(function() {
            alert("Erro ao cadastrar o profissional. Tente novamente.");
        });
    });
    
    document.getElementById('loginForm').addEventListener('submit', function(event) {
        event.preventDefault(); // Previne o envio padrão do formulário

        // Coleta os dados do formulário
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        // Envia os dados para o servidor usando fetch
        fetch('/Login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: 'Joaquim@J',
                password: '876'
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);
        })    
        })
        .catch(error => {
            // Erro na requisição
            console.error('Erro de conexão:', error);
            alert('Ocorreu um erro. Tente novamente mais tarde.');
        });
    });
});