import matplotlib.pyplot as plt

size = [60, 120, 240, 480, 960]
merge = [1.46, 2.00, 2.52, 2.78, 4.53]
quick = [1.80, 1.74, 2.11, 2.52, 4.22]
heap = [1.91, 2.12, 2.61, 3.08, 6.89]
insert = [2.89, 6.70, 22.24, 84.08, 331.4]
select = [3.90, 11.11, 39.95, 154.57, 612.78]

plt.figure(figsize=(10, 6))

plt.plot(size, merge, marker='o', label='Merge')
plt.plot(size, quick, marker='s', label='Quick')
plt.plot(size, heap, marker='^', label='Heap')
plt.plot(size, insert, marker='*', label='Insertion')
plt.plot(size, select, marker='x', label='Selection')

plt.xlabel('Size (in 1000s)')
plt.ylabel('Time (s)')
plt.title('User')

plt.legend()
plt.xticks(rotation=45)
plt.grid(True)
plt.tight_layout()
# plt.ylim(0, 10) # for scaled version
plt.show()