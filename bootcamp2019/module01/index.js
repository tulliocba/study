// Importar express
const express = require("express");
const server = express();

//configurar o servidor pra rodar na porta 3000
server.listen(3000);
//configurar o servidor para receber arquivos json, importando o módulo json de dentro do express
server.use(express.json());

// Middleware (Filter), global
server.use((req, res, next) => {
    console.log(`Method: ${req.method} - Url: ${req.url}`);
    return next();
});

function checkUserExists(req, res, next) {
    if (!req.body.name) {
        return res.status(400).json({ error: `User name is required` });
    }
    return next();
}

function checUserInArray(req, res, next) {
    if (!users[req.params.index]) {
        return res.status(400).json({ error: 'User does not exists' })
    }

    return next();
}

//CRUD Rest
const users = ['João', 'Maria', 'José'];

server.get('/users', (req, res) => {
    return res.json(users);
});

server.get('/users/:index', checUserInArray, (req, res) => {
    const { index } = req.params;
    return res.json({ message: `Ola ${users[index]}` });
});

//Middleware (Filter) Local
server.post('/users', checkUserExists, (req, res) => {
    const { name } = req.body;
    users.push(name);
    return res.json(users);
});

server.put('/users/:index', checkUserExists, checUserInArray, (req, res) => {
    const { index } = req.params;
    const { name } = req.body;
    users[index] = name;
    return res.json(users);
});

server.delete('/users/:index', checUserInArray, (req, res) => {
    const { index } = req.params;
    users.splice(index, 1);
    return res.json(users);
});