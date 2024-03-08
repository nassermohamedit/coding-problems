/**
 * tags: sorting, math, greedy, easy
 * statement: https://codeforces.com/problemset/problem/1767/B
 */

process.stdin.resume();
process.stdin.setEncoding("utf-8");
 
let inputString = "";
let currentLine = 0;
 
process.stdin.on("data", (inputStdin) => {
    inputString += inputStdin;
});
 
process.stdin.on("end", (_) => {
    inputString = inputString
        .trim()
        .split("\n")
        .map((string) => {
            return string.trim();
        });
 
    main();
});
 
function readline() {
    return inputString[currentLine++];
}


function solveCase(n, arr) {
    answer = arr[0];
    arr.sort((a, b) => a - b);
    for (let i=1; i<n; i++) {
        if (arr[i] > answer) {
            answer += Math.floor((arr[i] - answer + 1) / 2);
        }
    }
    return answer;
}

function main() {
    let t = +(readline());
    while (t--) {
        let n = +(readline());
        let arr = readline().split(" ").map(e => parseInt(e));
        console.log(solveCase(n, arr));
    }
}
