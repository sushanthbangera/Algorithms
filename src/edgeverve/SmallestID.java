/*
 * Instructions:

 

This is a debug type question.
Once you choose the language of your choice to code, the editor window will be populated with a program.

The program would have one or more bugs which prevent it from providing right results upon clicking “Run Code”

You need to understand the question and the provided program. You need to then correct the program such that, upon running the program, all the test cases pass successfully.

This is denoted by a message that says “Code Compiled Successfully. All available test cases passed!”

You can submit the code once you are done.

 

Question description:

At Indian Idol, each participant has a unique 4-digit identifiers. For example, 2547 is a participant identifier (the first digit must be non-zero). However, judges at Indian Idol find these identifier numbers too large to remember. So, they want to replace each identifier with a smaller number, which is easier to manage and remember.
Write a program that generates the smallest positive integer M such that the list of identifiers modulo M (the remainder after division of one number (identifier) by another (M)) renders a similar set of unique identifiers for the participants. This way, the judges can identify each participant with a smaller id, with each id still being unique with a 1:1 mapping to original ids!

Example

Suppose two participants have identifiers as 8967 and 9485. 

In the following way we can identify the M, such that (ID mod M) will produce corresponding smaller ids:

8-digit Ids

Mod 2

Mod 3

Mod 8

Explanation

8967

1

0

2 doesn’t give unique IDs. Both 3 and 8 gives unique IDs. But 3 is the smallest positive integer to do so. Hence, the answer here is 3 (M=3).

9485

1

2

5

 

Input Format

Input line starts with an integer containing the number of participants in the show. This integer is followed by the list of 4-digit identifiers for each participant.

The number of participants will be between 1<=participants<=30.

          
Output Format

Smallest Integer M

 

Example Input

Example Output

2 9098 8495

2

3 8663 7436 9293

4
 */
package edgeverve;

import java.util.HashSet;
import java.util.Scanner;
import utils.Utility;

/**
 *
 * @author Sushanth Bangera
 */
public class SmallestID {

    public static void main(String[] args) {
        Scanner ins = new Scanner(System.in);
        String ip = ins.nextLine();
        String[] na = ip.split(" ");
       
        int noi = Integer.parseInt(na[0]);
        Long[] in = new Long[noi];
        for (int i = 1; i <= noi; i++) {
            in[i - 1] = Long.parseLong(na[i]);
        }
        
        //Utility.printArray(in);

        System.out.println(FN(in));
    }

    public static int FN(Long[] ins) {
        boolean a = false;
        int n = 2;
        
        while (!a) {
            HashSet<Long> um = new HashSet<>();
            for (int i = 0; i < ins.length; i++) {
                Long ni = ins[i] % n;
                
                if (um.contains(ni)) {
                    break;
                } else {
                    um.add(ni);
                    if (um.size() == ins.length) {
                        a = true;
                    }
                }
            }
            if (!a) {
                n++;
            }
        }
        return n;
    }
}
