package a_books.Aha.di4zhang;
 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ss5_1 {
 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			String s = "01010101001011001001010110010110100100001000101010"
					+ "00001000100000101010010000100000001001100110100101"
					+ "01111011010010001000001101001011100011000000010000"
					+ "01000000001010100011010000101000001010101011001011"
					+ "00011111000000101000010010100010100000101100000000"
					+ "11001000110101000010101100011010011010101011110111"
					+ "00011011010101001001001010000001000101001110000000"
					+ "10100000101000100110101010111110011000010000111010"
					+ "00111000001010100001100010000001000101001100001001"
					+ "11000110100001110010001001010101010101010001101000"
					+ "00010000100100000101001010101110100010101010000101"
					+ "11100100101001001000010000010101010100100100010100"
					+ "00000010000000101011001111010001100000101010100011"
					+ "10101010011100001000011000010110011110110100001000"
					+ "10101010100001101010100101000010100000111011101001"
					+ "10000000101100010000101100101101001011100000000100"
					+ "10101001000000010100100001000100000100011110101001"
					+ "00101001010101101001010100011010101101110000110101"
					+ "11001010000100001100000010100101000001000111000010"
					+ "00001000110000110101101000000100101001001000011101"
					+ "10100101000101000000001110110010110101101010100001"
					+ "00101000010000110101010000100010001001000100010101"
					+ "10100001000110010001000010101001010101011111010010"
					+ "00000100101000000110010100101001000001000000000010"
					+ "11010000001001110111001001000011101001011011101000"
					+ "00000110100010001000100000001000011101000000110011"
					+ "10101000101000100010001111100010101001010000001000"
					+ "10000010100101001010110000000100101010001011101000"
					+ "00111100001000010000000110111000000001000000001011"
					+ "10000001100111010111010001000110111010101101111000";
			int[][] map = new int[30][50];
			for (int i = 0; i < 30; i++) {
				for (int j = 0; j < 50; j++) {
					map[i][j] = s.charAt(50 * i + j) - '0';
				}
			}
			System.out.println(BFS(map, 30, 50));
		} catch (Exception e) {
			input.close();
		}
	}
 
	public static String BFS(int[][] labyrinth, int row, int column) {
		int[][] next = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } }; // 上 右 左 下
		String[] direction = { "U", "R", "L", "D" };
		int[][] book = new int[row][column]; //标记是否已经访问过
		StringBuilder sb = new StringBuilder();//用来找路径
		Node node = new Node(0, 0, -1, -1, 0, null);//初始化
		Queue<Node> queue = new LinkedList<Node>();//使用官方提供的队列
		Stack<Node> stack = new Stack<Node>();
		queue.offer(node);//初始化节点，将起点所代表的节点放入队列中
		while (!queue.isEmpty()) {//当队列不为空时
			Node head = queue.poll();  //直接先将头节点出队
			stack.push(head); // 用于回溯路径
			book[head.x][head.y] = 1;
			for (int i = 0; i < 4; i++) {
				int x = head.x + next[i][0];
				int y = head.y + next[i][1];
				String d = direction[i];//d是由上一个位置但到当前位置的前进方向

				// bfs
				if (x >= 0 && x < row && y >= 0 && y < column && labyrinth[x][y] == 0 && book[x][y] == 0) {
					Node newNode = new Node(x, y, head.x, head.y, head.step + 1, d);
					queue.offer(newNode);
				}
				// exit
				if (x == row - 1 && y == column - 1 && labyrinth[x][y] == 0 && book[x][y] == 0) {
					// 打印路径
					Node top = stack.pop();
					sb.append(d);
					sb.append(top.direction);
					int preX = top.preX;
					int preY = top.preY;
					while (!stack.isEmpty()) {
						top = stack.pop();
						if (preX == top.x && preY == top.y) {
							if (top.direction != null)
								sb.append(top.direction);
							preX = top.preX;
							preY = top.preY;
						}
					}
					return sb.reverse().toString();
				}
			}
		}
		return null;
	}
}


class Node {
	int x, y;
	int step;//步数
	int preX, preY;//用来找路径
	String direction;

	/**
	 * @param preX 当前节点的父节点的x坐标
	 * @param preY 当前节点的父节点的y坐标
	 * @param direction 存储的是父节点到当前节点的方向，用于回溯路径
	 */
	Node(int x, int y, int preX, int preY, int step, String direction) {
		this.x = x;
		this.y = y;
		this.preX = preX;
		this.preY = preY;
		this.step = step;
		this.direction = direction;
	}
}