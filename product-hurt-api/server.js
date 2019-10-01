const express = require('express');

const app = express();

app.get('/', (req, res) => {
    res.send('Hello Tulio!');
});

app.listen(3001);