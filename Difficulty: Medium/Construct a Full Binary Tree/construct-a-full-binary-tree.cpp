class Solution {
    int preIndex;

    Node* build(vector<int> &pre, vector<int> &preMirror,
                int l, int r, unordered_map<int, int> &pos) {
        if (preIndex >= pre.size() || l > r)
            return nullptr;

        Node *root = new Node(pre[preIndex++]);

        // Leaf node
        if (l == r || preIndex >= pre.size())
            return root;

        // Position of the next preorder element in mirror preorder
        int idx = pos[pre[preIndex]];

        // Mirror preorder stores: root -> right -> left
        root->left = build(pre, preMirror, idx, r, pos);
        root->right = build(pre, preMirror, l + 1, idx - 1, pos);

        return root;
    }

public:
    Node *constructBinaryTree(vector<int> &pre, vector<int> &preMirror) {
        unordered_map<int, int> pos;
        for (int i = 0; i < preMirror.size(); i++)
            pos[preMirror[i]] = i;

        preIndex = 0;
        return build(pre, preMirror, 0, preMirror.size() - 1, pos);
    }
};
 