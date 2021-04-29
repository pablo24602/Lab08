import java.util.*;
public class Judge {

    //Method to find judge's number, returns -1 if judge doesn't exist

    public static int findJudge (int N, int [][] trust)
    {
        ArrayList<Integer> j = new ArrayList<>();
        int number = 0;
        int temp;

        /*
        fills out the hashmap j with keys (and corresponding values of 0) for every integer from 1 - N
        */
        HashMap<Integer, Integer> ans = new HashMap<>();
        for (int x = 1; x<N+1; x++)
        {
            ans.put(x, 0);
        }

        /*
        increments the key in the hashmap every time the value corresponding to that key
        appears in the first index of an array
        */
        for(int []a : trust)
        {
            number = a[1];
            temp = ans.get(number);
            ans.replace(number, temp+1);
        }

        boolean NoTrusts;
        int a = 0;
        /*
        The while loop sorts through all the possible values from 1-N.
        For each value we sort through, if the number they correspond to in our hashmap is N-1, which the number of
        that would trust them if they were a judge, we sort through all the arrays in our int [][] trust parameter
        to see if it ever appears at the zeroeth index (thus implying they trusted another number). This would
        disqualify them from being judge, so if they don't appear in any zeroeth index, we add them to the arraylist
        of numbers that meet all requirements to be judge.
         */
        while (a<N+1)
        {
            a++;
            if (ans.get(a)==null)
            {

            }
            else if (ans.get(a)==N-1)
            {
                NoTrusts = true;
                for (int []ji: trust)
                {
                    if (ji[0]==a)
                    {
                        NoTrusts = false;
                    }
                }
                if (NoTrusts)
                {
                    j.add(a);
                }
            }
        }

        /*
        If there are multiple or 0 integers that meet all requirements to be a judge (and are thus in the arraylist),
        we return -1, as there can only be one judge.
        If there is only 1 integer in the arraylist, we return that integer.
         */
        if (j.size()!=1)
        {
            return -1;
        }
        return j.get(0);

    }

    public static void main(String[] args) {
        int[][] j = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}} ;
        int s = findJudge(4, j);
        System.out.print(s);





    }
}
