const User = require('../models/User');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcrypt');

// User registration
exports.signup = async (req, res) => {
  const { email, password, name } = req.body;
  try {
    // Check if a user with the same email already exists
    const existingUser = await User.findOne({ email });
    if (existingUser) {
      return res.status(400).json({ success: false, message: 'Email already in use' });
    }

    // Hash the password before saving it
    const hashedPassword = await bcrypt.hash(password, 10);

    const user = new User({ email, password: hashedPassword, name });
    await user.save();
    res.json({ success: true, message: 'User registered successfully' });
  } catch (error) {
    console.error('Error in user registration:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};

// User login
exports.signin = async (req, res) => {
  const { email, password } = req.body;
  try {
    const user = await User.findOne({ email });
    if (!user) {
      return res.status(401).json({ success: false, message: 'Authentication failed' });
    }

    const isPasswordValid = await bcrypt.compare(password, user.password);
    if (!isPasswordValid) {
      return res.status(401).json({ success: false, message: 'Authentication failed' });
    }

    // Create and send a JWT token upon successful login
    const token = jwt.sign({ userId: user._id }, 'your-secret-key', { expiresIn: '1h' });
    res.json({ success: true, token, userId: user._id });
  } catch (error) {
    console.error('Error in user login:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};

// User profile view and update
exports.getProfile = async (req, res) => {
  try {
    const user = await User.findById(req.userId);
    if (!user) {
      return res.status(404).json({ success: false, message: 'User not found' });
    }

    res.json({ success: true, user });
  } catch (error) {
    console.error('Error in getting user profile:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};

exports.updateProfile = async (req, res) => {
  const { name } = req.body;
  try {
    const user = await User.findByIdAndUpdate(req.userId, { name }, { new: true });
    if (!user) {
      return res.status(404).json({ success: false, message: 'User not found' });
    }

    res.json({ success: true, user });
  } catch (error) {
    console.error('Error in updating user profile:', error);
    res.status(500).json({ success: false, message: 'Server error' });
  }
};
