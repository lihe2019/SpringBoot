class Solution1119 {
    public String removeVowels(String S) {
        char cur;
        String res = "";
        for (int i = 0; i < S.length(); i++) {
            cur = S.charAt(i);

            if (cur!='a' && cur!='e' && cur!='i' && cur!='o' && cur!='u'){
                res += cur;
            }
        }
        return res;
    }
    // 注意stringbuilder比string快很多
}