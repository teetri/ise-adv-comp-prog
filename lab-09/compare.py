import pandas as pd

# Read the CSV files into dataframes
df1 = pd.read_csv('tee_scores.csv')
df2 = pd.read_csv('mark_scores.csv')

# Concatenate the dataframes horizontally before sorting
before_sort = pd.concat([df1, df2], axis=1)
print('Before sorting:')
print(before_sort)

# Sort the dataframes by the columns you want to compare
df1_sorted = df1.sort_values(by=['ID'])
df2_sorted = df2.sort_values(by=['ID'])

# Concatenate the dataframes horizontally after sorting
after_sort = pd.concat([df1_sorted, df2_sorted], axis=1)
print('After sorting:')
print(after_sort)

# Compare the sorted dataframes
if df1_sorted.equals(df2_sorted):
    print('The data matches')
else:
    print('The data does not match')
    # Get the differences between the dataframes
    diff = pd.concat([df1_sorted, df2_sorted]).drop_duplicates(keep=False)
    print('The differences are:')
    print(diff)