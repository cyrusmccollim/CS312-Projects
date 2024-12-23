import matplotlib.pyplot as plt

size = [60, 120, 240, 480, 960]
merge = [0.0057, 0.0093, 0.0260, 0.0678, 0.1504]
quick = [0.0048, 0.0075, 0.0135, 0.0254, 0.0480]
heap = [0.0054, 0.0087, 0.0158, 0.0300, 0.0574]
insert = [0.0177, 0.0587, 0.2173, 1.2409, 5.3185]
select = [0.0284, 0.1024, 0.3932, 2.3437, 10.1336]

plt.figure(figsize=(10, 6))

plt.plot(size, merge, marker='o', label='Merge')
plt.plot(size, quick, marker='s', label='Quick')
plt.plot(size, heap, marker='^', label='Heap')
plt.plot(size, insert, marker='*', label='Insertion')
plt.plot(size, select, marker='x', label='Selection')

plt.xlabel('Size (in 1000s)')
plt.ylabel('Time (s)')
plt.title('Elapsed')

plt.legend()
plt.xticks(rotation=45)
plt.grid(True)
plt.tight_layout()
# plt.ylim(0, 0.3) # for scaled version
plt.show()