/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        HashMap<Integer, Node> og = new HashMap<>(); // index,Node of OG
        HashMap<Node, Integer> ogInverse = new HashMap<>(); // Node,index of OG
        HashMap<Integer, Node> copy = new HashMap<>(); // index.Node of copy
        Node temp = head;
        Node ans = null;
        Node rootAns = null;

        ogInverse.put(null, -1);

        int i = 0;
        while (temp != null) {
            og.put(i, temp);
            ogInverse.put(temp, i);

            if (ans == null) {
                ans = new Node(temp.val);
                rootAns = ans;
                copy.put(i, ans);
            } else {
                ans.next = new Node(temp.val);
                ans = ans.next;
                copy.put(i, ans);
            }
            i++;
            temp = temp.next;
        }

        temp = rootAns;
        i = 0;
        while (temp != null) {
            Node original = og.get(i);
            int randomIndex = ogInverse.get(original.random);

            if (randomIndex == -1) {
                temp.random = null;
            } else {
                temp.random = copy.get(randomIndex);
            }
            i++;
            temp = temp.next;
        }
        return rootAns;

    }
}
// @lc code=end
