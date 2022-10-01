/* Write a program to build a `Pyramid of stars` of given height */

const buildPyramid = (x) => {
     // Write your code here
     let op = '';
     for (let i = 0; i < x; i++) {
          op = op + `${' '.repeat(x - i)}`;
          op = op + `${'* '.repeat(i + 1)} `
          op = op + `\n`
     }
     return (op);
};
/* For example,

INPUT - buildPyramid(6)
OUTPUT -
     *
    * *
   * * *
  * * * *
 * * * * *
* * * * * *

*/

module.exports = buildPyramid;
