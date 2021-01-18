/**
 *
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 *
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 */
public class CountSortedVowelString {

    char[] vowels={'a','e','i','o','u'};

    public int countVowelStrings(int n) {

        int res=0;
        for (char v:vowels) {
            res+=count(n-1,v);
        }

        return res;
    }

    private int count(int len, char v) {
        if(len==0)
            return 1;
        int temp=0;
        for (char vowel:
             vowels) {
            if(vowel>=v)
                temp+=count(len-1,vowel);
        }
        return temp;
    }

    public static void main(String[] args) {

        CountSortedVowelString obj=new CountSortedVowelString();

        int n=2;
        int i = obj.countVowelStrings(n);
        System.out.println(i);
    }
}
