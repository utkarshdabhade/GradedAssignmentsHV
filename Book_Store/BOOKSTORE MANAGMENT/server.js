const app = require('./app'); // Import your Express app from app.js

// Define the port where your server will listen
const port = process.env.PORT || 5000;

// Start the Express server
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
