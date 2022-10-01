// Create a list of fruits with their properties (name, color, pricePerKg)
// and convert it into a format so that for a given fruit name
// retrieval of its color and pricePerKg value is fast


// Write your code here

const fruits = [
    { name: 'orange', color: 'orange', pricePerKg: "120" },
    { name: 'mango', color: 'green', pricePerKg: "250" },
    { name: 'apple', color: 'red', pricePerKg: "200" }
]


const convert = (arr, key) => {
    res = {};
    if (typeof (arr) == 'object') {
        arr.forEach(element => {
            res[element[key]] = element;
        });
        return res;
    } else { return null }
};

var searchFruits = convert(fruits)