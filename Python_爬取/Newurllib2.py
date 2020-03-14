import urllib3
import json
import re
url = 'https://maoyan.com/board/6'
header = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36'}
pattern =re.compile(r'<a href="(/[a-z]+/[0-9]+)" title="(.*)" data-act="boarditem-click" data-val="{movieId:([0-9]+)}">(.*)</a>')
http = urllib3.PoolManager(headers=header)
response = http.request('GET',url)
sourceData = response.data.decode('utf-8')
resturlts=pattern.findall(sourceData)
for resturlt in resturlts:
    print(f"链接：{url[0:-8]+resturlt[0]},'name:'{resturlt[1]}")

# print(response.data.decode('utf-8'))


