package leetCode;

public class RomanToInt {

	public static void main(String[] args) {
		System.out.print(romanToInt("MCMXCIV"));
	}
    public static int romanToInt(String s) {
        int result = 0;
        int num = 0;
        int pred = 0;
        for (int i = 0; i < s.length(); i++){
             switch (s.charAt(i)) {
               case 'I': num = 1; break;
               case 'V': num = 5; break;
               case 'X': num = 10; break;
               case 'L': num = 50; break;
               case 'C': num = 100; break;
               case 'D': num = 500;  break;
               case 'M': num = 1000; break;
             }
             if (pred * 4 < num){
                result = result + (num - 2*pred);
             }
             else{
                  result = result + num;
             }
             pred = num;
        }
        return result;
  }

}
