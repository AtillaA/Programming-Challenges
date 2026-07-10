def reverse_words_order_and_swap_cases(sentence):
    """
    Reverses the sequence of words and alters the casing of every letter.
    """
    # deconstruct input string into word units
    segmented_words = sentence.split(' ')
    
    # reverse order of extracted words
    backward_words = segmented_words[::-1]
    
    # reassemble the words
    inverted_sentence = ' '.join(backward_words)
    
    # transform character casing manually
    processed_letters = [
        current_char.lower() if current_char.isupper() else current_char.upper()
        for current_char in inverted_sentence
    ]
    
    # consolidate the list
    return "".join(processed_letters)
  
