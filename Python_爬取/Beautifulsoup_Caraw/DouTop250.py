from bs4 import BeautifulSoup
import requests
import time
import openpyxl

from 六间房爬取.Beautifulsoup_Caraw.excelope import WriteXlsx

url = 'https://movie.douban.com/top250?start=0&filter='
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36'}
dataList = []


def paquD250(url, headers=headers, dataList=[]):
    time.sleep(2)
    response = requests.get(url, headers=headers)
    soup = BeautifulSoup(response.text, 'lxml')
    titles = soup.select('#content > div > div.article > ol > li > div > div.info > div.hd > a  ')
    directors = soup.select('#content > div > div.article > ol > li')
    themes = soup.select('#content > div > div.article > ol > li > div > div.info > div.bd > p.quote > span')
    nextpage = soup.select_one('#content > div > div.article > div.paginator > span.next > a')

    for title, theme, director in zip(titles, themes, directors):
        tempData = {'作品': list(title.children)[1].string,
                    '链接': title.get('href'),
                    '导演': list(director.p.stripped_strings)[0].replace("\xa0", ""),
                    '时间和类型': list(director.p.stripped_strings)[1].replace("\xa0", ""),
                    '主要内容': theme.text
                    }
        dataList.append(tempData)
    if nextpage == None:
        return
    newurl = nextpage.get('href')
    paquD250(url[:31] + newurl, dataList=dataList)

paquD250(url, dataList=dataList)
cc = WriteXlsx()
cc.write(dataList)
print("写入完成")
