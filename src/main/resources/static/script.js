function validarCPF(cpf) {
    const regex = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;
    if (/[a-zA-Z]/.test(cpf)) 
    {
        return false; // Verifica se o CPF contém letras
    }
    return regex.test(cpf);
}

// Função para validar a idade (deve ser maior que 0)
function validarIdade(idade) {
    return idade > 0;
}

 // Função para validar o telefone
    function validarTelefone(telefone) {
        const phonePattern = /^\(\d{2}\)\s\d{4,5}-\d{4}$/;
        if (/[a-zA-Z]/.test(telefone)) {
        alert("O telefone não pode conter letras.");
        return false;
    }
    return true;
        return phonePattern.test(telefone);
    }
    
// Função para validar a data (no formato yyyy-mm-dd)
    function validarData(data) {
        const regex = /^\d{4}-\d{2}-\d{2}$/;
        return regex.test(data);
    }

// Função para validar o horário (no formato hh:mm)
    function validarHorario(horario) {
        const regex = /^(0[1-9]|1[0-9]|2[0-3]):([0-5][0-9])$/;
        return regex.test(horario);
    }

// Função para validar campos vazios
    function validarCampoVazio(campo, nomeCampo) {
        if (campo === "") {
            alert(`O campo ${nomeCampo} não pode estar vazio.`);
            return false;
        }
        return true;
    }

// Função para validar o endereço (não pode conter números)
function validarEndereco(endereco) 
{
    if (/\d/.test(endereco)) {
        alert("O endereço não pode conter números.");
        return false;
    }
    return true;
}

// Função para validar o formulário de paciente
document.getElementById("patientForm").addEventListener("submit", function(event) {
    let valid = true;
    const cpf = document.getElementById("cpf").value;
    const nomePaciente = document.getElementById("patientName").value;
    const idade = document.getElementById("age").value;
    const telefone = document.getElementById("telephone").value;
    const endereco = document.geElementBtId("address").value;

    // Validando CPF
    if (!validarCPF(cpf)) {
        alert("CPF inválido! Por favor, digite um CPF no formato xxx.xxx.xxx-xx.");
        valid = false;
    }

    // Verificando se o nome do paciente contém números
    if (/\d/.test(nomePaciente)) {
        alert("O nome do paciente não pode conter números.");
        valid = false;
    }
    
    // Validando Idade
    if (!validarIdade(idade)) {
        alert("Idade inválida! A idade deve ser maior que 0.");
        valid = false;
    }
    
    // Validando Telefone
    if (!validarTelefone(telefone)) {
        alert("Telefone inválido! Por favor, digite um telefone no formato (xx) xxxx-xxxx.");
        valid = false;
    }
    
    // Validando campos vazios
    if (!validarCampoVazio(cpf, "cpf") || !validarCampoVazio(nomePaciente, "patientName") || 
        !validarCampoVazio(idade, "age") || !validarCampoVazio(telefone, "telephone")) 
    {
        valid = false;
    }
    
    if (!validarEndereco(endereco))
    {
        alert("Endereço inválido! Por favor, digite apenas letras.");
        valid = false;
    }

    if (!valid) {
        event.preventDefault(); // Previne o envio do formulário se houver erro
    }
});

// Função para validar o formulário de profissional
document.getElementById("professionalForm").addEventListener("submit", function(event) {
    let valid = true;
    const cpf = document.getElementById("cpf").value;
    const nomeProfissional = document.getElementById("professionalName").value;
    const idade = document.getElementById("age").value;
    const telefone = document.getElementById("telephone").value;
    const endereco = document.getElementById("address").value;

    // Validando CPF
    if (!validarCPF(cpf)) {
        alert("CPF inválido! Por favor, digite um CPF no formato xxx.xxx.xxx-xx.");
        valid = false;
    }

    // Verificando se o nome do profissional contém números
    if (/\d/.test(nomeProfissional)) {
        alert("O nome do profissional não pode conter números.");
        valid = false;
    }
    
    // Validando Idade
    if (!validarIdade(idade)) {
        alert("Idade inválida! A idade deve ser maior que 0.");
        valid = false;
    }
    
    // Validando Telefone
    if (!validarTelefone(telefone)) {
        alert("Telefone inválido! Por favor, digite um telefone no formato (xx) xxxx-xxxx.");
        valid = false;
    }
    
    // Validando campos vazios
    if (!validarCampoVazio(cpf, "cpf") || !validarCampoVazio(nomeProfissional, "professionalName") || 
        !validarCampoVazio(idade, "age") || !validarCampoVazio(telefone, "telephone")) 
    {
        valid = false;
    }
    
    if (!validarEndereco(endereco))
    {
        alert("Endereço inválido! Por favor, digite apenas letras.");
        valid = false;
    }

    if (!valid) {
        event.preventDefault(); // Previne o envio do formulário se houver erro
    }
});

// Função para validar o formulário de consulta
document.getElementById("appointmentForm").addEventListener("submit", function(event) {
    let valid = true;
    const idPaciente = document.getElementById("id-patient").value;
    const idProfissional = document.getElementById("id-professional").value;
    const data = document.getElementById("date").value;
    const hora = document.getElementById("time").value;
    const receita = document.getElementById("recipe").value;
    const feita = document.getElementById("done").value;
    
    // Validando ID do Paciente
    if (isNaN(idPaciente) || idPaciente <= 0) 
    {
        alert("ID do paciente inválido! O ID deve ser um número positivo.");
        valid = false;
    }
    
    // Validando ID do Profissional
    if (isNaN(idProfissional) || idProfissional <= 0) 
    {
        alert("ID do profissional inválido! O ID deve ser um número positivo.");
        valid = false;
    }
    
    // Validando Data de Nascimento
    if (!validarData(data)) 
    {
        alert("Data inválida! Por favor, use o formato yyyy-mm-dd.");
        valid = false;
    }
    
    // Validando Horário
    if (!validarHorario(hora)) 
    {
        alert("Horário inválido! Por favor, use o formato hh:mm.");
        valid = false;
    }

    // Validando campos vazios
    if (!validarCampoVazio(idPaciente, "id-paciente") || !validarCampoVazio(idProfissional, "id-profissional") || 
        !validarCampoVazio(data, "date") || !validarCampoVazio(hora, "time") || !validarCampoVazio(receita, "recipe") || 
        !validarCampoVazio(feita, "done")) 
    {
        valid = false;
    }
        
    if (!valid) 
    {
        event.preventDefault();
    }

});