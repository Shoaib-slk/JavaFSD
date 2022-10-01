// Write a program to display one result card of 100 students
// with their name and percentage
// Out of 100 students, 50 has subjects - Grammer and Accounts
// and other 50 has subjects -  Grammer and Physics

// Hint : You need to calculate percentage of 100 students having different set of subjects.
//        You can assume their scores on their respective subjects.


// Write your code here

var students = [
    { name: 'A', subject: ['Grammar', 'Accounts'], scores: [20, 40] },
    { name: 'B', subject: ['Grammar', 'Accounts'], scores: [30, 40] },
    { name: 'C', subject: ['Grammar', 'Accounts'], scores: [40, 50] },
    { name: 'D', subject: ['Grammar', 'Accounts'], scores: [50, 60] },
    { name: 'E', subject: ['Grammar', 'Accounts'], scores: [60, 70] },

    { name: 'H', subject: ['Grammar', 'Physics'], scores: [20, 40] },
    { name: 'I', subject: ['Grammar', 'Physics'], scores: [30, 40] },
    { name: 'J', subject: ['Grammar', 'Physics'], scores: [20, 40] },
    { name: 'K', subject: ['Grammar', 'Physics'], scores: [30, 40] },
    { name: 'L', subject: ['Grammar', 'Physics'], scores: [40, 10] }
]

const Result = (stu) => {
    let op =
        stu.map((item, index) => {
            let total = item.scores.reduce((a, b) => a + b, 0);
            let percentage = (total / 200) * 100;
            item.percentage = +percentage.toFixed(2);
            return item
        })
    return op;
};

let res = Result(students);
res.map(nameVal => {
    console.log(`Name=${nameVal.name} and Percentage=${nameVal.percentage}%`)
})