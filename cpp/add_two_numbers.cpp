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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* p1 = l1;
        ListNode* p2 = l2;
        ListNode* head = new ListNode(0);
        ListNode* p = head;
        int carry = 0;
        while(p1 != NULL && p2 != NULL){
            p->next = new ListNode(0);
            p = p->next;
            if(p1->val + p2->val + carry >= 10){
                p->val = p1->val + p2->val + carry - 10;
                carry = 1;
            }else{
                p->val = p1->val + p2->val + carry;
                carry = 0;
            }
            p1 = p1->next;
            p2 = p2->next;
        }
        while(p1 != NULL){
            p->next = new ListNode(0);
            p = p->next;
            if(p1->val + carry >= 10){
                p->val = p1->val + carry - 10;
                carry = 1;
            }else{
                p->val = p1->val + carry;
                carry = 0;
            }
            p1 = p1->next;
        }
        while(p2 != NULL){
            p->next = new ListNode(0);
            p = p->next;
            if(p2->val + carry >= 10){
                p->val = p2->val + carry - 10;
                carry = 1;
            }else{
                p->val = p2->val + carry;
                carry = 0;
            }
            p2 = p2->next;
        }
        if(carry != 0){
            p->next = new ListNode(1);
        }
        return head->next;
    }
};
