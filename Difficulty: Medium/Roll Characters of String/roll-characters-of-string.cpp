class Solution {
public:
    string findRollOut(string& s, vector<int>& roll) {
        string str = "";
        int count[1000001] = {0};
        for(int i = 0;i<roll.size();i++){
            count[roll[i]]++;
        }
        int n = roll.size();
        vector<int> v;
        int sum = n;
        for(int i = 0;i<s.length();i++){
            v.push_back(sum);
            sum = sum - count[i+1];
        }

        for(int i = 0;i<s.length();i++){
            char ch = s[i];
            int a = ch - 'a';
            int b = v[i];
            int c = a+b;
            if(c >= 26){
                c = c % 26;
            }
            char ch1 = c + 'a';
            str.push_back(ch1);
        }
        return str;
    }
};