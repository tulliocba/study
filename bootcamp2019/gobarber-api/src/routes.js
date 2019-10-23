// importo somente o componente Router do express.
import { Router } from 'express';

import multer from 'multer';
import UserController from './app/controllers/UserController';
import SessionController from './app/controllers/SessionController';
import authMiddleware from './app/middlewares/auth';
import multerConfig from './config/multer';

const routes = new Router();
const upload = multer(multerConfig);

routes.post('/users', UserController.store);
routes.post('/sessions', SessionController.store);
routes.post('/files', upload.single('file'), (req, res) => {
    return res.json({ ok: true });
});

routes.use(authMiddleware);
routes.put('/users', UserController.update);

export default routes;
