const router = require('express').Router();
const controller = require('../controllers/reminders');

router.post('/', controller.create);
router.get('/', controller.getAll);
router.get('/:id', controller.getById);

router.delete('/:id', controller.notAllowed);
router.put('/:id', controller.notAllowed);
router.patch('/:id', controller.notAllowed);

module.exports = router;
