    const apiUrl = "https://espacolilas-backend.up.railway.app/profissionais";
    async function carregarProfissionais() {
        try {
            const response = await fetch(apiUrl);
            if (!response.ok) throw new Error("Erro ao buscar profissionais");
            const profissionais = await response.json();

            const tbody = document.getElementById("profissionais-tbody");
            tbody.innerHTML = "";

            profissionais.forEach(p => {
                const tr = document.createElement("tr");

                tr.innerHTML = `
                    <td><i class="material-icons">edit_square</i></td>
                    <td>${p.id}</td>
                    <td>${p.nome}</td>
                    <td>${p.cpf}</td>
                    <td>${p.email}</td>
                    <td>${p.telefone}</td>
                    <td>${p.especialidade}</td>
                    <td>${p.salario}</td>
                    <td><span class="material-symbols-outlined">delete</span></td>
                `;

                tbody.appendChild(tr);
            });
        } catch (error) {
            console.error(error);
        }
    }

    window.addEventListener("DOMContentLoaded", carregarProfissionais);