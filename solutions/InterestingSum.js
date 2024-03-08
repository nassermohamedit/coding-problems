/**
 * tags: sorting, math, greedy
 * statement: https://codeforces.com/problemset/problem/1720/B
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
    arr.sort((a, b) => a - b);
    console.log(arr[n-1] + arr[n-2] - arr[0] - arr[1]);
}

function main() {
    let t = +(readline())
    while (t--) {
        let n = +(readline());
        let arr = readline().split(" ").map(e => parseInt(e));
        solveCase(n, arr);
    }
}
