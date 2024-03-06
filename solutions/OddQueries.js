/*
 * tags: prefixsum, ds, da
 * statement: https://codeforces.com/problemset/problem/1807/D
*/

process.stdin.resume();
process.stdin.setEncoding('utf8');

let input = ""
let currLine = 0;

process.stdin.on("data", (data) => {
    input += data;
});

process.stdin.on("end", (_) => {
    input = input.
        trim().
        split('\n').
        map((string) => {
            return string.trim();
        })
    main();
})

function readline() {
    return input[currLine++];
}

let arr = new Array(100005).fill(0);
let cumSum = new Array(100005).fill(0);


function main() {
    let t = +(readline());
    while (t--) {
        let [n, q] = readline().split(' ').map(str => parseInt(str));
        let vals = readline().split(' ').map(str => parseInt(str));
        for (let i=1; i<=n; i++) {
            arr[i] = vals[i-1];
            cumSum[i] = cumSum[i-1] + arr[i];
        }
        while (q--) {
            let [l, r, k] = readline().split(' ').map(str => parseInt(str));
            if (solveCase(n, arr, cumSum, l, r, k)) console.log("yes")
            else console.log("no");
        }
    }
}

function solveCase(n, arr, cumSum, l, r, k) {
    return (cumSum[n] - cumSum[r] + cumSum[l-1] + (r-l+1)*k)%2 == 1;
}
