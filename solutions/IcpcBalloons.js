/**
 * tags: ds
 * statement: https://codeforces.com/problemset/problem/1703/B
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

function solveCase(n, s) {
    let answer = 0;
    let solved = new Set();
    for (let i=0; i<n; i++) {
        if (solved.has(s[i])) answer++;
        else {
            solved.add(s[i]);
            answer += 2;
        }
    }
    console.log(answer);
}

function main() {
    let t = +(readline());
    while (t--) {
        let n = +(readline());
        let s = readline();
        solveCase(n, s);
    }
}
