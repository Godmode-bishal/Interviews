/*
#include<bits/stdc++.h>
        using namespace std;

        bool ifZero(int i) {
        return i==0;
        }
        int GCD(int first, int second) {
        int t;
        int shift = __builtin_ctz(first|second);
        first >>= __builtin_ctz(first);
        do {
        second >>= __builtin_ctz(second);
        if(first>second) {
        t = second;
        second = first;
        first = t;
        }
        second -= first;
        }while(second != 0);
        return first << shift;
        }

        string solve (int N, vector<int> A) {
        // Write your code here
        auto it = remove_if(A.begin(), A.end(), ifZero);
        A.resize(it-A.begin());
        int first,second;
        for(int j = 1; j<A.size(); j++) {
        first = A[0];
        second = A[j];
        if(GCD(first,second)==1)
        return "YES";
        else
        continue;
        }
        return "NO";
        }

        int main() {

        ios::sync_with_stdio(0);
        cin.tie(0);
        int T;
        cin >> T;
        for(int t_i = 0; t_i < T; t_i++)
        {
        int N;
        cin >> N;
        vector<int> A(N);
        for(int i_A = 0; i_A < N; i_A++)
        {
        cin >> A[i_A];
        }

        string out_;
        out_ = solve(N, A);
        cout << out_;
        cout << "\n";
        }
        }



        #include<bits/stdc++.h>
        using namespace std;

        bool ifZero(int i) {
        return i==0;
        }
        int GCD(int first, int second) {
        int t;
        int shift = __builtin_ctz(first|second);
        first >>= __builtin_ctz(first);
        do {
        second >>= __builtin_ctz(second);
        if(first>second) {
        t = second;
        second = first;
        first = t;
        }
        second -= first;
        }while(second != 0);
        return first << shift;
        }

        string solve (int N, vector<int> A) {
        // Write your code here
        auto it = remove_if(A.begin(), A.end(), ifZero);
        A.resize(it-A.begin());
        int first,second;
        for(int j = 1; j<A.size(); j++) {
        first = A[0];
        second = A[j];
        if(GCD(first,second)==1)
        return "YES";
        else
        continue;
        }
        return "NO";
        }

        int main() {

        ios::sync_with_stdio(0);
        cin.tie(0);
        int T;
        cin >> T;
        for(int t_i = 0; t_i < T; t_i++)
        {
        int N;
        cin >> N;
        vector<int> A(N);
        for(int i_A = 0; i_A < N; i_A++)
        {
        cin >> A[i_A];
        }

        string out_;
        out_ = solve(N, A);
        cout << out_;
        cout << "\n";
        }
        }*/
