const express = require('express');
const multer = require('multer');

const uploadConfig = require('./config/Upload');

const SessionController = require('./controller/SessionController');
const SpotController = require('./controller/SpotController');

const routes = express.Router();
const upload = multer(uploadConfig);

routes.post('/users', SessionController.store);

routes.post('/spots', upload.single('thumbnail'), SpotController.store);

module.exports = routes;