package Apps;

import java.util.Comparator;

/**
 *
 * @author ITSC 2214 Q
 */
public class Vote implements Comparable<Vote> {

    String name;
    String state;
    int ID;
    String whom2vote;

    public Vote(String name, String state, int ID, String whom2vote) {
       this.name = name;
       this.state = state;
       this.ID = ID;
       this.whom2vote = whom2vote;
    }

    @Override
    public String toString() {
        return name + ":" + state + ":" + ID + ":" + whom2vote;
    }

    /**
     * TODO compare two vote objects based on voting registration ID
     * You could use Comparators.ID.compare method which needs two 
     * arguments.
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Vote o) {
        //TODO compares two vote objects based on voting registration 
        //ID. Please use Comparators.ID.compare method which needs 
        //two arguments
        int result = Comparators.ID.compare(o, this);
        
        return result;


    }

    public static class Comparators {
        /**
         * sort by state Votes will be sorted by states, ignoring 
         * cases. If two votes came from the same state, these two 
         * votes should be sorted based on vote registration ID.
         */
        public static Comparator<Vote> STATE = new Comparator<Vote>() {
            @Override
            public int compare(Vote o1, Vote o2) {
                int i = o1.state.compareToIgnoreCase(o2.state);
                if (i == 0) {
                    return o1.ID - o2.ID;
                }
                return i;
            }
        };
        
        /**
         * sort by state Votes will be sorted by vote registration ID.
         */
        public static Comparator<Vote> ID = new Comparator<Vote>() {
            @Override
            public int compare(Vote o1, Vote o2) {
                return o1.ID - o2.ID;
            }
        };
 
        /**
         * TODO Sort by whom to vote. Votes will be sorted by the information of whom to 
         * vote, ignoring cases. If two votes would like to vote the 
         * same person, these two votes should be sorted based on 
         * voting states; if two votes came from the same state, these 
         * two votes should be sorted based on vote registration ID. 
         */
        public static Comparator<Vote> WHOM2VOTE = new Comparator<Vote>() {
            @Override
            public int compare(Vote o1, Vote o2) {
                //TODO return. 0 if o1's whom2vote is equivalent to o2's
                //     return -1 if o1 should be ordered before o2 according 
                //     the criteria of sorting by whom2vote
                //     return 1 if o1 should be ordered after o2 according 
                //     the criteria of sorting by whom2vote 
                //if (o1.whom2vote.compareToIgnoreCase(o2.whom2vote) )
               
                //compare the values of whom2vote from o1 and o2 
                //if the value difference is not zero retur value difference
                //or else compare the values of state from o1 and o2 
                //if the value difference is not zero retur value difference
                //or else return the vote registration id difference
                String voteP1 = o1.whom2vote;
                String voteP2 = o2.whom2vote;
                
                String voteP3 = o1.state;
                String voteP4 = o2.state;
                
                int voteP5 = o1.ID;
                int voteP6 = o2.ID;

                int result1 = voteP1.compareTo(voteP2);
                int result2 = voteP3.compareTo(voteP4);
                int result3 = Integer.compare(voteP5, voteP6);

                
                if (result1 != 0) 
                {
                    return result1;
                } else if (result2 != 0) 
                {
                    return result2;
                } else 
                {
                    return result3;
                }
                

            }   
            
        };
    }
    
    
}