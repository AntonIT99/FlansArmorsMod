import json
from collections import Counter

# Load sounds.json
with open('sounds.json', 'r', encoding='utf-8') as file:
    data = json.load(file)

# Count how many times each key appears
key_counts = Counter(data.keys())

# Build a new dictionary without duplicates
cleaned_data = {key: value for key, value in data.items() if key_counts[key] == 1}

# Save the cleaned json back
with open('sounds_cleaned.json', 'w', encoding='utf-8') as file:
    json.dump(cleaned_data, file, indent=4)
    
print("Finished! Cleaned sounds saved to 'sounds_cleaned.json'")