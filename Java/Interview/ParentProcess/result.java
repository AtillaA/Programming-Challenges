class Result {
    public static int findParent(int processNumber) {
      // base condition
      if (processNumber <= 1) { return 0; }

        // define search range matrix parameters for the binary search
        long lowerBound = 1;
        long upperBound = processNumber;
        long resultNode = 1;

        // logarithmic tree segment evaluation
        while (lowerBound <= upperBound) {
            long midPointer = lowerBound + (upperBound - lowerBound) / 2;
            
            // calculates total sequential children generated up to parent node
            long treeLimit = 1L + (midPointer * (midPointer + 1L)) / 2L;

            // decision matrix routing based on total sequential ids generated
            if (treeLimit >= (long) processNumber) {
                resultNode = midPointer;
                upperBound = midPointer - 1L; // restructure bounds leftward
            } else {
                lowerBound = midPointer + 1L; // restructure bounds rightward
            }
        }

        // return the calculated long boundary, parsed back to an integer
        return (int) resultNode;
    }
}
