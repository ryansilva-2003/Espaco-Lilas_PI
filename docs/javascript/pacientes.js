const openButtons = document.querySelectorAll('.open-modal');

openButtons.forEach (button => {
    button.addEventListener('click', () =>{
        const modalId = button.getAttribute('data-modal');
        const modal = document.getElementById(modalId);

        modal.showModal();
    })
})

const closeButtons = document.querySelectorAll('.close-modal');

closeButtons.forEach (button => {
    button.addEventListener('click', () => {
        const modalId = button.getAttribute('data-modal');
        const modal = document.getElementById(modalId);

        modal.close();
    })
})

document.querySelector('#modal-1 form').addEventListener('submit', function(e) {
    e.preventDefault();

    const dados = {
        nome: document.getElementById('nome').value,
        cpf: document.getElementById('cpf').value,
        email: document.getElementById('email').value,
        telefone: document.getElementById('telefone').value,
        data_nascimento: document.getElementById('data_nascimento').value,
        sexo: document.getElementById('sexo').value,
        observacoes: document.getElementById('observacoes').value
    };

    fetch('http://localhost:8080/pacientes', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(dados)
    })
    .then(res => {
        if (!res.ok) throw new Error("Erro ao cadastrar");
        return res.json();
    })
    .then(data => {
        console.log("Cadastrado:", data);
        const modal = document.getElementById('modal-1');
        modal.close(); 
        alert("Paciente cadastrado com sucesso!");
    })
    .catch(err => {
        console.error(err);
        alert("Erro ao cadastrar paciente.");
    });
});


async function carregarPacientes() {
    try {
        const response = await fetch("http://localhost:8080/pacientes");
        const pacientes = await response.json();

        const tbody = document.getElementById("pacientes-tbody");
        tbody.innerHTML = "";

        pacientes.forEach(prof => {
            const tr = document.createElement("tr");

            tr.innerHTML = `
                <td><button class="editar-btn" data-id="${prof.id}"><span class="material-symbols-outlined">
edit_square
</span></button></td>
                <td>${prof.id}</td>
                <td>${prof.nome}</td>
                <td>${prof.cpf}</td>
                <td>${prof.email}</td>
                <td>${prof.telefone}</td>
                <td>${prof.data_nascimento}</td>
                <td>${prof.sexo}</td>
                <td>${prof.observacoes}</td>
                <td><button class="excluir-btn" data-id="${prof.id}"><span class="material-symbols-outlined">
delete
</span></button></td>
            `;

            tbody.appendChild(tr);
        });

    } catch (error) {
        console.error("Erro ao carregar pacientes:", error);
    }
}

carregarPacientes();

const telInput = document.getElementById('telefone');

telInput.addEventListener('input', function () {
  let value = telInput.value.replace(/\D/g, "");

  if (value.length > 11) value = value.slice(0, 11);

  if (value.length > 6) {
    value = value.replace(/(\d{2})(\d{5})(\d{1,4})/, "($1) $2-$3");
  } else if (value.length > 2) {
    value = value.replace(/(\d{2})(\d{1,5})/, "($1) $2");
  } else {
    value = value.replace(/(\d{1,2})/, "($1");
  }

  telInput.value = value;
});

const cpfInput = document.getElementById('cpf');

cpfInput.addEventListener('input', function () {
  let value = cpfInput.value.replace(/\D/g, "");

  if (value.length > 11) value = value.slice(0, 11);

  if (value.length > 9) {
    value = value.replace(/(\d{3})(\d{3})(\d{3})(\d{1,2})/, "$1.$2.$3-$4");
  } else if (value.length > 6) {
    value = value.replace(/(\d{3})(\d{3})(\d{1,3})/, "$1.$2.$3");
  } else if (value.length > 3) {
    value = value.replace(/(\d{3})(\d{1,3})/, "$1.$2");
  }

  cpfInput.value = value;
});
