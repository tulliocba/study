module.exports = {
    env: {
        browser: true,
        commonjs: true,
        es6: true,
    },
    extends: [
        'airbnb-base',
        'prettier'
    ],
    plugins: [
        'prettier'
    ],
    globals: {
        Atomics: 'readonly',
        SharedArrayBuffer: 'readonly',
    },
    parserOptions: {
        ecmaVersion: 2018,
    },
    rules: {
        "class-methods-use-this": "off",
        "prettier/prettier": "error",
        "no-param-reassign": "off",
        "camelcase": "off",
        "no-unused-vars": ["error", { "argsIgnorePattern": "next" }]
    },
};