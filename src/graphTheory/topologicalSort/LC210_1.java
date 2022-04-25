package graphTheory.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * �γ�˳��
 *
 * ��Ŀ���ͣ���������
 */
public class LC210_1 {
    // �洢����ͼ
    List<List<Integer>> edges;
    // �洢ÿ���ڵ�����
    int[] inDegree;
    // �洢��
    int[] result;
    // ���±�
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //���ݳ�ʼ��
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        inDegree = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        //��֪��0 <= ��֪�γ̱�� < numCourses;
        //���prerequisites = [[1,0],[2,0],[3,1],[3,2]],numCourses = 4,��ôedges�д洢�Ľ���
        //[[1,2],[3],[3]];  �� 0 -> 1,0 -> 2,1 -> 3,2 -> 3;
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            //�ۼ�ÿ���ڵ�����
            ++inDegree[prerequisite[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // ���������Ϊ 0 �Ľڵ���������
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        //�����Ϊ0�Ľڵ㿪ʼ����
        while (!queue.isEmpty()) {
            // �Ӷ���ȡ��һ���ڵ�
            int u = queue.poll();
            // �����Ϊ0�Ľڵ�������
            result[index++] = u;
            //�������ڵĽڵ�
            for (int v: edges.get(u)) {
                //�������Ľڵ����ȼ�һ
                --inDegree[v];
                // ������ڽڵ� v �����Ϊ 0���Ϳ���ѡ v ��Ӧ�Ŀγ���
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}
