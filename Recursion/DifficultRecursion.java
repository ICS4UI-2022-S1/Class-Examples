public class DifficultRecursion {
    
    public static int toDecimal(String binary, int position){
        // no more digits to use
        if(binary.length() == 0){
            return 0;
        }
        // rip off the last digit
        char digit = binary.charAt(binary.length() - 1);
        // shorten the binary String
        binary = binary.substring(0, binary.length() - 1);
        // decide to add or not to add
        if(digit == '1'){
            return (int)Math.pow(2, position) + toDecimal(binary, position + 1);
        }else{
            return toDecimal(binary, position + 1);
        }
    }

    public static void combos(String word, String progress, int numInGroup){
        // base cases - 
        
        // found the right length?
        if(progress.length() == numInGroup){
            // print it and stop this path
            System.out.println(progress);
            return;
        // run out of letters?
        }else if(word.length() == 0){
            // stop execution of this path
            return;
        }
        // pull the first letter
        char firstLetter = word.charAt(0);
        // chop that letter off the possible values
        word = word.substring(1);

        // either use the letter or not
        // choice 1: use it! - add the letter to progress
        combos(word, progress + firstLetter, numInGroup);

        // choice 2: don't use it - don't add the letter in
        combos(word, progress, numInGroup);
    }

    public static void main(String[] args) {
        //combos("ABCD","",2);
        System.out.println(toDecimal("10111", 0));
    }
}
