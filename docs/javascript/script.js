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
        email: document.getElementById('email').value,
        cpf: document.getElementById('cpf2').value,
        telefone: document.getElementById('telefone').value,
        especialidade: document.getElementById('especialidade').value,
        senha: document.getElementById('senha2').value
    };

    fetch('http://localhost:8080/profissionais/login', {
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
        alert("Profissional cadastrado com sucesso!");
    })
    .catch(err => {
        console.error(err);
        alert("Erro ao cadastrar profissional.");
    });
});

document.getElementById("form-login").addEventListener("submit", async function(event) {
    event.preventDefault();

    const formData = new FormData(this);

    const response = await fetch("http://localhost:8080/profissionais/login", {
        method: "POST",
        body: formData
    });

    if (response.ok) {
    window.location.href = "home.html";
    } else {
        const msg = await response.text();
        alert("❌ " + msg);
    }
});


