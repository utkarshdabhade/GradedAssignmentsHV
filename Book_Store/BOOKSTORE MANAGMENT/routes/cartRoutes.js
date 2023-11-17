const express = require('express');
const router = express.Router();
const cartController = require('../controllers/carController');
const authMiddleware = require('../middleware/authMiddleware'); // JWT authentication middleware

// Add a book to the cart (requires authentication)
router.post('/', authMiddleware, cartController.addToCart);

// Get the cart contents (requires authentication)
router.get('/', authMiddleware, cartController.getCart);

// Update the quantity of a book in the cart (requires authentication)
router.put('/:bookId', authMiddleware, cartController.updateCartItemQuantity);

// Remove a book from the cart (requires authentication)
router.delete('/:bookId', authMiddleware, cartController.removeCartItem);

module.exports = router;
