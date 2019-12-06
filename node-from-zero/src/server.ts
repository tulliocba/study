import http from "http";
import express from "express";

const app = express();

const { PORT = 3000 } = process.env;

const server = http.createServer(app);

server.listen(PORT, () =>
  console.log(`Server is running in http://localhost:${PORT}`)
);
