const express = require('express');
const router = express.Router();
const userController = require('../controllers/userController');
const authMiddleware = require('../middleware/authMiddleware'); // JWT authentication middleware

// User registration
router.post('/signup', userController.signup);

// User login
router.post('/signin', userController.signin);

// User profile view and update (requires authentication)
router.get('/profile', authMiddleware, userController.getProfile);
router.put('/profile', authMiddleware, userController.updateProfile);

module.exports = router;
