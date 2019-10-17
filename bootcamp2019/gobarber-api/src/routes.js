// importo somente o componente Router do express.
import { Router } from 'express';

const routes = new Router();

routes.get('/', (req, res) =>
    res.json({ message: 'Servidor rodando na porta 3333' })
);

export default routes;
