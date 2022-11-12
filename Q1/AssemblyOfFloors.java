package Q1;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class AssemblyOfFloors {

	int noOfFloors;

	public AssemblyOfFloors(int totalFloors) {
		noOfFloors = totalFloors;
	}

	PriorityQueue<Integer> queue = new PriorityQueue<>(java.util.Collections.reverseOrder());
	Queue<Integer> floorOnHold = new LinkedList<Integer>();

	public void floorConstruction(int size) {

		if (size < noOfFloors) {
			queue.add(size);
		} else {
			floorOnHold.add(size);
			noOfFloors--;
			if (!queue.isEmpty()) {
				while ((!queue.isEmpty()) && (queue.peek() == noOfFloors)) {
					floorOnHold.add(queue.remove());
					noOfFloors--;
				}
			}
		}

		while (!floorOnHold.isEmpty()) {
			System.out.print(floorOnHold.remove() + " ");
		}
	}
}