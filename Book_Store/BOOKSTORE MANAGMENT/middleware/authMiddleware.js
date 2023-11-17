const jwt = require('jsonwebtoken');

module.exports = (req, res, next) => {
  // Get the token from the request header
  const token = req.header('Authorization');

  // Check if there's no token
  if (!token) {
    return res.status(401).json({ success: false, message: 'Authentication failed: No token provided' });
  }

  try {
    // Verify the token using your secret key (you should store this securely)
    const decodedToken = jwt.verify(token, 'your-secret-key');

    // Attach the user ID to the request for further use in controllers
    req.userId = decodedToken.userId;

    // Continue to the next middleware or route handler
    next();
  } catch (error) {
    console.error('Error in authentication middleware:', error);
    return res.status(401).json({ success: false, message: 'Authentication failed: Invalid token' });
  }
};
