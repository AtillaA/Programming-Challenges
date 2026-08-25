function maxPresentations(scheduleStart: number[], scheduleEnd: number[]): number {
    const presentationCount = scheduleStart.length;

    // base
    if (presentationCount === 0) { return 0; }

    // structure records explicitly
    const structuredTimelines: { opening: number; closing: number }[] = [];
  
    for (let index = 0; index < presentationCount; index++) {
        structuredTimelines.push({
            opening: scheduleStart[index],
            closing: scheduleEnd[index]
        });
    }

    // sort by closing times to apply greedy selection
    structuredTimelines.sort((firstInterval, secondInterval) => {
        if (firstInterval.closing !== secondInterval.closing) { return firstInterval.closing - secondInterval.closing; }
        
        return firstInterval.opening - secondInterval.opening;
    });

    let totalAttended = 0;
    let trackCurrentTime = -1;

    // filter out conflicts linearly
    for (const currentPresentation of structuredTimelines) {
        if (currentPresentation.opening >= trackCurrentTime) {
            totalAttended++;
            trackCurrentTime = currentPresentation.closing;
        }
    }

    return totalAttended;
}
