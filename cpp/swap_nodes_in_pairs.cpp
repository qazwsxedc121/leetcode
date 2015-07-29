/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if(head == NULL || head->next == NULL) return head;
        ListNode* slow = head;
        ListNode* fast = head->next;
        ListNode* res = fast;
        ListNode* prev = slow;
        while(slow != NULL && fast != NULL){
            prev->next = fast;
            slow->next = fast->next;
            fast->next = slow;
            if(slow == NULL || slow->next == NULL) break;
            prev = slow;
            slow = slow->next;
            fast = slow->next;
        }
        return res;
    }
};
