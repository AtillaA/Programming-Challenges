import java.util.*;

class Result {
    public static int getRetryCount(int gap, List<String> requestIds, List<Integer> timestamps) {
        int retryAccumulator = 0;
        int logLimit = requestIds.size();
        
        // cache the single most recent timestamp recorded for each unique ID
        Map<String, Integer> logMatrix = new HashMap<>();

        // traversal config through the requests
        for (int i = 0; i < logLimit; i++) {
            String targetIdentity = requestIds.get(i);
            int currTs = timestamps.get(i);

            // check if the identifier has priorly recorded
            if (logMatrix.containsKey(targetIdentity)) {
                int prevTs = logMatrix.get(targetIdentity);
                
                // time interval matrix difference against the maximum gap
                if (currTs - prevTs <= gap) {
                    retryAccumulator++;
                }
            }
            
            // update pattern: overwrite the tracker with the newest log timestamp configuration
            logMatrix.put(targetIdentity, currTs);
        }

        return retryAccumulator;
    }
}
