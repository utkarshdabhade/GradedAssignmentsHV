const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const nodemon = require ('nodemon');
const morgan = require ('morgan');
const cors = require('cors'); // If you need to handle cross-origin requests

// Initialize Express app
const app = express();

// Middleware
app.use(bodyParser.json()); // Parse JSON request bodies
app.use(cors()); // Enable CORS for cross-origin requests

// Database connection
mongoose.connect('mongodb://localhost/bookstore', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});
mongoose.connection.on('connected', () => {
  console.log('Connected to MongoDB');
});
mongoose.connection.on('error', (err) => {
  console.error('MongoDB connection error:', err);
});

// Routes
const userRoutes = require('./routes/userRoutes');
const bookRoutes = require('./routes/bookRoutes');
const cartRoutes = require('./routes/carRoutes');

app.use('/users', userRoutes);
app.use('/books', bookRoutes);
app.use('/cart', cartRoutes);

// Handle 404 errors (route not found)
app.use((req, res, next) => {
  res.status(404).json({ success: false, message: 'Route not found' });
});

// Error handling middleware
app.use((err, req, res, next) => {
  console.error(err);
  res.status(500).json({ success: false, message: 'Internal server error' });
});

module.exports = app;
