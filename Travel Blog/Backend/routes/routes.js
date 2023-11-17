const express = require('express');
const router = express.Router();
const auth = require('../middleware/auth');
const { registerUser, getUser } = require('../controllers/usercontroller');

router.post('/register', registerUser);
router.get('/user', auth, getUser);

module.exports = router;