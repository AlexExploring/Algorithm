package String;

public class LC12 {
    public static void main(String[] args) {

    }

    public static String intToRoman(int num) {
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuffer ans = new StringBuffer();
        for(int i=0; i<13; i++){
            while(num>=values[i]){
                num -= values[i];
                ans.append(reps[i]);
            }
        }
        return ans.toString();
    }
}
