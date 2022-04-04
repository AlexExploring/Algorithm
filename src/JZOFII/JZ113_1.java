package JZOFII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * �γ�˳��
 *
 * ��Ŀ���ͣ���������
 */
public class JZ113_1 {
    // �洢����ͼ
    List<List<Integer>> edges;
    // �洢ÿ���ڵ�����
    int[] indeg;
    // �洢��
    int[] result;
    // ���±�
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //���ݳ�ʼ��
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        //��֪��0 <= ��֪�γ̱�� < numCourses;
        //���prerequisites = [[1,0],[2,0],[3,1],[3,2]],numCourses = 4,��ôedges�д洢�Ľ���
        //[[1,2],[3],[3]];  �� 0 -> 1,0 -> 2,1 -> 3,2 -> 3;
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            //�ۼ�ÿ���ڵ�����
            ++indeg[prerequisite[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // ���������Ϊ 0 �Ľڵ���������
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        //�����Ϊ0�Ľڵ㿪ʼ����
        while (!queue.isEmpty()) {
            // �Ӷ���ȡ��һ���ڵ�
            int u = queue.poll();
            // �������
            result[index++] = u;
            //�������ڵĽڵ�
            for (int v: edges.get(u)) {
                --indeg[v];
                // ������ڽڵ� v �����Ϊ 0���Ϳ���ѡ v ��Ӧ�Ŀγ���
                if (indeg[v] == 0) {
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
