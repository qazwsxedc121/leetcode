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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int n = lists.size();
        if(n == 0) return NULL;
        if(n == 1) return lists[0];
        if(n == 2) return merge2Lists(lists[0], lists[1]);
        vector<ListNode*> lists1;
        vector<ListNode*> lists2;
        for(int i = 0; i < n / 2; i += 1){
            lists1.push_back(lists[i]);
        }
        for(int i = n / 2; i < n; i += 1){
            lists2.push_back(lists[i]);
        }
        ListNode* list1 = mergeKLists(lists1);
        ListNode* list2 = mergeKLists(lists2);
        return merge2Lists(list1, list2);
    }
    ListNode* merge2Lists(ListNode* list1, ListNode* list2){
        ListNode* res = new ListNode(0);
        ListNode* p = res;
        ListNode* p1 = list1;
        ListNode* p2 = list2;
        while(p1 != NULL && p2 != NULL){
            if(p1->val < p2->val){
                p->next = new ListNode(p1->val);
                p = p->next;
                p1 = p1->next;
            }else{
                p->next = new ListNode(p2->val);
                p = p->next;
                p2 = p2->next;
            }
        }
        while(p1 != NULL){
            p->next = new ListNode(p1->val);
            p = p->next;
            p1 = p1->next;
        }
        while(p2 != NULL){
            p->next = new ListNode(p2->val);
            p = p->next;
            p2 = p2->next;
        }
        return res->next;
    }
};
