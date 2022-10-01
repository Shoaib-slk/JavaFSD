/* Write a Program to Flatten a given n-dimensional array */

const { type } = require("mocha/lib/utils");

const flat = (arr) => {
	return Array.isArray(arr) ? [].concat.apply([], arr.map(flat)) : arr;
}

const flatten = (arr) => {
	// Write your code here
	//return [].concat.apply([], arr);
	if (typeof (arr) == 'object') {
		return flat(arr);
	} else return null;
};


/* For example,
INPUT - flatten([1, [2, 3], [[4], [5]])
OUTPUT - [ 1, 2, 3, 4, 5 ]

*/

module.exports = flatten;
