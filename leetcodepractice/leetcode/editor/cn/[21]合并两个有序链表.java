//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2104 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 非递归
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode result = null;
        ListNode last = null;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                ListNode next = cur1.next;
                //cur1尾插到结果链表
                cur1.next = null;
                if(result == null){
                    result = cur1;
                }else{
                    last.next = cur1;
                }
                last = cur1;
                cur1 = next;
            }else{
                ListNode next = cur2.next;
                //cur2尾插到结果链表
                cur2.next = null;
                if(result == null){
                    result = cur2;
                }else{
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
        }
        if(cur1!=null){
            last.next = cur1;
        }
        if(cur2!=null){
            last.next = cur2;
        }
        return result;
    }
}


// 递归
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//         if(list1==null){
//             return list2;
//         }else if(list2==null){
//             return list1;
//         }else if(list1.val < list2.val){
//             list1.next = mergeTwoLists(list1.next, list2);
//             return list1;
//         }else{
//             list2.next = mergeTwoLists(list1,list2.next);
//             return list2;
//         }
//     }
// }
//leetcode submit region end(Prohibit modification and deletion)
