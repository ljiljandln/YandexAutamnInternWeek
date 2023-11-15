package internWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProblemC {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static class Node {
        int value;
        Node parent;
        ArrayList<Node> children = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }

        public void addChild(Node node) {
            children.add(node);
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public int[] findMaxLength() {
            if (children.isEmpty()) return new int[]{1, value};

            int length = 0, value = 0;

            for (Node child : children) {
                int[] arr = child.findMaxLength();
                if (arr[0] >= length) {
                    length = arr[0];
                    value = arr[1];
                }
            }
            return new int[]{length + 1, value};
        }

        public static Node addNode(Node[] arr, int index, Node node) {
            if (node == null) {
                node = new Node(index);
                arr[index] = node;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        Node[] nodeArray = new Node[n + 1];

        Node root = new Node(0);
        nodeArray[0] = root;

        for (int i = 1; i <= n; i++) {
            Node node = nodeArray[i];
            int parentValue = fs.nextInt();
            Node parent = nodeArray[parentValue];

            node = Node.addNode(nodeArray, i, node);
            parent = Node.addNode(nodeArray, parentValue, parent);

            node.setParent(parent);
            parent.addChild(node);
        }

        System.out.print(root.findMaxLength()[1]);
    }
}
