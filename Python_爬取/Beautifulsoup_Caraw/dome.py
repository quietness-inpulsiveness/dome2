from bs4 import BeautifulSoup
import requests
import time

# url = "http://bj.xiaozhu.com/"
#
#
# def getContent(url, dataList=[], cc=0):
#     time.sleep(2)
#
#     response = requests.get(url)
#     soup = BeautifulSoup(response.text, 'lxml')
#     images = soup.select('#page_list > ul > li > a > img')
#     addresss = soup.select('#page_list > ul > li > div.result_btm_con.lodgeunitname > div.result_intro > a > span')
#     pricles = soup.select('#page_list > ul > li > div.result_btm_con.lodgeunitname > div:nth-child(1) > span')
#     next_page = soup.select('#page_list > div.pagination_v2.pb0_vou > a.font_st')
#     if len(next_page) > 1:
#         print(next_page[1]['href'])
#     print(cc)
#     if (dataList == []):
#         print(type(dataList))
#     for image, address, pricle in zip(images, addresss, pricles):
#         data = {'image': image.get('lazy_src'),
#                 'address': address.get_text(),
#                 'pricle': pricle.get_text()}
#         dataList.append(data)
#     if (next_page == [] or cc>3):
#         return
#     cc += 1
#     if len(next_page) > 1:
#         getContent(next_page[1]['href'], dataList,cc)
#     else:getContent(next_page[0]['href'], dataList,cc)
#
#
# dataListd = []
# getContent(url, dataListd, 1)
# print(dataListd)

hearder={'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36',
        'cookie': 'uuid_tt_dd=10_37515184600-1581476845662-130970; dc_session_id=10_1581476845662.244758; __gads=ID=96f0968d0dee1ac7:T=1581478480:S=ALNI_MbVMwNhQm8OaN-KQpUzikVNlh8VHw; UM_distinctid=1709f7cb5621c3-01ee2a689e8dfd-4313f6b-1fa400-1709f7cb5631b0; UserName=xfxflower; UserInfo=670f10ce5544479195fa2ec38e0fd9c0; UserToken=670f10ce5544479195fa2ec38e0fd9c0; UserNick=xfxflower; AU=8CD; UN=xfxflower; BT=1583593710917; p_uid=U000000; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=6525*1*10_37515184600-1581476845662-130970!5744*1*xfxflower; firstDie=1; utm_source=distribute.pc_relevant.none-task; c_ref=https%3A//www.baidu.com/link%3Furl%3DMj118rztJ3JLJjipxUupGEnO1nlkfN9Pbv2rWlcWeaGQnxDM3CPGuHymeciMOOooBzbHKnOyRRM4sERmuwPbDa%26wd%3D%26eqid%3Dc3dd0c75001aecbd000000065e67a0db; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1583849114,1583849695,1583849714,1583849789; dc_tos=q6zf1q; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1583850735; announcement=%257B%2522isLogin%2522%253Atrue%252C%2522announcementUrl%2522%253A%2522https%253A%252F%252Fblog.csdn.net%252Fblogdevteam%252Farticle%252Fdetails%252F103603408%2522%252C%2522announcementCount%2522%253A0%252C%2522announcementExpire%2522%253A3600000%257D'
         }
url = 'https://me.csdn.net/xfxflower'

def getCounntLog(url,listdata2=[],hearder={}):
    response = requests.get(url,headers=hearder)
    soup = BeautifulSoup(response.text,'lxml')
    name = soup.select('body > div.me_wrap.clearfix > div.me_wrap_l.my_tab_page.clearfix > div.me_wrap_lt.clearfix > div.lt_main.clearfix > p')
    # name = soup.select('#app > div > div.view-container > div > div > div > div.right_c > div.nick > span')
    print(name)
    list2=name[0].get_text()
    list3 = ""
    print(name[0].get_text())
    for i in list2:
        if i!=' ' and i!='\n':
            list3 =list3+i
    print(list3)

getCounntLog(url,hearder=hearder)

# print(dataList)
# next_page = soup.select('#page_list > div.pagination_v2.pb0_vou > a.font_st')
# print(next_page[0]['href'])

# print(Soup)
# '''
# # # #page_list > div.pagination_v2.pb0_vou > a.font_st
# # # '''
# <a class="font_st" target="_self" href="http://bj.xiaozhu.com/search-duanzufang-p2-0/">&gt;</a>
#
# < a
#
#
# class ="font_st" target="_self" href="http://bj.xiaozhu.com/search-duanzufang-p3-0/" > & gt; < / a >

# page_list > div.pagination_v2.pb0_vou > a:nth-child(7)
# page_list > div.pagination_v2.pb0_vou > a.font_st
# page_list > div.pagination_v2.pb0_vou > a:nth-child(7)
# page_list > div.pagination_v2.pb0_vou > a:nth-child(7)
# page_list > div.pagination_v2.pb0_vou > a.font_st