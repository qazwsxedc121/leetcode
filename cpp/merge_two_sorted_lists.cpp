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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* res = new ListNode(0);
        ListNode* p = res;
        ListNode* p1 = l1;
        ListNode* p2 = l2;
        while(p1 != NULL && p2 != NULL){
            if(p1->val < p2->val){
                p->next = p1;
                p1 = p1->next;
                p = p->next;
                p->next = NULL;
            }else{
                p->next = p2;
                p2 = p2->next;
                p = p->next;
                p->next = NULL;
            }
        }
        if(p1 != NULL){
            p->next = p1;
        }else if(p2 != NULL){
            p->next = p2;
        }
        return res->next;

    }
};
