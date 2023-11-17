const Book = require('../models/Book');

// Create a new book
exports.createBook = async (req, res) => {
  const { title, author, ISBN, price, quantity } = req.body;
  try {
    const book = new Book({ title, author, ISBN, price, quantity });
    await book.save();
    res.json({ success: true, message: 'Book added successfully', bookId: book._id });
  } catch (error) {
    console.error('Error in creating a book:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};

// Get all books
exports.getAllBooks = async (req, res) => {
  try {
    const books = await Book.find();
    res.json({ success: true, books });
  } catch (error) {
    console.error('Error in getting all books:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};

// Get a single book by ID
exports.getBookById = async (req, res) => {
  const { bookId } = req.params;
  try {
    const book = await Book.findById(bookId);
    if (!book) {
      return res.status(404).json({ success: false, message: 'Book not found' });
    }
    res.json({ success: true, book });
  } catch (error) {
    console.error('Error in getting a book by ID:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};

// Update a book by ID
exports.updateBook = async (req, res) => {
  const { bookId } = req.params;
  const { title, price } = req.body;
  try {
    const book = await Book.findByIdAndUpdate(bookId, { title, price }, { new: true });
    if (!book) {
      return res.status(404).json({ success: false, message: 'Book not found' });
    }
    res.json({ success: true, message: 'Book updated successfully' });
  } catch (error) {
    console.error('Error in updating a book by ID:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};

// Delete a book by ID
exports.deleteBook = async (req, res) => {
  const { bookId } = req.params;
  try {
    const book = await Book.findByIdAndRemove(bookId);
    if (!book) {
      return res.status(404).json({ success: false, message: 'Book not found' });
    }
    res.json({ success: true, message: 'Book deleted successfully' });
  } catch (error) {
    console.error('Error in deleting a book by ID:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};
