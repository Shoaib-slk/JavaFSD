/* Write a Program to convert an array of objects to an object
	based on a given key */


const convert = (arr, key) => {
	// Write your code here
	res = {};
	if (typeof (arr) == 'object') {
		arr.forEach(element => {
			res[element[key]] = element;
		});
		return res;
	} else { return null }
};

convert([{ id: 1, value: 'abc' }, { id: 2, value: 'xyz' }], 'id')


/* For example,
INPUT - convert([{id: 1, value: 'abc'}, {id: 2, value: 'xyz'}], 'id')
OUTPUT - {
			'1': {id: 1, value: 'abc'},
			'2': {id: 2, value: 'xyz'}
		 }


*/

module.exports = convert;
