/**
 * implementation
 * statement: https://codeforces.com/problemset/problem/1760/C
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
    let max = 0;
    for (let i=1; i<n; i++) {
        if (arr[i] > arr[max]) max = i;
    }
    max2 = (max != 0)? 0: 1;
    for (let i=0; i<n; i++) {
        if (i == max) continue;
        if (arr[i] > arr[max2]) max2 = i;
    }
    let answer = "";
    for (let i=0; i<n; i++) {
        if (i != max) {
            answer += (arr[i] - arr[max]) + " ";
        }
        else {
            answer += (arr[i] - arr[max2]) + " ";
        }
    }
    console.log(answer);
}

function main() {
    let t = +(readline());
    while (t--) {
        let n = +(readline());
        let arr = readline().split(" ").map(e => parseInt(e));
        solveCase(n, arr);
    }
}
