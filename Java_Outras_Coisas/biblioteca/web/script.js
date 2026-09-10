async function carregarDashboard() {
    const response = await fetch('/api/dashboard');
    const dados = await response.json();
    document.getElementById('qtdLivros').textContent = dados.livros ?? 0;
    document.getElementById('qtdUsuarios').textContent = dados.usuarios ?? 0;
    document.getElementById('qtdEmprestimos').textContent = dados.emprestimosAtivos ?? 0;
}

async function buscarLivros() {
    const termo = document.getElementById('pesquisaLivro').value;
    const response = await fetch('/api/livros?termo=' + encodeURIComponent(termo));
    const livros = await response.json();
    const lista = document.getElementById('listaLivros');
    lista.innerHTML = '';

    if (!livros.length) {
        lista.innerHTML = '<div class="item">Nenhum livro encontrado.</div>';
        return;
    }

    livros.forEach(livro => {
        const item = document.createElement('div');
        item.className = 'item';
        item.textContent = `${livro.titulo} - ${livro.autor} (${livro.status})`;
        lista.appendChild(item);
    });
}

async function buscarUsuarios() {
    const termo = document.getElementById('pesquisaUsuario').value;
    const response = await fetch('/api/usuarios?termo=' + encodeURIComponent(termo));
    const usuarios = await response.json();
    const lista = document.getElementById('listaUsuarios');
    lista.innerHTML = '';

    if (!usuarios.length) {
        lista.innerHTML = '<div class="item">Nenhum usuário encontrado.</div>';
        return;
    }

    usuarios.forEach(usuario => {
        const item = document.createElement('div');
        item.className = 'item';
        item.textContent = `${usuario.nome} - ${usuario.cpf}`;
        lista.appendChild(item);
    });
}

document.getElementById('formLivro').addEventListener('submit', async function (event) {
    event.preventDefault();
    const formData = new FormData(this);
    const params = new URLSearchParams(formData);

    const response = await fetch('/api/livros', {
        method: 'POST',
        headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
        body: params.toString()
    });

    const dados = await response.json();
    document.getElementById('respostaLivro').textContent = dados.mensagem;
    carregarDashboard();
    buscarLivros();
});

document.getElementById('formUsuario').addEventListener('submit', async function (event) {
    event.preventDefault();
    const formData = new FormData(this);
    const params = new URLSearchParams(formData);

    const response = await fetch('/api/usuarios', {
        method: 'POST',
        headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
        body: params.toString()
    });

    const dados = await response.json();
    document.getElementById('respostaUsuario').textContent = dados.mensagem;
    carregarDashboard();
    buscarUsuarios();
});

document.getElementById('formEmprestimo').addEventListener('submit', async function (event) {
    event.preventDefault();
    const formData = new FormData(this);
    const params = new URLSearchParams(formData);
    params.append('action', 'emprestar');

    const response = await fetch('/api/emprestimos', {
        method: 'POST',
        headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
        body: params.toString()
    });

    const dados = await response.json();
    document.getElementById('respostaEmprestimo').textContent = dados.mensagem;
    carregarDashboard();
    buscarLivros();
});

document.getElementById('formDevolucao').addEventListener('submit', async function (event) {
    event.preventDefault();
    const formData = new FormData(this);
    const params = new URLSearchParams(formData);
    params.append('action', 'devolver');

    const response = await fetch('/api/emprestimos', {
        method: 'POST',
        headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
        body: params.toString()
    });

    const dados = await response.json();
    document.getElementById('respostaDevolucao').textContent = dados.mensagem;
    carregarDashboard();
    buscarLivros();
});

carregarDashboard();
buscarLivros();
buscarUsuarios();
