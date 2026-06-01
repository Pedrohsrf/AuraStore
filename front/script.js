const resultado = document.getElementById("resultado");

async function criarCliente() {
    const response = await fetch("http://localhost:8081/clientes", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            nome: document.getElementById("nome").value,
            email: document.getElementById("email").value,
            telefone: document.getElementById("telefone").value
        })
    });
    resultado.textContent = JSON.stringify(await response.json(), null, 2);
}

async function listarClientes() {
    const response = await fetch("http://localhost:8081/clientes");
    resultado.textContent = JSON.stringify(await response.json(), null, 2);
}

async function criarVenda() {
    const response = await fetch("http://localhost:8080/vendas", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            clienteId: Number(document.getElementById("clienteId").value),
            produtoId: Number(document.getElementById("produtoId").value),
            quantidade: Number(document.getElementById("quantidade").value),
            valorUnitario: Number(document.getElementById("valorUnitario").value)
        })
    });
    resultado.textContent = JSON.stringify(await response.json(), null, 2);
}

async function listarVendas() {
    const response = await fetch("http://localhost:8080/vendas");
    resultado.textContent = JSON.stringify(await response.json(), null, 2);
}

async function buscarVendasCliente() {
    const id = document.getElementById("clienteBusca").value;
    const response = await fetch(`http://localhost:8081/clientes/${id}/vendas`);
    resultado.textContent = JSON.stringify(await response.json(), null, 2);
}

async function buscarClienteDaVenda() {
    const vendaId = document.getElementById("vendaBusca").value;
    const response = await fetch(`http://localhost:8080/vendas/${vendaId}/cliente`);
    resultado.textContent = JSON.stringify(await response.json(), null, 2);
}

async function criarEstoque() {
    const response = await fetch("http://localhost:8084/estoques", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            nomeProduto: document.getElementById("nomeProduto").value,
            quantidade: Number(document.getElementById("quantidadeEstoque").value)
        })
    });
    resultado.textContent = JSON.stringify(await response.json(), null, 2);
}

async function listarEstoques() {
    const response = await fetch("http://localhost:8084/estoques");
    resultado.textContent = JSON.stringify(await response.json(), null, 2);
}