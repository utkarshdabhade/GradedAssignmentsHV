const Cart = require('../models/Cart');

// Add a book to the shopping cart
exports.addToCart = async (req, res) => {
  const { bookId, quantity } = req.body;
  const userId = req.userId; // Assuming userId is available from JWT

  try {
    let cart = await Cart.findOne({ userId });

    if (!cart) {
      cart = new Cart({ userId, items: [] });
    }

    // Check if the book is already in the cart
    const existingCartItem = cart.items.find((item) => item.bookId === bookId);

    if (existingCartItem) {
      existingCartItem.quantity += quantity;
    } else {
      cart.items.push({ bookId, quantity });
    }

    await cart.save();
    res.json({ success: true, message: 'Book added to cart' });
  } catch (error) {
    console.error('Error in adding to cart:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};

// Get the shopping cart contents
exports.getCart = async (req, res) => {
  const userId = req.userId; // Assuming userId is available from JWT

  try {
    const cart = await Cart.findOne({ userId }).populate('items.bookId');
    res.json({ success: true, cart });
  } catch (error) {
    console.error('Error in getting cart:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};

// Update the quantity of a book in the cart
exports.updateCartItemQuantity = async (req, res) => {
  const { bookId } = req.params;
  const { quantity } = req.body;
  const userId = req.userId; // Assuming userId is available from JWT

  try {
    const cart = await Cart.findOne({ userId });

    if (!cart) {
      return res.status(404).json({ success: false, message: 'Cart not found' });
    }

    const cartItem = cart.items.find((item) => item.bookId.toString() === bookId);

    if (!cartItem) {
      return res.status(404).json({ success: false, message: 'Book not found in cart' });
    }

    cartItem.quantity = quantity;
    await cart.save();
    res.json({ success: true, message: 'Cart updated successfully' });
  } catch (error) {
    console.error('Error in updating cart item quantity:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};

// Remove a book from the cart
exports.removeCartItem = async (req, res) => {
  const { bookId } = req.params;
  const userId = req.userId; // Assuming userId is available from JWT

  try {
    const cart = await Cart.findOne({ userId });

    if (!cart) {
      return res.status(404).json({ success: false, message: 'Cart not found' });
    }

    const updatedItems = cart.items.filter((item) => item.bookId.toString() !== bookId);
    cart.items = updatedItems;

    await cart.save();
    res.json({ success: true, message: 'Book removed from cart' });
  } catch (error) {
    console.error('Error in removing cart item:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};
