# Python 3
def stringAnagram(dictionary, query):
    # Write your code here
    if dictionary is None or query is None:
        return[]
        
    freq_map = {}
    
    for word in dictionary:
        if not isinstance(word, str):
            continue
            
        wcomp = "".join(sorted(word))
        freq_map[wcomp] = freq_map.get(wcomp, 0) + 1
        
    output = []
    
    for target in query:
        if not isinstance(target, str):
            output.append(0)
            continue
        
        qcomp = "".join(sorted(target))
        
        if qcomp in freq_map:
            output.append(freq_map[qcomp])
        else:
            output.append(0)
        
    return output
