function countMax(upRight) {
    if (!upRight || upRight.length === 0) {
        return 0;
    }

    // track intersection boundary of all increments
    let smallestRow = Infinity;
    let smallestCol = Infinity;

    // evaluate each operational coordinate pair
    for (const coordinatePair of upRight) {
        if (!coordinatePair.trim()) continue;

        // whitespace index
        const spaceIndex = coordinatePair.indexOf(' ');
        
        // isolate row & col dims
        const rowDimension = parseInt(coordinatePair.substring(0, spaceIndex), 10);
        const colDimension = parseInt(coordinatePair.substring(spaceIndex + 1), 10);

        // keep min dimensions as they receive every increment
        if (rowDimension < smallestRow) { smallestRow = rowDimension; }
        if (colDimension < smallestCol) { smallestCol = colDimension; }
    }

    // return total overlap grid space containing peak values
    return smallestRow * smallestCol;
}
