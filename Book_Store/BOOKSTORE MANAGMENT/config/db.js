const mongoose = require('mongoose');

require('dotenv').config();


// Your MongoDB connection URL
const dbURL = 'mongodb://localhost/bookstore'; // Replace with your actual database URL

// Connect to MongoDB
mongoose.connect(dbURL, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

// Handle database connection events
mongoose.connection.on('connected', () => {
  console.log('Connected to MongoDB');
});

mongoose.connection.on('error', (err) => {
  console.error('MongoDB connection error:', err);
});

mongoose.connection.on('disconnected', () => {
  console.log('Disconnected from MongoDB');
});

module.exports = mongoose.connection;
