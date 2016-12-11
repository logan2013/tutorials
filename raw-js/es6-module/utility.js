/**
 * Created by Logan on 2016/12/8.
 */
function generateRandom() {
    return Math.random();
}

function sum(a, b) {
    return a + b;
}

function substract(a, b) {
    return a - b;
}

function multiply(a, b) {
    return a * b;
}

export {generateRandom, sum, substract as sub, multiply};