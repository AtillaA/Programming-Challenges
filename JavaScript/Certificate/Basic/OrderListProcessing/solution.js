function processOrderList(orderList, OrderId, state) {
    if (!Array.isArray(orderList)) { return []; }

    const targetId = Number(OrderId);
    const trimmedState = String(state).trim();

    if (trimmedState === 'Processing') {
        for (let i = 0; i < orderList.length; i++) {
            const currElt = orderList[i];
          
            if (currElt && currElt.id === targetId) {
                currElt.state = 'Processing';
                break;
            }
        }
    } else if (trimmedState === 'Delivered') {
        const targetIndex = orderList.findIndex(_obj => _obj && _obj.id === targetId);
        
        if (targetIndex !== -1) { orderList.splice(targetIndex, 1); }
    }

    return orderList;
}
