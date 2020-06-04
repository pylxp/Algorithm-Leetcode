# Read from the file file.txt and print its transposed content to stdout.
# 获取列数
col=$(wc file.txt | awk '{print $2 / $1}')

# 按列输出
for i in `seq 1 $col`
do
    awk -v col="$i" '{print $col}' file.txt |xargs
done