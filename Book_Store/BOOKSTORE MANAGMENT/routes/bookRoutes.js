const express = require('express');
const router = express.Router();
const bookController = require('../controllers/bookController');

// Create a new book
router.post('/', bookController.createBook);

// Get all books
router.get('/', bookController.getAllBooks);

// Get a book by ID
router.get('/:bookId', bookController.getBookById);

// Update a book by ID
router.put('/:bookId', bookController.updateBook);

// Delete a book by ID
router.delete('/:bookId', bookController.deleteBook);

module.exports = router;
