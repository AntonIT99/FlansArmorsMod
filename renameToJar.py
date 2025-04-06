import os

# Path to the "flan" subdirectory
flan_dir = os.path.join(os.getcwd(), 'run/flan')

# Make sure the directory exists
if not os.path.isdir(flan_dir):
    print(f'"{flan_dir}" does not exist.')
else:
    for filename in os.listdir(flan_dir):
        if filename.endswith('.zip'):
            zip_path = os.path.join(flan_dir, filename)
            jar_path = os.path.join(flan_dir, filename[:-4] + '.jar')  # Replace .zip with .jar
            os.rename(zip_path, jar_path)
            print(f'Renamed: {filename} -> {os.path.basename(jar_path)}')

print("Done.")
input("Press Enter to exit...")