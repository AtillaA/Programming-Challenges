const express = require('express');
const router = express.Router();
const postsController = require('../controllers/posts');

router.post('/', postsController.create);
router.get('/', postsController.getAll);
router.get('/:id', postsController.getById);

router.delete('/:id', postsController.notAllowed);
router.put('/:id', postsController.notAllowed);
router.patch('/:id', postsController.notAllowed);

module.exports = router;
