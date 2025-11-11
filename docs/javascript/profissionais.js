async function carregarProfissionais() {
    try {
        const response = await fetch("http://localhost:8080/profissionais");
        const profissionais = await response.json();

        const tbody = document.getElementById("profissionais-tbody");
        tbody.innerHTML = "";

        profissionais.forEach(prof => {
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
                <td>${prof.especialidade}</td>
                <td>${prof.salario}</td>
                <td><button class="excluir-btn" data-id="${prof.id}"><span class="material-symbols-outlined">
delete
</span></button></td>
            `;

            tbody.appendChild(tr);
        });

    } catch (error) {
        console.error("Erro ao carregar profissionais:", error);
    }
}

carregarProfissionais();

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

const salarioInput = document.getElementById('salario');

salarioInput.addEventListener('input', function () {
  let value = salarioInput.value.replace(/\D/g, "");

  if (value === "") {
    salarioInput.value = "";
    return;
  }

  value = (value / 100).toFixed(2);
  value = value.replace(".", ",");

  salarioInput.value = "R$ " + value;
});

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