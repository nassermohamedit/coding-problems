/**
 * tags: data structures, implementation
 * statement: https://codeforces.com/problemset/problem/1798/B
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

let arr = new Array(50005).fill(0);
let winners = new Array(50005).fill(0);


function main() {
    let t = +(readline());
    while (t--) {
        let n = 0;
        let m = +(readline());
        for (let i=1; i<=m; i++) {
            winners[i] = 0;
            readline();
            readline().split(" ").forEach(x => {
                p = parseInt(x);
                arr[p] = i;
                if (p > n) n = p;
            });
        }
        for (let i=1; i<=n; i++) {
            if (arr[i] !== 0 && winners[arr[i]] === 0) {
                winners[arr[i]] = i;
            }
            arr[i] = 0;
        }
        let answer = "";
        let noSol = false;
        for (let i=1; i<=m; i++) {
            if (winners[i] === 0) {
                answer = -1;
                break;
            }
            answer += winners[i] + " ";
        }
        console.log(answer);
    }
}

