module.exports = {
    dialect: 'postgres',
    host: 'localhost',
    username: 'postgres',
    password: 'P@ssw0rd',
    database: 'gobarberdb',
    define: {
        timestamps: true,
        underscored: true,
        underscoredAll: true,
    },
};
