# 爬虫的一般思路
# 1.分析目标网页，确认爬取的url路径，headers参数
import json
import scrapy

import requests

url = "https://v.6.cn/minivideo/getlist.php?act=recommend&page=1&pagesize=20"
headers = {
    'user-agent': 'Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Mobile Safari/537.36'}
# 2.发送请求
respons = requests.get(url, headers=headers)
respons_data = respons.text
# print(respons_data)
# 3.解析数据 3.1json 模块转换数据类型 3.2解析数据
dict_data = json.loads(respons_data)
# print(dict_data)
list_data = dict_data['content']['list']
# print(type(list_data))
for i in list_data:
    alias_name = i['vid'] + '.mp4'
    print(alias_name)
    playurl = i['playurl']
    # 发送视频数据请求
    video_data = requests.get(playurl, headers).content
    with open('E:\\python_crawling\\' + alias_name, 'wb') as f:
        f.write(video_data)
        print('下载完成')
    break
# print(i)

# 4保存数据
