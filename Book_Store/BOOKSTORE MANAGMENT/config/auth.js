const jwt = require('jsonwebtoken');

require('dotenv').config();


// Get the secret key from environment variables
const secretKey = process.env.SECRET_KEY;

// // Your secret key (replace with a strong, secret key)
// const secretKey = 'your-secret-key';

// Generate a JWT token
function generateToken(userId) {
  const token = jwt.sign({ userId }, secretKey, { expiresIn: '1h' }); // Token expires in 1 hour
  return token;
}




// Verify a JWT token
function verifyToken(token) {
  try {
    const decodedToken = jwt.verify(token, secretKey);
    return decodedToken;
  } catch (error) {
    throw new Error('Invalid token');
  }
}

module.exports = { generateToken, verifyToken };
