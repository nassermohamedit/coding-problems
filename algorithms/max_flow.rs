use std::cmp::min;
use std::collections::VecDeque;

fn max_flow(s: usize, t: usize, adj: Vec<Vec<usize>>, capacity: &mut Vec<Vec<u32>>) -> u32 {
    let mut parent: Vec<i32> = Vec::new();
    let mut max_flow = 0;
    while true {
        let p_flow = bfs_util(&s, &t, &adj, &capacity, &mut parent);
        if p_flow == 0 {
            break;
        }
        let mut u = t;
        while parent[u] != -1 {
            let v = parent[u];
            capacity[v as usize][u] -= p_flow;
            capacity[u][v as usize] += p_flow;
        }
    }
    max_flow
}

fn bfs_util(s: &usize, t: &usize, adj: &Vec<Vec<usize>>, capacity: &Vec<Vec<u32>>, parent: &mut Vec<i32>) -> u32 {
    parent.fill(-1);
    parent[*s] = -1;
    let mut queue: VecDeque<(usize, u32)> = VecDeque::new();
    queue.push_back((*s, u32::MAX));
    while !queue.is_empty() {
        let first = queue.front().unwrap();
        let u = first.0;
        let p_flow = first.1;
        for v in &adj[u] {
            if (parent[*v] == -1 && capacity[u][*v] > 0) {
                parent[*v] = u as i32;
                let new_flow = min(p_flow, capacity[u][*v]);
                if *v == *t {
                    return new_flow;
                }
                queue.push_back((*v, new_flow));
            }
        }
    }
    0
}
