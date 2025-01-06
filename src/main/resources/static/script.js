$(document).ready(function() {
    // Listar Consultas
    function listarConsultas() {
        $.get("https://localhost:8080/api/consultas/", function(data) {
            $("#listarConsultas").empty(); // Limpa a lista antes de renderizar
            data.forEach(function(consulta) {
                $("#listarConsultas").append(`
                        <li><${consulta.paciente}</li>
                        <li>${consulta.profissional}</li>
                        <li>${consulta.data}</li>
                        <li>${consulta.receita}</li>
                        <li>${consulta.feita}</li>`);
            });
        }).fail(function(jqXHR, textStatus, errorThrown) {
            alert("Erro ao carregar a lista de consultas.");
        });
    }

    listarConsultas(); // Chama a função ao carregar a página
    
    // Cadastrar Consulta
    $("#btn-adicionar-consulta").click(function() {
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
    $("#btn-adicionar-paciente").click(function() {
        const nome_p = $("#nome_p").val();
        const cpf_p = $("#cpf_p").val();
        const ende_p= $("#ende_p").val();
        const idade_p = $("#idade_p").val();
        const telefone_p = $("#telefone_p").val();
        const convenio_p = $("#convenio_p").val();

        const novoPaciente = { nome_p, cpf_p, ende_p, idade_p, telefone_p, convenio_p };

        $.post("https://localhost:8080/api/pacientes/", novoPaciente, function() {
            alert("Paciente cadastrado com sucesso!");
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
    $("#btn-adicionar-profissional").click(function() {
        const nome_pr = $("#nome_pr").val();
        const cpf_pr = $("#cpf_pr").val();
        const ende_pr= $("#ende_pr").val();
        const idade_pr = $("#idade_pr").val();
        const telefone_pr = $("#telefone_pr").val();
        const especialidade_pr = $("#especialidade_pr").val();

        const novoProfissional = { nome_pr, cpf_pr, ende_pr, idade_pr, telefone_pr, especialidade_pr };

        $.post("https://localhost:8080/api/profissionais/", novoProfissional, function() {
            alert("Profissional cadastrado com sucesso!");
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
});