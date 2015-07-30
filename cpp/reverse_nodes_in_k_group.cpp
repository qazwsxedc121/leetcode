/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
private:
    ListNode* reverse(ListNode* src){
        ListNode* p1 = src;
        ListNode* p2 = src->next;
        if(p2 == NULL) return src;
        ListNode* res = p2;
        ListNode* p3;
        p1->next = NULL;
        while(p1 != NULL && p2 != NULL){
            p3 = p2->next;
            p2->next = p1;
            p1 = p2;
            res = p1;
            p2 = p3;
        }
        return res;;
    }
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        int count = 0;
        if(k <= 1) return head;
        ListNode* p = head;
        ListNode* last_head = head;
        ListNode* res = NULL;
        ListNode* res_tail = NULL;
        while(p != NULL){
            if(count == k - 1){
                ListNode* p_next = p->next; //save for keepgoing
                p->next = NULL; // break;
                ListNode* new_list_head = reverse(last_head);
                if(res == NULL){
                    res = new_list_head;
                    res_tail = last_head;
                }else{
                    res_tail->next = new_list_head;
                    res_tail = last_head;
                }
                last_head = p_next;
                p = p_next;
                count = 0;
            }else{
                p = p->next;
                count += 1;
            }
        }
        if(res == NULL) res = last_head;
        if(res_tail != NULL) res_tail->next = last_head;
        return res;
    }
};
