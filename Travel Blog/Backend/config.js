const dotenv = require('dotenv');

dotenv.config();

module.exports = {
    get(name) {
        const value = process.env[name];

        if (!value) {
            throw new Error(`Environment variable not found: ${name}`);
        }

        return value;
    },
    jwtSecret: process.env.JWT_SECRET || 'a-very-secure-secret-key'
};