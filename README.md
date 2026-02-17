# Sorting Algorithm Visualizer
A sorting algorithm visualizer made with Java using Swing.
> [!NOTE]
> This application uses a nanosecond-based simulation to process the visualizer. Expect any lag spikes.
## Guide
Press **Q** to shuffle the list.\
Press **W** to sort the list using the selected sorting algorithm.\
To change the speed of the simulation, change the **sortDelay (ms) in BarList.java**.\
To change the selected sorting algorithm, change the sorting algorithm in the **SortList(ArrayList<BarObject> arr, int delay) method in SortingAlgorithm.java**.
## Available Sorting Algorithms
| Sorting Algorithm | Method | Average Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- |
| Bubble Sort | In-Place Swapping | O(n^2) | O(1) |
| Merge Sort | Divide and Conquer | O(nlogn) | O(n) |
| Quick Sort | Divide and Conquer | O(nlogn) | O(logn) |
| Radix Sort | Least Significant Digit Selection | O(nk) | O(n+k) |
| Bogo Sort | Randomization | O(n*n!) | O(1) |
> [!NOTE]
> You can add any sorting algorithm you want with this app!
